package com.sda.mvc_data1.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class PersonDTO {
    @NotEmpty(message = "Pole imie nie może być puste")
    private String imie;
    @NotEmpty
    private String nazwisko;
    @Min(17)
    private int wiek;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }
}
