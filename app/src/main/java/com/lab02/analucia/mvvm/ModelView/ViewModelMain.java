package com.lab02.analucia.mvvm.ModelView;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.ViewModel;

import com.lab02.analucia.mvvm.View.ViewMedicalVisitActivity;
import com.lab02.analucia.mvvm.View.ViewPatientActivity;

public class ViewModelMain extends ViewModel {

    private Context context;

    public ViewModelMain(){
    }

    public void setContext(Context _context){
        context= _context;
    }

    public void onActivityPatient() {
        Intent intent = new Intent(context, ViewPatientActivity.class);
        context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation((Activity) context).toBundle());
    }

    public void onActivityMedicalVisit(){
        Intent intent = new Intent(context, ViewMedicalVisitActivity.class);
        context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation((Activity) context).toBundle());
    }

}
