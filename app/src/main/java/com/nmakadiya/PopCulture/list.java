package com.nmakadiya.PopCulture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class list extends AppCompatActivity {

    Globalclass globalVariable = Globalclass.getInstance();
    String url;
    RequestQueue queue;
    StringRequest request;
    String info = null;
    ArrayList<String> movielist = new ArrayList<>();
    ArrayList<String> idlist = new ArrayList<>();
    ArrayList<String> postrlist = new ArrayList<>();
    ArrayList<String> yearlist = new ArrayList<>();
    int total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no);

        String name = globalVariable.getName();
        //String name="dilwale";
        url = "http://www.omdbapi.com/?s=" + name.replace(" ", "+") + "&r=json&apikey=fdb54f51";


        final RecyclerView rview = findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rview.setLayoutManager(linearLayoutManager);


        queue = Volley.newRequestQueue(this);
        request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(list.this, "Response:" + response, Toast.LENGTH_SHORT).show();
                info = response;

                try {
                    JSONObject obj1 = new JSONObject(response);

                    JSONArray alllist = obj1.getJSONArray("Search");
                    total = alllist.length();

                    for (int i = 0; i < total; i++) {
                        JSONObject obj = alllist.getJSONObject(i);
                        String title = obj.getString("Title");
                        String year = obj.getString("Year");
                        String id = obj.getString("imdbID");
                        String poster = obj.getString("Poster");

                        movielist.add(title);
                        yearlist.add(year);
                        idlist.add(id);
                        postrlist.add(poster);


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                rview.setAdapter(new CustomAdapter(list.this, movielist, yearlist, idlist, postrlist));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(list.this, "Error......", Toast.LENGTH_SHORT).show();

            }
        });

        queue.add(request);


    }
}
