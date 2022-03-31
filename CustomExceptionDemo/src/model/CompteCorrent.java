package model;

import excepcions.BalancNegatiu;
import excepcions.IngresDiari;
import excepcions.MassaDiners;

public class CompteCorrent {
    //attributes
    private double quantitatDiners;
    private double limitDiari;
    private double ingresDiari;

    //constructors
    public CompteCorrent(){
        this.quantitatDiners = 0;
    }

    public CompteCorrent(double c, double ld){
        this.quantitatDiners = c;
        this.limitDiari = ld;
    }

    //methods
    public double getQuantitatDiners() {
        return this.quantitatDiners;
    }

    public double getIngresDiari() {
        return ingresDiari;
    }

    public double getLimitDiari() {
        return limitDiari;
    }

    public void ingres(double c) throws MassaDiners, IngresDiari {
        this.ingresDiari+=c;
        if(this.ingresDiari > limitDiari){
            throw new IngresDiari("Has superat el límit diari. Esperi a demà per tornar a ingressar.");
        }
        this.quantitatDiners +=c;
        if (this.quantitatDiners > 1000000) {
            throw new MassaDiners();
        }
    }

    public void treureDiners(double c) throws BalancNegatiu {
        if(this.quantitatDiners < c) {
            throw new BalancNegatiu("No pots treure tants diners; actualment disposes de: " + getQuantitatDiners());
        }else {
            quantitatDiners -= c;
        }
    }

    public void canviarDia(){
        ingresDiari = 0;
    }
}