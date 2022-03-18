package com.company.ejercicios.E01_2;

import java.io.File;
import java.util.Date;

public class E01_2_2 {
    public static void main(String[] args) {
        listarDescargasCompleto();
    }

    private static void listarDescargasCompleto(){
        String home = System.getProperty("user.home");
        String rutaCompleta = home + File.separator + "Downloads";
        File descargas = new File(rutaCompleta);
        File[] elementosDescargas = new File[0];
        try{
            elementosDescargas = descargas.listFiles();
        }catch(SecurityException se){
            System.out.println("ERROR de seguridad: " + se.getMessage());
        }
        catch(Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
        recorrerElementosDescargas(elementosDescargas);
        
    }
    
    private static void recorrerElementosDescargas(File[] files){
        final float KBYTESIZEINBITES = 1024;
        long millisec;
        Date lastModifiedDate;
        try{
            for (File f: files) {
                millisec=f.lastModified();
                lastModifiedDate = new Date(millisec);
                if(f.isDirectory()){
                    System.out.println("El elemento " + f.getName() + " es un directorio. Ocupa: " + f.length() / KBYTESIZEINBITES + " KB." +
                            "Última modificación: " + lastModifiedDate);
                }
                else if(f.isFile()){
                    System.out.println("El elemento " + f.getName() + " es un documento. Ocupa " + f.length() / KBYTESIZEINBITES + " KB." +
                            "Última modificación: " + lastModifiedDate);
                }
            }
        }catch(SecurityException se){
            System.out.println("ERROR de seguridad: " + se.getMessage());
        }
        catch(Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
