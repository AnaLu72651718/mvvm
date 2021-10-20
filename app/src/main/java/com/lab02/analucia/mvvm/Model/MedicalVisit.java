package com.lab02.analucia.mvvm.Model;

public class MedicalVisit {
    private String weight;
    private String temperature;
    private String pressure;
    private String saturation;

    public MedicalVisit(){
        weight = "";
        temperature = "";
        pressure = "";
        saturation = "";
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getSaturation() {
        return saturation;
    }

    public void setSaturation(String saturation) {
        this.saturation = saturation;
    }

    public String toString(){
        String msg = "";
        msg += "\tPeso: " + getWeight() + "\n";
        msg += "\tTemperatura: " + getTemperature() + "\n";
        msg += "\tPresión: " + getPressure() + "\n";
        msg += "\tSaturación: " + getSaturation();
        return msg;
    }

}
