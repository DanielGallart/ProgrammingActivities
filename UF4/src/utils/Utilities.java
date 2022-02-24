package utils;

import java.util.Scanner;

public final class Utilities {
    private static final String RED_BOLD_BRIGHT = "\033[1;91m";   // ROJO
    private static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// MORADO

    private static Scanner input = new Scanner(System.in);

    private Utilities(){}

    /**
     * Aquest mètode serveix per llegir un enter de teclat amb control d'errors.
     * @param missatge: Serveix per passar-li el text a mostrar del menú.
     * @param min:      Valor mínim acceptat
     * @param max:      Valor màxim acceptat
     * @return : retorna un enter dins del domini de valors
     */
    public static int llegirEnter(String missatge, int min, int max) {
        int opcio = 0;
        boolean valorCorrecte;

        do {
            System.out.println(PURPLE_BOLD_BRIGHT + missatge);

            valorCorrecte = input.hasNextInt();

            if (!valorCorrecte) {
                System.out.println(RED_BOLD_BRIGHT + "ERROR: No has introduït un enter");
                input.nextLine();
            } else {
                opcio = input.nextInt();
                input.nextLine();

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
     * @param missatge: missatge que se li vol mostrar a l'usuari
     * @return valor que ha introduit l'usuari després del control d'errors
     */
    public static float llegirFloat(String missatge) {
        float opcio = 0;
        boolean valorCorrecte;

        do {
            System.out.println(PURPLE_BOLD_BRIGHT + missatge);

            valorCorrecte = input.hasNextFloat();

            if (!valorCorrecte) {
                System.out.println(RED_BOLD_BRIGHT + "ERROR: No has introduït un enter");
                input.nextLine();
            } else {
                opcio = input.nextFloat();
                input.nextLine();
            }

        } while (!valorCorrecte);

        return opcio;
    }

    /**
     * Mètode per llegir un float amb control d'errors
     * @param missatge missatge que se li vol mostrar a l'usuari
     * @param min: valor mínim que pot agafar el número
     * @param max: valor màxim que pot agafar el número
     * @return valor que ha introduit l'usuari després del control d'errors
     */
    public static float llegirFloatLimit(String missatge, int min, int max) {
        float opcio = 0;
        boolean valorCorrecte;

        do {
            System.out.println(PURPLE_BOLD_BRIGHT + missatge);

            valorCorrecte = input.hasNextFloat();

            if (!valorCorrecte) {
                System.out.println(RED_BOLD_BRIGHT + "ERROR: No has introduït un enter");
            } else {
                opcio = input.nextFloat();
                if(opcio < min || opcio > max){
                    System.out.println(RED_BOLD_BRIGHT + "ERROR: Valor fora de rang");
                    valorCorrecte = false;
                }
            }
            input.nextLine();

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

        return input.nextLine();
    }

    /**
     * Mètode per llegir un char
     * @param missatge missatge que se li vol mostrar a l'usuari
     * @return un char
     */
    public static char llegirChar(String missatge){
        String paraula;
        paraula = input.next();
        input.nextLine();

        return paraula.charAt(0);
    }
}
