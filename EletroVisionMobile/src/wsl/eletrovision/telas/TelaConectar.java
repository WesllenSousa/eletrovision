package wsl.eletrovision.telas;

import wsl.eletrovision.R;
import wsl.eletrovision.controle.recursos.ConstantesTelas;
import wsl.eletrovision.controle.recursos.InstanciasPortatil;
import wsl.eletrovision.controle.redes.Cliente;
import wsl.eletrovision.utils.Criptografia;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class TelaConectar extends Activity implements OnClickListener {
	
	private ImageButton bt_voltar;
	private EditText et_ip;
	private EditText et_usuario;
	private EditText et_senha;
	private Button bt_conectar;
	
	private Handler handler = new HandleConectar();
	private ProgressDialog dialog;
	private Resources resources;
	
	private Cliente cliente;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_conectar);
        resources = getResources();
        
        bt_voltar = (ImageButton) findViewById(R.id.telaConectar_bt_voltar);
        bt_voltar.setOnClickListener(this);
        et_ip = (EditText) findViewById(R.id.telaConectar_et_ip);
        et_usuario = (EditText) findViewById(R.id.telaConectar_et_usuario);
        et_senha = (EditText) findViewById(R.id.telaConectar_et_senha);
        bt_conectar = (Button) findViewById(R.id.telaConectar_bt_conectar);
        bt_conectar.setOnClickListener(this);
    }
    
    @Override
	public void onClick(View v) {
		if(v == bt_voltar) {
			finish();
		} else if(v == bt_conectar) {
			conectar();
		}
	}
    
    private void conectar() { 
		dialog = ProgressDialog.show(this, resources.getString(R.string.geral_rede), 
				resources.getString(R.string.geral_conectando), true, true);
    	cliente = new Cliente(et_ip.getText().toString(), et_usuario.getText().toString(), 
    			Criptografia.MD5(et_senha.getText().toString()));
    	cliente.getTratarMensagem().setHandler(handler);
        Thread thread = new Thread(cliente);
        thread.start();
    }
    
    public void confirmaConexao(String confirmacao) {
    	dialog.dismiss();
    	if("-1".equals(confirmacao)) {
    		Toast.makeText(this, resources.getString(R.string.geral_servidornaoencontrado), Toast.LENGTH_SHORT).show();
    	} else if("0".equals(confirmacao)) { //0: Usuário inválido  
            cliente.fecharConexao();
            Toast.makeText(this, resources.getString(R.string.conectar_usuarioinvalido), Toast.LENGTH_SHORT).show();
        } else if("1".equals(confirmacao)) { //1: logado com sucesso
        	Toast.makeText(this, resources.getString(R.string.conectar_conexaosucesso), Toast.LENGTH_SHORT).show();
            InstanciasPortatil.setCliente(cliente); 
            setResult(ConstantesTelas.RS_CONECTADO, new Intent());
            finish();
        } else if("2".equals(confirmacao)) { //1: usuário já logado
            cliente.fecharConexao();
            Toast.makeText(this, resources.getString(R.string.conectar_usariologado), Toast.LENGTH_SHORT).show();
        }
    }
    
    private class HandleConectar extends Handler {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case ConstantesTelas.HD_CONECTAR:
					String confirmacao = msg.getData().getString(ConstantesTelas.BD_CONFIRMACAO_CONEXAO);
					confirmaConexao(confirmacao);
					dialog.dismiss();
					break;
				default:
					break;
			}
		}
	}
    
}