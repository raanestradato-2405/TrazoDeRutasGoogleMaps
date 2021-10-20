package com.example.trazar_linea;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.trazar_linea.Utils.Utils;
import com.example.trazar_linea.other.EnableServices;
import com.example.trazar_linea.other.GPSTracker;
import com.example.trazar_linea.other.PermissionGranted;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener, GoogleMap.OnMarkerClickListener {


    GoogleMap nMap;
    JsonObjectRequest jsonObjectRequest;
    RequestQueue request;
    //  Button btnEnviar;
    ProgressBar progressBar;
    Location location;
    GPSTracker gpsTracker;
    private View pop = null;



    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress_circular);
        gpsTracker = new GPSTracker(getApplicationContext());
        location = gpsTracker.getLocation();
        // btnEnviar = findViewById(R.id.btn);

        //recibirparametroDeInicio();


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        request = Volley.newRequestQueue(getApplicationContext());
        if (PermissionGranted.checkPermiso(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)) {   //Si tiene el permiso de gps

            locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

            if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {                             //Si el gps esta activo
                FragmentManager fragmentManager = getSupportFragmentManager();
                EnableServices enableServices = new EnableServices();
                enableServices.show(fragmentManager, null);

            } else {
                //Toast.makeText(this,"tienes activar gps",Toast.LENGTH_SHORT).show();

            }

        } else {

            PermissionGranted.pedirPermiso(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);
        }


    }

    Geocoder geocoder = new Geocoder(this, Locale.getDefault());


    @Override
    public void onMapReady(GoogleMap googleMap) {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        nMap = googleMap;
        nMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {


                return pop;
            }
        });
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        nMap.setMyLocationEnabled(true);
        LatLng we = new LatLng(-12.07614625353171, -76.98364348978973);
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(we,6));


        // nMap.animateCamera(CameraUpdateFactory.newLatLngZoom(we,13),5000,null);
        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.mapstyle));


            if (!success) {
                Log.e("MainActivityInicioMapas" ,"Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("MainActivityInicioMapas", "Can't find style. Error: ", e);
        }







        try {
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.mapstyle));
            if (!success) {
                Log.e("error", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("error", "Can't find style. Error: ", e);
        }
        //googleMap.moveCamera(CameraUpdateFactory.zoomBy(20));


        Utils.markersDefault(nMap, getApplicationContext());


        nMap.setOnMapLongClickListener(this);
        nMap.setOnMarkerClickListener(this);

    }


    @Override
    public void onMapLongClick(LatLng latLng) {
        Utils.coordenadas.setOrigenLat(latLng.latitude);
        Utils.coordenadas.setOrigenLat(latLng.longitude);
        //nMap.addMarker(new MarkerOptions().position(latLng)).setTitle("Punto de inicio");
        Toast.makeText(this, "Toque icono donde sea dirigir", Toast.LENGTH_SHORT).show();
    }

    public void ObtenerRuta(String latInicial, String lngInicial, String latFinal, String lngFinal){

        String url = "https://maps.googleapis.com/maps/api/directions/json?origin=" + latInicial + "," + lngInicial + "&destination=" + latFinal + "," + lngFinal + "&key=AIzaSyBq8-SqVB8et7Jr6fHcKoVi_vBtXMAxwTU&mode=drive";

        //Toast.makeText(this, latInicial, Toast.LENGTH_SHORT).show();

        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONArray jRoutes = null;
                JSONArray jLegs = null;
                JSONArray jSteps = null;
                //Toast.makeText(MainActivityInicioMapas.this, "hola", Toast.LENGTH_SHORT).show();

                try {

                    jRoutes = response.getJSONArray("routes");

                    //Toast.makeText(MainActivityInicioMapas.this, String.valueOf(response), Toast.LENGTH_SHORT).show();
                    /** Traversing all routes */
                    for(int i=0;i<jRoutes.length();i++){
                        //Log.d("Routesssssssssss: ", String.valueOf(i));
                        jLegs = ( (JSONObject)jRoutes.get(i)).getJSONArray("legs");
                        List<HashMap<String, String>> path = new ArrayList<HashMap<String, String>>();
                        //Log.d("Routesssssssssss: ", String.valueOf(jLegs));
                        /** Traversing all legs */
                        for(int j=0;j<jLegs.length();j++){
                            jSteps = ( (JSONObject)jLegs.get(j)).getJSONArray("steps");

                            /** Traversing all steps */
                            for(int k=0;k<jSteps.length();k++){
                                //Log.d("steepssssssssssss", "aaaaaaaaaaaaaa");
                                //Toast.makeText(MainActivityInicioMapas.this, String.valueOf(jSteps.length()), Toast.LENGTH_SHORT).show();
                                String polyline = "";
                                polyline = (String)((JSONObject)((JSONObject)jSteps.get(k)).get("polyline")).get("points");
                                List<LatLng> list = decodePoly(polyline);
                                //Toast.makeText(MainActivityInicioMapas.this, String.valueOf(list.get(0)), Toast.LENGTH_LONG).show();

                                /** Traversing all points */
                                for(int l=0;l<list.size();l++){
                                    //Toast.makeText(MainActivityInicioMapas.this, String.valueOf(list.size()), Toast.LENGTH_SHORT).show();
                                    HashMap<String, String> hm = new HashMap<String, String>();
                                    hm.put("lat", Double.toString(((LatLng)list.get(l)).latitude) );
                                    hm.put("lng", Double.toString(((LatLng)list.get(l)).longitude) );
                                    path.add(hm);
                                    //Toast.makeText(MainActivityInicioMapas.this, String.valueOf(path.size()), Toast.LENGTH_SHORT).show();
                                }
                            }
                            //Log.d("AAAAAAAAAAAAAAAAA", String.valueOf(Utilidades.routes.size()));
                            Utils.routes.add(path);
                            //Log.d("AAAAAAAAAAAAAAAAA", String.valueOf(Utilidades.routes.size()));
                            Intent intent = new Intent(MainActivity.this, TrasarLinea_Mpas.class);
                            startActivity(intent);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }catch (Exception e){
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "No se puede conectar "+error.toString(), Toast.LENGTH_LONG).show();
                System.out.println();
                Log.d("ERROR: ", error.toString());
            }
        }
        );

        request.add(jsonObjectRequest);

    }


    private List<LatLng> decodePoly(String encoded) {

        List<LatLng> poly = new ArrayList<LatLng>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            LatLng p = new LatLng((((double) lat / 1E5)),
                    (((double) lng / 1E5)));
            poly.add(p);
        }

        return poly;
    }







    public  class MyAsyncTask extends AsyncTask<Integer, Integer, String> {                        //Se declara una clase que extiende de AsyncTask y entre los pico parentesis se ingresa los tipo de datos que manejará


        @Override
        protected void onPreExecute() {                                                             //1 metodo en ejecutarse
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);                                                //Se establece el progressbar como visible
        }

        @Override
        protected String doInBackground(Integer... integers) {                                      //2 metodo en ejecutarse recibe el parametro 1 del AsyncTask y retorna el parametro 3 del mismo

            try {
                while (location == null){
                    location = gpsTracker.getLocation();
                    publishProgress(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            location = gpsTracker.getLocation();
            publishProgress(2);

            return "Fin";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {                                        //Obtiene el parametro 2 del AsyncTask y muestra el progreso de la ejecución del doInBackground
            super.onProgressUpdate(values);

            if(values[0] == 1){
                Log.d("Asyntask", "null");
            }else{
                Log.d("Asyntask", "Coordenadas");
                Toast.makeText(MainActivity.this, "LISTO", Toast.LENGTH_SHORT).show();
                Utils.coordenadas.setOrigenLat(location.getLatitude());
                Utils.coordenadas.setOriggenLng(location.getLongitude());
                Log.d("Asyntask", String.valueOf(location.getLatitude()));
                Log.d("Asyntask", String.valueOf(location.getLongitude()));
                ObtenerRuta(String.valueOf(Utils.coordenadas.getOrigenLat()), String.valueOf(Utils.coordenadas.getOriggenLng()),
                        String.valueOf(Utils.coordenadas.getDestinoLat()), String.valueOf(Utils.coordenadas.getDestinoLng()));

            }
            progressBar.setProgress(values[0]);                                                     //Envia al progressbar el progreso actual
        }

        @Override
        protected void onPostExecute(String s) {                                                    //El ultimo metodo en ejecutarse y obtiene el parametro "result" del AsyncTask
            super.onPostExecute(s);
            Log.d("asyntask", "FIN");
            progressBar.setVisibility(View.INVISIBLE);                                              //Oculta el progressbar del GUI al finalizar el AsynTask
        }
    }







    public void AlertShow(String title, final LatLng latLng){
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);

        builder.setMessage("Desea ir este punto?");
        builder.setTitle(title);
        builder.setCancelable(false);

        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Utils.coordenadas.setDestinoLat(latLng.latitude);
                Utils.coordenadas.setDestinoLng(latLng.longitude);

                new MyAsyncTask().execute(50);
                //ObtenerRuta(String.valueOf(Utils.coordenadas.getOrigenLat()), String.valueOf(Utils.coordenadas.getOriggenLng()),
                //        String.valueOf(Utils.coordenadas.getDestinoLat()), String.valueOf(Utils.coordenadas.getDestinoLng()));
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        AlertShow(marker.getTitle(),marker.getPosition());
        return false;
    }






    }