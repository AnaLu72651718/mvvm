package com.lab02.analucia.mvvm.View;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lab02.analucia.mvvm.Model.MedicalVisit;
import com.lab02.analucia.mvvm.Model.Patient;
import com.lab02.analucia.mvvm.ModelView.ViewModelMedicalVisit;
import com.lab02.analucia.mvvm.ModelView.ViewModelPatient;
import com.lab02.analucia.mvvm.R;

public class BlankFragmentVMMedicalVisit extends Fragment {

    View view;

    private AppCompatButton buttonRegister, buttonCancel;
    private AppCompatEditText editTextWeight, editTextTemperature, editTextPressure, editTextSaturation;
    private ViewModelMedicalVisit viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_blank_v_m_medical_visit, container, false);
        configView();
        return view;
    }

    private void configView(){
        viewModel = ViewModelProviders.of(this).get(ViewModelMedicalVisit.class); //?

        buttonRegister = view.findViewById(R.id.buttonRegister);
        buttonCancel = view.findViewById(R.id.buttonCancel);

        editTextWeight = view.findViewById(R.id.editTextWeight);
        editTextTemperature = view.findViewById(R.id.editTextTemperature);
        editTextPressure = view.findViewById(R.id.editTextPressure);
        editTextSaturation = view.findViewById(R.id.editTextSaturation);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.registerMedicalVisit(editTextWeight.getText().toString(), editTextTemperature.getText().toString(), editTextPressure.getText().toString(), editTextSaturation.getText().toString());
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(new BlankFragmentVMMain());
            }
        });

        final Observer<MedicalVisit> observer = new Observer<MedicalVisit>() {
            @Override
            public void onChanged(MedicalVisit medicalVisit) {
                ((MainActivity)getActivity()).patient.addMedicalVisit(medicalVisit);
                ((MainActivity)getActivity()).replaceFragment(new BlankFragmentVMMain());
            }
        };

        viewModel.getMedicalVisit().observe(getViewLifecycleOwner(), observer);


    }
}