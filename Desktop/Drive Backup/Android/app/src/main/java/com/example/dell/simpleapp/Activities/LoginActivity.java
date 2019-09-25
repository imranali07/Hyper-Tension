package com.example.dell.simpleapp.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dell.simpleapp.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText editTextPhone, editTextPass;
    AsyncHttpClient asyncHttpClient;
    String URL = "http://192.168.0.52/api/Tbl_Admin/GetTbl_Admin/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        btnLogin = findViewById(R.id.button_login);
        editTextPhone = findViewById(R.id.mobile);
        editTextPass = findViewById(R.id.password);
        asyncHttpClient = new AsyncHttpClient();




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = editTextPhone.getText().toString();
                String pass = editTextPass.getText().toString();
                userLogin(phone, pass);
            }
        });

    }

    private void userLogin(String phone, String pass)
    {
//        final RequestParams params = new RequestParams();
//        params.add("", phone);
//        params.add("", pass);
        URL = URL + phone + "/" + pass;
        asyncHttpClient.get(this, URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String respone = new String(responseBody);
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                LoginActivity.this.finish();
                Toast.makeText(LoginActivity.this, respone, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(LoginActivity.this, "Invalid phone or password", Toast.LENGTH_SHORT).show();
            }
        });
    }

}


