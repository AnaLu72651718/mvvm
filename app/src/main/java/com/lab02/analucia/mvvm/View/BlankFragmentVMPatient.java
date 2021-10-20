package com.lab02.analucia.mvvm.View;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lab02.analucia.mvvm.Model.Patient;
import com.lab02.analucia.mvvm.ModelView.ViewModelPatient;
import com.lab02.analucia.mvvm.R;

public class BlankFragmentVMPatient extends Fragment {

    View view;

    private AppCompatButton buttonRegister, buttonCancel;
    private AppCompatEditText editTextName;
    private AppCompatEditText editTextLastName;
    private AppCompatEditText editTextDni;
    private AppCompatEditText editTextAddress;
    private AppCompatEditText editTextEmail;
    private ViewModelPatient viewModel;

    private TextView showDataPatient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_blank_v_m_patient, container, false);
        configView();
        return view;
    }

    private void configView(){
        viewModel = ViewModelProviders.of(this).get(ViewModelPatient.class); //?
        buttonRegister = view.findViewById(R.id.buttonRegister);
        buttonCancel = view.findViewById(R.id.buttonCancel);

        editTextName = view.findViewById(R.id.editTextNames);
        editTextLastName = view.findViewById(R.id.editTextLastNames);
        editTextDni = view.findViewById(R.id.editTextDni);
        editTextAddress = view.findViewById(R.id.editTextAddress);
        editTextEmail = view.findViewById(R.id.editTextEmail);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.registerPatient(editTextName.getText().toString(), editTextLastName.getText().toString(), editTextDni.getText().toString(), editTextAddress.getText().toString(), editTextEmail.getText().toString());

            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(new BlankFragmentVMMain());
            }
        });

        final Observer<Patient> observer = new Observer<Patient>() {
            @Override
            public void onChanged(Patient patient) {
            //    Toast toast = Toast.makeText(getContext(), viewModel.getPatient().getValue().toString(), Toast.LENGTH_LONG);
            //    toast.show();
                ((MainActivity)getActivity()).patient = patient;
                ((MainActivity)getActivity()).replaceFragment(new BlankFragmentVMMain());
            }
        };
        viewModel.getPatient().observe(getViewLifecycleOwner(), observer);
    }
}