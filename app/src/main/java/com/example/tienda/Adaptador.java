package com.example.tienda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private Context contexto;
    private ArrayList<Entidad> listItems;

    public Adaptador(Context contexto, ArrayList<Entidad> listItems) {
        this.contexto = contexto;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listItems.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Entidad item = (Entidad) getItem(position);

        convertView = LayoutInflater.from(contexto).inflate(R.layout.item,null);
        ImageView ivProducto = (ImageView) convertView.findViewById(R.id.ivProducto);
        ImageView ivCamion = (ImageView) convertView.findViewById(R.id.ivCamion);
        TextView tvNombre = (TextView) convertView.findViewById(R.id.tvNombre);
        TextView tvProveedor = (TextView) convertView.findViewById(R.id.tvProveedor);
        TextView tvPrecio = (TextView) convertView.findViewById(R.id.tvPrecio);
        TextView tvEntrega = (TextView) convertView.findViewById(R.id.tvEntrega);

        ivCamion.setImageResource(item.getCamion());

        tvNombre.setText(item.getNombre());
        tvProveedor.setText(item.getProveedor());
        tvPrecio.setText("Precio: $" + String.valueOf(item.getPrecio()));

        if(item.getEntrega()==0.0)
            tvEntrega.setText("Costo de envío: GRATIS");
        else
            tvEntrega.setText("Costo de envío: $" + String.valueOf(item.getEntrega()));

        Picasso.with(contexto)
                .load(listItems.get(position).getThumb())
                .into(ivProducto);

        return convertView;
    }

}
