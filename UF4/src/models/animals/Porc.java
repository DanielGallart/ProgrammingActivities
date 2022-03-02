package models.animals;

import models.interfaces.AccionsAnimal;

import java.sql.Array;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;

public class Porc extends Mamifer implements AccionsAnimal {
    private String color;
    private boolean iberic;
    private boolean senglar;

    public Porc(String nom, LocalDate dataNaixement, int numPotes, Animal pare, Animal mare, ArrayList<Animal> descendencia, char genere, int numEstomacs, boolean herbivor, String color, boolean iberic, boolean senglar) {
        super(nom, dataNaixement, numPotes, pare, mare, descendencia, genere, numEstomacs, herbivor);
        this.color = color;
        this.iberic = iberic;
        this.senglar = senglar;
    }

    @Override
    public void parlar() {
        System.out.println("Oink oink");
    }

    @Override
    public void madurar() {
        if(this.descendencia == null){
            this.descendencia = new ArrayList<>();
        }
    }

    @Override
    public void dormir() {

    }
}
