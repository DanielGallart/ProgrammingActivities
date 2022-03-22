package com.company;

import models.Car;
import models.Pelicula;

public class MainCar {
    public static void main(String[] args) {
        Car coche1 = new Car();
        String[] actores1 = {"Zoe Saldana", "Sam Worthing", "Sigourney Weaver", "Stephen Lang"};
        Pelicula pelicula1 = new Pelicula("Avatar", "James Cameron", actores1, "18-12-2009", "USA", 237000000);
        System.out.println(pelicula1);
    }
}
