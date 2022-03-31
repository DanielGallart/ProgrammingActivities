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
            File file = new File("src" + File.separator + "scores.txt");
            File newFile = new File("src" + File.separator + "files" + File.separator + "medias.txt");
            if(!newFile.exists()){
                newFile.createNewFile();
            }
            FileWriter fw = new FileWriter(newFile);
            main.readFromFile(file, fw);
        }catch (NullPointerException npe){
            System.out.println("ERROR --> " + npe.getMessage());
        }catch (Exception e){
            System.out.println("ERROR --> " + e.getMessage());
        }
    }

    private void readFromFile(File file, FileWriter fw){
        DecimalFormat numberFormat = new DecimalFormat("#.##");
        Scanner auxInput = null, input = null;
        float averageScore = 0;
        int count = 0, totalElementsCounter = 0, auxTotalElementsCounter = 0;

        //Abro un fichero auxiliar igual al fichero que quiero leer
        // y cuento cuantas lineas hay para saber la última y así no escribir una línea de más
        try{
            auxInput = new Scanner(file);
            while(auxInput.hasNextLine()){
                totalElementsCounter++;
                auxInput.nextLine();
            }
        }catch(FileNotFoundException fnfe){
            System.out.println("ERROR lectura --> " + fnfe.getMessage());
        }catch (Exception e){
            System.out.println("ERROR lectura general --> " + e.getMessage());
        }finally{
            if(auxInput != null){
                auxInput.close();
            }
        }

        //Leo el archivo que quiero y compruebo si ya he llegado a la última línea que quiero escribir
        try{
            input = new Scanner(file);
            while (input.hasNextLine()){
                auxTotalElementsCounter++;
                String line = input.nextLine();
                String[] values = line.split(";");
                String[] auxValues = new String[4];
                for (int i = 0; i < 3; i++) {
                    auxValues[i] = values [i];
                }
                for (int i = 3; i < values.length; i++) {
                    averageScore+=Float.parseFloat(values[i]);
                    count++;
                }
                auxValues[3] = String.valueOf(averageScore/count);
                System.out.println(averageScore/count);
                //Compruebo si las líneas escritas coinciden con el total de líneas que hay
                fw = writeToFile(auxValues, fw, totalElementsCounter==auxTotalElementsCounter);
                averageScore=0;
                count=0;

            }
        }catch(FileNotFoundException fnfe){
            System.out.println("ERROR lectura --> " + fnfe.getMessage());
        }catch (Exception e){
            System.out.println("ERROR lectura general --> " + e.getMessage());
        }finally{
            try{
                if(input != null){
                    input.close();
                    fw.close();
                }
            }catch (IOException ioe){
                System.out.println("ERROR cerrar --> " + ioe.getMessage());
            }catch(Exception e){
                System.out.println("ERROR cerrar general --> " + e.getMessage());
            }
        }
    }

    private FileWriter writeToFile(String[] text, FileWriter fw, boolean last){
        try{
            byte count = 0;
            for (String s: text) {
                if(count < text.length - 1){
                    fw.write(s + ";");
                }
                else{
                    //Si es la última línea, no poner el salto de línea para no escribir una línea
                    //más de la cuenta
                    if(last){
                        fw.write(s);
                    }
                    else{
                        fw.write(s + "\n");
                    }
                }
                count++;
            }
        }catch(IOException ioe){
            System.out.println("ERROR escritura --> " + ioe.getMessage());
        }catch(Exception e){
            System.out.println("ERROR escritura general --> " + e.getMessage());
        }finally {
            return fw;
        }
    }
}
