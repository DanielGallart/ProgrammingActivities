package models;

import java.util.ArrayList;

public class Persona {
    private String nom;
    private String cognom1;
    private String cognom2;
    private int edat;
    private String pais;
    private String DNI;
    private ArrayList<Gos> gossos;

    public Persona(String nom, String cognom1, String cognom2, int edat, String pais, String DNI) {
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.edat = edat;
        this.pais = pais;
        this.DNI = DNI;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public int getEdat() {
        return edat;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public ArrayList<Gos> getGossos() {
        return gossos;
    }

    public void adoptarGos(Gos gos) {
        this.gossos.add(gos);
    }

    public String getDNI(){
        return DNI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        return DNI.equals(persona.DNI);
    }
}
