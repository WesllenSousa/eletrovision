package wsl.eletrovision.telas;

import wsl.eletrovision.R;
import wsl.eletrovision.controle.adapter.UsuarioAdapter;
import wsl.eletrovision.controle.recursos.ConstantesRedes;
import wsl.eletrovision.controle.recursos.ConstantesTelas;
import wsl.eletrovision.controle.recursos.InstanciasPortatil;
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

public class TelaUsuarios extends Activity implements OnClickListener {
	
	private ImageButton bt_voltar;
	private ListView lv_usuarios;
	
	private ProgressDialog dialog;
	private Resources resources;
	private Handler handler = new HandleUsuario();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_usuario);
        resources = getResources();
        
        bt_voltar = (ImageButton) findViewById(R.id.telaUsuario_bt_voltar);
        bt_voltar.setOnClickListener(this);
        lv_usuarios = (ListView) findViewById(R.id.telaUsuario_lv_usuario);
        
        solicitarUsuarios();
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
    
    private void solicitarUsuarios() {
        if(InstanciasPortatil.getCliente() != null) {
        	dialog = ProgressDialog.show(this, resources.getString(R.string.geral_rede), 
					resources.getString(R.string.geral_buscando), true, true);
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_CLIENTE_CONECTADOS);
        }
    }
    
    private void preencherUsuario() {
    	UsuarioAdapter usuarioAdapter = new UsuarioAdapter(this, InstanciasPortatil.getClientesConectados(), this);
    	lv_usuarios.setAdapter(usuarioAdapter);
    	lv_usuarios.invalidate();
    }
    
    public void gps(final String usuario) {
    	dialog = ProgressDialog.show(this, resources.getString(R.string.geral_rede), 
				resources.getString(R.string.geral_buscando), true, true);
    	new Thread(new Runnable() {      
			@Override
			public void run() {
				if(InstanciasPortatil.getCliente() != null) {
					InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_INFORMAR_LOCALIZACAO_GPS);
					InstanciasPortatil.getCliente().enviarDados(usuario);
				} 
			}
		}).start();	
    }
    
    private void confirmacao(String confirmacao) {
    	if(confirmacao.equals("1")) {
    		Toast.makeText(this, resources.getString(R.string.usuario_erro_gps), Toast.LENGTH_SHORT).show();
    	}
    }
    
    private class HandleUsuario extends Handler {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case ConstantesTelas.HD_USUARIOS: 
					preencherUsuario();
					dialog.dismiss();
					break;
				case ConstantesTelas.HD_LOCALIZACAO_USUARIO: 	
					String confirmacao = msg.getData().getString(ConstantesTelas.BD_CONFIRMACAO_LOCALIZACAO);
					confirmacao(confirmacao);
					dialog.dismiss();
					break;
			}
		}
	}
    
}