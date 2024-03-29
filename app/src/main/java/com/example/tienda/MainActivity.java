package com.example.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONArray>{

    private ListView lvLista;
    private Adaptador adaptador;
    private ArrayList<Producto> productos = new ArrayList<>();

    String url;
    RequestQueue queue;
    JsonArrayRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = Volley.newRequestQueue(this);
        url = getResources().getString(R.string.url_prods);
        request = new JsonArrayRequest(Request.Method.GET, url, null, this, this);
        queue.add(request);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.d("RESPUESTA", error.toString());
    }

    public void onResponse(JSONArray response) {
        Log.d("RESPUESTA", response.toString());

        JSONObject jsonObject;

        try {
            for(int i=0;i<response.length();i++){

                jsonObject = response.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String name = jsonObject.getString("name");
                String thumbnail_url = jsonObject.getString("thumbnail_url");
                double price = jsonObject.getDouble("price");
                String provider = jsonObject.getString("provider");
                double delivery = jsonObject.getDouble("delivery");

                Producto nuevo = new Producto(id,name,thumbnail_url,provider,price,delivery);
                productos.add(nuevo);
            }

            lvLista = (ListView) findViewById(R.id.lvLista);
            adaptador = new Adaptador(MainActivity.this, getArrayItems(productos));
            lvLista.setAdapter(adaptador);

            lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(MainActivity.this, ProductoActivity.class);
                    intent.putExtra("ID", id);
                    //Toast.makeText(MainActivity.this, String.valueOf(id), Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            });


        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private ArrayList<Entidad> getArrayItems(ArrayList<Producto> lista){
        ArrayList<Entidad> listItems = new ArrayList<>();
        // match imagenes con productos
        for (Producto prod: lista)
            listItems.add(new Entidad(prod.getId(),prod.getThumbnail_url(),R.drawable.deliver,prod.getName(),prod.getProvider(),prod.getPrice(),prod.getDelivery()));

        return listItems;
    }
}
