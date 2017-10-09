package wsl.eletrovision.telas;

import wsl.eletrovision.R;
import wsl.eletrovision.controle.adapter.CenarioAdapter;
import wsl.eletrovision.controle.recursos.ConstantesRedes;
import wsl.eletrovision.controle.recursos.ConstantesTelas;
import wsl.eletrovision.controle.recursos.InstanciasPortatil;
import wsl.eletrovision.controle.serializado.GuardaCenario;
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

public class TelaCenario extends Activity implements OnClickListener {
	
	private ImageButton bt_voltar;
	private ListView lv_cenarios;
	
	private ProgressDialog dialog;
	private Resources resources;
	private Handler handler = new HandleCenario();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cenario);
        resources = getResources();
        
        bt_voltar = (ImageButton) findViewById(R.id.telaCenario_bt_voltar);
        bt_voltar.setOnClickListener(this);
        lv_cenarios = (ListView) findViewById(R.id.telaCenario_lv_cenarios);
        
        solicitarCenarios();
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
	
	private void solicitarCenarios() {
        if(InstanciasPortatil.getCliente() != null) {
        	dialog = ProgressDialog.show(this, resources.getString(R.string.geral_rede), 
					resources.getString(R.string.geral_buscando), true, true);
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_CENARIOS);
        }
    }
	
	private void preencherCenarios() {
		CenarioAdapter cenarioAdapter = new CenarioAdapter(this, InstanciasPortatil.getGuardaCenarios(), this);
		lv_cenarios.setAdapter(cenarioAdapter);
		lv_cenarios.invalidate();
	}
	
	public void acionar(GuardaCenario guardaCenario) {
		if(InstanciasPortatil.getCliente() != null) {
			dialog = ProgressDialog.show(this, resources.getString(R.string.geral_rede), 
					resources.getString(R.string.geral_acionando), true, true);
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_ACIONAR_CENARIOS);
            InstanciasPortatil.getCliente().enviarDados(guardaCenario.getCodigo());
            if (guardaCenario.getAcao().equals("Ligar")) {
                InstanciasPortatil.getCliente().enviarDados("1");
            } else {
            	InstanciasPortatil.getCliente().enviarDados("0");
            }
        }
    }
	
	public void configurar(GuardaCenario guardaCenario) {
		if(InstanciasPortatil.getCliente() != null) {
			dialog = ProgressDialog.show(this, resources.getString(R.string.geral_rede), 
					resources.getString(R.string.geral_configurando), true, true);
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_CONFIG_ACIONAMENTO);
            InstanciasPortatil.getCliente().enviarDados(guardaCenario.getCodigo());
        }
	}
	
	public void confirmacao(String confirmacao) {
        if("0".equals(confirmacao)) {
        	Toast.makeText(this, resources.getString(R.string.cenario_erro), Toast.LENGTH_SHORT).show();
        } else if("1".equals(confirmacao)) {
        	Toast.makeText(this, resources.getString(R.string.cenario_sucesso), Toast.LENGTH_SHORT).show();
        } else if("2".equals(confirmacao)) {
        	Toast.makeText(this, resources.getString(R.string.cenario_desativado), Toast.LENGTH_SHORT).show();
        }
    }
	
	private class HandleCenario extends Handler {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case ConstantesTelas.HD_CENARIO:
					dialog.dismiss();
					String confirmacao = msg.getData().getString(ConstantesTelas.BD_CONFIRMACAO_CENARIO);
					confirmacao(confirmacao);	
					break;
				case ConstantesTelas.HD_CENARIO_PREENCHER_LISTA:
					Integer acesso = msg.getData().getInt(ConstantesTelas.BD_ACESSO);
					if(acesso == 1)
						preencherCenarios();
					else
						Toast.makeText(TelaCenario.this, resources.getString(R.string.cenario_acesso), Toast.LENGTH_SHORT).show();
					dialog.dismiss();
					break;
				default:
					break;
			}
		}
	}
	
	@Override
	protected void onResume() {
    	super.onResume();
    	if(dialog != null) {
    		dialog.dismiss();
    	}
    }
    
}