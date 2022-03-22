package com.company;

import models.Persona3;
import models.Aliment;

import java.time.LocalDate;
import java.util.ArrayList;
import utils.Utilities;

public class Main3 {
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // ROJO
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // VERDE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN


    public static void main(String[] args) {
        ArrayList<Persona3> persones = new ArrayList<>();
        Persona3 persona = new Persona3("Daniel", "Gallart", "Álvarez", "23842866P", 81.5f);
        persones.add(persona);

        ArrayList<Aliment> aliments = new ArrayList<>();
        Aliment poma = new Aliment("Poma", 200, 65);
        Aliment hamburguesa = new Aliment("Hamburguesa", 100, 295);
        Aliment monster = new Aliment("Beguda Monster", 100, 42);
        Aliment espaguetis = new Aliment("Plat d'espaguetis", 250, 400);
        aliments.add(poma);
        aliments.add(hamburguesa);
        aliments.add(monster);
        aliments.add(espaguetis);

        System.out.println(GREEN_BOLD_BRIGHT + "BENVINGUT AL PROGRAMA");

        menuInicial(persones, aliments);
    }

    /**
     * Mètode pel menú principal
     * @param persones array list amb totes les persones
     * @param aliments array list amb tots els aliments
     */
    private static void menuInicial(ArrayList<Persona3> persones, ArrayList<Aliment> aliments){
        Persona3 personaActual;
        int opcio = Utilities.llegirEnter("Què vols fer?\n\t1.-Crear persona\n\t2.-Actualitzar persona\n\t3.-Log in com a persona\n\t4.-Eliminar persona\n\t5.-Veure número de persones creades\n\t6.-Sortir", 1, 6);

        switch (opcio){
            case 1:
                personaActual = crearPersona();
                if(existeixPersona(persones, personaActual.getDNI())){
                    System.out.println(RED_BOLD_BRIGHT + "Ja existeix una persona amb aquest DNI.");
                    Persona3.restarPersonesCreades();
                    menuInicial(persones, aliments);
                }
                persones.add(personaActual);
                System.out.println(CYAN_BOLD_BRIGHT + "Persona creada correctament");
                menuPersona(persones, personaActual, aliments);
                break;
            case 2:
                actualitzarPersona(persones);
                menuInicial(persones, aliments);
                break;
            case 3:
                personaActual = logPersona(persones);
                if(personaActual == null){
                    System.out.println(RED_BOLD_BRIGHT + "No existeix aquesta persona.");
                    menuInicial(persones, aliments);
                }
                else{
                    System.out.println(CYAN_BOLD_BRIGHT + "Log in correcte.");
                    menuPersona(persones, personaActual, aliments);
                }
                break;
            case 4:
                String DNI4 = Utilities.llegirString("Escriu el DNI de la persona que vol eliminar.");
                if(existeixPersona(persones, DNI4)){
                    eliminarPersona(persones, DNI4);
                    System.out.println(CYAN_BOLD_BRIGHT + "Persona eliminada amb èxit.");
                    Persona3.restarPersonesCreades();
                }
                else{
                    System.out.println(RED_BOLD_BRIGHT + "No es pot eliminar aquesta persona perquè no existeix.");
                }
                menuInicial(persones, aliments);
                break;
            case 5:
                System.out.println(Persona3.getPersonesCreades());
                menuInicial(persones, aliments);
            case 6:
                System.out.println(GREEN_BOLD_BRIGHT + "SORTINT DE L'APLICACIÓ...");
                break;
        }
    }

    /**
     * Menú per quan s'ha iniciat sessió com a persona
     * @param persones array list amb totes les persones
     * @param personaActual la persona amb la qual s'ha iniciat sessió
     * @param aliments array list amb tots els aliments
     */
    private static void menuPersona(ArrayList<Persona3> persones, Persona3 personaActual, ArrayList<Aliment> aliments){
        int opcio = Utilities.llegirEnter(personaActual.getNom() + " " + personaActual.getCognom1() + " , què vols fer?\n\t1.-Mostrar persona\n\t2.-Dir nom\n\t3.-Mostrar edat" +
                "\n\t4.-Parlar\n\t5.-Vacunar (AstraZeneca/Physer/Moderna)\n\t6.-Dormir\n\t7.-Menjar\n\t8.-Fer esport\n\t9.-Tirar enrere\n\t10-Sortir", 1, 10);

        switch (opcio){
            case 1:
                System.out.println(CYAN_BOLD_BRIGHT + personaActual);
                menuPersona(persones, personaActual, aliments);
                break;
            case 2:
                personaActual.dirNom();
                menuPersona(persones, personaActual, aliments);
                break;
            case 3:
                if(personaActual.getDataNaixement() == null){
                    System.out.println(RED_BOLD_BRIGHT + "No tens data de naixement, actualitza les dades.");
                }
                else{
                    personaActual.mostrarEdat();
                }
                menuPersona(persones, personaActual, aliments);
                break;
            case 4:
                personaActual.parlar();
                menuPersona(persones, personaActual, aliments);
                break;
            case 5:
                String vacuna = Utilities.llegirString("Escriu la vacuna que et vols ficar.");
                personaActual.vacunar(vacuna);
                menuPersona(persones, personaActual, aliments);
                break;
            case 6:
                personaActual.dormir();
                menuPersona(persones, personaActual, aliments);
                break;
            case 7:
                menjar(personaActual, aliments);
                menuPersona(persones, personaActual, aliments);
                break;
            case 8:
                ferEsport(personaActual);
                menuPersona(persones, personaActual, aliments);
                break;
            case 9:
                menuInicial(persones, aliments);
                break;
            case 10:
                System.out.println(GREEN_BOLD_BRIGHT + "SORTINT DE L'APLICACIÓ...");
                break;
        }

    }

    /**
     * Mètode per a crear una persona
     * @return retorna la persona creada
     */
    private static Persona3 crearPersona(){
        String nom = Utilities.llegirString("Escriu el teu nom.");
        String cognom1 = Utilities.llegirString("Escriu el teu primer cognom.");
        String cognom2 = Utilities.llegirString("Escriu el teu segon cognom.");
        String DNI = Utilities.llegirString("Escriu el teu DNI.");
        float pes = Utilities.llegirFloatLimit("Escriu el teu pes.", 2, 200);
        return new Persona3(nom, cognom1, cognom2, DNI, pes);
    }

    /**
     * Mètode per fer log in d'una persona
     * @param persones array list amb totes les persones
     * @return retorna la persona
     */
    private static Persona3 logPersona(ArrayList<Persona3> persones){
        String DNI = Utilities.llegirString("Escriu el teu DNI.");
        Persona3 personaActual = null;
        for (Persona3 persona : persones) {
            if (persona.getDNI().equals(DNI)) {
                personaActual = persona;
            }
        }
        return personaActual;
    }

    /**
     * Mètode per eliminar una persona
     * @param persones array list amb totes les persones
     * @param DNI DNI de la persona que es vol eliminar
     */
    private static void eliminarPersona(ArrayList<Persona3> persones, String DNI){
        for (int i = 0; i < persones.size(); i++) {
            if(persones.get(i).getDNI().equals(DNI)){
                persones.remove(persones.get(i));
            }
        }
    }

    /**
     * Mètode per actualitzar les dades d'una persona
     * @param persones array list amb totes les persones
     */
    private static void actualitzarPersona(ArrayList<Persona3> persones){
        String DNI = Utilities.llegirString("Escriu el DNI de la persona que vols actualitzar.");
        int pos = getPosicioPersona(persones, DNI);
        Persona3 persona;
        if(pos > -1 ){
            persona = persones.get(pos);
            String nom = Utilities.llegirString("Escriu el teu nom.");
            String cognom1 = Utilities.llegirString("Escriu el teu primer cognom.");
            String cognom2 = Utilities.llegirString("Escriu el teu segon cognom.");
            int diaNaixement = Utilities.llegirEnter("Escriu el teu dia de naixement.", 1, 31);
            int mesNaixement = Utilities.llegirEnter("Escriu el teu mes de naixement.", 1, 12);
            int anyNaixement = Utilities.llegirEnter("Escriu el teu any de naixement.", 0, LocalDate.now().getYear());
            LocalDate dataNaixement = LocalDate.of(anyNaixement, mesNaixement, diaNaixement);
            String genere = Utilities.llegirString("Escriu el teu gènere.");
            int alcada = Utilities.llegirEnter("Esciu la teva alçada (cm).", 100, 250);
            persona.setNom(nom);
            persona.setCognom1(cognom1);
            persona.setCognom2(cognom2);
            persona.setDataNaixement(dataNaixement);
            persona.setGenere(genere);
            persona.setAlcada(alcada);
            System.out.println(CYAN_BOLD_BRIGHT + "Persona actualitzada correctament.");
        }
        else{
            System.out.println(RED_BOLD_BRIGHT + "No es pot actualitzar aquesta persona perquè no existeix.");
        }
    }

    /**
     * Mètode per a donar de menjar a una persona
     * @param personaActual persona que menja
     * @param aliments array list amb tots els aliments que hi ha
     */
    private static void menjar(Persona3 personaActual, ArrayList<Aliment> aliments){
        int numAliment = Utilities.llegirEnter("Què vols prendre?\n\t1.-Una poma\n\t2.-Una hamburguesa\n\t3.-Una beguda monster\n\t4.-Un plat d'espaguetis", 1, 4);
        personaActual.menjar(aliments.get(numAliment - 1));
        System.out.println("Després de prendre un/a " + aliments.get(numAliment - 1).getNom() + " el/la "  + personaActual.getNom() + " pesa "  + personaActual.getPes() + "kg.");
    }

    /**
     * Mètode per fer que una persona faci esport
     * @param personaActual persona que farà esport
     */
    private static void ferEsport(Persona3 personaActual){
        int minuts = Utilities.llegirEnter("Escriu quants minuts d'esport vols fer.", 1, 240);
        personaActual.ferEsport(minuts);
        System.out.println("Després de fer " + minuts + " d'esport, el/la " + personaActual.getNom() + " pesa " + personaActual.getPes() + "kg.");
    }

    /**
     * Mètode pero saber si una persona existeix o no
     * @param persones array list amb totes les persones
     * @param DNI DNI per identificar la persona
     * @return true si existeix, false si no
     */
    private static boolean existeixPersona(ArrayList<Persona3> persones, String DNI){
        for (Persona3 persona : persones) {
            if (persona.getDNI().equals(DNI)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Mètode per trobar la posició d'una persona dins de l'array list
     * @param persones array list amb totes les persones
     * @param DNI DNI per identificar la persona
     * @return -1 si no està, la posició en la que es troba si està
     */
    private static int getPosicioPersona(ArrayList<Persona3> persones, String DNI){
        for (int i = 0; i < persones.size(); i++) {
            if(persones.get(i).getDNI().equals(DNI)){
                return i;
            }
        }
        return -1;
    }

}
