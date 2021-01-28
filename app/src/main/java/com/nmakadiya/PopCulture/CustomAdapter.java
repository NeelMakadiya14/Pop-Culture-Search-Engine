package com.nmakadiya.PopCulture;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Globalclass globalVariable = Globalclass.getInstance();
    private ArrayList<String> movielist;
    private ArrayList<String> yearlist;
    private ArrayList<String> idlist;
    private ArrayList<String> posterlist;
    private Context context;

    public CustomAdapter(Context context, ArrayList<String> movielist, ArrayList<String> yearlist, ArrayList<String> idlist, ArrayList<String> posterlist) {
        this.context = context;
        this.idlist = idlist;
        this.movielist = movielist;
        this.yearlist = yearlist;
        this.posterlist = posterlist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rowlayout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final String title1 = movielist.get(position);
        String year1 = yearlist.get(position);
        String imageurl1 = posterlist.get(position);
        final String id1 = idlist.get(position);


        holder.textView1.setText(title1);
        holder.textView2.setText(year1);
        Glide.with(holder.imageView.getContext()).load(imageurl1).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Poster.class);
                globalVariable.setId(id1);
                context.startActivity(intent);


            }
        });

    }


    @Override
    public int getItemCount() {
        return movielist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView1;
        TextView textView2;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView1 = itemView.findViewById(R.id.t1);
            textView2 = itemView.findViewById(R.id.t2);
        }


    }
}