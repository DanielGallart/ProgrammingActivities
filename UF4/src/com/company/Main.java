package com.company;

import models.Gos;
import models.Persona;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
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
        Scanner llegir = new Scanner(System.in);
        int opcio;
        int numGossos;
        int numGos;

        ArrayList<Persona> persones = new ArrayList<Persona>();
        ArrayList<Gos> gossos = new ArrayList<Gos>();
        System.out.println("BENVINGUT...");

        primerMenu(persones, gossos);

    }

    private static void primerMenu(ArrayList<Persona> persones, ArrayList<Gos> gossos) {
        int opcio = llegirEnter("Què vols fer?\n\t1.-Crear persona\n\t2.-Identificar persona\n\t3.-Crear gos\n\t4.-Sortir", 1, 4);
        Persona personaActual;

        switch (opcio) {
            case 1:
                String nomPersona = llegirString("Escriu el nom de la persona.");
                String cognom1 = llegirString("Escriu el teu cognom.");
                String cognom2 = llegirString("Escriu el teu segon cognom");
                int edatPersona = llegirEnter("Escriu al teva edat.", 5, 99);
                String pais = llegirString("Escriu el teu país");
                String DNI = llegirString("Escriu el teu DNI");

                persones.add(crearPersona(nomPersona, cognom1, cognom2, edatPersona, pais, DNI));
                primerMenu(persones, gossos);
                break;
            case 2:
                String DNI2 = llegirString("Escriu el teu DNI per entrar com a usuari.");
                personaActual = getPersonaByDNI(persones, DNI2);
                if (personaActual != null) {
                    segonMenu(personaActual, gossos);
                } else {
                    System.out.println("ERROR. Aquesta persona no existeix.");
                    primerMenu(persones, gossos);
                }
                break;
            case 3:
                String nom = llegirString("Escriu el nom del gos.");
                String raca = llegirString("Escriu la raça del gos.");
                int edat = llegirEnter("Escriu la edat del gos.", 1, 20);
                float pes = llegirFloat("Escriu el pes del gos.");
                boolean perillos = llegirBoolean("Escriu si és perillós el gos.");

                gossos.add(crearGos(nom, raca, edat, pes, perillos));
                primerMenu(persones, gossos);
                break;
            case 4:
                System.out.println("SORTINT DE L'APLICACIÓ...");
                break;
        }
    }

    private static void segonMenu(Persona personaActual, ArrayList<Gos> gossos) {
        int opcio = llegirEnter("Quin gos vols adoptar?",1, gossos.size()-1);
    }

    private static void menuJugar(Persona personaActual, ArrayList<Gos> gossosAEscollir) {
        int opcio = llegirEnter("Hola, què vols fer amb el teu gos?\n\t1- Treure'l a passejar\n\t2- Donar-li menjar\n\t3- Posar-lo a dormir\n\t4.-Tornar enrere\n\t5- Sortir",1, 5);
        ArrayList<Gos> gossos = personaActual.getGossos();
        int numGos;

        switch (opcio) {
            case 1:
                System.out.println("Quin gos vols fer servir?");
                for (int i = 0; i < gossos.size(); i++) {
                    System.out.println(i + "- " + gossos.get(i).getNom());
                }
                numGos = llegirEnter("",0, gossos.size());

                gossos.get(numGos).passejar();
                menuJugar(personaActual, gossosAEscollir);
                break;
            case 2:
                String tipusMenjar;
                System.out.println("Quin gos vols fer servir?");
                for (int i = 0; i < gossos.size(); i++) {
                    System.out.println(i + "- " + gossos.get(i).getNom());
                }
                numGos = llegirEnter("",0, gossos.size());
                tipusMenjar = llegirString("Quin tipus de menjar li vols donar? (Pinso / Entrecot)");
                gossos.get(numGos).donarMenjar(tipusMenjar);
                menuJugar(personaActual, gossosAEscollir);
                break;
            case 3:
                int hores;
                System.out.println("Quin gos vols fer servir?");
                for (int i = 0; i < gossos.size(); i++) {
                    System.out.println(i + "- " + gossos.get(i).getNom());
                }
                numGos = llegirEnter("",0, gossos.size());
                hores = llegirEnter("Quantes hores vols que dormi el teu gos " + gossos.get(numGos).getNom(),1, 12);
                gossos.get(numGos).dormir(hores);
                menuJugar(personaActual, gossosAEscollir);
                break;
            case 4:
                segonMenu(personaActual, gossosAEscollir);
                break;
            case 5:
                System.out.println("Adéu");
                break;
        }
    }

    private static Gos crearGos(String nom, String raca, int edat, float pes, boolean perillos) {
        Gos gos = new Gos(nom, raca, edat, pes, perillos);
        return gos;
    }

    private static Persona crearPersona(String nom, String cognom1, String cognom2, int edat, String pais, String DNI) {
        Persona persona = new Persona(nom, cognom1, cognom2, edat, pais, DNI);

        return persona;
    }

    private static Persona getPersonaByDNI(ArrayList<Persona> persones, String DNI) {
        Persona persona;
        for (int i = 0; i < persones.size(); i++) {
            if (persones.get(i).getDNI().equals(DNI)) {
                return persones.get(i);
            }
        }
        return null;
    }

    /**
     * Aquest mètode serveix per llegir un enter de teclat amb control d'errors.
     *
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

    public static boolean llegirBoolean(String missatge) {
        Scanner llegir = new Scanner(System.in);
        boolean opcio = false;
        boolean valorCorrecte = false;

        do {
            System.out.println(PURPLE_BOLD_BRIGHT + missatge);

            valorCorrecte = llegir.hasNextBoolean();

            if (!valorCorrecte) {
                System.out.println(RED_BOLD_BRIGHT + "ERROR: No has introduït un enter");
                llegir.nextLine();
            } else {
                opcio = llegir.nextBoolean();
                llegir.nextLine();
            }

        } while (!valorCorrecte);

        return opcio;
    }

    /**
     * Mètode per llegir un enter de teclat
     *
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
