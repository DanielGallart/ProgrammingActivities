package models.animals;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Animal {
    private int id;
    protected String nom;
    private LocalDate dataNaixement;
    private int numPotes;
    protected Animal pare;
    protected Animal mare;
    protected ArrayList<Animal> descendencia;
    private static int recompteAnimals = 1; //Atribut static. Això vol dir que és un atribut a nivell de classe

    public Animal(String nom, LocalDate dataNaixement, int numPotes, Animal pare, Animal mare, ArrayList<Animal> descendencia) {
        this.id = recompteAnimals;
        this.nom = nom;
        this.dataNaixement = dataNaixement;
        this.numPotes = numPotes;
        this.pare = pare;
        this.mare = mare;
        this.descendencia = descendencia;
        Animal.recompteAnimals++;
    }

    public final int getRecompteAnimals(){
        return Animal.recompteAnimals;
    }

    public final int getIdentificador(){
        return this.id;
    }

    public abstract boolean afegirDescendencia(Animal a);

    public abstract String toString();
}
