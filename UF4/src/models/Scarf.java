package models;

public class Scarf extends Clothing{
    public Scarf(String cod, double price, String size, String color, char genre) {
        super(cod, price, size, color, genre);
    }

    @Override
    public String toString() {
        return "Scarf{ " + super.toString() + " }";
    }
}
