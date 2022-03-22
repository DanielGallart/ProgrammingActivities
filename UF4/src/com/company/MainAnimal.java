package com.company;

import models.animals.Animal;
import models.animals.Porc;

import java.time.LocalDate;

public class MainAnimal {
    public static void main(String[] args) {
        Porc dave = new Porc("Dave", LocalDate.now(), 4, null, null, null, 'M', 1, true,
                "Rosa", false, false);

        System.out.println(dave);
    }
}
