package models;

public class Jeans extends Clothing{
    private String type;

    public Jeans(String cod, double price, String size, String color, char genre, String type) {
        super(cod, price, size, color, genre);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Jeans{" +
                super.toString() +  " type='" + type + '\'' +
                '}';
    }
}
