package wsl.eletrovision.telas;

import wsl.eletrovision.R;
import wsl.eletrovision.controle.recursos.ConstantesTelas;
import wsl.eletrovision.controle.recursos.Preferencias;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageButton;

public class TelaOpcoes extends Activity implements OnClickListener {
	
	private ImageButton bt_voltar;
	
	private CheckBox ck_localizacaoGps;
	private CheckBox ck_audio;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_opcoes);
        
        bt_voltar = (ImageButton) findViewById(R.id.telaOpcoes_bt_voltar);
        bt_voltar.setOnClickListener(this);
        
        ck_localizacaoGps = (CheckBox) findViewById(R.id.telaOpcoes_ck_enviarLocalizacaoGPS);
        ck_localizacaoGps.setOnClickListener(this);
        ck_audio = (CheckBox) findViewById(R.id.telaOpcoes_ck_executarAudio);
        ck_audio.setOnClickListener(this);
        
        verificarPreferencias();
    }
	
	/* 
	 * EVENTOS
	 * */
	
	@Override
	public void onClick(View v) {
		if(v == bt_voltar) {
			finish();
		} else if(v == ck_localizacaoGps) {
			if(ck_localizacaoGps.isChecked()) localizacaoGps(true);
			else localizacaoGps(false);
		} else if(v == ck_audio) {
			if(ck_audio.isChecked()) audio(true);
			else audio(false);
		}
	}
	
	/* 
	 * AÇOES ESPECIFICAS
	 * */
	
	private void verificarPreferencias() {
		if(Preferencias.getLocalizacaoGps(this)) ck_localizacaoGps.setChecked(true);
		else ck_localizacaoGps.setChecked(false);
		if(Preferencias.getAudio(this)) ck_audio.setChecked(true);
		else ck_audio.setChecked(false);
	}
	
	private void localizacaoGps(Boolean valor) {
		SharedPreferences preferencias = getSharedPreferences(ConstantesTelas.PF_NOME_PREFERENCIA, MODE_PRIVATE);
		SharedPreferences.Editor editor = preferencias.edit();
		editor.putBoolean(ConstantesTelas.PF_LOCALIZACAO_GPS, valor);
		editor.commit();
	}
	
	private void audio(Boolean valor) {
		SharedPreferences preferencias = getSharedPreferences(ConstantesTelas.PF_NOME_PREFERENCIA, MODE_PRIVATE);
		SharedPreferences.Editor editor = preferencias.edit();
		editor.putBoolean(ConstantesTelas.PF_AUDIO, valor);
		editor.commit();
	}

}
