package com.example.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProductoActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject>{

    ImageView ivImagenProd;
    TextView tvNomProd, tvDesc;

    String url;
    RequestQueue queue;
    JsonObjectRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        ivImagenProd = findViewById(R.id.ivImagenProd);

        Bundle bundle = new Bundle();

        bundle = getIntent().getExtras();

        final long id = bundle.getLong("ID");

        queue = Volley.newRequestQueue(this);
        url = "https://www.serverbpw.com/cm/2020-1/product_detail.php?id=" + id;
        request = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        queue.add(request);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        //Manejar error
    }

    @Override
    public void onResponse(JSONObject response) {
        Log.d("RESPUESTA", response.toString());

        try {
            String name = response.getString("name");
            String desc = response.getString("desc");

           //Toast.makeText(Main3Activity.this, response.getString("title"), Toast.LENGTH_LONG).show();

            Picasso.with(this)
                    .load(response.getString("imag_url"))
                    .into(ivImagenProd);

            tvNomProd = (TextView) findViewById(R.id.tvNomProd);
            tvDesc = (TextView) findViewById(R.id.tvDesc);
            tvDesc.setMovementMethod(new ScrollingMovementMethod());

            tvNomProd.setText(name);
            tvDesc.setText(desc);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
