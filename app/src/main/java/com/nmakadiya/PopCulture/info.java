package com.nmakadiya.PopCulture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class info extends AppCompatActivity {

    String infostr;
    String Title;
    String Released;
    String Genre;
    String Actors;
    String Directors;
    String Writers;
    String Plot;
    String Duration;
    String Country;
    String Language;
    String imdb;
    String Collection;
    String Awards;
    String Production;
    String season;
    String type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        infostr = getIntent().getStringExtra("message3");

        try {
            JSONObject obj = new JSONObject(infostr);


            Awards = obj.getString("Awards");
            type = obj.getString("Type");
            Title = obj.getString("Title");
            Released = obj.getString("Released");
            Genre = obj.getString("Genre");
            Actors = obj.getString("Actors");
            Directors = obj.getString("Director");
            Writers = obj.getString("Writer");
            Plot = obj.getString("Plot");
            Duration = obj.getString("Runtime");
            Country = obj.getString("Country");
            Language = obj.getString("Language");
            imdb = obj.getString("imdbRating");

            if (type.equals("series")) {
                season = obj.getString("totalSeasons");
                Collection = "N/A";
                Production = "N/A";

            } else {
                Collection = obj.getString("BoxOffice");
                Production = obj.getString("Production");
                season = "N/A";


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        TextView b2 = findViewById(R.id.tv2);
        TextView b4 = findViewById(R.id.tv4);
        TextView b6 = findViewById(R.id.tv6);
        TextView b8 = findViewById(R.id.tv8);
        TextView b10 = findViewById(R.id.tv10);
        TextView b12 = findViewById(R.id.tv12);
        TextView b14 = findViewById(R.id.tv14);
        TextView b16 = findViewById(R.id.tv16);
        TextView b18 = findViewById(R.id.tv18);
        TextView b20 = findViewById(R.id.tv20);
        TextView b22 = findViewById(R.id.tv22);
        TextView b24 = findViewById(R.id.tv24);
        TextView b26 = findViewById(R.id.tv26);
        TextView b28 = findViewById(R.id.tv28);
        TextView b30 = findViewById(R.id.tv30);
        TextView b32 = findViewById(R.id.tv32);

        b2.setText(Title);
        b4.setText(imdb);
        b6.setText(Genre);
        b8.setText(Plot);
        b10.setText(Actors);
        b12.setText(Directors);
        b14.setText(Writers);
        b16.setText(Duration);
        b18.setText(Released);
        b20.setText(Country);
        b22.setText(Language);
        b24.setText(Awards);
        b26.setText(Production);
        b28.setText(Collection);
        b32.setText(season);
        b30.setText(type);


    }
}
