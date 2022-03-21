package com.company.ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class E01_6 {
    public static void main(String[] args) {
        DecimalFormat numberFormat = new DecimalFormat("#.##");
        File file= new File("partides.csv");
        Scanner input = null;
        float averageScore = 0;
        int count = 0;
        try{
            input = new Scanner(file);
            while (input.hasNextLine()){
                String line = input.nextLine();
                String[] values = line.split(";");
                averageScore+=Integer.parseInt(values[1]);
                count++;
            }
        }catch(FileNotFoundException fnfe){
            System.out.println("ERROR." + fnfe.getMessage());
        }catch (Exception e){
            System.out.println("ERROR." + e.getMessage());
        }finally{
            if(input != null){
                input.close();
                averageScore /= count;
                System.out.println("Average score: " + numberFormat.format(averageScore));
            }
        }
    }
}
