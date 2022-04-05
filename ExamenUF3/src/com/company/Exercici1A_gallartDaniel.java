package com.company;

import com.company.utils.Utilities_gallartDaniel;

import java.io.File;
import java.io.IOException;

public class Exercici1A_gallartDaniel {

    public static void main(String[] args) {
	    Exercici1A_gallartDaniel main = new Exercici1A_gallartDaniel();
        System.out.println("BENVINGUT AL PROGRAMA");
        main.menuInicial();
    }

    /**
     * Menú inicial amb les opcions a escollir
     */
    private void menuInicial(){
        int opcio = Utilities_gallartDaniel.leerIntLimites("Escull una opció:\n\t1.-Llistar contingut de carpeta\n\t2.-Crear document o carpeta\n\t" +
                "3.-Esborrar document o carpeta\n\t4.-Sortir",1, 4);
        String nomCarpeta = "";
        switch (opcio){
            case 1:
                nomCarpeta = Utilities_gallartDaniel.leerString("Escriu el nom de la carpeta");
                llistarContingut(nomCarpeta);
                menuInicial();
                break;
            case 2:
                menuCrear();
                menuInicial();
                break;
            case 3:
                menuEliminar();
                menuInicial();
                break;
            case 4:
                System.out.println("SORTINT DE L'APLICACIÓ...");
                break;
        }
    }

    /**
     * Mètode per llistar el contingut d'una carpeta
     * @param nomCarpeta nom de la carpeta a llistar
     */
    private void llistarContingut(String nomCarpeta){
        File carpeta = new File(nomCarpeta);
        File[] arxiusCarpeta;
        if(!carpeta.exists()){
            System.out.println("No existeix la carpeta");
        }
        else{
            if(!carpeta.isDirectory()){
                System.out.println("No es una carpeta");
            }
            else{
                arxiusCarpeta = carpeta.listFiles();
                for (int i = 0; i < arxiusCarpeta.length; i++) {
                    System.out.println(arxiusCarpeta[i].getName());
                }
            }
        }
    }

    /**
     * Mètode per crear un document
     * @param nomDocument nom del document a crear
     * @return true si s'ha pogut crear / false si no
     */
    private boolean crearDocument(String nomDocument){
        File document = new File(nomDocument);
        String[] paraules = nomDocument.split(" ");
        if(document.exists() || paraules.length > 1){
            return false;
        }
        else{
            try{
                document.createNewFile();
            }catch (IOException ioe){
                System.out.println("ERROR de I/O --> " + ioe.getMessage());
            }catch (Exception e){
                System.out.println("ERROR genèric --> " + e.getMessage());
            }
            return true;
        }
    }

    /**
     * Mètode per crear una carpeta
     * @param nomCarpeta nom de la carpeta a crear
     * @return true si s'ha pogut crear / false si no
     */
    private boolean crearCarpeta(String nomCarpeta){
        File carpeta = new File(nomCarpeta);
        String[] paraules = nomCarpeta.split(" ");
        if(carpeta.exists() || paraules.length > 1){
            return false;
        }
        else{
            carpeta.mkdir();
            return true;
        }
    }

    /**
     * Mètode per eliminar un document
     * @param nomDocument nom del document a eliminar
     * @return true si s'ha pogut eliminar / false si no
     */
    private boolean eliminarDocument(String nomDocument){
        File document = new File(nomDocument);
        return document.delete();
    }

    /**
     * Mètode per eliminar una carpeta
     * @param nomCarpeta nom de la carpeta a eliminar
     * @return true si s'ha pogut eliminar / false si no
     */
    private boolean eliminarCarpeta(String nomCarpeta){
        File carpeta = new File(nomCarpeta);
        return carpeta.delete();
    }

    /**
     * Menú per a escollir què vols crear (document o carpeta)
     */
    private void menuCrear(){
        int opcio = Utilities_gallartDaniel.leerIntLimites("\t1.-Crear carpeta\n\t2.-Crear document\n\t3.-Tornar enrere",1,3);
        switch (opcio){
            case 1:
                String nomCarpeta;
                do{
                    nomCarpeta = Utilities_gallartDaniel.leerString("Escriu un nom per la carpeta. (No pot existir una carpeta amb el " +
                            "mateix nom i no pot contenir espais en blanc)");
                }while(!crearCarpeta(nomCarpeta));
                menuInicial();
                break;
            case 2:
                String nomDocument;
                do{
                    nomDocument = Utilities_gallartDaniel.leerString("Escriu un nom pel fitxer. (No pot existir un fitxer amb el " +
                            "mateix nom i no pot contenir espais en blanc)");
                }while(!crearDocument(nomDocument));
                menuInicial();
                break;
            case 3:
                menuInicial();
                break;
        }
    }

    /**
     * Menú per a escollir què vols eliminar (document o carpeta)
     */
    private void menuEliminar(){
        int opcio = Utilities_gallartDaniel.leerIntLimites("\t1.-Eliminar carpeta\n\t2.-Eliminar document\n\t3.-Tornar enrere",1,3);
        switch (opcio){
            case 1:
                String nomCarpeta;
                nomCarpeta = Utilities_gallartDaniel.leerString("Escriu el nom de la carpeta que vols eliminar.");
                if(!eliminarCarpeta(nomCarpeta)){
                    System.out.println("No s'ha pogut eliminar la carpeta.");
                }
                menuInicial();
                break;
            case 2:
                String nomDocument;
                nomDocument = Utilities_gallartDaniel.leerString("Escriu el nom del fitxer que vols eliminar.");
                if(!eliminarDocument(nomDocument)){
                    System.out.println("No s'ha pogut eliminar el document.");
                }
                menuInicial();
                break;
            case 3:
                menuInicial();
                break;
        }
    }
}
