package models;

import java.time.LocalDate;

public class Persona2 {

    private String nom;
    private String cognom1;
    private String cognom2;
    private LocalDate dataNaixement;
    private String DNI;
    private String genere;
    private float alcada;
    private boolean vacunatCovid;
    private boolean majorEdat;
    private boolean carnetConduir;
    private int codiPostal;
    public static int personesCreades;

    /**
     * Constructor de persona amb 3 paràmetres
     * @param nom nom de la persona
     * @param cognom1 primer cognom de la persona
     * @param cognom2 segon cognom de la persona
     */
    public Persona2(String nom, String cognom1, String cognom2) {
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
    }

    /**
     * Constructor amb 4 paràmetres
     * @param nom nom de la persona
     * @param cognom1 primer cognom de la persona
     * @param cognom2 segon cognom de la persona
     * @param DNI DNI de la persona
     */
    public Persona2(String nom, String cognom1, String cognom2, String DNI) {
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.DNI = DNI;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public LocalDate getDataNaixement() {
        return dataNaixement;
    }

    public void setDataNaixement(LocalDate dataNaixement) {
        this.dataNaixement = dataNaixement;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public float getAlcada() {
        return alcada;
    }

    public void setAlcada(float alcada) {
        this.alcada = alcada;
    }

    public boolean isVacunatCovid() {
        return vacunatCovid;
    }

    public void setVacunatCovid(boolean vacunatCovid) {
        this.vacunatCovid = vacunatCovid;
    }

    public boolean esMajorEdat() {
        return majorEdat;
    }

    public void setMajorEdat(boolean majorEdat) {
        this.majorEdat = majorEdat;
    }

    public boolean teCarnetConduir() {
        return carnetConduir;
    }

    public void setCarnetConduir(boolean carnetConduir) {
        this.carnetConduir = carnetConduir;
    }

    public int getCodiPostal() {
        return codiPostal;
    }

    public void setCodiPostal(int codiPostal) {
        this.codiPostal = codiPostal;
    }

    public void vacunar(String vacuna){
        if(vacuna.equalsIgnoreCase("AstraZeneca") || vacuna.equalsIgnoreCase("Physer") || vacuna.equalsIgnoreCase("Moderna")){
            this.vacunatCovid = true;
            System.out.println("Gràcies per vacunar-te.");
        }
        else{
            System.out.println("No tenim aquesta vacuna, no el podem vacunar.");
        }
    }

    public void dormir(){
        System.out.println("zzzzzzzzzz...");
    }

    public void parlar(){
        System.out.println("bla bla bla...");
    }

    public void dirNom(){
        System.out.println("Hola, em dic " + this.nom + " " + this.cognom1 + " " + this.cognom2 + ".");
    }

    public void mostrarEdat(){
        int anyNaixement = this.dataNaixement.getYear();
        int anyActual = LocalDate.now().getYear();
        int edat = anyActual - anyNaixement;

        System.out.println("Tens " + edat + " anys.");
    }

    @Override
    public String toString() {
        return "Persona\n{" +
                "\tLa persona es diu " + nom + " " + cognom1 + " " + cognom2 +
                "\n\t, dataNaixement=" + dataNaixement +
                "\n\t, DNI='" + DNI + '\'' +
                "\n\t, genere='" + genere + '\'' +
                "\n\t, alcada=" + alcada +
                "\n\t, vacunatCovid=" + vacunatCovid +
                "\n\t, majorEdat=" + majorEdat +
                "\n\t, carnetConduir=" + carnetConduir +
                "\n\t, codiPostal=" + codiPostal +
                "\n}";
    }
}
