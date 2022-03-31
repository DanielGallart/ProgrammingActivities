package com.company;

import java.io.File;
import java.io.IOException;

public class FilesTry {
    public static void main(String[] args) {
        File fitxer = new File("hola.txt");
        System.out.println(fitxer.exists());

        try{
            fitxer.createNewFile();
        }catch(IOException ioe){
            System.out.println("ERROR: " + ioe.getMessage());
        }catch(Exception e){
            System.out.println("ERROR: FATAL ERROR "  + e.getMessage());
        }

        try{
            System.out.println(fitxer.mkdir());
        }catch(Exception e){
            System.out.println("ERROR: FATAL ERROR "  + e.getMessage());
        }
        String home = System.getProperty("user.home");
        String ruta = home + File.separator + "IdeaProjects";
        File file= new File(ruta); //unix or windows platform
        System.out.println(ruta);
    }
}
