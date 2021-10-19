package com.lab02.analucia.mvvm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lab02.analucia.mvvm.ModelView.ViewModelMain;
import com.lab02.analucia.mvvm.ModelView.ViewModelPatient;
import com.lab02.analucia.mvvm.R;

public class ViewMainActivity extends AppCompatActivity {

    private AppCompatButton buttonRegisterPatient, buttonRegisterMedicalVisit, buttonSendEmail;
    private AppCompatTextView textViewDataPatient;
    private ViewModelMain viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_main);
        configView();
    }

    private void configView(){
        viewModel = ViewModelProviders.of(this).get(ViewModelMain.class);
        buttonRegisterPatient = findViewById(R.id.buttonRegisterPatient);
        buttonRegisterMedicalVisit = findViewById(R.id.buttonRegisterMedicalVisit);
        buttonSendEmail = findViewById(R.id.buttonSendEmail);
        textViewDataPatient = findViewById(R.id.textViewDataPatient);

        viewModel.setContext(this);

        buttonRegisterPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onActivityPatient();
            }
        });

        buttonRegisterMedicalVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onActivityMedicalVisit();
            }
        });


    }
}