package wsl.eletrovision.controle.adapter;

import java.util.ArrayList;

import wsl.eletrovision.R;
import wsl.eletrovision.controle.serializado.GuardaMensagem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MensagensAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<GuardaMensagem> mensagens;
	
	public MensagensAdapter(Context context, ArrayList<GuardaMensagem> mensagens) {
		this.context = context;
		this.mensagens = mensagens;
	}

	@Override
	public int getCount() {
		return mensagens.size();
	}

	@Override
	public Object getItem(int position) {
		return mensagens.get(position);
	}

	@Override
	public long getItemId(int id) {
		return id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		GuardaMensagem mensagem = (GuardaMensagem) mensagens.get(position);
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.lista_mensagens, null);
		TextView tv_titulo = (TextView)view.findViewById(R.id.listaMensagem_tv_titulo);
		TextView tv_mensagem = (TextView) view.findViewById(R.id.listaMensagem_tv_compMensagem);
		
		tv_titulo.setText(mensagem.getContato());
		tv_mensagem.setText(mensagem.getMensagem());
		
		return view;
	}
	
}
