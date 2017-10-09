package wsl.eletrovision.controle.recursos;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferencias {
	
	public static Boolean getLocalizacaoGps(Context context) {
		SharedPreferences preferencias = context.getSharedPreferences(ConstantesTelas.PF_NOME_PREFERENCIA, 0);
		return preferencias.getBoolean(ConstantesTelas.PF_LOCALIZACAO_GPS, true);
	}
	
	public static Boolean getAudio(Context context) {
		SharedPreferences preferencias = context.getSharedPreferences(ConstantesTelas.PF_NOME_PREFERENCIA, 0);
		return preferencias.getBoolean(ConstantesTelas.PF_AUDIO, true);
	}

}
