package com.nmakadiya.PopCulture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    String name;
    Globalclass globalVariable = Globalclass.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name1 = findViewById(R.id.editText1);


        Button b2 = findViewById(R.id.button);
        ImageButton b1 = findViewById(R.id.imgbtn1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText year1 = findViewById(R.id.editText2);
                final String year = year1.getText().toString();
                name = name1.getText().toString();
                globalVariable.setName(name);
                globalVariable.setId(null);


                Intent i = new Intent(MainActivity.this, com.nmakadiya.PopCulture.Poster.class);

                //i.putExtra("message1",name);
                i.putExtra("message2", year);

                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = name1.getText().toString();
                globalVariable.setName(name);
                Intent j = new Intent(MainActivity.this, list.class);
                //j.putExtra("message6",name);
                startActivity(j);

            }
        });
    }
}
