package com.example.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvLista;
    private Adaptador arrayAdapter;
    private ArrayList<Producto> productos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvLista = (ListView) findViewById(R.id.lvLista);
        productos.add(new Producto(1,"prod1","www.prod.com","provider",11,5));
        productos.add(new Producto(2,"prod2","www.prod.com","provider",12,6));
        productos.add(new Producto(3,"prod3","www.prod.com","provider",13,7));

        arrayAdapter = new Adaptador(this, GetArrayItems(productos));
        lvLista.setAdapter(arrayAdapter);


    }

    private ArrayList<Entidad> GetArrayItems(ArrayList<Producto> lista){
        ArrayList<Entidad> listItems = new ArrayList<>();
        for (Producto prod: lista){
            listItems.add(new Entidad(R.drawable.mujer,R.drawable.deliver,prod.getName(),prod.getProvider(),prod.getPrice(),prod.getDelivery()));
        }
        return listItems;
    }
}
