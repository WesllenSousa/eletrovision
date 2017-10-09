package wsl.eletrovision.controle.gps;

import android.location.Location;

import com.google.android.maps.GeoPoint;

public class Ponto extends GeoPoint {
	
	//valores micro-graus
	public Ponto(int latitudeE6, int longitudeE6) {
		super(latitudeE6, longitudeE6);
	}
	
	//valores em graus
	public Ponto(double latitude, double longitude) {
		this((int)(latitude * 1E6), (int)(longitude * 1E6));
	}
	
	//valores baseados em locations vindo direto do GPS
	public Ponto(Location location) {
		this(location.getLatitude(), location.getLongitude());
	}
	
}
