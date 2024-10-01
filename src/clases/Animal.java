package clases;

public class Animal {
    private String nombreCientifico;
    private String descripcionHabitat;
    private int vidaEsperanza;
    private Boolean intercambio;

    public Animal(String nombreCientifico, String descripcionHabitat, int vidaEsperanza){
        this.nombreCientifico = nombreCientifico;
        this.descripcionHabitat = descripcionHabitat;
        this.vidaEsperanza = vidaEsperanza;
    }

    public Animal(){
    }

    public void setIntercambio(Boolean intercambio){
        this.intercambio = intercambio;
    }

    public Boolean getIntercambio(){
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