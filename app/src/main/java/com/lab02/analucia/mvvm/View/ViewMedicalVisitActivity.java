package com.lab02.analucia.mvvm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

import com.lab02.analucia.mvvm.ModelView.ViewModelMedicalVisit;
import com.lab02.analucia.mvvm.ModelView.ViewModelPatient;
import com.lab02.analucia.mvvm.R;

public class ViewMedicalVisitActivity extends AppCompatActivity {

    private AppCompatButton buttonRegister, buttonCancel;
    private AppCompatEditText editTextWeight, editTextTemperature, editTextPressure, editTextSaturation;
    private ViewModelMedicalVisit viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_medical_visit);
        configView();
    }

    private void configView(){
        viewModel = ViewModelProviders.of(this).get(ViewModelMedicalVisit.class);
        buttonRegister = findViewById(R.id.buttonRegister);
        buttonCancel = findViewById(R.id.buttonCancel);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextTemperature = findViewById(R.id.editTextTemperature);
        editTextPressure = findViewById(R.id.editTextPressure);
        editTextSaturation = findViewById(R.id.editTextSaturation);

        viewModel.setContext(this);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onActivityMain();
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onActivityMain();
            }
        });


    }
}