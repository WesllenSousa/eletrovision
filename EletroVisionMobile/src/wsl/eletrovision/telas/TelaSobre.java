package wsl.eletrovision.telas;

import wsl.eletrovision.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class TelaSobre extends Activity implements OnClickListener {
	
	private ImageButton bt_voltar;
	
	@Override 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_sobre);
        
        bt_voltar = (ImageButton) findViewById(R.id.telaSobre_bt_voltar);
        bt_voltar.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		if(v == bt_voltar) {
			finish();
		} 
	}

}
