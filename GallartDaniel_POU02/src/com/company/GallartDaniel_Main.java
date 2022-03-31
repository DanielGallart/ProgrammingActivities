package com.company;

import models.GallartDaniel_Character;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GallartDaniel_Main {
        public static void main(String[] args) {
        GallartDaniel_Main main = new GallartDaniel_Main();
        ArrayList<GallartDaniel_Character> characters = new ArrayList<>();
        main.llegirFitxer(characters);
    }

    private void llegirFitxer(ArrayList<GallartDaniel_Character> characters){
        File characterFile = new File("characters_wh_semicolon.csv");
        Scanner read = null;
        try{
            read = new Scanner(characterFile);
            read.nextLine();
            while(read.hasNextLine()){
                String line = read.nextLine();
                String[] values = line.split(";");
                characters.add(afegirPersonatge(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9]));
            }
        }catch(FileNotFoundException fnfe){
            System.out.println("ERROR: Fichero no encontrado --> " + fnfe.getMessage());
        }catch(Exception e){
            System.out.println("ERROR --> " + e.getMessage());
        }finally{
            if(read != null){
                read.close();
                for (GallartDaniel_Character c: characters) {
                    System.out.println(c);
                }
            }
        }
    }

    private GallartDaniel_Character afegirPersonatge(String name, String height, String mass, String hair_color, String skin_color, String eye_color,
                                                     String birth_year, String gender, String homeworld, String species){
        String notValid = "NA";
        float auxHeight, auxMass;
        if(height.equalsIgnoreCase(notValid)){
            auxHeight = -1;
        }
        else{
            try{
                auxHeight = Float.parseFloat(height);
            }catch(Exception e){
                auxHeight = -1;
            }
        }
        if(mass.equalsIgnoreCase(notValid)){
            auxMass = -1;
        }
        else{
            try{
                auxMass = Float.parseFloat(mass);
            }catch(Exception e){
                auxMass = -1;
            }
        }

        return new GallartDaniel_Character(name, auxHeight, auxMass, hair_color, skin_color, eye_color, birth_year, gender, homeworld, species);
    }
}
