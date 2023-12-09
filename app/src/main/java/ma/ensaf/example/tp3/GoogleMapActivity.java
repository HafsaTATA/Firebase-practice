package ma.ensaf.example.tp3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);


        SupportMapFragment mapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        LatLng ensaFes = new LatLng(33.99666584009761, -4.991943719090541);
        Marker markerFes = googleMap.addMarker(new MarkerOptions().position(ensaFes).title("ENSA Fes"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ensaFes, 10));

        LatLng ensaAgadir = new LatLng(30.406030426000562, -9.529829604128905);
        Marker markerAgadir = googleMap.addMarker(new MarkerOptions().position(ensaAgadir).title("ENSA Agadir"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ensaFes, 10));

        LatLng ensaElJadida = new LatLng(33.25117882968763, -8.434111604020861);
        Marker markerElJadida = googleMap.addMarker(new MarkerOptions().position(ensaElJadida).title("ENSA ElJadida"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ensaFes, 10));

        LatLng ensaKenitra = new LatLng(34.28760097111719, -6.572344628678676);
        Marker markerKenitra = googleMap.addMarker(new MarkerOptions().position(ensaKenitra).title("Ensa Kenitra"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ensaKenitra, 10));

        LatLng ensaTanger = new LatLng(35.85560155344618, -5.911211790892528);
        Marker markerTanger = googleMap.addMarker(new MarkerOptions().position(ensaTanger).title("ENSA Tanger"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ensaTanger, 10));

        LatLng ensaTetouan = new LatLng(35.56235994410579, -5.364460973241401);
        Marker markerTetouan = googleMap.addMarker(new MarkerOptions().position(ensaTetouan).title("ENSA Tetouan"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ensaTetouan, 10));

        LatLng ensaSafi = new LatLng(32.327134217006616, -9.263649775221435);
        Marker markerSafi = googleMap.addMarker(new MarkerOptions().position(ensaSafi).title("ENSA Safi"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ensaSafi, 10));

        LatLng ensaMarrakech = new LatLng(31.64693200819888, -8.020397690589697);
        Marker markerMarrakech = googleMap.addMarker(new MarkerOptions().position(ensaMarrakech).title("ENSA Marrakech"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ensaMarrakech, 10));

        LatLng ensaOujda = new LatLng(34.651638721294454, -1.8961679403569394);
        Marker markerOujda = googleMap.addMarker(new MarkerOptions().position(ensaOujda).title("ENSA Oujda"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ensaOujda, 10));

        LatLng ensaBeniMellal = new LatLng(32.49323305296787, -6.338355365726272);
        Marker marker1 = googleMap.addMarker(new MarkerOptions().position(ensaBeniMellal).title("ENSA Beni Mellal"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ensaBeniMellal, 10));

        LatLng ensaKhouribga = new LatLng(32.897283774726134, -6.913785361705974);
        Marker markerKhouribga = googleMap.addMarker(new MarkerOptions().position(ensaKhouribga).title("ENSA Khouribga"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ensaFes, 10));

        LatLng ensaAlHoceima = new LatLng(35.27055938980936, -3.8343644321541213);
        Marker markerAlHoceima = googleMap.addMarker(new MarkerOptions().position(ensaAlHoceima).title("ENSA AlHoceima"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ensaAlHoceima, 10));

        LatLng ensaBerrechid = new LatLng(33.25889494589365, -7.5839708040205345);
        Marker markerBerrechid = googleMap.addMarker(new MarkerOptions().position(ensaBerrechid).title("ENSA Berrechid"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ensaBerrechid, 10));

        LatLng initialPosition = new LatLng(33.99666584009761, -4.991943719090541);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(initialPosition, 6));
    }

}