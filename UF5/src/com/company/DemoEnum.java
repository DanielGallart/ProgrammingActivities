package com.company;

import com.company.models.DiaSetmana;
import com.company.models.Estacions;

import java.util.ArrayList;

public class DemoEnum {
    public static void main(String[] args) {
        DemoEnum main = new DemoEnum();
        Estacions estacioActual;
        ArrayList<DiaSetmana> dies = new ArrayList<>();
        main.initDies(dies);
        estacioActual = Estacions.HIVERN;
        System.out.println(estacioActual );
        main.llistarDies(dies);

    }

    private void initDies(ArrayList<DiaSetmana> dies){
        dies.add(DiaSetmana.DISSABTE);
        dies.add(DiaSetmana.DIUMENGE);
    }

    private void llistarDies(ArrayList<DiaSetmana> dies){
        for (DiaSetmana d: dies) {
            System.out.println(d);
        }
    }
}
