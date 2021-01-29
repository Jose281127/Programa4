package com.example.ahorcado;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ahorcado.Ahorcado.Letra;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.AdaptadorViewHolder> {
    Context context;
    String palabra;
    ArrayList<Letra> list;
    ArrayList<Letra> lisa;
    char a;
    int intentos;
    private Integer[] encontrarimagen={
      R.drawable.an,
      R.drawable.bn,
            R.drawable.cn,
      R.drawable.dn,
      R.drawable.en,
            R.drawable.fn,
            R.drawable.gn,
            R.drawable.hn,
            R.drawable.in,
            R.drawable.jn,
            R.drawable.kn,
            R.drawable.ln,
            R.drawable.mn,
            R.drawable.nn,
            R.drawable.on,
            R.drawable.pn,
            R.drawable.qn,
            R.drawable.rn,
            R.drawable.sn,
            R.drawable.tn,
            R.drawable.un,
            R.drawable.vn,
            R.drawable.wn,
            R.drawable.xn,
            R.drawable.yn,
            R.drawable.zn

    };
    public Adaptador(Context context, String palabra,char a,ArrayList<Letra> list) {
        this.context = context;
        this.palabra = palabra;
        this.a=a;
        this.list=list;
        this.lisa=lisa;
        this.intentos=intentos;
    }

    public int getIntentos() {
        return intentos;
    }

    public ArrayList<Letra> getLisa() {
        return lisa;
    }



    @NonNull
    @Override
    public AdaptadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.adaptador,null,false);
        return new Adaptador.AdaptadorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorViewHolder holder, int position) {
        String aux;
        if (list.isEmpty()&&a==' '){
            holder.uno.setText(" ");

        }

        else {
            if(!list.isEmpty()){
                for (int i=0;i<list.size();i++){
                    if(position==list.get(i).getId()){
                        if(position==0) {
                            String val=list.get(i).getLetra().toUpperCase();
                            holder.uno.setText(val);
                            byte[] auxiliar=val.getBytes(StandardCharsets.US_ASCII);
                            holder.imageView.setImageResource(encontrarimagen[auxiliar[0]-65]);
                        }
                        else {
                            holder.uno.setText(String.valueOf(list.get(i).getLetra()));
                            byte[] auxiliar=String.valueOf(list.get(i).getLetra()).getBytes(StandardCharsets.US_ASCII);
                            holder.imageView.setImageResource(encontrarimagen[auxiliar[0]-97]);

                        }

                    }
                }
                Log.d("Listto",String.valueOf(list.size()));
            }
            Log.d("Listto","Que sucede"+a+palabra.charAt(position)+String.valueOf(position));
                if (a == palabra.charAt(position)) {

                    Letra letra = new Letra(String.valueOf(a), position);
                    list.add(letra);
                    if (position==0){
                        char b=a;

                        holder.uno.setText(String.valueOf(b).toUpperCase());

                        byte[] auxiliar=String.valueOf(b).toUpperCase().getBytes(StandardCharsets.US_ASCII);
                        holder.imageView.setImageResource(encontrarimagen[auxiliar[0]-65]);
                    }
                    else {
                    holder.uno.setText(String.valueOf(a));
                        byte[] auxiliar=String.valueOf(a).getBytes(StandardCharsets.US_ASCII);
                        holder.imageView.setImageResource(encontrarimagen[auxiliar[0]-97]);
                    }
                    Log.d("Listto","Que sucede"+String.valueOf(position)+list.get(0).getLetra());
                    Log.d("Listto", list.get(0).getLetra());
                    Log.d("Ventra","Ray"+String.valueOf(list.size()));
                }

                /*else {
                    Letra rela=new Letra(String.valueOf(a),position);
                    if(lisa.isEmpty()){
                        lisa.add(rela);
                        Log.d("Listto", lisa.get(0).getLetra());
                        intentos++;
                        Log.d("Listto", "Vames"+String.valueOf(intentos));
                    }
                    else {
                        if (!busca(lisa,list, String.valueOf(a))) {
                            lisa.add(rela);
                            intentos++;
                            Log.d("Listto", "Vamos2"+a);

                        }
                    }

                }*/


            /*else {

                if (!list.isEmpty()&&a==palabra.charAt(position)){

                        for (int i=0;i<list.size();i++){
                            if(position==list.get(position).getId()) {
                                holder.uno.setText(list.get(i).getLetra());
                            }
                        }
                    holder.uno.setText(String.valueOf(a));
                        Letra l=new Letra(String.valueOf(a),position);
                        list.add(l);

                }
                else {
                    if (!list.isEmpty()){
                        for (int i=0;i<list.size();i++){
                            if(position==list.get(position).getId()) {
                                holder.uno.setText(list.get(i).getLetra());
                            }
                        }
                    }
                }

            }*/
        }

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public ArrayList<Letra> getList() {
        Log.d("Listto","Vamosaad"+list.size());
        return list;
    }

    @Override
    public int getItemCount() {
        return palabra.length();
    }



    public class AdaptadorViewHolder extends RecyclerView.ViewHolder {
        EditText uno;
        ImageView imageView;
        public AdaptadorViewHolder(@NonNull View itemView) {
            super(itemView);
            uno=itemView.findViewById(R.id.let);
            imageView=itemView.findViewById(R.id.letras);


        }
    }
}
