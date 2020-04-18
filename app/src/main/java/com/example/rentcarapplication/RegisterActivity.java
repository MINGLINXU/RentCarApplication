package com.example.rentcarapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity  extends AppCompatActivity implements View.OnClickListener {
    private EditText etFirstName, etLastName, etNRIC, etMobileNumber, etEmail, etPassword;
    private Button btnRegister, btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerpage);
        init();
    }

    private void init() {

        etFirstName = (EditText) findViewById(R.id.EditViewFirstName);
        etLastName = (EditText) findViewById(R.id.EditViewLastName);
        etNRIC = (EditText) findViewById(R.id.EditViewIC);
        etMobileNumber = (EditText) findViewById(R.id.EditViewMobileNumber);
        etEmail = (EditText) findViewById(R.id.EditViewEmail);
        etPassword = findViewById(R.id.et_password);
        btnRegister = (Button) findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(this);
        btn_login = (Button)findViewById(R.id.btnLogin);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                register();
                break;
            case R.id.btnLogin:
                returnEnter();
                break;
        }
    }

    private void returnEnter() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void register() {
        final String firstname = etFirstName.getText().toString().trim();
        final String lastname = etLastName.getText().toString().trim();
        final String nric  = etNRIC.getText().toString().trim();
        String mobilenumber = etMobileNumber.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if (TextUtils.isEmpty(firstname)) {  //When first name is empty
            Toast.makeText(this, "Please enter your First Name！", Toast.LENGTH_SHORT).show();
            etFirstName.requestFocus();
            return;
        } else if (TextUtils.isEmpty(lastname)) {//When last name is empty
            Toast.makeText(this, "Please enter your Last Name！", Toast.LENGTH_SHORT).show();
            etLastName.requestFocus();
            return;
        } else if (TextUtils.isEmpty(nric)) {//When NRIC number is empty
            Toast.makeText(this, "Please enter your NRIC！", Toast.LENGTH_SHORT).show();
            etNRIC.requestFocus();
            return;
        } else if (TextUtils.isEmpty(mobilenumber)) {//When Mobile Number is empty
            Toast.makeText(this, "Please enter your 8 digit mobile number！", Toast.LENGTH_SHORT).show();
            etMobileNumber.requestFocus();
            return;
        } else if (TextUtils.isEmpty(email)) {//When email is empty
            Toast.makeText(this, "Please enter your Email Address！", Toast.LENGTH_SHORT).show();
            etEmail.requestFocus();
            return;
        } else if (TextUtils.isEmpty(password)) {//When password is empty
            Toast.makeText(this, "Please enter your password！", Toast.LENGTH_SHORT).show();
            etPassword.requestFocus();
            return;
        }
        if (!TextUtils.isEmpty(firstname) && !TextUtils.isEmpty(lastname) && !TextUtils.isEmpty(nric) && !TextUtils.isEmpty(mobilenumber) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            final ProgressDialog pd = new ProgressDialog(this);
            pd.setMessage("Register in progress...!");
            pd.show();

            new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {

                    }
                    pd.dismiss();
                    Toast.makeText(RegisterActivity.this, "Register Successful!", Toast.LENGTH_SHORT).show();
                }
            }).start();

        }
    }
}
