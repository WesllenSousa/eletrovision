package wsl.eletrovision.controle.recursos;

import wsl.eletrovision.R;
import android.content.Context;
import android.media.MediaPlayer;

public class ExecutarAudio {
	
	public static void pessoasDetectadas(Context context) {
		if(Preferencias.getAudio(context)) {
			MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.pessoas_detectadas);
	        mediaPlayer.start();
		}
	}
	
	public static void cenarioAcionado(Context context) {
		if(Preferencias.getAudio(context)) {
			MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.cenario_acionado);
	        mediaPlayer.start();
		}
	}
	
	public static void dispositivoAcionado(Context context) {
		if(Preferencias.getAudio(context)) {
			MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.dispositivo_acionado);
	        mediaPlayer.start();
		}
	}

	public static void agendamentoDisparado(Context context) {
		if(Preferencias.getAudio(context)) {
			MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.agendamento_disparado);
	        mediaPlayer.start();
		}
	}
	
	public static void faceReconhecida(Context context) {
		if(Preferencias.getAudio(context)) {
			MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.face_reconhecida);
	        mediaPlayer.start();
		}
	}
	
	public static void visita(Context context) {
		if(Preferencias.getAudio(context)) {
			MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.visita);
	        mediaPlayer.start();
		}
	}
	
	public static void movimento(Context context) {
		if(Preferencias.getAudio(context)) {
			MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.movimento_detectado);
	        mediaPlayer.start();
		}
	}
	
	public static void ambiente(Context context) {
		if(Preferencias.getAudio(context)) {
			MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.ambiente_alterado);
	        mediaPlayer.start();
		}
	}
	
	public static void telefone(Context context) {
		if(Preferencias.getAudio(context)) {
			MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.telefone);
	        mediaPlayer.start();
		}
	}

}
