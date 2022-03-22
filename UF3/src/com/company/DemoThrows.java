package com.company;

public class DemoThrows {
    public static void main(String[] args) {
        int x = 12, y = 3;
        int resultat;

        try {
            resultat = procediment(x, y);
            System.out.println(resultat);
        }catch(ArithmeticException ae){
            System.out.println("ERROR: Divisió per zero " + ae.getMessage());
        }catch(Exception e) {
            System.out.println("ERROR: Desconegut " + e);
        }

        try{
            int[] vector = new int[10];
            resseguirVector(vector);
        }catch(IndexOutOfBoundsException iobe){
            System.out.println("ERROR: No hi ha més posicions. " + iobe.getMessage());
        }
    }

    private static int procediment(int x, int y) throws ArithmeticException{
        int resultat = x / y;
        return resultat; // Aquesta operació podria provocar una ArithmeticException
    }

    private static void resseguirVector(int[] vector) throws IndexOutOfBoundsException{
        int i = 0;
        while(true){
            System.out.println(vector[i]);
            i++;
        }
    }
}