package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Persona3 {

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
    private float pes;
    private static int personesCreades;

    /**
     * Constructor de persona amb 3 paràmetres
     * @param nom nom de la persona
     * @param cognom1 primer cognom de la persona
     * @param cognom2 segon cognom de la persona
     */
    public Persona3(String nom, String cognom1, String cognom2) {
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        sumarPersonesCreades();
    }

    /**
     * Constructor amb 4 paràmetres
     * @param nom nom de la persona
     * @param cognom1 primer cognom de la persona
     * @param cognom2 segon cognom de la persona
     * @param DNI DNI de la persona
     */
    public Persona3(String nom, String cognom1, String cognom2, String DNI) {
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.DNI = DNI;
        sumarPersonesCreades();
    }

    /**
     * Constructor amb 5 paràmetres
     * @param nom nom de la persona
     * @param cognom1 primer cognom de la persona
     * @param cognom2 segon congnom de la persona
     * @param DNI DNI de la persona
     * @param pes pes de la persona
     */
    public Persona3(String nom, String cognom1, String cognom2, String DNI, float pes) {
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.DNI = DNI;
        this.pes = pes;
        sumarPersonesCreades();
    }

    /**
     * Mètode per saber el nom de la persona
     * @return nom de la persona
     */
    public String getNom() {
        return nom;
    }

    /**
     * Mètode per canviar el nom de la persona
     * @param nom nou nom de la persona
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Mètode per saber el primer cognom de la persona
     * @return primer cognom de la persona
     */
    public String getCognom1() {
        return cognom1;
    }

    /**
     * Mètode per canviar el primer cognom de la persona
     * @param cognom1 nou primer cognom de la persona
     */
    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    /**
     * Mètode per saber el segon cognom de la persona
     * @return segon cognom de la persona
     */
    public String getCognom2() {
        return cognom2;
    }

    /**
     * Mètode per canviar el segon cognom de la persona
     * @param cognom2 nou segon cognom de la persona
     */
    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    /**
     * Mètode per saber la data de naixement de la persona
     * @return la data de naixement de la persona
     */
    public LocalDate getDataNaixement() {
        return dataNaixement;
    }

    /**
     * Mètode per canviar la data de naixement
     * @param dataNaixement nova data de naixement
     */
    public void setDataNaixement(LocalDate dataNaixement) {
        this.dataNaixement = dataNaixement;
    }

    /**
     * Mètode per saber el DNI
     * @return DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Mètode per saber el gènere
     * @return gènere
     */
    public String getGenere() {
        return genere;
    }

    /**
     * Mètode per canviar el gènere
     * @param genere nou gènere
     */
    public void setGenere(String genere) {
        this.genere = genere;
    }

    /**
     * Mètode per saber l'alçada de la persona
     * @return alçada
     */
    public float getAlcada() {
        return alcada;
    }

    /**
     * Mètode per canviar l'alçada
     * @param alcada alçada
     */
    public void setAlcada(float alcada) {
        this.alcada = alcada;
    }

    /**
     * Mètode per saber si la persona està vacunada
     * @return true si la persona està vacunada, false si no ho està
     */
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

    /**
     * Mètode per fer que una persona digui el seu nom complet
     */
    public void dirNom(){
        System.out.println("Hola, em dic " + this.nom + " " + this.cognom1 + " " + this.cognom2 + ".");
    }

    /**
     * Mètode per calcular el pes després d'haver menjat
     * @param aliment aliment que es vol menjar
     */
    public void menjar(Aliment aliment){
        this.pes = this.pes + (aliment.getValorEnergetic() / 1000);
    }

    /**
     * Mètode per calcular el nou pes després de fer esport
     * @param minutsEsport quantitat de minuts d'esport
     */
    public void ferEsport(int minutsEsport){
        this.pes = this.pes - (minutsEsport / 40);
    }

    /**
     * Mètode per saber el número de persones creades
     * @return número de persones creades
     */
    public static int getPersonesCreades(){
        return personesCreades;
    }

    /**
     * Mètode per sumar a les persones creades
     */
    private void sumarPersonesCreades(){
        personesCreades++;
    }

    /**
     * Mètode per restar a les persones creades
     */
    public static void restarPersonesCreades(){
        personesCreades--;
    }

    /**
     * Mètode per mostrar l'edat de la persona
     */
    public void mostrarEdat(){
        int anyNaixement = this.dataNaixement.getYear();
        int anyActual = LocalDate.now().getYear();
        int edat = anyActual - anyNaixement;

        System.out.println("Tens " + edat + " anys.");
    }

    /**
     * Mètode per saber el pes de la persona
     * @return pes de la persona
     */
    public float getPes() {
        return pes;
    }

    /**
     * Mètode per canviar el pes de la persona
     * @param pes nou pes de la persona
     */
    public void setPes(float pes) {
        this.pes = pes;
    }

    /**
     * Mètode per mostrar els valors de la persona per pantalla
     * @return string amb els valors de la persona
     */
    @Override
    public String toString() {
        return "Persona\n{" +
                "\tLa persona es diu " + nom + " " + cognom1 + " " + cognom2 +
                "\n\t, dataNaixement = " + dataNaixement +
                "\n\t, DNI = " + DNI +
                "\n\t, genere = " + genere +
                "\n\t, alçada = " + alcada + "cm" +
                "\n\t, pes = " + pes + "kg" +
                "\n\t, vacunatCovid = " + vacunatCovid +
                "\n\t, majorEdat = " + majorEdat +
                "\n\t, carnetConduir = " + carnetConduir +
                "\n\t, codiPostal = " + codiPostal +
                "\n}";
    }
}
