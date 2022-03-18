package com.company.ejercicios.E01_3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class E01_3_1 {
    public static void main(String[] args) {
        E01_3_1 main = new E01_3_1();
        main.moverFotos();
    }

    private File crearDirectorio(){
        File fotos = new File("fotos");
        try{
            if(!fotos.exists()){
                if(fotos.mkdir()){
                    System.out.println("Directorio creado.");
                }
                else{
                    System.out.println("No se ha podido crear.");
                }
            }
            else{
                System.out.println("El directorio ya existe.");
            }
        }catch(SecurityException se){
            System.out.println("ERROR de seguridad: " + se.getMessage());
        }
        catch(Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
        return fotos;
    }

    private void moverFotos(){
        String home = System.getProperty("user.home");
        String rutaCompleta = home + File.separator + "Downloads";
        File descargas = new File(rutaCompleta);
        File[] elementosDescargas = new File[0];
        File fotos = crearDirectorio();

        for (File f: elementosDescargas) {

        }
    }

}
