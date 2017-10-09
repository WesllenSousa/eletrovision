package wsl.eletrovision.telas;

import java.util.ArrayList;

import wsl.eletrovision.R;
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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class TelaConfigCenario extends Activity implements OnClickListener {
	
	private ImageButton bt_voltar;
	private CheckBox ck_ativar;
	private RadioButton rd_nenhumAcionamento;
	private RadioButton rd_controleAutomatico;
	private RadioButton rd_alarme;
	private RadioButton rd_detectarFace;
	private RadioButton rd_reconhecerFace;
	private RadioButton rd_movimento;
	private Button bt_salvar;
	private Button bt_cancelar;
	
	private Handler handler = new HandleConfigCenario();
	private ProgressDialog dialog;
	private Resources resources;
	private String codigo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_config_cenario);
        resources = getResources();
        
        bt_voltar = (ImageButton) findViewById(R.id.configCenario_bt_voltar);
        bt_voltar.setOnClickListener(this);
        ck_ativar = (CheckBox) findViewById(R.id.configCenario_ck_ativar);
        rd_nenhumAcionamento = (RadioButton) findViewById(R.id.configCenario_nenhumAcionamento);
        rd_controleAutomatico = (RadioButton) findViewById(R.id.configCenario_controleAutomatico);
        rd_alarme = (RadioButton) findViewById(R.id.configCenario_alarme);
        rd_detectarFace = (RadioButton) findViewById(R.id.configCenario_detectarFace);
        rd_reconhecerFace = (RadioButton) findViewById(R.id.configCenario_reconhecerFace);
        rd_movimento = (RadioButton) findViewById(R.id.configCenario_movimento);
        bt_salvar = (Button) findViewById(R.id.configCenario_bt_salvar);
        bt_salvar.setOnClickListener(this);
        bt_cancelar = (Button) findViewById(R.id.configCenario_bt_cancelar);
        bt_cancelar.setOnClickListener(this);
        
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
        	codigo = bundle.getString(ConstantesTelas.BD_CONFIG_CENARIO_CODIGO);
        	ArrayList<String> lista = bundle.getStringArrayList(ConstantesTelas.BD_CONFIG_CENARIO_LISTA);
        	preencheCampos(lista);
        }
        if(InstanciasPortatil.getCliente() != null)
        	InstanciasPortatil.getCliente().getTratarMensagem().setHandler(handler);
        else
        	Toast.makeText(this, resources.getString(R.string.geral_nao_conectado), Toast.LENGTH_SHORT).show();
    }

	@Override
	public void onClick(View v) {
		if(v == bt_voltar) {
			finish();
		} else if(v == bt_salvar) {
			salvar();
		} else if(v == bt_cancelar) {
			finish();
		}
	}
	
	public void preencheCampos(ArrayList<String> configCamera) {
        if(configCamera.get(0).equals("0")) {
        	ck_ativar.setChecked(true);
        } else {
        	ck_ativar.setChecked(false);
        }
        if(configCamera.get(1).equals("0")) {
        	rd_nenhumAcionamento.setChecked(true);
        } else if(configCamera.get(1).equals("1")) {
        	rd_controleAutomatico.setChecked(true);
        } else if(configCamera.get(1).equals("2")) {
        	rd_detectarFace.setChecked(true);
        } else if(configCamera.get(1).equals("3")) {
        	rd_reconhecerFace.setChecked(true);
        } else if(configCamera.get(1).equals("4")) {
        	rd_alarme.setChecked(true);
        } else if(configCamera.get(1).equals("5")) {
        	rd_movimento.setChecked(true);
        }
    }
     
    private ArrayList<String> populaConfigBean() {
        ArrayList<String> configCamera = new ArrayList<String>();
        
        if(ck_ativar.isChecked()) {
        	configCamera.add(0, "1");
        } else {
        	configCamera.add(0, "0");
        }
        if(rd_nenhumAcionamento.isChecked()) {
        	configCamera.add(1, "0");
        } else if(rd_controleAutomatico.isChecked()) {
        	configCamera.add(1, "1");
        } else if(rd_detectarFace.isChecked()) {
        	configCamera.add(1, "2");
        } else if(rd_reconhecerFace.isChecked()) {
        	configCamera.add(1, "3");
        } else if(rd_alarme.isChecked()) {
        	configCamera.add(1, "4");
        } else if(rd_movimento.isChecked()) {
        	configCamera.add(1, "5");
        }
        
        return configCamera;
    }
    
    private void salvar() {
        if(InstanciasPortatil.getCliente() != null) {
        	dialog = ProgressDialog.show(this, resources.getString(R.string.geral_rede), 
    				resources.getString(R.string.configcenario_salvando), true, true);
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_CONFIG_ACIONAMENTO_SALVAR);
            InstanciasPortatil.getCliente().enviarDados(codigo);
            InstanciasPortatil.getCliente().enviarDados(populaConfigBean());
        }
    }  
	
	private class HandleConfigCenario extends Handler {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case ConstantesTelas.HD_CONFIG_CENARIO:
					Toast.makeText(TelaConfigCenario.this, resources.getString(R.string.configcenario_sucesso), Toast.LENGTH_SHORT).show();
					dialog.dismiss();
					finish();
					break;
				default:
					break;
			}
		}
	}
    
}