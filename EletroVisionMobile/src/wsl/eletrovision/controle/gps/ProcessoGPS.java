package wsl.eletrovision.controle.gps;

import wsl.eletrovision.controle.recursos.ConstantesRedes;
import wsl.eletrovision.controle.recursos.ConstantesTelas;
import wsl.eletrovision.controle.recursos.InstanciasPortatil;
import wsl.eletrovision.controle.recursos.Preferencias;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Message;

public class ProcessoGPS extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		
		if(InstanciasPortatil.getTelaPrincipal() != null) {
			
			if(Preferencias.getLocalizacaoGps(InstanciasPortatil.getTelaPrincipal())) {
				Gps gps = new Gps(InstanciasPortatil.getTelaPrincipal());
				Location localizacao = gps.getLocation();
				if(localizacao != null) {
					final Double latitude = localizacao.getLatitude();
					final Double longitude = localizacao.getLongitude();
					new Thread(new Runnable() {      
						@Override
						public void run() {
							if(InstanciasPortatil.getCliente() != null) {
								InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_POSTAR_LOCALIZACAO_GPS);
								InstanciasPortatil.getCliente().enviarDados(latitude.toString());
								InstanciasPortatil.getCliente().enviarDados(longitude.toString()); 
							} 
						}
					}).start();	
				} 
			}
	
			if(InstanciasPortatil.getCliente() == null) {
				handleAtualizaRede();
			}
			
		}
		
	}
	
	private void handleAtualizaRede() {
    	Message message = new Message();
    	message.what = ConstantesTelas.HD_ATUALIZAR_REDE;
    	InstanciasPortatil.getTelaPrincipal().handle.sendMessage(message);
    }

}
