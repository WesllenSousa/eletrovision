package wsl.eletrovision.telas;

import wsl.eletrovision.R;
import wsl.eletrovision.controle.adapter.DispositivoAdapter;
import wsl.eletrovision.controle.recursos.ConstantesRedes;
import wsl.eletrovision.controle.recursos.ConstantesTelas;
import wsl.eletrovision.controle.recursos.InstanciasPortatil;
import wsl.eletrovision.controle.serializado.GuardaDispositivo;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class TelaDispositivo extends Activity implements OnClickListener {
	
	private ImageButton bt_voltar;
	private ListView lv_dispositivos;
	
	private ProgressDialog dialog;
	private Resources resources;
	private Handler handler = new HandleDispositivos();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_dispositivo);
        resources = getResources();
        
        bt_voltar = (ImageButton) findViewById(R.id.telaDispositivo_bt_voltar);
        bt_voltar.setOnClickListener(this);
        lv_dispositivos = (ListView) findViewById(R.id.telaDispositivo_lv_dispositivos);
        
        solicitarDispositivos();
        if(InstanciasPortatil.getCliente() != null)
        	InstanciasPortatil.getCliente().getTratarMensagem().setHandler(handler);
        else
        	Toast.makeText(this, resources.getString(R.string.geral_nao_conectado), Toast.LENGTH_SHORT).show();
    }
    
    @Override
	public void onClick(View v) {
		if(v == bt_voltar) {
			finish();
		} 
	}
    
    private void solicitarDispositivos() {
        if(InstanciasPortatil.getCliente() != null) {
        	dialog = ProgressDialog.show(this, resources.getString(R.string.geral_rede), 
					resources.getString(R.string.geral_buscando), true, true);
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_DISPOSITIVOS);
        }
    }
	
	private void preencherDispositivos() {
		DispositivoAdapter dispositivoAdapter = new DispositivoAdapter(this, InstanciasPortatil.getGuardaDispositivos(), this);
		lv_dispositivos.setAdapter(dispositivoAdapter);
		lv_dispositivos.invalidate();
	}
    
    public void acionar(GuardaDispositivo guardaDispositivo) {
    	if(InstanciasPortatil.getCliente() != null) {
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_ACIONAR_DISPOSITIVOS);
            InstanciasPortatil.getCliente().enviarDados(guardaDispositivo.getCodigo());
        }
    }
    
    private void confirmacao(String confirmacao) {
    	dialog.dismiss();
        if("0".equals(confirmacao)) {
        	Toast.makeText(this, resources.getString(R.string.dispositivo_erro), Toast.LENGTH_SHORT).show();
        } else if("1".equals(confirmacao)) {
        	Toast.makeText(this, resources.getString(R.string.dispositivo_sucesso), Toast.LENGTH_SHORT).show();
        } else if("2".equals(confirmacao)) {
        	Toast.makeText(this, resources.getString(R.string.dispositivo_desativado), Toast.LENGTH_SHORT).show();
        }
    }
    
    private class HandleDispositivos extends Handler {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case ConstantesTelas.HD_DISPOSITIVO:
					String confirmacao = msg.getData().getString(ConstantesTelas.BD_CONFIRMACAO_DISPOSITIVO);
					confirmacao(confirmacao);
					dialog.dismiss();
					break;
				case ConstantesTelas.HD_DISPOSITIVO_PREENCHER_LISTA:
					Integer acesso = msg.getData().getInt(ConstantesTelas.BD_ACESSO);
					if(acesso == 1)
						preencherDispositivos();
					else
						Toast.makeText(TelaDispositivo.this, resources.getString(R.string.dispositivo_acesso), Toast.LENGTH_SHORT).show();
					dialog.dismiss();
					break;
				default:
					break;
			}
		}
	}
    
}