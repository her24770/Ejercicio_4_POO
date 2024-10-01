package clases;

public class Serpiente extends Reptil{
    private String especie;
    private String color;
    private boolean venenosa;
    private boolean tipoVeneno;

    //Metodos
    public Serpiente(String nombreCientifico, String descripcionHabitat, int vidaEsperanza, boolean intercambio, int temperatura, double huevos, double peso, int longevidad, boolean peligroExt, String dieta, double longitud, String especie, String color, boolean venenosa, boolean tipoVeneno) {
        super(nombreCientifico, descripcionHabitat, vidaEsperanza, intercambio, temperatura, huevos, peso, longevidad, peligroExt, dieta, longitud);
        this.especie = especie;
        this.color = color;
        this.venenosa = venenosa;
        this.tipoVeneno = tipoVeneno;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getEspecie() {
        return especie;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public void setVenenosa(Boolean venenosa) {
        this.venenosa = venenosa;
    }
    public Boolean getVenenosa() {
        return venenosa;
    }
    public void setTipoVeneno(Boolean tipoVeneno) {
        this.tipoVeneno = tipoVeneno;
    }
    public Boolean getTipoVeneno() {
        return tipoVeneno;
    }
}
