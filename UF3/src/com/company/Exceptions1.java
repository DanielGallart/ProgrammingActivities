package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Exceptions1 {
    public static void main(String[] args) {
        InputStream in = null;
        try {
            System.out.println("About to open a file");
            in = new FileInputStream("src/files/missingfile.txt");
            System.out.println("File open");
            int s = in.read();
        } catch(FileNotFoundException e){
            System.out.println(e.getClass().getName()+"-"+ e.getMessage());
        } catch(IOException e){
            System.out.println(e.getClass().getName()+"-"+ e.getMessage());
        } finally{
            System.out.println("Application end");
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } System.out.println("Failed to close file");
        }
    }
}
