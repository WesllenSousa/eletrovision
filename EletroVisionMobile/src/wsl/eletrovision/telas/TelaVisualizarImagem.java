package wsl.eletrovision.telas;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import wsl.eletrovision.R;
import wsl.eletrovision.controle.gesture.GestureImageView;
import wsl.eletrovision.controle.recursos.ConstantesTelas;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class TelaVisualizarImagem extends Activity implements OnClickListener {
	
	private ImageButton bt_voltar;
	private ImageButton bt_salvar;
	private GestureImageView iv_imagem;
	
	private byte[] byteImagens;
	private Resources resources;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_visualizarimagem);
        resources = getResources();
        
        bt_voltar = (ImageButton) findViewById(R.id.telaVisualizarImagem_bt_voltar);
        bt_voltar.setOnClickListener(this);
        bt_salvar = (ImageButton) findViewById(R.id.telaVisualizarImagem_bt_salvar);
        bt_salvar.setOnClickListener(this);
        iv_imagem = (GestureImageView) findViewById(R.id.telaVisualizarImagem_iv_imagem);
        
        //Recupera a imagem que foi passada por parametro
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
	        byteImagens = bundle.getByteArray("imagem");
        	Bitmap bitmap = BitmapFactory.decodeByteArray(byteImagens, 0, byteImagens.length);
	        iv_imagem.setImageBitmap(bitmap);
        } 
    }

	@Override
	public void onClick(View v) {
		if(v == bt_voltar) {
			finish();
		} else if(v == bt_salvar) {
			if(byteImagens.length != 0) {
				showDialog(ConstantesTelas.DIALOG_ENTRADA);
			} else {
	        	Toast.makeText(TelaVisualizarImagem.this, resources.getString(R.string.visualizarimagem_semimagem), Toast.LENGTH_SHORT).show();
	        } 
		}
	}
	
	private void salvarImagem(byte[] imageData, int quality, String nome) {

        String externalStoragePath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/eletrovision"; 
        File dir = new File(externalStoragePath);
        if(!dir.exists()) dir.mkdirs();
        
        File sdImageMainDirectory = new File(externalStoragePath);
        FileOutputStream fileOutputStream = null;
        try {

            BitmapFactory.Options options=new BitmapFactory.Options();
            options.inSampleSize = 5;
            
            Bitmap myImage = BitmapFactory.decodeByteArray(imageData, 0,
                    imageData.length,options);
            
            fileOutputStream = new FileOutputStream(
                    sdImageMainDirectory.toString() +"/"+nome+".jpg");
  
            BufferedOutputStream bos = new BufferedOutputStream(
                    fileOutputStream);

            myImage.compress(CompressFormat.JPEG, quality, bos);

            bos.flush();
            bos.close();
            
            Toast.makeText(TelaVisualizarImagem.this, resources.getString(R.string.visualizarimagem_salvar), Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	
	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case ConstantesTelas.DIALOG_ENTRADA:
            // This example shows how to add a custom layout to an AlertDialog
            LayoutInflater factory = LayoutInflater.from(this);
            final View textEntryView = factory.inflate(R.layout.dialog_nome_arquivo, null);
            return new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_arquivo)
                .setView(textEntryView)
                .setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    	EditText et_nome = (EditText) textEntryView.findViewById(R.id.dialog_edit);
                    	salvarImagem(byteImagens, 50, et_nome.getText().toString());
                    }
                })
                .setNegativeButton(R.string.dialog_cancelar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                })
                .create();
		}
		return null;
	}
	
}
