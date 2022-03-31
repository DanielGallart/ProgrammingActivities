package com.company.ejercicios.E01_2;

import java.io.File;

public class E01_2_1 {
    public static void main(String[] args) {
        E01_2_1 main = new E01_2_1();
        main.listarDescargas();
    }

    private void listarDescargas(){
        String home = System.getProperty("user.home");
        String rutaCompleta = home + File.separator + "Downloads";
        File descargas = new File(rutaCompleta);
        try{
            File[] elementosDescargas = descargas.listFiles();
            for (File f: elementosDescargas) {
                if(f.isDirectory()){
                    System.out.println("El elemento " + f.getName() + " es un directorio.");
                }
                else if(f.isFile()){
                    System.out.println("El elemento " + f.getName() + " es un documento.");
                }
            }
        }catch(Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
