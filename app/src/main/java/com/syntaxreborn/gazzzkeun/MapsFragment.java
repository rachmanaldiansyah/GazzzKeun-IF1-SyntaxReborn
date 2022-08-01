package com.syntaxreborn.gazzzkeun;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//Identitas
//1. Reihan wiyanda - 10119011
//2. Rachman Aldiansyah - 10119038
//3. Diva Sabila Ramadhan - 10119039
//4. Rendy Dermawan- 10119030
//5. Adira Fahri Gathan - 10119025
// IF-1
public class MapsFragment extends Fragment {
    private FusedLocationProviderClient client;
    private SupportMapFragment mapFragment;
    private final OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {
            DatabaseReference database = FirebaseDatabase.getInstance().getReference();
            //mengambil data pada Hutan - Reihan
            DatabaseReference hutanRef = database.child("Hutan");
            hutanRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (task.isSuccessful()) {
                        DataSnapshot snapshot = task.getResult();
                        double lat = snapshot.child("Lat").getValue(Double.class);
                        double lng = snapshot.child("Long").getValue(Double.class);
                        Log.d("TAG", lat + ", " + lng);
                        LatLng Hutan = new LatLng(Double.valueOf(lat), Double.valueOf(lng));
                        googleMap.addMarker(new MarkerOptions().position(Hutan).title("Taman Hutan Raya Ir. H. Djuanda"));
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Hutan, 17));
                    } else {
                        Log.d("TAG", task.getException().getMessage()); //Never ignore potential errors!
                    }
                }
            });

            //mengambil data pada Lembang - Reihan
            DatabaseReference lembangRef = database.child("Floating");
            lembangRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (task.isSuccessful()) {
                        DataSnapshot snapshot = task.getResult();
                        double lat = snapshot.child("Lat").getValue(Double.class);
                        double lng = snapshot.child("Long").getValue(Double.class);
                        Log.d("TAG", lat + ", " + lng);
                        LatLng Lembang = new LatLng(Double.valueOf(lat), Double.valueOf(lng));
                        googleMap.addMarker(new MarkerOptions().position(Lembang).title("Floating Market Lembang"));
//                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Lembang, 17));
                    } else {
                        Log.d("TAG", task.getException().getMessage()); //Never ignore potential errors!
                    }
                }
            });

            //mengambil data pada Alun - Reihan
            DatabaseReference alun = database.child("Alun");
            alun.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (task.isSuccessful()) {
                        DataSnapshot snapshot = task.getResult();
                        double lat = snapshot.child("Lat").getValue(Double.class);
                        double lng = snapshot.child("Long").getValue(Double.class);
                        Log.d("TAG", lat + ", " + lng);
                        LatLng Alun = new LatLng(Double.valueOf(lat), Double.valueOf(lng));
                        googleMap.addMarker(new MarkerOptions().position(Alun).title("Alun-alun Kota Bandung"));
//                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Lembang, 17));
                    } else {
                        Log.d("TAG", task.getException().getMessage()); //Never ignore potential errors!
                    }
                }
            });

            //mengambil data pada kawah - Reihan
            DatabaseReference kawahRef = database.child("Kawah");
            kawahRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (task.isSuccessful()) {
                        DataSnapshot snapshot = task.getResult();
                        double lat = snapshot.child("Lat").getValue(Double.class);
                        double lng = snapshot.child("Long").getValue(Double.class);
                        Log.d("TAG", lat + ", " + lng);
                        LatLng Kawah = new LatLng(Double.valueOf(lat), Double.valueOf(lng));
                        googleMap.addMarker(new MarkerOptions().position(Kawah).title("Kawah Putih Ciwidey"));
//                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Lembang, 17));
                    } else {
                        Log.d("TAG", task.getException().getMessage()); //Never ignore potential errors!
                    }
                }
            });

            //mengambil data pada Cai - Reihan
            DatabaseReference caiRef = database.child("Cai");
            caiRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (task.isSuccessful()) {
                        DataSnapshot snapshot = task.getResult();
                        double lat = snapshot.child("Lat").getValue(Double.class);
                        double lng = snapshot.child("Long").getValue(Double.class);
                        Log.d("TAG", lat + ", " + lng);
                        LatLng Cai = new LatLng(Double.valueOf(lat), Double.valueOf(lng));
                        googleMap.addMarker(new MarkerOptions().position(Cai).title("Kampung Cai Ranca Upas"));
//                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Lembang, 17));
                    } else {
                        Log.d("TAG", task.getException().getMessage()); //Never ignore potential errors!
                    }
                }
            });

            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            client = LocationServices.getFusedLocationProviderClient(requireActivity());
            mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
            getCurrentLocation();
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    // setting googleMaps
    private void getCurrentLocation() {

        if (ContextCompat.checkSelfPermission(requireActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(requireActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }
        client = LocationServices.getFusedLocationProviderClient(requireActivity());

        client.getLastLocation().addOnSuccessListener(location -> {
            if (location != null) {
                mapFragment.getMapAsync(googleMap -> {
                    Log.e("Last Location: ", location.toString());
                    LatLng currentLoc = new LatLng(location.getLatitude(), location.getLongitude());
                    googleMap.addMarker(new MarkerOptions().position(currentLoc).title("Lokasi anda saat ini"));
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLoc, 17));
                });

            }
        });
    }
}

//Stackoverflow the best