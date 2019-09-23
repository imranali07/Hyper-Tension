package com.example.dell.simpleapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dell.simpleapp.Adapters.PatientHistoryAdapter;
import com.example.dell.simpleapp.R;

public class PatientMedicalHistoryActivity extends AppCompatActivity {
    String[] diseaseList;
    PatientHistoryAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_medical_history);
        diseaseList = new String[]{"Diabetes", "Heartattack in last 3 years", "Strokes", "Kidney disease"};
        adapter = new PatientHistoryAdapter(diseaseList);
        recyclerView = findViewById(R.id.recycler_view_patient_history);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);




    }
}
