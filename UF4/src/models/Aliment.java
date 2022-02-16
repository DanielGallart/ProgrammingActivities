package models;

public class Aliment {
    private String nom;
    private float pes;
    private float valorEnergetic;

    /**
     * Constructor per crear aliments amb tots els paràmetres
     * @param nom nom de l'aliment
     * @param pes pes de l'aliment
     * @param valorEnergetic valor energètic de l'aliment
     */
    public Aliment(String nom, float pes, float valorEnergetic) {
        this.nom = nom;
        this.pes = pes;
        this.valorEnergetic = valorEnergetic;
    }

    /**
     * Mètode per saber el nom de l'aliment
     * @return nom de l'aliment
     */
    public String getNom() {
        return nom;
    }

    /**
     * Mètode per canviar el nom de l'aliment
     * @param nom nou nom de l'aliment
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Mètode per saber el pes de l'aliment
     * @return pes de l'aliment
     */
    public float getPes() {
        return pes;
    }

    /**
     * Mètode per canviar el pes de l'aliment
     * @param pes nou pes de l'aliment
     */
    public void setPes(float pes) {
        this.pes = pes;
    }

    /**
     * Mètode per saber el valor energètic de l'aliment
     * @return valor energètic de l'aliment
     */
    public float getValorEnergetic() {
        return valorEnergetic;
    }

    /**
     * Mètode per canviar el valor energètic de l'aliment
     * @param valorEnergetic nou valor energètic de l'aliment
     */
    public void setValorEnergetic(float valorEnergetic) {
        this.valorEnergetic = valorEnergetic;
    }

    /**
     * Mètode per imprimir les variables de l'aliment per pantalla
     * @return string amb les variables de l'aliment
     */
    @Override
    public String toString() {
        return "Aliment{" +
                "nom='" + nom + '\'' +
                ", pes=" + pes +
                ", valorEnergetic=" + valorEnergetic +
                '}';
    }
}
