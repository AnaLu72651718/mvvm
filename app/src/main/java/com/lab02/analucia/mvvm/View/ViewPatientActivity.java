package com.lab02.analucia.mvvm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

import com.lab02.analucia.mvvm.ModelView.ViewModelMain;
import com.lab02.analucia.mvvm.ModelView.ViewModelPatient;
import com.lab02.analucia.mvvm.R;

public class ViewPatientActivity extends AppCompatActivity {

    private AppCompatButton buttonRegister, buttonCancel;
    private AppCompatEditText editTextNames, editTextLastNames, editTextDni, editTextAddress, editTextEmail;
    private ViewModelPatient viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_patient);
        configView();
    }

    private void configView(){
        viewModel = ViewModelProviders.of(this).get(ViewModelPatient.class);
        buttonRegister = findViewById(R.id.buttonRegister);
        buttonCancel = findViewById(R.id.buttonCancel);

        editTextNames = findViewById(R.id.editTextNames);
        editTextLastNames = findViewById(R.id.editTextLastNames);
        editTextDni = findViewById(R.id.editTextDni);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextEmail = findViewById(R.id.editTextEmail);

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