package wsl.eletrovision.telas;

import wsl.eletrovision.R;
import wsl.eletrovision.controle.adapter.CameraAdapter;
import wsl.eletrovision.controle.recursos.ConstantesRedes;
import wsl.eletrovision.controle.recursos.ConstantesTelas;
import wsl.eletrovision.controle.recursos.InstanciasPortatil;
import wsl.eletrovision.controle.serializado.GuardaCamera;
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

public class TelaCamera extends Activity implements OnClickListener {
	
	private ImageButton bt_voltar;
	private ListView lv_cameras;
	
	private ProgressDialog dialog;
	private Resources resources;
	private Handler handler = new HandleCamera();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_camera);
        InstanciasPortatil.setTelaCamera(TelaCamera.this);
        resources = getResources();
        
        bt_voltar = (ImageButton) findViewById(R.id.telaCamera_bt_voltar);
        bt_voltar.setOnClickListener(this);
        lv_cameras = (ListView) findViewById(R.id.telaCamera_lv_cameras);
        
        solicitarCameras();
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
	
	private void solicitarCameras() {
        if(InstanciasPortatil.getCliente() != null) {
        	dialog = ProgressDialog.show(this, resources.getString(R.string.geral_rede), 
					resources.getString(R.string.geral_buscando), true, true);
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_CAMERAS);
        }
    }
	
	private void preencherCameras() {
		CameraAdapter cameraAdapter = new CameraAdapter(this, InstanciasPortatil.getGuardaCameras(), this);
		lv_cameras.setAdapter(cameraAdapter);
		lv_cameras.invalidate();
	}
	
	public void tirarFoto(GuardaCamera guardaCamera) {
		if(InstanciasPortatil.getCliente() != null) {
			dialog = ProgressDialog.show(this, resources.getString(R.string.geral_rede), 
					resources.getString(R.string.camera_tirandofoto), true, true);
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_TIRAR_FOTO);
            InstanciasPortatil.getCliente().enviarDados(guardaCamera.getCodigo());
        }
	}
	
	public void configuracao(GuardaCamera guardaCamera) {
		if(InstanciasPortatil.getCliente() != null) {
			dialog = ProgressDialog.show(this, resources.getString(R.string.geral_rede), 
					resources.getString(R.string.geral_configurando), true, true);
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_CONFIG_CAMERA);
            InstanciasPortatil.getCliente().enviarDados(guardaCamera.getCodigo());
        }
	}
	
	private void confirmacao(String confirmacao) {
        if("0".equals(confirmacao)) {
        	Toast.makeText(this, resources.getString(R.string.camera_erro), Toast.LENGTH_SHORT).show();
        } else if("2".equals(confirmacao)) {
        	Toast.makeText(this, resources.getString(R.string.visualizarimagem_cameradesativada), Toast.LENGTH_SHORT).show();
        }
    }
	
	private class HandleCamera extends Handler {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case ConstantesTelas.HD_CAMERA:
					dialog.dismiss();
					String confirmacao = msg.getData().getString(ConstantesTelas.BD_CONFIRMACAO_CAMERA);
					confirmacao(confirmacao);
					break;
				case ConstantesTelas.HD_CAMERA_PREENCHER_LISTA:
					Integer acesso = msg.getData().getInt(ConstantesTelas.BD_ACESSO);
					if(acesso == 1)
						preencherCameras();
					else
						Toast.makeText(TelaCamera.this, resources.getString(R.string.camera_acesso), Toast.LENGTH_SHORT).show();
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