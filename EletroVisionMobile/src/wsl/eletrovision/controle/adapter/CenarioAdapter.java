package wsl.eletrovision.controle.adapter;

import java.util.ArrayList;

import wsl.eletrovision.R;
import wsl.eletrovision.controle.serializado.GuardaCenario;
import wsl.eletrovision.telas.TelaCenario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class CenarioAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<GuardaCenario> cenarios;
	private TelaCenario telaCenario;
	
	public CenarioAdapter(Context context, ArrayList<GuardaCenario> cenarios, TelaCenario telaCenario) {
		this.context = context;
		this.cenarios = cenarios;
		this.telaCenario = telaCenario;
	}

	@Override
	public int getCount() {
		return cenarios.size();
	}

	@Override
	public Object getItem(int position) {
		return cenarios.get(position);
	}

	@Override
	public long getItemId(int id) {
		return id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final GuardaCenario cenario = (GuardaCenario) cenarios.get(position);
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.lista_cenario, null);
		TextView tv_titulo = (TextView)view.findViewById(R.id.listaCenario_tv_cenario);
		ImageButton bt_acionar = (ImageButton) view.findViewById(R.id.listaCenario_ib_acionar);
		ImageButton bt_configuracao = (ImageButton) view.findViewById(R.id.listaCenario_ib_configuracao);
		
		bt_configuracao.setImageResource(R.drawable.config);
		if(cenario.getAcao().equals("Desligar")) {
			bt_acionar.setImageResource(R.drawable.acionamento_ativado2);
		} else {
			bt_acionar.setImageResource(R.drawable.acionamento_desativado);
		}
		bt_acionar.setOnClickListener(new ImageButton.OnClickListener() {
			public void onClick(View v) {
				telaCenario.acionar(cenario);
			}
		});
		bt_configuracao.setOnClickListener(new ImageButton.OnClickListener() {
			public void onClick(View v) {
				telaCenario.configurar(cenario);
			}
		});
		
		
		tv_titulo.setText(cenario.getCenario());
		
		return view;
	}
	
}
