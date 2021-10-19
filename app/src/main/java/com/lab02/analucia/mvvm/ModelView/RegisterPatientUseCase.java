package com.lab02.analucia.mvvm.ModelView;

import android.text.method.HideReturnsTransformationMethod;

import com.lab02.analucia.mvvm.Model.Patient;

public class RegisterPatientUseCase {
    public static Patient patient; //new

    public static  Patient register(Patient patientData){ //new}
        patient = patientData;
        return patient;
    }
}
