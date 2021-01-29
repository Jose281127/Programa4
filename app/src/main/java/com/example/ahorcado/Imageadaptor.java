package com.example.ahorcado;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class Imageadaptor extends BaseAdapter {
    Context context;
    int ancho;
    int columnas=10;

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
    public Imageadaptor(Context context, int ancho) {
        this.context = context;
        this.ancho = ancho;

    }

    public void setValue(Integer[] value) {
        this.value = value;
    }

    @Override
    public int getCount() {
        return value.length;
    }

    @Override
    public Object getItem(int position) {
        return value[position];
    }

    @Override
    public long getItemId(int position) {
        return value[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView=new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ancho/columnas,ancho/columnas));
        imageView.setImageResource(value[position]);
        return imageView;
    }
}
