package com.lab02.analucia.mvvm.View;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lab02.analucia.mvvm.Model.Patient;
import com.lab02.analucia.mvvm.ModelView.ViewModelMain;
import com.lab02.analucia.mvvm.ModelView.ViewModelMedicalVisit;
import com.lab02.analucia.mvvm.ModelView.ViewModelPatient;
import com.lab02.analucia.mvvm.R;


public class BlankFragmentVMMain extends Fragment {

    View view;

    private AppCompatButton buttonRegisterPatient, buttonRegisterMedicalVisit, buttonSendEmail;
    private AppCompatTextView textViewDataPatient;
    ViewModelMain viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_blank_v_m_main, container, false);
        configView();
        return view;
    }

    public void configView(){
        viewModel = ViewModelProviders.of(this).get(ViewModelMain.class); //?

        viewModel.setContext(getActivity());

        buttonRegisterPatient = view.findViewById(R.id.buttonRegisterPatient);
        buttonRegisterMedicalVisit = view.findViewById(R.id.buttonRegisterMedicalVisit);
        buttonSendEmail = view.findViewById(R.id.buttonSendEmail);
        textViewDataPatient = view.findViewById(R.id.textViewDataPatient);

        buttonRegisterPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(new BlankFragmentVMPatient());
            }
        });

        buttonRegisterMedicalVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(new BlankFragmentVMMedicalVisit());
            }
        });

        buttonSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.sendEmail(((MainActivity)getActivity()).patient);
            }
        });

        textViewDataPatient.setMovementMethod(new ScrollingMovementMethod());
        textViewDataPatient.setText(((MainActivity)getActivity()).patient.toString());

    }

}