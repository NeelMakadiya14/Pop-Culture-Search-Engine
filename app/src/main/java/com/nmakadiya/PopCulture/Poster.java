package com.nmakadiya.PopCulture;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import org.json.JSONException;
import org.json.JSONObject;


public class Poster extends AppCompatActivity {

    Globalclass globalVariable = Globalclass.getInstance();

    String url1;
    RequestQueue queue;
    StringRequest request;
    String iurl;
    Button btn1;
    Button btn2;
    String jsoninfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conformation);


        final TextView box2 = findViewById(R.id.textView2);

        final ProgressBar progressBar = findViewById(R.id.pb);
        final ImageView img = findViewById(R.id.image1);


        String name = globalVariable.getName();
        String id = globalVariable.getId();
        //String name ="dilwale";
        final String year = getIntent().getStringExtra("message2");


        if (id == null) {

            if (year.equals("Enter the year if you know")) {
                url1 = "http://www.omdbapi.com/?t=" + name.replace(' ', '+') + "&r=json&plot=full&apikey=fdb54f51";
            } else {
                url1 = "http://www.omdbapi.com/?t=" + name.replace(' ', '+') + "&r=json&y=" + year + "&plot=full&apikey=fdb54f51";
            }
        } else {
            url1 = "http://www.omdbapi.com/?i=" + id + "&r=json&plot=full&apikey=fdb54f51";
        }

        queue = Volley.newRequestQueue(this);
        request = new StringRequest(Request.Method.GET, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    jsoninfo = response;
                    JSONObject obj = new JSONObject(response);

                    iurl = obj.getString("Poster");


                    Glide.with(img.getContext()).load(iurl).listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            Toast.makeText(Poster.this, "Image not found", Toast.LENGTH_SHORT).show();
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(Poster.this, "Image loaded", Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    }).into(img);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Poster.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

            }
        });


        queue.add(request);

        btn1 = findViewById(R.id.button1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(Poster.this, info.class);

                i1.putExtra("message3", jsoninfo);

                startActivity(i1);

            }
        });
    }
}
