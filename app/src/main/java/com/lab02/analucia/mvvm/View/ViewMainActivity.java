package com.lab02.analucia.mvvm.View;


import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.lab02.analucia.mvvm.Model.Patient;
import com.lab02.analucia.mvvm.ModelView.ViewModelMain;
import com.lab02.analucia.mvvm.ModelView.ViewModelPatient;
import com.lab02.analucia.mvvm.R;

public class ViewMainActivity extends AppCompatActivity {

    private AppCompatButton buttonRegisterPatient, buttonRegisterMedicalVisit, buttonSendEmail;
    private AppCompatTextView textViewDataPatient;
    private ViewModelMain viewModelMain;
    private ViewModelPatient viewModelPatiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_main);
        configView();
    }

    private void configView(){
        viewModelMain = ViewModelProviders.of(this).get(ViewModelMain.class);
        viewModelPatiente = ViewModelProviders.of(this).get(ViewModelPatient.class);
        buttonRegisterPatient = findViewById(R.id.buttonRegisterPatient);
        buttonRegisterMedicalVisit = findViewById(R.id.buttonRegisterMedicalVisit);
        buttonSendEmail = findViewById(R.id.buttonSendEmail);
        textViewDataPatient = findViewById(R.id.textViewDataPatient);

        viewModelMain.setContext(this);
/*
        buttonRegisterPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  replaceFragment(new fracment)
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new PacienteView()).commit();
            }
        });*/
        buttonRegisterPatient.setOnClickListener(view -> viewModelMain.onActivityPatient());
        buttonRegisterMedicalVisit.setOnClickListener(view -> viewModelMain.onActivityMedicalVisit());

//        final Observer<Patient> observer= s -> textViewDataPatient.setText((CharSequence) s);
  //      viewModelPatiente.getPatient().observe(this,observer);
    }
}