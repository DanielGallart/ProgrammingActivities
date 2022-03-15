package models.animals;

import java.time.LocalDate;
import java.util.ArrayList;

public class Mamifer extends Animal{
    private char genere;
    private int numEstomacs;
    private boolean herbivor;

    public Mamifer(String nom, LocalDate dataNaixement, int numPotes, Animal pare, Animal mare, ArrayList<Animal> descendencia, char genere, int numEstomacs, boolean herbivor) {
        super(nom, dataNaixement, numPotes, pare, mare, descendencia);
        this.genere = genere;
        this.numEstomacs = numEstomacs;
        this.herbivor = herbivor;
    }

    @Override
    public boolean afegirDescendencia(Animal a) {
        if(a instanceof Mamifer && this.descendencia != null){
            Mamifer m = (Mamifer) a;

            return this.descendencia.add(m);
        }

        return false;
    }

    @Override
    public String toString() {
        return "Mamifer{" +
                "id='" + this.getIdentificador() + '\'' +
                ", nom='" + nom + '\'' +
                ", pare=" + pare +
                ", mare=" + mare +
                ", descendencia=" + descendencia +
                ", herbivor=" + herbivor +
                '}';
    }
}
