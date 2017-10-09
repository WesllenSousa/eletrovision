package wsl.eletrovision.telas;

import wsl.eletrovision.R;
import wsl.eletrovision.controle.gps.Ponto;
import wsl.eletrovision.controle.recursos.ConstantesTelas;
import wsl.eletrovision.controle.recursos.InstanciasPortatil;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;

public class TelaMapa extends MapActivity implements LocationListener, OnClickListener {
	
	private MapController controlador;
	
	private ImageButton bt_voltar;
	private MapView mapa;
	private MyLocationOverlay myLocationOverlay;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_mapa);
        InstanciasPortatil.setTelaMapa(this);
        
        bt_voltar = (ImageButton) findViewById(R.id.telaMapa_bt_voltar);
        bt_voltar.setOnClickListener(this);
        mapa = (MapView) findViewById(R.id.mapa);
        
        controlador = mapa.getController();
        controlador.setZoom(16);
          
        myLocationOverlay = new MyLocationOverlay(this, mapa);
        mapa.getOverlays().add(myLocationOverlay);
        mapa.setBuiltInZoomControls(true);
        
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
        	Double latitude = bundle.getDouble(ConstantesTelas.BD_MAPA_LATITUDE);
        	Double longitude = bundle.getDouble(ConstantesTelas.BD_MAPA_LONGITUDE);
        	Ponto ponto = new Ponto(latitude, longitude);
        	controlador.setCenter(ponto);
        }
 
	}
	
	@Override
	public void onClick(View v) {
		if(v == bt_voltar) {
			finish();
		} 
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		myLocationOverlay.enableMyLocation();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		myLocationOverlay.disableMyLocation();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		InstanciasPortatil.setTelaMapa(null);
	}

	@Override
	public void onLocationChanged(Location location) {
	}

	@Override
	public void onProviderDisabled(String provider) {
	}

	@Override
	public void onProviderEnabled(String provider) {
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

}
