package com.lab02.analucia.mvvm.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lab02.analucia.mvvm.Model.Patient;
import com.lab02.analucia.mvvm.ModelView.ViewModelPatient;
import com.lab02.analucia.mvvm.R;

public class PacienteView extends Fragment {
      private ViewModelPatient viewModel;
      private TextView textViewDataPatient;
      public PacienteView() {
        // Required empty public constructor
    }
/*
    public static PacienteView newInstance(String param1, String param2) {
        PacienteView fragment = new PacienteView();
        return fragment;
    }
*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_paciente_view, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //viewModel = new ViewModelProvider(requireActivity()).get(ViewModelPatient.class);
        textViewDataPatient = view.findViewById(R.id.textViewDataPatient);
        viewModel = ViewModelProviders.of(this).get(ViewModelPatient.class);
        final Observer<Patient> observer= s -> textViewDataPatient.setText((CharSequence) s);
        viewModel.getPatient().observe(getViewLifecycleOwner(),observer);
    }
}