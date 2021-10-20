package com.lab02.analucia.mvvm.ModelView;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lab02.analucia.mvvm.Model.MedicalVisit;

public class ViewModelMedicalVisit extends ViewModel{

    private MutableLiveData<MedicalVisit> medicalVisit;
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public ViewModelMedicalVisit(){
        medicalVisit = new MutableLiveData<>();
    }
    public LiveData<MedicalVisit> getMedicalVisit(){
        return medicalVisit;
    }

    public void registerMedicalVisit(String _weight, String _temperature, String _pressure, String _saturation) {
        MedicalVisit newMedicalVisit = new MedicalVisit();
        newMedicalVisit.setWeight(_weight);
        newMedicalVisit.setTemperature(_temperature);
        newMedicalVisit.setPressure(_pressure);
        newMedicalVisit.setSaturation(_saturation);
        medicalVisit.setValue(newMedicalVisit);
    }

}
