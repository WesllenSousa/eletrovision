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

public class TelaConfigCamera extends Activity implements OnClickListener {
	
	private ImageButton bt_voltar;
	private CheckBox ck_ativar;
	private RadioButton rd_adaptarAmbiente;
	private RadioButton rd_mudancaAmbiente;
	private CheckBox ck_movimento;
	private CheckBox ck_ambienteStatico;
	private CheckBox ck_objeto;
	private CheckBox ck_face;
	private CheckBox ck_olhos;
	private CheckBox ck_corpo;
	private CheckBox ck_gravar;
	private CheckBox ck_acionarDispositivos;
	private CheckBox ck_campanhia;
	private CheckBox ck_reconhecerFace;
	private Button bt_salvar;
	private Button bt_cancelar;
	
	private Handler handler = new HandleConfigCamera();
	private ProgressDialog dialog;
	private Resources resources;
	private String codigo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_config_camera);
        resources = getResources();
        
        bt_voltar = (ImageButton) findViewById(R.id.configCamera_bt_voltar);
        bt_voltar.setOnClickListener(this);
        rd_adaptarAmbiente = (RadioButton) findViewById(R.id.configCamera_rd_adaptarAmbiente);
        rd_mudancaAmbiente = (RadioButton) findViewById(R.id.configCamera_rd_mudancaAmbiente);
        ck_ativar = (CheckBox) findViewById(R.id.configCamera_ck_ativar);
        ck_movimento = (CheckBox) findViewById(R.id.configCamera_ck_movimento);
        ck_ambienteStatico = (CheckBox) findViewById(R.id.configCamera_ck_ambienteStatico);
        ck_objeto = (CheckBox) findViewById(R.id.configCamera_ck_objeto);
        ck_face = (CheckBox) findViewById(R.id.configCamera_ck_face);
        ck_olhos = (CheckBox) findViewById(R.id.configCamera_ck_olhos);
        ck_corpo = (CheckBox) findViewById(R.id.configCamera_ck_corpo);
        ck_gravar = (CheckBox) findViewById(R.id.configCamera_ck_gravar);
        ck_acionarDispositivos = (CheckBox) findViewById(R.id.configCamera_ck_dispositivos);
        ck_campanhia = (CheckBox) findViewById(R.id.configCamera_ck_campanhia);
        ck_reconhecerFace = (CheckBox) findViewById(R.id.configCamera_ck_reconhecerFace);
        bt_salvar = (Button) findViewById(R.id.configCamera_bt_salvar);
        bt_salvar.setOnClickListener(this);
        bt_cancelar = (Button) findViewById(R.id.configCamera_bt_cancelar);
        bt_cancelar.setOnClickListener(this);
        
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
        	codigo = bundle.getString(ConstantesTelas.BD_CONFIG_CAMERA_CODIGO);
        	ArrayList<String> lista = bundle.getStringArrayList(ConstantesTelas.BD_CONFIG_CAMERA_LISTA);
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
    
    private void preencheCampos(ArrayList<String> configCamera) {
        if(configCamera.get(0).equals("0")) {
        	ck_ativar.setChecked(true);
        } else {
        	ck_ativar.setChecked(false);
        }
        if(configCamera.get(1).equals("0")) {
        	rd_adaptarAmbiente.setChecked(true);
        } else {
        	rd_mudancaAmbiente.setChecked(true);
        }
        if(configCamera.get(2).equals("1")) {
        	ck_movimento.setChecked(true);
        } else {
        	ck_movimento.setChecked(false);
        }
        if(configCamera.get(3).equals("1")) {
        	ck_ambienteStatico.setChecked(true);
        } else {
        	ck_ambienteStatico.setChecked(false);
        }
        if(configCamera.get(4).equals("1")) {
        	ck_objeto.setChecked(true);
        } else {
        	ck_objeto.setChecked(false);
        }
        if(configCamera.get(5).equals("1")) {
        	ck_acionarDispositivos.setChecked(true);
        } else {
        	ck_acionarDispositivos.setChecked(false);
        }
        if(configCamera.get(6).equals("1")) {
        	ck_campanhia.setChecked(true);
        } else {
        	ck_campanhia.setChecked(false);
        }
        if(configCamera.get(7).equals("1")) {
        	ck_gravar.setChecked(true);
        } else {
        	ck_gravar.setChecked(false);
        }
        if(configCamera.get(8).equals("1")) {
        	ck_face.setChecked(true);
        } else {
        	ck_face.setChecked(false);
        }
        if(configCamera.get(9).equals("1")) {
        	ck_olhos.setChecked(true);
        } else {
        	ck_olhos.setChecked(false);
        }
        if(configCamera.get(10).equals("1")) {
        	ck_corpo.setChecked(true);
        } else {
        	ck_corpo.setChecked(false);
        }
        if(configCamera.get(11).equals("1")) {
        	ck_reconhecerFace.setChecked(true);
        } else {
        	ck_reconhecerFace.setChecked(false);
        }
    }
    
    private ArrayList<String> populaConfigCameraBean() {
        ArrayList<String> configCamera = new ArrayList<String>();
        
        if(ck_ativar.isChecked()) {
        	configCamera.add(0, "1");
        } else {
        	configCamera.add(0, "0");
        }
        if(rd_adaptarAmbiente.isChecked()) {
        	configCamera.add(1, "0");
        } else {
        	configCamera.add(1, "1");
        }
        if(ck_movimento.isChecked()) {
        	configCamera.add(2, "0");
        } else {
        	configCamera.add(2, "1");
        }
        if(ck_ambienteStatico.isChecked()) {
        	configCamera.add(3, "0");
        } else {
        	configCamera.add(3, "1");
        }
        if(ck_objeto.isChecked()) {
        	configCamera.add(4, "0");
        } else {
        	configCamera.add(4, "1");
        }
        if(ck_acionarDispositivos.isChecked()) {
        	configCamera.add(5, "0");
        } else {
        	configCamera.add(5, "1");
        }
        if(ck_campanhia.isChecked()) {
        	configCamera.add(6, "0");
        } else {
        	configCamera.add(6, "1");
        }
        if(ck_gravar.isChecked()) {
        	configCamera.add(7, "0");
        } else {
        	configCamera.add(7, "1");
        }
        if(ck_face.isChecked()) {
        	configCamera.add(8, "0");
        } else {
        	configCamera.add(8, "1");
        }
        if(ck_olhos.isChecked()) {
        	configCamera.add(9, "0");
        } else {
        	configCamera.add(9, "1");
        }
        if(ck_corpo.isChecked()) {
        	configCamera.add(10, "0");
        } else {
        	configCamera.add(10, "1");
        }
        if(ck_reconhecerFace.isChecked()) {
        	configCamera.add(11, "0");
        } else {
        	configCamera.add(11, "1");
        }

        return configCamera;
    }
    
    private void salvar() {
        if(InstanciasPortatil.getCliente() != null) {
        	dialog = ProgressDialog.show(this, resources.getString(R.string.geral_rede), 
    				resources.getString(R.string.configcamera_salvando), true, true);
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_CONFIG_CAMERA_SALVAR);
            InstanciasPortatil.getCliente().enviarDados(codigo);
            InstanciasPortatil.getCliente().enviarDados(populaConfigCameraBean());
        }
    }  
    
    private class HandleConfigCamera extends Handler {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case ConstantesTelas.HD_CONFIG_CAMERA:		
					Toast.makeText(TelaConfigCamera.this, resources.getString(R.string.configcamera_sucesso), Toast.LENGTH_SHORT).show();
					dialog.dismiss();
					finish();
					break;
				default:
					break;
			}
		}
	}
    
}