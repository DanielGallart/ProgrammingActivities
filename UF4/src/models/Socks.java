package models;

public class Socks extends Clothing{
    private String length;

    public Socks(String cod, double price, String size, String color, char genre, String type) {
        super(cod, price, size, color, genre);
        this.length = type;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public double finalPrice() {
        double profitMargin = 0.05;
        return super.getPrice() / (1-profitMargin);
    }

    @Override
    public String toString() {
        return "Socks{" +
                super.toString() + " length='" + length + '\'' +
                '}';
    }
}
