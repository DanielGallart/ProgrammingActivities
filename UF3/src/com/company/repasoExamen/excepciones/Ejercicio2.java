package com.company.repasoExamen.excepciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio2 {
    private static boolean incidencias = false;
    public static void main(String[] args) {
        Ejercicio2 main = new Ejercicio2();
        String ruta = "src" + File.separator + "files" + File.separator + "texto.txt";
        String ruta2 = "src" + File.separator + "files" + File.separator + "escritura.txt";
        ArrayList<String> contenido = main.leerFichero(ruta);
        try{
            main.escribirFichero(ruta2, contenido);
        }catch(FileAlreadyExistsException faee){
            System.out.println("ERROR --> " + faee.getMessage());
            incidencias = true;
        }
        if(incidencias){
            System.out.println("Lo sentimos, ha habido algunos problemas.");
        }
        else{
            System.out.println("Todo ha ido perfecto.");
        }
    }

    private ArrayList<String> leerFichero(String ruta){
        File f = new File(ruta);
        ArrayList<String> contenido = new ArrayList<>();
        Scanner input = null;
        try{
            input = new Scanner(f);
            while(input.hasNextLine()){
                contenido.add(input.nextLine());
            }
        }catch (FileNotFoundException fnfe){
            System.out.println("ERROR no existe el archivo --> " + fnfe.getMessage());
            incidencias = true;
        }catch(Exception e) {
            System.out.println("ERROR general --> " + e.getMessage());
            incidencias = true;
        }finally {
            if(input != null){
                input.close();
            }
        }
        return contenido;
    }

    private void escribirFichero(String path, ArrayList<String> texto) throws FileAlreadyExistsException{
        File f = new File(path);
        PrintStream ps = null;
        try{
            if(f.exists()){
                throw new FileAlreadyExistsException("Ya existe el archivo");
            }
            ps = new PrintStream(f);
            for (int i = 0; i < texto.size(); i++) {
                ps.println(texto.get(i).toUpperCase(Locale.ROOT));
            }
        }catch(FileNotFoundException fnfe){
            System.out.println("ERROR no existe el archivo --> " + fnfe.getMessage());
            incidencias = true;
        }catch (Exception e){
            System.out.println("ERROR genérico --> " + e.getStackTrace());
            incidencias = true;
        }finally {
            if(ps != null){
                ps.close();
            }
        }
    }
}
