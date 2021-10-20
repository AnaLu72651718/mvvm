package com.lab02.analucia.mvvm.ModelView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lab02.analucia.mvvm.Model.Patient;


public class ViewModelPatient extends ViewModel {

    private MutableLiveData<Patient> patient;

    public ViewModelPatient(){
        patient = new MutableLiveData<>();
    }
    public LiveData<Patient> getPatient(){
        return patient;
    }
    public void setPatient(Patient _patient){
        patient.setValue(_patient);
    }

    public void registerPatient(String name, String lastname, String dni, String address, String email ) {
        Patient newPatient = new Patient();
        newPatient.setName(name);
        newPatient.setLastName(lastname);
        newPatient.setAddress(address);
        newPatient.setDni(dni);
        newPatient.setEmail(email);
        patient.setValue(newPatient);
    }

}
