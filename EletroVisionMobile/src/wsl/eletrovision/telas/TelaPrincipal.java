package wsl.eletrovision.telas;

import java.util.Calendar;

import wsl.eletrovision.R;
import wsl.eletrovision.controle.recursos.ConstantesRedes;
import wsl.eletrovision.controle.recursos.ConstantesTelas;
import wsl.eletrovision.controle.recursos.InstanciasPortatil;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class TelaPrincipal extends Activity implements OnClickListener {

	private ImageButton bt_mensagem;
	private ImageButton bt_cenario;
	private ImageButton bt_dispositivo;
	private ImageButton bt_camera;
	private ImageButton bt_configuracoes;
	private ImageButton bt_foto;

	private ImageButton bt_sair;
	private ImageButton bt_sobre;
	public ImageButton bt_conectar;
	private ImageButton bt_usuarios;

	private ProgressDialog dialog;
	public Handler handle = new HandlePrincipal();
	private Resources resources;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_principal);
		InstanciasPortatil.setTelaPrincipal(this);
		resources = getResources();

		bt_mensagem = (ImageButton) findViewById(R.id.telaPrincipal_bt_mensagem);
		bt_mensagem.setOnClickListener(this);
		bt_cenario = (ImageButton) findViewById(R.id.telaPrincipal_bt_cenario);
		bt_cenario.setOnClickListener(this);
		bt_dispositivo = (ImageButton) findViewById(R.id.telaPrincipal_bt_dispositivos);
		bt_dispositivo.setOnClickListener(this);
		bt_camera = (ImageButton) findViewById(R.id.telaPrincipal_bt_cameras);
		bt_camera.setOnClickListener(this);
		bt_configuracoes = (ImageButton) findViewById(R.id.telaPrincipal_bt_configuracoes);
		bt_configuracoes.setOnClickListener(this);
		bt_foto = (ImageButton) findViewById(R.id.telaPrincipal_bt_foto);
		bt_foto.setOnClickListener(this);

		bt_sair = (ImageButton) findViewById(R.id.telaPrincipal_bt_sair);
		bt_sair.setOnClickListener(this);
		bt_conectar = (ImageButton) findViewById(R.id.telaPrincipal_bt_conectar);
		bt_conectar.setOnClickListener(this);
		bt_usuarios = (ImageButton) findViewById(R.id.telaPrincipal_bt_usuarios);
		bt_usuarios.setOnClickListener(this);
		bt_sobre = (ImageButton) findViewById(R.id.telaPrincipal_bt_sobre);
		bt_sobre.setOnClickListener(this);

		verificarStatusServidor();
		iniciarProcessoGPS();
	}

	@Override
	public void onClick(View v) {
		if (v == bt_mensagem) {
			Intent intent = new Intent(this, TelaMensagem.class);
			startActivity(intent);
		} else if (v == bt_cenario) {
			Intent intent = new Intent(this, TelaCenario.class);
			startActivity(intent);
		} else if (v == bt_dispositivo) {
			Intent intent = new Intent(this, TelaDispositivo.class);
			startActivity(intent);
		} else if (v == bt_camera) {
			Intent intent = new Intent(this, TelaCamera.class);
			startActivity(intent);
		} else if (v == bt_sair) {
			showDialog(ConstantesTelas.DIALOG_SIM_NAO);
		} else if (v == bt_conectar) {
			if (InstanciasPortatil.getCliente() == null) {
				Intent intent = new Intent(this, TelaConectar.class);
				startActivityForResult(intent, ConstantesTelas.RS_CONECTADO);
			} else {
				showDialog(ConstantesTelas.DIALOG_DESCONECTAR);
			}
		} else if (v == bt_usuarios) {
			Intent intent = new Intent(this, TelaUsuarios.class);
			startActivity(intent);
		} else if (v == bt_sobre) {
			Intent intent = new Intent(this, TelaSobre.class);
			startActivity(intent);
		} else if (v == bt_configuracoes) {
			Intent intent = new Intent(this, TelaOpcoes.class);
			startActivity(intent);
		} else if (v == bt_foto) {
			tirarUltimaFoto();
		}
	}
	
	private void verificarStatusServidor() {
		if (InstanciasPortatil.getCliente() != null && InstanciasPortatil.getCliente().getStatusConexao()) {
			bt_conectar.setImageResource(R.drawable.servidorl_36);
		} else {
			bt_conectar.setImageResource(R.drawable.servidor_36);
			InstanciasPortatil.setCliente(null); 
		}
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
			case ConstantesTelas.DIALOG_SIM_NAO:
				return new AlertDialog.Builder(this)
						.setIcon(R.drawable.alerta_50)
						.setTitle(R.string.dialog_tituloDialogSairPrograma)
						.setPositiveButton(R.string.dialog_sim,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog, int whichButton) {
										finish();
									}
								})
						.setNegativeButton(R.string.dialog_nao,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int whichButton) {
									}
								}).create();
			case ConstantesTelas.DIALOG_DESCONECTAR:
				return new AlertDialog.Builder(this)
						.setIcon(R.drawable.alerta_50)
						.setTitle(R.string.dialog_desconectar)
						.setPositiveButton(R.string.dialog_sim,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog, int whichButton) {
										InstanciasPortatil.getCliente().fecharConexao();
										InstanciasPortatil.setCliente(null);
										verificarStatusServidor();
									}
								})
						.setNegativeButton(R.string.dialog_nao,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int whichButton) {
									}
								}).create();
		}
		return null;
	}
	
	public void tirarUltimaFoto() {
		if(InstanciasPortatil.getCliente() != null) {
			dialog = ProgressDialog.show(this, resources.getString(R.string.geral_rede), 
					resources.getString(R.string.principal_buscandoultimafoto), true, true);
			InstanciasPortatil.getCliente().getTratarMensagem().setHandler(handle); 
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_TIRAR_ULTIMA_FOTO);
        } else {
        	Toast.makeText(this, resources.getString(R.string.geral_nao_conectado), Toast.LENGTH_SHORT).show();
        }
	}

	@Override
	protected void onActivityResult(int codigo, int resultado, Intent it) {
		if (it == null)
			return;
		switch (resultado) {
			case ConstantesTelas.RS_CONECTADO:
				verificarStatusServidor();
				break;
		}
	}
	
	@Override
    protected void onDestroy() {
    	super.onDestroy();
    }
	
	private void iniciarProcessoGPS() {
		Intent intent = new Intent("PROCESSO_GPS");
		PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		c.add(Calendar.SECOND, 5);
		AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), 30*1000, pendingIntent);
		//Repete de 30 em 30 segundos
	}
	
	private class HandlePrincipal extends Handler {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case ConstantesTelas.HD_ATUALIZAR_REDE:
					verificarStatusServidor();
					break;
				case ConstantesTelas.HD_ULTIMA_FOTO:
					dialog.dismiss();
					String confirmacao = msg.getData().getString(ConstantesTelas.BD_ULTIMA_FOTO);
					if(confirmacao.equals("0")) {
						Toast.makeText(TelaPrincipal.this, resources.getString(R.string.principal_ultimafotoindisponivel), Toast.LENGTH_SHORT).show();
					} 
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