package com.company;

import models.Clothing;
import models.Jeans;
import models.Scarf;
import models.Socks;

import java.util.ArrayList;

public class MainShop {
    public static void main(String[] args) {
        ArrayList<Clothing> clothes = new ArrayList<>();
        initClothing(clothes);
        for (Clothing cloth : clothes) {
            System.out.println(cloth);
        }
        clothes.get(0).setPrice(50);
        System.out.println(clothes.get(0));
        System.out.println(clothes.get(0).getPrice());
    }

    private static void initClothing(ArrayList<Clothing> clothes){
        Jeans j = new Jeans("123", 23, "L", "Blue", 'M', "Slim");
        Scarf sr = new Scarf("321", 15.5f, "M", "Red and Yellow", 'F');
        Socks sk = new Socks("010", 5.75f, "36-39", "Grey", 'F', "Ankle length");
        clothes.add(j);
        clothes.add(sr);
        clothes.add(sk);
    }
}
