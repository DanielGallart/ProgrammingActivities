package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Cientifica_gallartDaniel implements Serializable {
    private String nom;
    private int edat;
    private String llocNaixement;
    private ArrayList<String> professions;

    public Cientifica_gallartDaniel(String nom, int anyNaixement, int anyMort, String llocNaixement, ArrayList<String> professions) {
        this.nom = nom;
        this.edat = calcularEdat(anyNaixement, anyMort);
        this.llocNaixement = llocNaixement;
        this.professions = professions;
    }

    public int calcularEdat(int anyNaixement, int anyMort){
        return anyMort -  anyNaixement;
    }

    @Override
    public String toString() {
        return "Cientifica_gallartDaniel{" +
                "nom='" + nom + '\'' +
                ", edat=" + edat +
                ", professions=" + professions +
                '}';
    }
}
