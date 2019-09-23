package com.example.dell.simpleapp.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.dell.simpleapp.R;

import java.util.Calendar;

public class RegistrationActivity extends AppCompatActivity {

    private Button btnNext;
    private EditText editTextDob;
    private Calendar mCalendar = Calendar.getInstance();
    int mDay, mMonth, mYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        btnNext = findViewById(R.id.button_Next);
        editTextDob = findViewById(R.id.dob_edit_text);
        mDay = mCalendar.get(Calendar.DAY_OF_MONTH);
        mMonth = mCalendar.get(Calendar.MONTH);
        mYear = mCalendar.get(Calendar.YEAR);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, PatientMedicalHistoryActivity.class));
                RegistrationActivity.this.finish();
            }
        });
        editTextDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarDialog();
            }
        });


    }

    private void calendarDialog(){

        DatePickerDialog dateDialog = new DatePickerDialog(this, dateListener, mYear, mMonth, mDay);
        dateDialog.show();
    }
    DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            month += 1;
            if(month < 10){
                editTextDob.setText(dayOfMonth + "-0" + month + "-" + year);
            }
            else{
                editTextDob.setText(dayOfMonth + "-" + month + "-" + year);
            }
        }
    };
}
