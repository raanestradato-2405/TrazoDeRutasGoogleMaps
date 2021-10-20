package com.example.trazar_linea.Utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trazar_linea.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;




public class MarkersDefault  {

    GoogleMap nMap;
    Context context;

    private View po=null;





    public MarkersDefault(GoogleMap nMap, Context context) {
        this.nMap = nMap;
        this.context = context;
    }


    public void addMarkersDefault() {




//TextView tv=(TextView)unooooooooooooooooooooooooooooooooo.findViewById(R.layout.)
        uno(-5.071663409585319, -80.65843234019266, "punto 1");
        dos(-3.494100420904711, -73.36351093420208, "punto 2");
        tres(-6.62355560628795, -79.62571756283857, "punto 3");
        cuatro(-3.559893530985199, -80.37278782730748, "punto 4");
        cinco(-7.016264127276264, -78.74681136934574, "punto 5");
        seis(-7.887738307033681, -79.16429181125483, "punto 6");
        siete(-9.386612829442342, -77.7800145565036, "punto 7");
       ocho( -8.192331417446612, -74.6379249147667,"punto 8");
        nueve( -10.317492717035329, -71.80345244075228,"punto 9");
        dies(-12.94287135119999, -74.30833509220687,"punto 10");
        once(-16.97524266085619, -71.07835483112069,"punto 11");
        doce(-13.306648311845997, -72.28685084717335,"punto 12");
        trece(-15.223112872325387, -72.70433128908245,"punto 13");
        catorce(-11.826901653996506, -76.87913570817345,"punto 14");
        quince(-3.2528202047461923, -77.9997411048768,"punto 14");
        diesis(-5.618589065850917, -76.8351903984988,"punto 15");
        diciete(-11.568706332538776, -69.29856978929769,"punto 16");
        diceocho(-13.135526254017433, -69.16673386027377,"punto 17");
        disinueve(-12.07934431285095, -77.06077490702137,"punto 18");





    }
    public void disinueve(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;

        BitmapDrawable jira = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap ji = jira.getBitmap();
        Bitmap jiras = Bitmap.createScaledBitmap(ji, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo).snippet("desea ir este punto?")
                .icon(BitmapDescriptorFactory.fromBitmap(jiras))
        );
    }

    public void uno(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;

        BitmapDrawable jira = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap ji = jira.getBitmap();
        Bitmap jiras = Bitmap.createScaledBitmap(ji, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo).snippet("desea ir este punto?")
                .icon(BitmapDescriptorFactory.fromBitmap(jiras))
        );
    }
    public void dos(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;

        BitmapDrawable lo = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap lob = lo.getBitmap();
        Bitmap lod = Bitmap.createScaledBitmap(lob, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromBitmap(lod))
        );
    }
    public void tres(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;

        BitmapDrawable muse = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap mus = muse.getBitmap();
        Bitmap muss = Bitmap.createScaledBitmap(mus, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromBitmap(muss))
        );
    }
    public void cuatro(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;

        BitmapDrawable pv = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap pava = pv.getBitmap();
        Bitmap pavas = Bitmap.createScaledBitmap(pava, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromBitmap(pavas))
        );
    }
    public void cinco(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;
        BitmapDrawable jb = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap jarb = jb.getBitmap();
        Bitmap jbs = Bitmap.createScaledBitmap(jarb, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromBitmap(jbs))
        );
    }
    public void seis(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;

        BitmapDrawable os = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap oso = os.getBitmap();
        Bitmap osoo= Bitmap.createScaledBitmap(oso, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromBitmap(osoo))
        );
    }
    public void siete(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;
        BitmapDrawable his = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap hip = his.getBitmap();
        Bitmap hipo= Bitmap.createScaledBitmap(hip, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromBitmap(hipo))
        );
    }
    public void ocho(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;
        BitmapDrawable ce = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap ceb = ce.getBitmap();
        Bitmap cebr= Bitmap.createScaledBitmap(ceb, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromBitmap(cebr))
        );
    }
    public void nueve(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;

        BitmapDrawable bol = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap bole = bol.getBitmap();
        Bitmap bolt= Bitmap.createScaledBitmap(bole, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromBitmap(bolt))
        );
    }
    public void dies(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;

        BitmapDrawable mus = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap muss = mus.getBitmap();
        Bitmap mu= Bitmap.createScaledBitmap(muss, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromBitmap(mu))
        );
    }
    public void once(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;

        BitmapDrawable pr = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap par = pr.getBitmap();
        Bitmap paq= Bitmap.createScaledBitmap(par, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromBitmap(paq))
        );
    }
    public void doce(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;

        BitmapDrawable en = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap ent = en.getBitmap();
        Bitmap entr= Bitmap.createScaledBitmap(ent, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromBitmap(entr))
        );
    }
    public void trece(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;
        BitmapDrawable hu = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap hua = hu.getBitmap();
        Bitmap huu= Bitmap.createScaledBitmap(hua, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromBitmap(huu))
        );
    }
    public void catorce(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;
        BitmapDrawable huac = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap huas = huac.getBitmap();
        Bitmap h= Bitmap.createScaledBitmap(huas, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromBitmap(h))
        );
    }
    public void quince(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;

        BitmapDrawable zz = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap zzz = zz.getBitmap();
        Bitmap hz= Bitmap.createScaledBitmap(zzz, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromBitmap(hz))
        );
    }
    public void diesis(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;
        BitmapDrawable cas = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap cass = cas.getBitmap();
        Bitmap casss= Bitmap.createScaledBitmap(cass, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromBitmap(casss))
        );
    }
    public void diciete(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;

        BitmapDrawable pamp = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap pas = pamp.getBitmap();
        Bitmap pass= Bitmap.createScaledBitmap(pas, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromBitmap(pass))
        );
    }

    //nuevo

    public void diceocho(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;
        BitmapDrawable jb = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap jarb = jb.getBitmap();
        Bitmap jbs = Bitmap.createScaledBitmap(jarb, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromBitmap(jbs))
        );
    }

    public void vente(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;
        BitmapDrawable his = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap hip = his.getBitmap();
        Bitmap hipo= Bitmap.createScaledBitmap(hip, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromBitmap(hipo))
        );
    }
    public void venteuno(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;

        BitmapDrawable ce = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap ceb = ce.getBitmap();
        Bitmap cebr= Bitmap.createScaledBitmap(ceb, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromBitmap(cebr))
        );
    }
    public void veintydos(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;

        @SuppressLint("UseCompatLoadingForDrawables") BitmapDrawable bol = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconomapas);
        Bitmap bole = bol.getBitmap();
        Bitmap bolt= Bitmap.createScaledBitmap(bole, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromBitmap(bolt))
        );
    }

    public void ventitres(Double latitud, Double longitud, String titulo) {
        LatLng punto = new LatLng(latitud, longitud);
        int height = 140;
        int width = 165;

        @SuppressLint("UseCompatLoadingForDrawables") BitmapDrawable pr = (BitmapDrawable) context.getResources().getDrawable(R.drawable.iconom);
        Bitmap par = pr.getBitmap();
        Bitmap paq= Bitmap.createScaledBitmap(par, width, height, false);

        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromBitmap(paq))
        );
    }






}
