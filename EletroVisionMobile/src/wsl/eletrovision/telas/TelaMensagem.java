package wsl.eletrovision.telas;

import wsl.eletrovision.R;
import wsl.eletrovision.controle.adapter.MensagensAdapter;
import wsl.eletrovision.controle.recursos.ConstantesRedes;
import wsl.eletrovision.controle.recursos.ConstantesTelas;
import wsl.eletrovision.controle.recursos.InstanciasPortatil;
import wsl.eletrovision.controle.redes.Cliente;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class TelaMensagem extends Activity implements OnClickListener {
	
	private ImageButton bt_voltar;
	private ImageButton bt_enviar;
	private EditText et_mensagem;
	private ListView lv_mensagens;
	
	private Handler handler = new HandleMensagem();
	private Cliente cliente;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_mensagem);
        
        bt_voltar = (ImageButton) findViewById(R.id.telaMensagem_bt_voltar);
        bt_voltar.setOnClickListener(this);
        bt_enviar = (ImageButton) findViewById(R.id.telaMensagem_bt_enviar);
        bt_enviar.setOnClickListener(this);
        et_mensagem = (EditText) findViewById(R.id.telaMensagem_et_mensagem);
        lv_mensagens = (ListView) findViewById(R.id.telaMensagem_lv_mensagens);
        
        recuperaCliente();
        preencherLista();
    }
    
    @Override
	public void onClick(View v) {
		if(v == bt_voltar) {
			finish();
		} else if(v == bt_enviar) {
			enviar();
		}
	}
    
    private void recuperaCliente() {
		if(InstanciasPortatil.getCliente() != null) {
			cliente = InstanciasPortatil.getCliente();
			cliente.getTratarMensagem().setHandler(handler);
    	} 
	}
    
    private void enviar() {
		new Thread(new Runnable() {      
			@Override
			public void run() {
				if(cliente != null) {
					cliente.enviarDados(ConstantesRedes.CS_MENSAGEM);
					cliente.enviarDados(et_mensagem.getText().toString());
					cliente.enviarDados("0");
				} 
			}
		}).start();	
		if(cliente != null) {
			Resources resources = getResources();
			Toast.makeText(this, resources.getString(R.string.mensagem_enviar), Toast.LENGTH_SHORT).show();
		}
	}
    
    private void preencherLista() {
    	if(InstanciasPortatil.getGuardaMensagens() != null) {
    		et_mensagem.setText("");
	    	MensagensAdapter adapter = new MensagensAdapter(this, InstanciasPortatil.getGuardaMensagens());
	    	lv_mensagens.setAdapter(adapter);
	    	lv_mensagens.invalidate();
    	}
    }
    
    private class HandleMensagem extends Handler {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case ConstantesTelas.HD_MENSAGEM:
					preencherLista();
					break;
				default:
					break;
			}
		}
	}
    
}