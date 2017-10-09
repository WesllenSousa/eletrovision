package wsl.eletrovision.controle.adapter;

import java.util.ArrayList;

import wsl.eletrovision.R;
import wsl.eletrovision.controle.serializado.GuardaDispositivo;
import wsl.eletrovision.telas.TelaDispositivo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class DispositivoAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<GuardaDispositivo> dispositivos;
	private TelaDispositivo telaDispositivo;
	
	public DispositivoAdapter(Context context, ArrayList<GuardaDispositivo> dispositivos, TelaDispositivo telaDispositivo) {
		this.context = context;
		this.dispositivos = dispositivos;
		this.telaDispositivo = telaDispositivo;
	}

	@Override
	public int getCount() {
		return dispositivos.size();
	}

	@Override
	public Object getItem(int position) {
		return dispositivos.get(position);
	}

	@Override
	public long getItemId(int id) {
		return id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final GuardaDispositivo dispositivo = (GuardaDispositivo) dispositivos.get(position);
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.lista_dispositivo, null);
		TextView tv_titulo = (TextView)view.findViewById(R.id.listaDispositivo_tv_dispositivo);
		ImageButton bt_ligar = (ImageButton) view.findViewById(R.id.listaDispositivo_ib_ligar);
		
		if(dispositivo.getAcao().equals("Desligar")) {
			bt_ligar.setImageResource(R.drawable.dispositivo_ligado);
		} else {
			bt_ligar.setImageResource(R.drawable.dispositivo_desligado);
		}
		bt_ligar.setOnClickListener(new ImageButton.OnClickListener() {
			public void onClick(View v) {
				telaDispositivo.acionar(dispositivo);
			}
		});
		tv_titulo.setText(dispositivo.getDispositivo());
		
		return view;
	}
	
}
