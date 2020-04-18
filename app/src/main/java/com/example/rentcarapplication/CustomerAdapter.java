package com.example.rentcarapplication;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomerAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Car>carList;

    public CustomerAdapter(Context context, int resource, ArrayList<Car>objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        carList = objects;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);
        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvPrice = rowView.findViewById(R.id.textViewPrice);
        TextView tvIsAvalible = rowView.findViewById(R.id.textViewIsAvalible);
        ImageView ivCar = rowView.findViewById(R.id.imageViewCar);

        Car currentItem = carList.get(position);
        tvName.setText(currentItem.getName());
        tvPrice.setText("$" + String.format("%.2f",currentItem.getPrice()) + " /Day");
        if(currentItem.isAvailable() == true){
            tvIsAvalible.setText("Available");
        }
        else{
            tvIsAvalible.setText("Unavailable");
        }
        if(currentItem.getName() == "Maserati"){
            ivCar.setImageResource(R.drawable.maserati);
        }
        else if (currentItem.getName() == "Audi A4"){
            ivCar.setImageResource(R.drawable.audi);
        }
        else if (currentItem.getName() == "Benz GLA"){
            ivCar.setImageResource(R.drawable.benz);
        }
        else if (currentItem.getName() == "BMW X1"){
            ivCar.setImageResource(R.drawable.bmw);
        }
        else if (currentItem.getName() == "Honda Civic"){
            ivCar.setImageResource(R.drawable.honda);
        }
        else if(currentItem.getName() == "Toyoda Corolla"){
            ivCar.setImageResource(R.drawable.toyota);
        }


        return  rowView;

    }
}
