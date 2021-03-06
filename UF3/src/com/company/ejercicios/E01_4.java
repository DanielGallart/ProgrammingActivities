package com.company.ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class E01_4 {
    public static void main(String[] args) {
        E01_4 main = new E01_4();
        main.readText();
    }

    private void readText(){
        float average = 0, count = 0;
        float aux;
        try {
            File myObj = new File("src/files/numbers.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()) {
                String data = myReader.next();
                System.out.println(data);
                average += Float.parseFloat(data);
                count++;
            }
            System.out.println(average + " " + count);
            myReader.close();
            System.out.println("La media de los numeros es " + average / count);
        } catch(NumberFormatException nfe){
            System.out.println("ERROR de formato -->" + nfe.getMessage());
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred." + e.getMessage());
        }
    }
}
