package com.company;

import com.company.models.CartaUno;

import java.util.Stack;

public class EjercicioClase {
    public static void main(String[] args) {
        EjercicioClase main = new EjercicioClase();
        Stack<CartaUno> cartas = new Stack<>();
        Stack<CartaUno> mazo = new Stack();
        cartas = main.initBaraja();
        System.out.println(cartas);
        mazo = main.cogerCarta(cartas, mazo);
        System.out.println(cartas);
        System.out.println(mazo);
        System.out.println(main.cartaAleatoria(cartas));
    }

    private Stack<CartaUno> initBaraja(){
        Stack<CartaUno> baraja = new Stack<>();
        for (int i = 0; i < 2; i++) {
            baraja.add(CartaUno.ZERO);
            baraja.add(CartaUno.UNO);
            baraja.add(CartaUno.DOS);
            baraja.add(CartaUno.TRES);
            baraja.add(CartaUno.CUATRO);
            baraja.add(CartaUno.CINCO);
            baraja.add(CartaUno.SEIS);
            baraja.add(CartaUno.SIETE);
            baraja.add(CartaUno.OCHO);
            baraja.add(CartaUno.NUEVE);
            baraja.add(CartaUno.COMODIN);
            baraja.add(CartaUno.MASDOS);
            baraja.add(CartaUno.MASCUATRO);
        }
        return baraja;
    }

    private Stack<CartaUno> cogerCarta(Stack<CartaUno> baraja, Stack<CartaUno> mazo){
        mazo.add(baraja.pop());
        return mazo;
    }


    private CartaUno cartaAleatoria(Stack<CartaUno> baraja){
        int min = 0, max = baraja.size() - 1;
        int indice = (int)((Math.random() * (max - min)) + min);
        return baraja.get(indice);
    }
}
