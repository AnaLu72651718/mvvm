package com.lab02.analucia.mvvm.ModelView;


import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lab02.analucia.mvvm.Model.MedicalVisit;
import com.lab02.analucia.mvvm.Model.Patient;
import com.lab02.analucia.mvvm.View.BlankFragmentVMPatient;

public class ViewModelMain extends ViewModel {

    Context context;

    public ViewModelMain(){

    }

    public void setContext(Context _context){
        context = _context;
    }

    public void sendEmail(Patient patient) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{patient.getEmail()});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Laboratorio 04");
        intent.putExtra(Intent.EXTRA_TEXT, patient.toString());
        intent.setType("message/rfc822");
        context.startActivity(Intent.createChooser(intent,"Elija una aplicación de correo"));
    }


}
