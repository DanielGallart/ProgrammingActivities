package models;

public abstract class Clothing {
    private String cod;
    private double price;
    private String size;
    private String color;
    private char genre;

    public Clothing(String cod, double price, String size, String color, char genre) {
        this.cod = cod;
        this.price = price;
        this.size = size;
        this.color = color;
        this.genre = genre;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getGenre() {
        return genre;
    }

    public void setGenre(char genre) {
        this.genre = genre;
    }

    public abstract double finalPrice();

    @Override
    public String toString() {
        return  "cod='" + cod + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", genre=" + genre;
    }
}
