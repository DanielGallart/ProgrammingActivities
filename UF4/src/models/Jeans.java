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

    public double finalPrice(){
        double profitMargin;
        switch (type){
            case "slim":
                profitMargin=0.10;
                break;
            case "fit":
                profitMargin=0.15;
                break;
            default:
                profitMargin=0.20;
                break;
        }
        return super.getPrice() / (1-profitMargin);
    }

    @Override
    public String toString() {
        return "Jeans{" +
                super.toString() +  " type='" + type + '\'' +
                '}';
    }
}
