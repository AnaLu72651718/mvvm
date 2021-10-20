package com.lab02.analucia.mvvm.Model;

import java.util.ArrayList;

public class Patient {
    private String name;
    private String lastName;
    private String dni;
    private String address;
    private String email;
    private ArrayList<MedicalVisit> medicalVisits;

    public Patient(){
        this.name = "";
        this.lastName = "";
        this.dni = "";
        this.address = "";
        this.email = "";
        medicalVisits = new ArrayList<MedicalVisit>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<MedicalVisit> getMedicalVisits() {
        return medicalVisits;
    }

    public void setMedicalVisits(ArrayList<MedicalVisit> medicalVisits) {
        this.medicalVisits = medicalVisits;
    }

    public void addMedicalVisit(MedicalVisit _medicalVisit){
        this.medicalVisits.add(_medicalVisit);
    }

    public String toString(){
        String msg = "";
        msg += "Nombres: " + getName() + "\n";
        msg += "Apellidos: " + getLastName() + "\n";
        msg += "Dni: " + getDni() + "\n";
        msg += "Dirección: " + getAddress() + "\n";
        msg += "Correo electrónico: " + getEmail() + "\n";
        if(getMedicalVisits().size() > 0)
            for(int i = 0; i < getMedicalVisits().size(); ++i)
                msg += "Visita " + (i + 1 ) + ": " + "\n" + getMedicalVisits().get(i).toString() + "\n";
        return msg;
    }
}
