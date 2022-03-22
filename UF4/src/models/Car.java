package models;

public class Car {
    private String type;
    private String brand;
    private String model;
    private int seats;
    private float price;
    private boolean isRented;

    public float rentPrice(){
        float price = 0;

        return price;
    }

    public void setRented(boolean rented){
        this.isRented = rented;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", seats=" + seats +
                ", price=" + price +
                ", isRented=" + isRented +
                '}';
    }
}
