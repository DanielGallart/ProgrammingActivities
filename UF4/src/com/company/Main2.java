package com.company;

import models.Persona2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // NEGRO
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // ROJO
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // VERDE
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// AMARILLO
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // AZUL
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// MORADO
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // BLANCO
    public static final String RESET = "\033[0m";

    public static void main(String[] args) {
        ArrayList<Persona2> persones = new ArrayList<Persona2>();
        Persona2 persona = new Persona2("Daniel", "Gallart", "Álvarez", "23842866P");
        Persona2.sumPersonesCreades();
        persones.add(persona);

        System.out.println(GREEN_BOLD_BRIGHT + "BENVINGUT AL PROGRAMA");

        menuInicial(persones);
    }

    private static void menuInicial(ArrayList<Persona2> persones){
        Persona2 personaActual;
        int opcio = llegirEnter("Què vols fer?\n\t1.-Crear persona\n\t2.-Actualitzar persona\n\t3.-Log in com a persona\n\t4.-Eliminar persona\n\t5.-Veure número de persones creades\n\t6.-Sortir", 1, 6);

        switch (opcio){
            case 1:
                String nom = llegirString("Escriu el teu nom.");
                String cognom1 = llegirString("Escriu el teu primer cognom.");
                String cognom2 = llegirString("Escriu el teu segon cognom.");
                String DNI = llegirString("Escriu el teu DNI.");

                personaActual = crearPersona(nom, cognom1, cognom2, DNI);
                if(existeixPersona(persones, personaActual.getDNI())){
                    System.out.println(RED_BOLD_BRIGHT + "Ja existeix una persona amb aquest DNI.");
                    menuInicial(persones);
                }
                persones.add(crearPersona(nom, cognom1, cognom2, DNI));
                Persona2.sumPersonesCreades();
                System.out.println(CYAN_BOLD_BRIGHT + "Persona creada correctament");
                menuPersona(persones, personaActual);
                break;
            case 2:
                String DNI2 = llegirString("Escriu el DNI de la persona que vols actualitzar.");
                break;
            case 3:
                String DNI3 = llegirString("Escriu el teu DNI.");
                personaActual = logPersona(persones, DNI3);
                if(personaActual == null){
                    System.out.println(RED_BOLD_BRIGHT + "No existeix aquesta persona.");
                    menuInicial(persones);
                }
                else{
                    System.out.println(CYAN_BOLD_BRIGHT + "Log in correcte.");
                    menuPersona(persones, personaActual);
                }
                break;
            case 4:
                String DNI4 = llegirString("Escriu el DNI de la persona que vol eliminar.");
                if(existeixPersona(persones, DNI4)){
                    eliminarPersona(persones, DNI4);
                    System.out.println(CYAN_BOLD_BRIGHT + "Persona eliminada amb èxit.");
                    Persona2.subtractPersonesCreades();
                }
                else{
                    System.out.println(RED_BOLD_BRIGHT + "No es pot eliminar aquesta persona perquè no existeix.");
                }
                menuInicial(persones);
                break;
            case 5:
                Persona2.getPersonesCreades();
                menuInicial(persones);
            case 6:
                System.out.println(GREEN_BOLD_BRIGHT + "SORTINT DE L'APLICACIÓ...");
                break;
        }
    }

    private static void menuPersona(ArrayList<Persona2> persones, Persona2 personaActual){
        int opcio = llegirEnter(personaActual.getNom() + " " + personaActual.getCognom1() + " , què vols fer?\n\t1.-Mostrar persona\n\t2.-Dir nom\n\t3.-Mostrar edat" +
                "\n\t4.-Parlar\n\t5.-Vacunar (AstraZeneca/Physer/Moderna)\n\t6.-Dormir\n\t7.Tirar enrere\n\t8-Sortir", 1, 8);

        switch (opcio){
            case 1:
                System.out.println(CYAN_BOLD_BRIGHT + personaActual.toString());
                menuPersona(persones, personaActual);
                break;
            case 2:
                personaActual.dirNom();
                menuPersona(persones, personaActual);
                break;
            case 3:
                if(personaActual.getDataNaixement() == null){
                    System.out.println(RED_BOLD_BRIGHT + "No tens data de naixement, actualitza les dades.");
                }
                else{
                    personaActual.mostrarEdat();
                }
                menuPersona(persones, personaActual);
                break;
            case 4:
                personaActual.parlar();
                menuPersona(persones, personaActual);
                break;
            case 5:
                String vacuna = llegirString("Escriu la vacuna que et vols ficar.");
                personaActual.vacunar(vacuna);
                menuPersona(persones, personaActual);
                break;
            case 6:
                personaActual.dormir();
                menuPersona(persones, personaActual);
                break;
            case 7:
                menuInicial(persones);
                break;
            case 8:
                System.out.println(GREEN_BOLD_BRIGHT + "SORTINT DE L'APLICACIÓ...");
                break;
        }

    }

    /**
     * Mètode per a crear una persona
     * @param nom nom de la persona
     * @param cognom1 primer cognom de la persona
     * @param cognom2 segon cognom de la persona
     * @param DNI DNI de la persona
     * @return retorna la persona creada
     */
    private static Persona2 crearPersona(String nom, String cognom1, String cognom2, String DNI){
        Persona2 persona = new Persona2(nom, cognom1, cognom2, DNI);
        return persona;
    }

    private static Persona2 logPersona(ArrayList<Persona2> persones, String DNI){
        Persona2 personaActual = null;
        for (int i = 0; i < persones.size(); i++) {
            if(persones.get(i).getDNI().equals(DNI)){
                personaActual = persones.get(i);
            }
        }
        return personaActual;
    }

    private static void eliminarPersona(ArrayList<Persona2> persones, String DNI){
        for (int i = 0; i < persones.size(); i++) {
            if(persones.get(i).getDNI().equals(DNI)){
                persones.remove(persones.get(i));
            }
        }
    }

    private static boolean existeixPersona(ArrayList<Persona2> persones, String DNI){
        for (int i = 0; i < persones.size(); i++) {
            if(persones.get(i).getDNI().equals(DNI)){
                return true;
            }
        }
        return false;
    }

    /**
     * Aquest mètode serveix per llegir un enter de teclat amb control d'errors.
     * @param missatge: Serveix per passar-li el text a mostrar del menú.
     * @param min:      Valor mínim acceptat
     * @param max:      Valor màxim acceptat
     * @return : retorna un enter dins del domini de valors
     */
    public static int llegirEnter(String missatge, int min, int max) {
        Scanner llegir = new Scanner(System.in);
        int opcio = 0;
        boolean valorCorrecte = false;

        do {
            System.out.println(PURPLE_BOLD_BRIGHT + missatge);

            valorCorrecte = llegir.hasNextInt();

            if (!valorCorrecte) {
                System.out.println(RED_BOLD_BRIGHT + "ERROR: No has introduït un enter");
                llegir.nextLine();
            } else {
                opcio = llegir.nextInt();
                llegir.nextLine();

                if (opcio < min || opcio > max) {
                    System.out.println(RED_BOLD_BRIGHT + "ERROR: Opció no correcte");
                    valorCorrecte = false;
                }
            }

        } while (!valorCorrecte);

        return opcio;
    }

    /**
     * Mètode per llegir un float amb control d'errors
     * @param missatge missatge que se li vol mostrar a l'usuari
     * @return valor que ha introduit l'usuari després del control d'errors
     */
    public static float llegirFloat(String missatge) {
        Scanner llegir = new Scanner(System.in);
        float opcio = 0;
        boolean valorCorrecte = false;

        do {
            System.out.println(PURPLE_BOLD_BRIGHT + missatge);

            valorCorrecte = llegir.hasNextFloat();

            if (!valorCorrecte) {
                System.out.println(RED_BOLD_BRIGHT + "ERROR: No has introduït un enter");
                llegir.nextLine();
            } else {
                opcio = llegir.nextFloat();
                llegir.nextLine();
            }

        } while (!valorCorrecte);

        return opcio;
    }

    /**
     * Mètode per llegir un enter de teclat
     * @param missatge text que se li vol mostrar a l'usuari
     * @return retorna un string amb el text imprès per l'usuari
     */
    public static String llegirString(String missatge) {
        System.out.println(PURPLE_BOLD_BRIGHT + missatge);
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();

        return text;
    }
}
