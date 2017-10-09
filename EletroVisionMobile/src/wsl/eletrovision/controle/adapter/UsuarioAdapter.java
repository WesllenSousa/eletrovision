package wsl.eletrovision.controle.adapter;

import java.util.ArrayList;

import wsl.eletrovision.R;
import wsl.eletrovision.controle.serializado.ClientesConectado;
import wsl.eletrovision.telas.TelaUsuarios;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class UsuarioAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<ClientesConectado> clientesConectados;
	private TelaUsuarios telaUsuarios;
	
	public UsuarioAdapter(Context context, ArrayList<ClientesConectado> clientesConectados, TelaUsuarios telaUsuarios) {
		this.context = context;
		this.clientesConectados = clientesConectados;
		this.telaUsuarios = telaUsuarios;
	}

	@Override
	public int getCount() {
		return clientesConectados.size();
	}

	@Override
	public Object getItem(int position) {
		return clientesConectados.get(position);
	}

	@Override
	public long getItemId(int id) {
		return id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ClientesConectado clientesConectado = (ClientesConectado) clientesConectados.get(position);
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.lista_usuarios, null);
		TextView tv_titulo = (TextView)view.findViewById(R.id.listaUsuario_tv_usuario);
		ImageButton bt_gps = (ImageButton) view.findViewById(R.id.listaUsuario_ib_gps);
		
		bt_gps.setImageResource(R.drawable.gps);
		bt_gps.setOnClickListener(new ImageButton.OnClickListener() {
			public void onClick(View v) {
				telaUsuarios.gps(clientesConectado.getContato());
			}
		});
		tv_titulo.setText(clientesConectado.getContato());
		
		return view;
	}
	
}
