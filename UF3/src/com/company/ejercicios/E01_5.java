package com.company.ejercicios;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.DecimalFormat;

public class E01_5 {
    public static void main(String[] args) {
        E01_5 main = new E01_5();
        main.escribirFichero();
    }

    private void escribirFichero(){
        final byte MIN_NUM = 1, MAX_NUM = 100;
        int num = 3;
        try{
            FileWriter fw = new FileWriter("numbers.txt");
            DecimalFormat numberFormat = new DecimalFormat("#.##");
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    fw.write(String.valueOf(numberFormat.format(calcularNumeroAleatorio((byte)1,(byte)100))) + " ");
                }
                fw.write("\n");
            }
            fw.close();
        }catch (FileNotFoundException fnfe){
            System.out.println(fnfe.getMessage());
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    private float calcularNumeroAleatorio(Byte maxNum, Byte minNum){
        return (float)(Math.random()*(maxNum-minNum)+minNum);
    }
}

