package com.lab02.analucia.mvvm.View;

import static com.lab02.analucia.mvvm.R.id.textViewDataPatient;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lab02.analucia.mvvm.Model.Patient;
import com.lab02.analucia.mvvm.ModelView.ViewModelPatient;
import com.lab02.analucia.mvvm.R;

public class ViewPatientActivity extends AppCompatActivity {

    private AppCompatButton buttonRegister, buttonCancel;
    private AppCompatEditText editTextName;
    private View editTextLastName;
    private View editTextDni;
    private AppCompatEditText editTextAddress;
    private AppCompatEditText editTextEmail;
    private ViewModelPatient viewModel;

    private TextView showDataPatient;

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

        editTextName = findViewById(R.id.editTextNames);
        editTextLastName = findViewById(R.id.editTextLastNames);
        editTextDni = findViewById(R.id.editTextDni);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextEmail = findViewById(R.id.editTextEmail);


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.registerPatient(editTextName.toString(),editTextLastName.toString(),editTextDni.toString(),editTextAddress.toString(),editTextEmail.toString());
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onActivityMain();
            }
        });

        final Observer <Patient> observer = new Observer<Patient>() {
            @Override
            public void onChanged(Patient patient) {
                showDataPatient.setText("Nombres: "+editTextName.toString()+"\nApellidos: "+editTextLastName.toString()+"\nDNI: "+editTextDni.toString()+
                        "\nDirección: "+editTextAddress.toString()+"\nCorreo: "+editTextEmail.toString());

            }
        };

        viewModel.getPatient().observe(this, observer);
    }
}