package com.company.ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class E01_6 {
    public static void main(String[] args) {
        E01_6 main = new E01_6();
        try{
            File file = new File("scores.txt");
            main.readFromFile(file);
        }catch (NullPointerException npe){
            System.out.println("ERROR --> " + npe.getMessage());
        }catch (Exception e){
            System.out.println("ERROR --> " + e.getMessage());
        }
    }

    private void readFromFile(File file){
        DecimalFormat numberFormat = new DecimalFormat("#.##");
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

    private void writeToFile(String[] text, FileWriter fw){
        try{
            byte count = 0;
            for (String s: text) {
                if(count < text.length - 2){
                    fw.write(s + ";");
                }
                else{
                    fw.write(s);
                }
            }
        }catch(IOException ioe){
            System.out.println("ERROR --> " + ioe.getMessage());
        }catch(Exception e){
            System.out.println("ERROR --> " + e.getMessage());
        }

    }
}
