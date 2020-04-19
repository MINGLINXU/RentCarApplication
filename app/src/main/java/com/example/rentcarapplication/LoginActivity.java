package com.example.rentcarapplication;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity  extends AppCompatActivity implements View.OnClickListener{
    private EditText etUserName, etPassword;
    private TextView tvHelp;
    private Button btnLogin, btnRegister;
    public static String currentUsername;
    private String currentPassword;
    private boolean progressShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {

        etUserName = (EditText) findViewById(R.id.editViewUsername);
        etPassword = (EditText) findViewById(R.id.editViewPassword);
        tvHelp = (TextView) findViewById(R.id.textViewHelp);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);
    }

    /**
     * Click event
     * */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:  //Login Button
                login(v);
                break;
            case R.id.btnRegister:  //Register Button
                Intent intentToReg = new Intent(this,RegisterActivity.class);
                startActivity(intentToReg);
                finish();
                break;


        }
    }

    /**
     *Login
     *
     */
    public void login(View view) {

        currentUsername = etUserName.getText().toString().trim(); //Remove space and get the username
        currentPassword = etPassword.getText().toString().trim();  //Remove space and get the password

        if (TextUtils.isEmpty(currentUsername)) { //Check if username is empty
            Toast.makeText(this, "Please enter your username!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(currentPassword)) {  //Check if password is empty
            Toast.makeText(this, "Please enter your password!", Toast.LENGTH_SHORT).show();
            return;
        }

        progressShow = true;
        final ProgressDialog pd = new ProgressDialog(LoginActivity.this);  //progress animation
        /**
         * Set listener
         * */
        pd.setCanceledOnTouchOutside(false);
        pd.setOnCancelListener(new DialogInterface.OnCancelListener() {

            @Override
            public void onCancel(DialogInterface dialog) {
                progressShow = false;   //set boolean to false
            }
        });
        pd.setMessage("Login in progress....");  //Animation title
        pd.show();  //showing animation

        new Thread(new Runnable() {
            public void run() {
                //sleep for 2 sec
                try {
                    Thread.sleep(2000);  //here sleep for 2 sec
                } catch (InterruptedException e) {
                }

                /**
                 * After 2 seconds
                 * */
                pd.dismiss();    //progress bar dismiss
                Intent intent = new Intent(LoginActivity.this, CarCatActivity.class);  //Intent new activity
                startActivity(intent);  //change to another activity
                finish();  //close this activity
            }
        }).start();


    }
}
