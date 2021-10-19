package com.lab02.analucia.mvvm.ModelView;

import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lab02.analucia.mvvm.Model.Patient;
import com.lab02.analucia.mvvm.View.ViewMainActivity;


public class ViewModelPatient extends ViewModel {
    private MutableLiveData<Patient> patient;

    private Context context;

    public ViewModelPatient(){
        patient = new MutableLiveData<>();
    }
    public LiveData<Patient> getPatient(){
        return patient;
    }

    public void registerPatient(String name, String lastname, String dni, String address, String email ) {
        Patient newPatient = new Patient();
        newPatient.setName(name);
        newPatient.setLastName(lastname);
        newPatient.setAddress(address);
        newPatient.setDni(dni);
        newPatient.setEmail(email);
        //patient.setValue(RegisterPatientUseCase.register(newPatient));
        patient.setValue(newPatient);//prueba sin Use cae
    }

    public void onActivityMain() {
        Intent intent = new Intent(context, ViewMainActivity.class);
        context.startActivity(intent);
    }

}
