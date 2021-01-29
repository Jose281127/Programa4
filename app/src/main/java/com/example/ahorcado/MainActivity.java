package com.example.ahorcado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.ahorcado.Ahorcado.Ahorcado;
import com.example.ahorcado.Ahorcado.ErrorConexion;
import com.example.ahorcado.Ahorcado.Letra;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener{
    RequestQueue queue;
    JsonObjectRequest  request;
    RecyclerView nuevo;
    GridView gridView;
    boolean bandera=true;
    ProgressBar pb;
    int arroba;
    MediaPlayer mp;
    ImageView ahorca;
    int ancho,altura;
    String palabra;
    TextView victoria;
    TextView cat;
    TextView palabra2;
    TextView salir;
    TextView vaj;
    ArrayList<Letra> arreglo=new ArrayList<>();
    ArrayList<Letra> arreglo3=new ArrayList<>();
    ArrayList<Letra> arreglo2=new ArrayList<>();
    private Integer[] value={
            R.drawable.qn,
            R.drawable.wn,
            R.drawable.en,
            R.drawable.rn,
            R.drawable.tn,
            R.drawable.yn,
            R.drawable.un,
            R.drawable.in,
            R.drawable.on,
            R.drawable.pn,
            0,
            R.drawable.an,
            R.drawable.sn,
            R.drawable.dn,
            R.drawable.fn,
            R.drawable.gn,
            R.drawable.hn,
            R.drawable.jn,
            R.drawable.kn,
            0,
            0,
            R.drawable.ln,
            R.drawable.zn,
            R.drawable.xn,
            R.drawable.cn,
            R.drawable.vn,
            R.drawable.bn,
            R.drawable.nn,
            R.drawable.mn,
            0


    };
    private Integer[] imagen={
            R.drawable.n2,
            R.drawable.n3,
            R.drawable.n4,
            R.drawable.n5,
            R.drawable.n6,
            R.drawable.n7
    };
    char[] a={'q','w','e','r','t','y','u','i','o','p',' ' ,'a','s','d','f','g','h','j','k',' ' ,' ','l','z','x','c','v','b','n','m',' ' };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Display display=getWindowManager().getDefaultDisplay();
        Integer[] resp;
        Point Size= new Point();
        ahorca=findViewById(R.id.ahor);
        display.getSize(Size);
        ancho=Size.x;
        altura=Size.y;
        nuevo=(RecyclerView) findViewById(R.id.nuevo);
        gridView=findViewById(R.id.gv);
        cat=findViewById(R.id.Categoria);
        victoria=findViewById(R.id.ganador);
        salir=findViewById(R.id.salir);
        vaj=findViewById(R.id.Jugar);
        pb=findViewById(R.id.progressbar);
        gridView.setNumColumns(10);
        Imageadaptor imageadaptor=new Imageadaptor(this,ancho);
        gridView.setAdapter(imageadaptor);
        nuevo.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        queue= Volley.newRequestQueue(this);


        request=new JsonObjectRequest(Request.Method.GET,getResources().getString(R.string.direccion),null,this,this);
        queue.add(request);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        pb.setVisibility(View.GONE);

        Intent intent=new Intent(this, ErrorConexion.class);
        Animatoo.animateZoom(this);
        startActivity(intent);
        finish();

    }

    @Override
    public void onResponse(JSONObject object) {

        try {
            pb.setVisibility(View.GONE);
            Ahorcado nuev=new Ahorcado(object.getString("word"),object.getString("category"));
            cat.setText(getResources().getString(R.string.Categori)+"\n"+nuev.getCategoria());
            Adaptador adaptador=new Adaptador(MainActivity.this,nuev.getPalabra(),' ',arreglo);
            nuevo.setPadding(0,0,0,0);
            nuevo.setAdapter(adaptador);

                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                    @Override
                                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                        arroba = position;
                                                        if(bandera) {

                                                            Adaptador adaptador = new Adaptador(MainActivity.this, nuev.getPalabra(), a[position], arreglo);

                                                            nuevo.setAdapter(adaptador);



                                                            String omega = "" + a[position];
                                                            nosqh(arreglo3, omega, nuev.getPalabra(),position);
                                                            equivocarse(arreglo3, String.valueOf(a[position]), arreglo2,position);
                                                            Imageadaptor imageadaptor=new Imageadaptor(MainActivity.this,ancho);
                                                            imageadaptor.setValue(value);
                                                            gridView.setAdapter(imageadaptor);
                                                            if (!arreglo2.isEmpty() && arreglo2.size() < 7) {
                                                                ahorca.setImageResource(imagen[arreglo2.size() - 1]);
                                                            }

                                                            if (arreglo3.size() == nuev.getPalabra().length()) {
                                                                cat.setVisibility(View.INVISIBLE);
                                                                victoria.setVisibility(View.VISIBLE);
                                                                victoria.setText(getResources().getString(R.string.gana));
                                                                mp=MediaPlayer.create(MainActivity.this,R.raw.triunfo);
                                                                mp.start();
                                                                vaj.setVisibility(View.VISIBLE);
                                                                vaj.setEnabled(true);
                                                                salir.setVisibility(View.VISIBLE);
                                                                salir.setEnabled(true);
                                                                bandera=false;
                                                            }
                                                            if (arreglo2.size() == 6) {
                                                                mp=MediaPlayer.create(MainActivity.this,R.raw.muerte);
                                                                Thread tiempo = new Thread() {
                                                                    public void run() {
                                                                        try {
                                                                            sleep(1000);
                                                                        } catch (Exception e) {

                                                                        } finally {

                                                                            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                                                                            startActivity(intent);
                                                                            Animatoo.animateSlideRight(MainActivity.this);
                                                                            finish();

                                                                        }

                                                                    }

                                                                };
                                                                tiempo.run();
                                                            }
                                                        }

                                                    }

                                                }

                );




        } catch (JSONException e) {
            palabra2.setText("error de conexión");
            Log.d("Listto","error en json");
            e.printStackTrace();
        }
    }


    public void  nosqh(ArrayList<Letra> lista,String a,String palabran,int position){
        Letra letter=new Letra(a,0);

        if (lista.isEmpty()&&palabran.contains(a)){
            for (int i=0;i<palabran.length();i++){
                if (a.equals(String.valueOf(palabran.charAt(i)))){
                    lista.add(letter);
                    value[position]=0;

                }
            }

            return;
        }
        else {
            if(!lista.isEmpty()){
                for (int i=0;i<lista.size();i++){
                    if(lista.get(i).getLetra().equals(a)){
                        return;
                    }

                }
                for (int i=0;i<palabran.length();i++){
                    if (a.equals(String.valueOf(palabran.charAt(i)))){
                        lista.add(letter);
                        value[position]=0;

                    }
                }
                return;


            }
        }

    }


    public void equivocarse(ArrayList<Letra> lista,String a,ArrayList<Letra> listaocp,int position){
        Letra letra=new Letra(a,0);
        if(lista.isEmpty()){
            listaocp.add(letra);

                mp = MediaPlayer.create(this, R.raw.dolor);

            mp.start();

            value[position]=0;
            return;
        }
        else {
            for (int i=0;i<lista.size();i++){
                if(lista.get(i).getLetra().equals(a)){

                    return ;
                }
            }
            if(listaocp.isEmpty()){
                listaocp.add(letra);
                mp=MediaPlayer.create(this,R.raw.dolor);
                mp.start();
                value[position]=0;
            }
            else {
                for (int i=0;i<listaocp.size();i++){
                    if(listaocp.get(i).getLetra().equals(a)){
                        return ;
                    }
                }
                listaocp.add(letra);
                if(listaocp.size()!=6) {
                    mp = MediaPlayer.create(this, R.raw.dolor);
                }
                else {
                    mp = MediaPlayer.create(this, R.raw.muerte);
                }

                mp.start();
                value[position]=0;
            }
        }
    }

    public void clickeo(View view) {

        Intent intent= new Intent(this,MainActivity.class);
        mp.stop();
        mp=MediaPlayer.create(this,R.raw.disparo);
        mp.start();
        startActivity(intent);
        Animatoo.animateInAndOut(this);
        finish();
    }

    public void clickeosal(View view) {

        Intent intent= new Intent(this,Portada.class);
        mp.stop();
        mp=MediaPlayer.create(this,R.raw.disparo);
        mp.start();
        startActivity(intent);
        Animatoo.animateInAndOut(this);
        finish();
    }
}