package musicplayer.example.com.musicplayer;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class GetLocation extends AppCompatActivity implements LocationListener {

    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        //criteria is for choosing a provider " satellite"
        Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(new Criteria(), false));

        locationManager.requestLocationUpdates(locationManager.getBestProvider(new Criteria(), false), 5000, 1, this);

        //if GPS is on
        if(location!=null)
            onLocationChanged(location);


    }

    @Override
    public void onLocationChanged(android.location.Location location) {

        if(location!=null)
        {
            Double lat = location.getLatitude();
            Double lng = location.getLongitude();
            Toast.makeText(getApplicationContext(), lng + " " + lat, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(intent);
        Toast.makeText(getBaseContext(), "Gps is turned off!! ",
                Toast.LENGTH_SHORT).show();
    }
}
