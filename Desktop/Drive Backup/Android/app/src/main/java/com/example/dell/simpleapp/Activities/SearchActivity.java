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

import com.example.dell.simpleapp.Adapters.SearchListAdapter;
import com.example.dell.simpleapp.R;
import com.loopj.android.http.AsyncHttpClient;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    private String URL = "http://192.168.0.52/api/Tbl_Patient";
    SearchView searchViewPatient;
    RecyclerView recyclerViewSearchList;
    SearchListAdapter searchListAdapter;
    TextView textNoPatient;
    Button btnRegister;
    AsyncHttpClient asyncHttpClient;
    int i = 0;
    String[] patientNameArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().hide();
        patientNameArray = new String[]{"Roman Reigns", "John Cena", "Angelina Julie", "Michael Clarke", "Emma Watson"};
        textNoPatient = findViewById(R.id.no_patient_text);
        searchViewPatient = findViewById(R.id.search_view);
        btnRegister = findViewById(R.id.button_register);
        asyncHttpClient = new AsyncHttpClient();
        searchListAdapter = new SearchListAdapter(patientNameArray);
        recyclerViewSearchList = findViewById(R.id.search_activity_recycler_view);
        recyclerViewSearchList.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewSearchList.setItemAnimator(new DefaultItemAnimator());
        recyclerViewSearchList.setAdapter(searchListAdapter);
        searchViewPatient.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //searchViewPatient.clearFocus();
                i++;
                if(i == 1){
                    textNoPatient.setVisibility(View.VISIBLE);
                    btnRegister.setVisibility(View.VISIBLE);
                    textNoPatient.setText("No patient found in the list");
                    recyclerViewSearchList.setVisibility(View.GONE);
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
//    private void LoadAllPatients(){
//        asyncHttpClient.get(getApplicationContext(), URL, new AsyncHttpResponseHandler() {
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                String response = new String(responseBody);
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                }
//                catch (JSONException ex){
//
//                }
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//
//            }
//        });
//    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_register:
                startActivity(new Intent(SearchActivity.this, RegistrationActivity.class));
        }
    }
}
