package wsl.eletrovision.controle.adapter;

import java.util.ArrayList;

import wsl.eletrovision.R;
import wsl.eletrovision.controle.serializado.GuardaCamera;
import wsl.eletrovision.telas.TelaCamera;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class CameraAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<GuardaCamera> cameras;
	private TelaCamera telaCamera;
	
	public CameraAdapter(Context context, ArrayList<GuardaCamera> cameras, TelaCamera telaCamera) {
		this.context = context;
		this.cameras = cameras;
		this.telaCamera = telaCamera;
	}

	@Override
	public int getCount() {
		return cameras.size();
	}

	@Override
	public Object getItem(int position) {
		return cameras.get(position);
	}

	@Override
	public long getItemId(int id) {
		return id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final GuardaCamera camera = (GuardaCamera) cameras.get(position);
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.lista_camera, null);
		TextView tv_titulo = (TextView)view.findViewById(R.id.listaCamera_tv_camera);
		ImageButton bt_tirarFoto = (ImageButton) view.findViewById(R.id.listaCamera_ib_tirarFoto);
		ImageButton bt_configuracao = (ImageButton) view.findViewById(R.id.listaCamera_ib_configuracao);
		
		bt_configuracao.setImageResource(R.drawable.config);
		bt_tirarFoto.setImageResource(R.drawable.tirarfoto);
		bt_tirarFoto.setOnClickListener(new ImageButton.OnClickListener() {
			public void onClick(View v) {
				telaCamera.tirarFoto(camera);
			}
		});
		bt_configuracao.setOnClickListener(new ImageButton.OnClickListener() {
			public void onClick(View v) {
				telaCamera.configuracao(camera);
			}
		});
		
		tv_titulo.setText(camera.getCamera());
		
		return view;
	}
	
}
