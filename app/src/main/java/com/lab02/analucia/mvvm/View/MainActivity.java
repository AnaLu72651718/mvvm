package com.lab02.analucia.mvvm.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProviders;

import com.lab02.analucia.mvvm.Model.Patient;
import com.lab02.analucia.mvvm.ModelView.ViewModelMain;
import com.lab02.analucia.mvvm.R;

public class MainActivity extends AppCompatActivity {

    public Patient patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        patient = new Patient();
        replaceFragment(new BlankFragmentVMMain());
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment);
        fragmentTransaction.commit();
    }

}