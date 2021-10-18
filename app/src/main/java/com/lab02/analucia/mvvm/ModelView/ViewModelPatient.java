package com.lab02.analucia.mvvm.ModelView;

import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.ViewModel;

import com.lab02.analucia.mvvm.View.ViewMainActivity;

public class ViewModelPatient extends ViewModel {

    private Context context;

    public ViewModelPatient(){

    }

    public void setContext(Context _context){
        context= _context;
    }

    public void onActivityMain() {
        Intent intent = new Intent(context, ViewMainActivity.class);
        context.startActivity(intent);
    }

}