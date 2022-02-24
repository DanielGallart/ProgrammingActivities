package models;

public class Scarf extends Clothing{
    public Scarf(String cod, double price, String size, String color, char genre) {
        super(cod, price, size, color, genre);
    }

    public double finalPrice() {
        double profitMargin = 0.10;
        return super.getPrice() / (1-profitMargin);
    }

    @Override
    public String toString() {
        return "Scarf{ " + super.toString() + " }";
    }
}
