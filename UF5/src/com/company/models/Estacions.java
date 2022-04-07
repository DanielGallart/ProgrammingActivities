package com.company.models;

public enum Estacions {
    PRIMAVERA("primavera"), ESTIU("estiu"), TARDOR("tardor"), HIVERN("hivern");

    private String estacio;

    private Estacions(String estacio){
        this.estacio=estacio;
    }
}
