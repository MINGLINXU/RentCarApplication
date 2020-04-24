package com.example.rentcarapplication;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class RentalDetails extends AppCompatActivity {
    DatePickerDialog picker;
    EditText etPickUpDate, etReturnDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rentaldetail);
        etPickUpDate=(EditText) findViewById(R.id.selectPickUpDate);
        etPickUpDate.setInputType(InputType.TYPE_NULL);
        etReturnDate=(EditText) findViewById(R.id.selectReturnDate);
        etReturnDate.setInputType(InputType.TYPE_NULL);


        etPickUpDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar pickUpDate = Calendar.getInstance();
                int day = pickUpDate.get(Calendar.DAY_OF_MONTH);
                int month = pickUpDate.get(Calendar.MONTH);
                int year = pickUpDate.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(RentalDetails.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                etPickUpDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        etReturnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar returnDate = Calendar.getInstance();
                int day = returnDate.get(Calendar.DAY_OF_MONTH);
                int month = returnDate.get(Calendar.MONTH);
                int year = returnDate.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(RentalDetails.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                etReturnDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

    }
}
