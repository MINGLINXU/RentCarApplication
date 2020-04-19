package com.example.rentcarapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import androidx.appcompat.app.AppCompatActivity;


public class HelpActivity  extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helppage);
        Button btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(listener);
        //Retrieve phone image
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton_phone);
        //Retrieve message image
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton_email);
        imageButton.setOnClickListener(listener); //set call listener
        imageButton1.setOnClickListener(listener);//set email button listener
    }

    //Create listener object
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(); //Create Intent object
            switch (v.getId()) {
                case R.id.btn_back:              //if is phone call option
                    Intent intentback = new Intent(HelpActivity.this,LoginActivity.class);
                    startActivity(intentback);
                    finish();
                    break;
                case R.id.imageButton_phone:              //if is phone call option
                    intent.setAction(intent.ACTION_DIAL); //get the phone call function
                    intent.setData(Uri.parse("tel:+6568765432")); //Set the phone number
                    startActivity(intent);
                    break;
                case R.id.imageButton_email: //if is email option
                    intent.setAction(intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:info@easycarrental.com.sg"));
                    startActivity(Intent.createChooser(intent,"Send Feedback"));
                    break;
            }
        }


    };
}
