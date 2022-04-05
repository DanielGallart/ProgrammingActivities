package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercici2_gallartDaniel {
    ArrayList<Cientifica_gallartDaniel> cientifiques = new ArrayList<>();

    public static void main(String[] args) {
        Exercici2_gallartDaniel ex2 = new Exercici2_gallartDaniel();
        ex2.start();
    }

    private void start() {
        Scanner input = new Scanner(System.in);
        int opcio = -1;
        do {
            System.out.println("Menú científiques");
            System.out.println("Què vols fer?");
            System.out.println("[1]Llistar científiques");
            System.out.println("[2]Crear fitxer binari de científiques");
            System.out.println("[3]Afegir una científica");
            System.out.println("[4]Sortir");
            if(input.hasNextInt()) {
                opcio = input.nextInt();
            }
            input.nextLine();

            switch (opcio) {
                case 1:
                    llistarCientifiques(llegirFitxerText("cientifiques.txt"));
                    break;
                case 2:
                    escriureFitxerBinari("cientifiques_gallartdaniel.dat", llegirFitxerText("cientifiques.txt"));
                    break;
                case 3:
                    System.out.println("Introdueix nom:");
                    String nom = input.nextLine();
                    System.out.println("Introdueix ciutat:");
                    String ciutat = input.nextLine();
                    System.out.println("Introdueix any de naixament:");
                    int naixament = llegirInt(input,"");
                    System.out.println("Introdueix any de defunció:");
                    int defuncio = llegirInt(input," ,si la científica encara es viva introdueix. 2020");
                    ArrayList<String> professions = llegirProfessions(input);
                    System.out.println("TODO: Afegir científica en els dos fitxers txt i binari.");
                    //TODO: Afegir científica en els dos fitxers txt i binari.
                    break;
                case 4:
                    System.out.println("Sortir...");
                    break;
                default:
                    System.out.println("Opció no disponible");
                    break;
            }
        } while (opcio != 4);
    }

    private ArrayList<String> llegirProfessions(Scanner input) {
        ArrayList<String> professions = new ArrayList<>();
        System.out.println("Pots escriure tantes professions com vulguis.");
        while(true){
            System.out.println("Escriu una professio.[S] per sortir.");
            String prof = input.nextLine();
            if(prof.equalsIgnoreCase("s")) return professions;
           professions.add(prof);
        }
    }

    private int llegirInt(Scanner input,String message) {
        boolean sortir = false;
        int nombre = 0;
        while(!sortir){
            if(input.hasNextInt()) {
                nombre = input.nextInt();
                sortir = true;
                input.nextLine();
            }else{
                System.out.println("Introdueix un nombre enter" + message);
                input.nextLine();
            }
        }
        return nombre;
    }

    private ArrayList<Cientifica_gallartDaniel> llegirFitxerText(String nomFitxer){
        File fitxer = new File(nomFitxer);
        Scanner input = null;
        ArrayList<Cientifica_gallartDaniel> cientifiques = new ArrayList<>();
        try{
            if(fitxer.exists()){
                input = new Scanner(fitxer);
            }
            while(input.hasNextLine()){
                String cientifica = input.nextLine();
                String[] aux = cientifica.split(";");
                String[] anys = aux[1].split("-");
                String[] professions = aux[3].split(",");
                cientifiques.add(crearCientifica(aux[0],anys[0], anys[1],aux[2], professions));
            }
        }catch (FileNotFoundException fnfe){
            System.out.println("ERROR: Fitxer no trobat --> " + fnfe.getMessage());
        }catch(Exception e){
            System.out.println("ERROR genèric --> " + e.getMessage());
        }finally{
        }
        return cientifiques;
    }

    private void llistarCientifiques(ArrayList<Cientifica_gallartDaniel> cientifiques){
        for (Cientifica_gallartDaniel c: cientifiques) {
            System.out.println(c);
        }
    }

    private Cientifica_gallartDaniel crearCientifica(String nom, String anyNaixement, String anyMort, String llocNaixement, String[] professions){
        int anyN = Integer.parseInt(anyNaixement);
        int anyM = Integer.parseInt(anyMort);
        ArrayList<String> professionsAux = new ArrayList<>();
        for (int i = 0; i < professions.length; i++) {
            professionsAux.add(professions[i]);
        }

        return new Cientifica_gallartDaniel(nom, anyN, anyM, llocNaixement, professionsAux);
    }

    private void escriureFitxerBinari(String nomFitxer, ArrayList<Cientifica_gallartDaniel> cientifiques){
        try{
            FileOutputStream fileOut = new FileOutputStream(nomFitxer);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (int i = 0; i < cientifiques.size(); i++) {
                objectOut.writeObject(cientifiques.get(i));
            }
        }catch (FileNotFoundException fnfe){
            System.out.println("ERROR: Fitxer no trobat --> " + fnfe.getMessage());
        }catch (IOException ioe){
            System.out.println("ERROR: I/O --> " + ioe.getMessage());
        }
    }

    private void afegirCientificaTxt(String nomFitxer, String nom, String ciutat, int naixement, int defuncio, ArrayList<String> professions){
        try{
            FileOutputStream fileOut = new FileOutputStream(nomFitxer);
            BufferedOutputStream objectOut = new BufferedOutputStream(fileOut);
        }catch (FileNotFoundException fnfe){
            System.out.println("ERROR: Fitxer no trobat --> " + fnfe.getMessage());
        }catch(IOException ioe){
            System.out.println("ERROR: I/O --> " + ioe.getMessage());
        }

    }

    private void afegirCientificaBinari(String nomFitxer, String nom, String ciutat, int naixement, int defuncio, ArrayList<String> professions){
        try{
            FileOutputStream fileOut = new FileOutputStream(nomFitxer);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        }catch (FileNotFoundException fnfe){
            System.out.println("ERROR: Fitxer no trobat --> " + fnfe.getMessage());
        }catch(IOException ioe){
            System.out.println("ERROR: I/O --> " + ioe.getMessage());
        }

    }
}
