package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class DemoStack {

    public static void main(String[] args) {
	// write your code here
        ArrayList<Integer> aL = new ArrayList<>();
        Stack<String> pila = null;
        DemoStack main = new DemoStack();
        pila = main.init(pila);
        main.printPila(pila);
    }

    private Stack<String> init (Stack<String> pila){
        pila = new Stack<>();
        pila.push("Groc");
        pila.push("Lila");
        pila.push("Blau");
        pila.push("Vermell");
        return pila;
    }


    private void printPila(Stack<String> pila){
        for (String s: pila) {
            System.out.println(s);
        }
    }


}
