package clases;

public class Serpiente extends Reptil{
    private String especie;
    private String color;
    private Boolean venenosa;
    private Boolean tipoVeneno;

    //Metodos
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
