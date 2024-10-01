package clases;

public class Animal {
    protected String nombreCientifico;
    protected String descripcionHabitat;
    protected int vidaEsperanza;
    protected boolean intercambio;

    public Animal(String nombreCientifico, String descripcionHabitat, int vidaEsperanza, boolean intercambio) {
        this.nombreCientifico = nombreCientifico;
        this.descripcionHabitat = descripcionHabitat;
        this.vidaEsperanza = vidaEsperanza;
        this.intercambio = intercambio;
    }

    public Animal(){
    }

    public void setIntercambio(boolean intercambio){
        this.intercambio = intercambio;
    }

    public boolean getIntercambio(){
        return intercambio;
    }

    public void setNombreCientifico(String nombreCientifico){
        this.nombreCientifico = nombreCientifico;
    }

    public String getNombreCientifico(){
        return nombreCientifico;
    }

    public void setDescripcionHabitat(String descripcionHabitat){
        this.descripcionHabitat = descripcionHabitat;
    }
    public String getDescripcionHabitat(){
        return descripcionHabitat;
    }

    public void setVidaEsperanza(int vidaEsperanza){
        this.vidaEsperanza = vidaEsperanza;
    }
    public int getVidaEsperanza(){
        return vidaEsperanza;
    }

    @Override
    public String toString() {
        return "Nombre Cientifico: " + nombreCientifico +
                "\nDescripcion del Habitat: " + descripcionHabitat +
                "\nEsperanza de Vida: " + vidaEsperanza;
    }
}