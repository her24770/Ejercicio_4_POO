package clases;

public class Animal {
    protected String nombreCientifico;
    protected String descripcionHabitat;
    protected int vidaEsperanza;
    protected boolean intercambio;


    /**
     * Constructor personalizado para animal
     * @param nombreCientifico nombre cientifico de la serpiente
     * @param descripcionHabitat cómo es el habitat de la serpiente
     * @param vidaEsperanza años que vive
     * @param intercambio fue obtenida por intercambio
     */
    public Animal(String nombreCientifico, String descripcionHabitat, int vidaEsperanza, boolean intercambio) {
        this.nombreCientifico = nombreCientifico;
        this.descripcionHabitat = descripcionHabitat;
        this.vidaEsperanza = vidaEsperanza;
        this.intercambio = intercambio;
    }

    /**
     * Constructor vacio Animal
     */
    public Animal(){
    }

    /**
     * @param intercambio define si el animal fue intercambiado o no
     */
    public void setIntercambio(boolean intercambio){
        this.intercambio = intercambio;
    }

    /**
     * @return define si el animal fue intercambiado o no
     */
    public boolean getIntercambio(){
        return intercambio;
    }

    /**
     * @param nombreCientifico El nombre cientifico del animal
     */
    public void setNombreCientifico(String nombreCientifico){
        this.nombreCientifico = nombreCientifico;
    }

    /**
     * @return El nombre cientifico del animal
     */
    public String getNombreCientifico(){
        return nombreCientifico;
    }

    /**
     * @param descripcionHabitat Describe el tipo de habitat en el que vive
     */
    public void setDescripcionHabitat(String descripcionHabitat){
        this.descripcionHabitat = descripcionHabitat;
    }

    /**
     * @return Describe el tipo de habitat en el que vive
     */
    public String getDescripcionHabitat(){
        return descripcionHabitat;
    }

    /**
     * @param vidaEsperanza La esperanza de Vida del animal
     */
    public void setVidaEsperanza(int vidaEsperanza){
        this.vidaEsperanza = vidaEsperanza;
    }

    /**
     * @return La esperanza de Vida del animal
     */
    public int getVidaEsperanza(){
        return vidaEsperanza;
    }

    /**
     * @return informacion del animal
     */
    @Override
    public String toString() {
        return "Nombre Cientifico: " + nombreCientifico +
                "\nDescripcion del Habitat: " + descripcionHabitat +
                "\nEsperanza de Vida: " + vidaEsperanza;
    }
}