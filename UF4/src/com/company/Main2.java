package com.company;

import models.Persona2;

import java.time.LocalDate;
import java.util.ArrayList;
import utils.Utilities;

public class Main2 {
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // ROJO
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // VERDE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN

    public static void main(String[] args) {
        ArrayList<Persona2> persones = new ArrayList<>();
        Persona2 persona = new Persona2("Daniel", "Gallart", "Álvarez", "23842866P");
        Persona2.personesCreades++;
        persones.add(persona);

        System.out.println(GREEN_BOLD_BRIGHT + "BENVINGUT AL PROGRAMA");

        menuInicial(persones);
    }

    /**
     * Mètode pel menú principal
     * @param persones array list amb totes les persones
     */
    private static void menuInicial(ArrayList<Persona2> persones){
        Persona2 personaActual;
        int opcio = Utilities.llegirEnter("Què vols fer?\n\t1.-Crear persona\n\t2.-Actualitzar persona\n\t3.-Log in com a persona\n\t4.-Eliminar persona\n\t5.-Veure número de persones creades\n\t6.-Sortir", 1, 6);

        switch (opcio){
            case 1:
                String nom = Utilities.llegirString("Escriu el teu nom.");
                String cognom1 = Utilities.llegirString("Escriu el teu primer cognom.");
                String cognom2 = Utilities.llegirString("Escriu el teu segon cognom.");
                String DNI = Utilities.llegirString("Escriu el teu DNI.");

                personaActual = crearPersona(nom, cognom1, cognom2, DNI);
                if(existeixPersona(persones, personaActual.getDNI())){
                    System.out.println(RED_BOLD_BRIGHT + "Ja existeix una persona amb aquest DNI.");
                    menuInicial(persones);
                }
                persones.add(crearPersona(nom, cognom1, cognom2, DNI));
                Persona2.personesCreades++;
                System.out.println(CYAN_BOLD_BRIGHT + "Persona creada correctament");
                menuPersona(persones, personaActual);
                break;
            case 2:
                String DNI2 = Utilities.llegirString("Escriu el DNI de la persona que vols actualitzar.");
                actualitzarPersona(persones, DNI2);
                menuInicial(persones);
                break;
            case 3:
                String DNI3 = Utilities.llegirString("Escriu el teu DNI.");
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
                String DNI4 = Utilities.llegirString("Escriu el DNI de la persona que vol eliminar.");
                if(existeixPersona(persones, DNI4)){
                    eliminarPersona(persones, DNI4);
                    System.out.println(CYAN_BOLD_BRIGHT + "Persona eliminada amb èxit.");
                    Persona2.personesCreades--;
                }
                else{
                    System.out.println(RED_BOLD_BRIGHT + "No es pot eliminar aquesta persona perquè no existeix.");
                }
                menuInicial(persones);
                break;
            case 5:
                System.out.println(Persona2.personesCreades);
                menuInicial(persones);
            case 6:
                System.out.println(GREEN_BOLD_BRIGHT + "SORTINT DE L'APLICACIÓ...");
                break;
        }
    }

    /**
     * Menú per quan s'ha iniciat sessió com a persona
     * @param persones array list amb totes les persones
     * @param personaActual la persona amb la qual s'ha iniciat sessió
     */
    private static void menuPersona(ArrayList<Persona2> persones, Persona2 personaActual){
        int opcio = Utilities.llegirEnter(personaActual.getNom() + " " + personaActual.getCognom1() + " , què vols fer?\n\t1.-Mostrar persona\n\t2.-Dir nom\n\t3.-Mostrar edat" +
                "\n\t4.-Parlar\n\t5.-Vacunar (AstraZeneca/Physer/Moderna)\n\t6.-Dormir\n\t7.Tirar enrere\n\t8-Sortir", 1, 8);

        switch (opcio){
            case 1:
                System.out.println(CYAN_BOLD_BRIGHT + personaActual);
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
                String vacuna = Utilities.llegirString("Escriu la vacuna que et vols ficar.");
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
        return new Persona2(nom, cognom1, cognom2, DNI);
    }

    /**
     * Mètode per fer log in d'una persona
     * @param persones array list amb totes les persones
     * @param DNI DNI de la persona amb la que vull fer log in
     * @return retorna la persona
     */
    private static Persona2 logPersona(ArrayList<Persona2> persones, String DNI){
        Persona2 personaActual = null;
        for (Persona2 persone : persones) {
            if (persone.getDNI().equals(DNI)) {
                personaActual = persone;
            }
        }
        return personaActual;
    }

    /**
     * Mètode per eliminar una persona
     * @param persones array list amb totes les persones
     * @param DNI DNI de la persona que es vol eliminar
     */
    private static void eliminarPersona(ArrayList<Persona2> persones, String DNI){
        for (int i = 0; i < persones.size(); i++) {
            if(persones.get(i).getDNI().equals(DNI)){
                persones.remove(persones.get(i));
            }
        }
    }

    /**
     * Mètode per actualitzar les dades d'una persona
     * @param persones array list amb totes les persones
     * @param DNI DNI de la persona que volem actualitzar
     */
    private static void actualitzarPersona(ArrayList<Persona2> persones, String DNI){
        int pos = getPosicioPersona(persones, DNI);
        Persona2 persona;
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
     * Mètode pero saber si una persona existeix o no
     * @param persones array list amb totes les persones
     * @param DNI DNI per identificar la persona
     * @return true si existeix, false si no
     */
    private static boolean existeixPersona(ArrayList<Persona2> persones, String DNI){
        for (Persona2 persona : persones) {
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
    private static int getPosicioPersona(ArrayList<Persona2> persones, String DNI){
        for (int i = 0; i < persones.size(); i++) {
            if(persones.get(i).getDNI().equals(DNI)){
                return i;
            }
        }
        return -1;
    }

}
