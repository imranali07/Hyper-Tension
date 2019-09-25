package com.example.dell.simpleapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.simpleapp.Adapters.SearchListAdapter;
import com.example.dell.simpleapp.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    private String URL = "http://192.168.0.52/api/Tbl_Patient";
    SearchView searchViewPatient;
    RecyclerView recyclerViewSearchist;
    SearchListAdapter searchListAdapter;
    TextView textNoPatient;
    Button btnRegister;
    AsyncHttpClient asyncHttpClient;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().hide();
        textNoPatient = findViewById(R.id.no_patient_text);
        searchViewPatient = findViewById(R.id.search_view);
        btnRegister = findViewById(R.id.button_register);
        asyncHttpClient = new AsyncHttpClient();
        searchListAdapter = new SearchListAdapter();
        recyclerViewSearchist = findViewById(R.id.search_activity_recycler_view);
        recyclerViewSearchist.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewSearchist.setItemAnimator(new DefaultItemAnimator());
        searchViewPatient.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(i == 0)
                {
                    textNoPatient.setVisibility(View.VISIBLE);
                    btnRegister.setVisibility(View.VISIBLE);
                    textNoPatient.setText("No Patient Found");
                    recyclerViewSearchist.setVisibility(View.GONE);
                }
                else
                {
                    textNoPatient.setVisibility(View.GONE);
                    btnRegister.setVisibility(View.GONE);
                    recyclerViewSearchist.setAdapter(searchListAdapter);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        btnRegister.setOnClickListener(this);


    }
    private void LoadAllPatients(){
        asyncHttpClient.get(getApplicationContext(), URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = new String(responseBody);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                }
                catch (JSONException ex){

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_register:
                startActivity(new Intent(SearchActivity.this, RegistrationActivity.class));
        }
    }
}
