package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class ArrayListExercises {

    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // NEGRO
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // ROJO
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // VERDE
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// AMARILLO
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // AZUL
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// MORADO
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // BLANCO
    public static final String BLACK = "\033[30m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String YELLOW = "\033[33m";
    public static final String BLUE = "\033[34m";
    public static final String PURPLE = "\033[35m";
    public static final String CYAN = "\033[36m";
    public static final String WHITE = "\033[37m";
    public static final String RESET = "\033[0m";

    public static void main(String[] args) {
	    final int SIZE = 5, SIZE2 = 10;

        ArrayList<Integer> numsArrayList = new ArrayList<Integer>();
        ArrayList<Integer> numsArrayList2 = new ArrayList<Integer>();
        ArrayList<Integer> numsArrayList3 = new ArrayList<Integer>();
        ArrayList<Integer> numsArrayList4 = new ArrayList<Integer>();
        ArrayList<Integer> numsArrayList4_2 = new ArrayList<Integer>();
        ArrayList<Integer> numsArrayList5 = new ArrayList<Integer>();
        ArrayList<Integer> numsArrayList6 = new ArrayList<Integer>();
        ArrayList<Integer> numsArrayList7 = new ArrayList<Integer>();

        /*
        //array en orden de escritura
        numsArrayList = crearArrayList(SIZE);
        mostrarArrayList(numsArrayList);
        */
        /*
        //array en orden inverso de escritura
        numsArrayList2 = crearArrayList(SIZE);
        mostrarArrayListInverso(numsArrayList2);
        */
        /*
        //media de números positivos, negativos y número de 0
        numsArrayList3 = crearArrayList(SIZE);
        mediaNumeros(numsArrayList3);
        */
        /*
        //mezclar vectores
        numsArrayList4 = crearArrayList(SIZE2);
        numsArrayList4_2 = crearArrayList(SIZE2);
        numsArrayList4 = mezclarArrays(numsArrayList4, numsArrayList4_2);
        mostrarArrayList(numsArrayList4);
         */
        /*
        //desplazar array
        numsArrayList5 = crearArrayList(SIZE2);
        numsArrayList5 = moverNumerosDerecha(numsArrayList5);
        mostrarArrayList(numsArrayList5);
         */

        /*
        //eliminar valor del array
        numsArrayList6 = crearArrayList(SIZE2);
        int pos = leerIntMinMax("Escribe una posicion para eliminar (0-" + (numsArrayList6.size()-1) + ")", 0, numsArrayList6.size()-1);
        numsArrayList6 = eliminarValor(numsArrayList6, pos);
        mostrarArrayList(numsArrayList6);
        pos = leerIntMinMax("Escribe una posicion para eliminar (0-" + (numsArrayList6.size()-1) + ")", 0, numsArrayList6.size()-1);
        numsArrayList6 = eliminarValor(numsArrayList6, pos);
        mostrarArrayList(numsArrayList6);
        */

        //Buscar valor en array
        numsArrayList7 = crearArrayList(SIZE2);
        int num = leerInt("Escribe el número que quieras buscar.");
        buscarValor(numsArrayList7, num);
        num = leerInt("Escribe el número que quieras buscar.");
        buscarValor(numsArrayList7, num);
    }

    public static ArrayList<Integer> crearArrayList(int arrayListSize){
        ArrayList<Integer> nombres = new ArrayList<Integer>();
        for (int i = 0; i < arrayListSize; i++) {
            nombres.add(leerInt("Escribe un número. Quedan " + (arrayListSize - i) + " números." ));
        }

        return nombres;
    }

    public static ArrayList<Integer> crearArrayListMinMax(int arrayListSize){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < arrayListSize; i++) {
            arrayList.add(leerInt("Escribe un número. Quedan " + (arrayListSize - i) + " números." ));
        }

        return arrayList;
    }

    public static void mostrarArrayList(ArrayList<Integer> arrayList){
        for (Integer num : arrayList) {
            System.out.print(num + " ");
        }
    }

    public static void mostrarArrayListInverso(ArrayList<Integer> arrayList){
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            System.out.print(arrayList.get(i) + " ");
        }
    }

    public static void mediaNumeros(ArrayList<Integer> arrayList){
        int mediaNegativa = 0, mediaPositiva = 0, numPositivos = 0, numNegativos = 0, numCeros = 0;
        for (Integer num : arrayList) {
            if(num > 0){
                mediaPositiva += num;
                numPositivos++;
            }
            else if(num < 0){
                mediaNegativa += num;
                numNegativos++;
            }
            else{
                numCeros++;
            }
        }
        System.out.println("La media de números positivos es " + (mediaPositiva / numPositivos) + ".");
        System.out.println("La media de números negativos es " + (-(Math.abs(mediaNegativa) / numNegativos)) + ".");
        System.out.println("La media de ceros es " + numCeros + ".");
    }

    public static ArrayList<Integer> mezclarArrays(ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2){
        ArrayList<Integer> mezclaArrayList = new ArrayList<Integer>();
        for (int i = 0; i < arrayList1.size(); i++) {
            mezclaArrayList.add(arrayList1.get(i));
            mezclaArrayList.add(arrayList2.get(i));
        }
        return mezclaArrayList;
    }

    public static ArrayList<Integer> moverNumerosDerecha(ArrayList<Integer> arrayList){
        ArrayList<Integer> arrayListFinal = new ArrayList<Integer>();
        int aux;
        arrayListFinal.add(arrayList.get(arrayList.size() - 1));
        for (int i = 0; i < arrayList.size() - 1; i++) {
            arrayListFinal.add(i+1, arrayList.get(i));
        }

        return arrayListFinal;
    }

    public static ArrayList<Integer> eliminarValor(ArrayList<Integer> arrayList, int pos){
        arrayList.remove(pos);
        return arrayList;
    }

    public static void buscarValor(ArrayList<Integer> arrayList, int num){
        Collections.sort(arrayList);
        mostrarArrayList(arrayList);
        System.out.println("");
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) == num){
                System.out.println("El número " + num + " está en la posición " + i + ".");
                return;
            }
            else if(arrayList.get(i) > num){
                System.out.println("El número " + num + " no está.");
                return;
            }
        }
    }

    public static int leerIntMinMax(String mensaje, int min, int max) {
        final String RED = "\033[31m";
        final String CYAN = "\033[36m";
        final String RESET = "\u001B[0m";
        int valor = 0;
        Scanner input = new Scanner(System.in);
        boolean valorCorrecto;
        do{
            System.out.println( WHITE_BOLD_BRIGHT + mensaje);
            valorCorrecto = input.hasNextInt();
            if (valorCorrecto) {
                valor = input.nextInt();
                if (valor < min || valor > max) {
                    System.out.println(RED_BOLD_BRIGHT + "ERROR! " + RESET + WHITE_BOLD_BRIGHT +" Número fuera de rango." + RESET);
                    valorCorrecto = false;
                }
            } else {
                System.out.println(RED_BOLD_BRIGHT + "ERROR!" + RESET + WHITE_BOLD_BRIGHT + " Carácter no válido." + RESET);
            }
            input.nextLine();
        }while(!valorCorrecto);

        return valor;
    }

    public static int leerInt(String mensaje) {
        final String RED = "\033[31m";
        final String CYAN = "\033[36m";
        final String RESET = "\u001B[0m";
        int valor = 0;
        Scanner input = new Scanner(System.in);
        boolean valorCorrecto;
        do{
            System.out.println( WHITE_BOLD_BRIGHT + mensaje);
            valorCorrecto = input.hasNextInt();
            if (valorCorrecto) {
                valor = input.nextInt();
            } else {
                System.out.println(RED_BOLD_BRIGHT + "ERROR!" + RESET + WHITE_BOLD_BRIGHT + " Carácter no válido." + RESET);
            }
            input.nextLine();
        }while(!valorCorrecto);

        return valor;
    }
}
