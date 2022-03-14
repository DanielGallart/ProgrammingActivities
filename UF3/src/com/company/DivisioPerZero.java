package com.company;

public class DivisioPerZero {
    public static void main(String[] args) {
        int x = 2, y = 0;

        try{
            int r = x/y;
        }catch(ArithmeticException a){
            System.out.println("Augusto es un perro " + a.getMessage());
            System.out.println(a.getCause());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Estamos practicando las excepciones");
        }
    }
}
