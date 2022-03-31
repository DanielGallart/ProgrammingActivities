package com.company.ejercicios.E01_3;

import java.io.File;

public class E01_3_2 {
    public static void main(String[] args) {
        E01_3_2 main = new E01_3_2();
        File fotos = new File("fotos");
        main.deleteDir(fotos);
    }

    private void deleteDir(File dir){
        try{
            if(!dir.delete()){
                dir = deleteContentInDirectory(dir);
                dir.delete();
            }
        }catch(Exception e){
            System.out.println("ERROR --> " + e.getMessage());
        }
    }

    private File deleteContentInDirectory(File dir){
        try{
            if(dir.isDirectory()){
                File []files = dir.listFiles();
                if(files.length > 0){
                    for (File f : dir.listFiles()) {
                        f.delete();
                    }
                }
            }
        }catch(Exception e){
            System.out.println("ERROR --> " + e.getMessage());
        }
        return dir;
    }
}
