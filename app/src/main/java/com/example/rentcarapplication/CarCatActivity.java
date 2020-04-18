package com.example.rentcarapplication;

import android.os.Bundle;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CarCatActivity extends AppCompatActivity {

    ListView lvCar;
    ArrayList<Car> alCarList;
    CustomerAdapter caCar;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectcar);


        lvCar = findViewById(R.id.ListViewSelectCar);
        alCarList = new ArrayList<>();

        Car car1 = new Car("BMW X1",400.00,true);
        alCarList.add(car1);
        Car car2 = new Car("Maserati",800.00,true);
        alCarList.add(car2);
        Car car3 = new Car("Audi A4", 500.00, true);
        alCarList.add(car3);
        Car car4 = new Car("Benz GLA", 500.00, true);
        alCarList.add(car4);
        Car car5 = new Car("Honda Civic", 500.00, true);
        alCarList.add(car5);
        Car car6 = new Car("Toyoda Corolla", 500.00, true);
        alCarList.add(car6);

        caCar = new CustomerAdapter(this,R.layout.carcategory, alCarList);
        lvCar.setAdapter(caCar);


    }
}
