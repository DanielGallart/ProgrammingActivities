package models;

public class Gos {
    // Atributs que descriuen un Gos
    private String nom;
    private String raca;
    private int edat;
    private float pes;
    private boolean perillos;
    private Persona propietari;
    private int nivellGana = 10;
    private int nivellSet = 5;
    private int nivellEnergia = 7;
    private boolean teSon = true;

    /**
     * Constructor amb els següents paràmetres:
     * @param nom
     */
    public Gos(String nom){
        this.nom = nom;
    }

    /**
     * Constructor amb els següents paràmetres:
     * @param nom
     * @param raca
     * @param edat
     */
    public Gos(String nom, String raca, int edat){
        this.nom = nom;
        this.raca = raca;
        this.edat = edat;
    }

    public Gos(String nom, String raca, int edat, float pes, boolean perillos) {
        this.nom = nom;
        this.raca = raca;
        this.edat = edat;
        this.pes = pes;
        this.perillos = perillos;
    }

    /**
     * Mètode dormir
     * @param hores
     */
    public void dormir(int hores){
        this.nivellEnergia += hores;
        this.teSon = false;
    }

    /**
     * Mètode per fer bordar el gos
     */
    public void bordar(){
        System.out.println("Bup bup!");
    }

    /**
     * Passejar el Gos
     */
    public void passejar(){
        if (this.nivellEnergia <= 0 || this.nivellGana > 20 || this.nivellSet > 10){
            System.out.println("El teu gos està mig desmaiat i no pot caminar");
            this.dormir(10);
        }else {
            for (int i = 0; i < 4; i++) {
                this.bordar();
            }
            System.out.println("" +
                    "             .--~~,__\n" +
                    ":-....,-------`~~'._.'\n" +
                    " `-,,,  ,_      ;'~U'\n" +
                    "  _,-' ,'`-__; '--.\n" +
                    " (_/'~~      ''''(;");
            this.nivellGana += 10;
            this.nivellSet += 5;
            this.nivellEnergia -= 7;
        }
    }

    /**
     * Donar de menjar al Gos
     * @param tipus
     */
    public void donarMenjar(String tipus){
        switch (tipus){
            case "Pinso":
                this.bordar();
                this.nivellGana += 2;
                this.nivellSet -= 2;
                System.out.println("" +
                        " __       ___,.-------..__        __\n" +
                        "//\\\\ _,-''                `'--._ //\\\\\n" +
                        "\\\\ ;'                           `: //\n" +
                        " `(                               )'\n" +
                        "   :.                           ,;\n" +
                        "    `.`--.___           ___.--','\n" +
                        "      `.     ``-------''     ,'\n" +
                        "         -.               ,-\n" +
                        "            `-._______.-'");
                this.pes *= 1.2f;
                break;
            case "Entrecot":
                this.nivellGana -= 10;
                this.nivellSet -= 5;
                this.pes += 2;
                System.out.println("" +
                        "    ___\n" +
                        " __/_  `.  .-\"\"\"-.\n" +
                        " \\_,` | \\-'  /   )`-')\n" +
                        "  \"\") `\"`    \\  ((`\"`\n" +
                        " ___Y  ,    .'7 /|\n" +
                        "(_,___/...-` (_/_/");
                break;
            default:
                System.out.println("Li has donat un menjar no adequat al teu gos!");
                break;
        }
    }

    /**
     * Mètode per recuperar nom del Gos
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * Em permet canviar el nom del Gos
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Setter per canviar el pes del Gos
     * @param pes
     */
    public void setPes(float pes) {
        if (pes < 0.5f || pes > 50.0f){
            System.out.println("ERROR: Tens un microbi o un cavall");
        }else {
            this.pes = pes;
        }
    }

    public boolean isPerillos() {
        return perillos;
    }

    public Persona getPropietari() {
        return propietari;
    }

    public void setPropietari(Persona propietari) {
        this.propietari = propietari;
    }

    @Override
    public String toString() {
        return "Gos{" +
                "nom='" + nom + '\'' +
                ", raça='" + raca + '\'' +
                ", edat=" + edat +
                ", pes=" + pes +
                ", perillos=" + perillos +
                ", propietari='" + propietari + '\'' +
                ", nivellGana=" + nivellGana +
                ", nivellSet=" + nivellSet +
                ", nivellEnergia=" + nivellEnergia +
                ", teSon=" + teSon +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gos gos = (Gos) o;

        if (!nom.equals(gos.nom)) return false;
        if (!raca.equals(gos.raca)) return false;
        return propietari.equals(gos.propietari);
    }
}