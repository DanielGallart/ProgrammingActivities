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
        }finally{
            return fotos;
        }
    }

    private void moverFotos(){
        String home = System.getProperty("user.home");
        String rutaCompleta = home + File.separator + "Downloads";
        File descargas = new File(rutaCompleta);
        File[] elementosDescargas = descargas.listFiles();
        File fotos = crearDirectorio();
        String name;
        String []values;
        for (File f: elementosDescargas) {
            name = f.getName();
            name = name.replace('.',';');
            values = name.split(";");
            String path = fotos.getName() + File.separator + f.getName();
            if(values[values.length-1].equalsIgnoreCase("png")){
                f.renameTo(new File(path));
            }
        }
    }

}
