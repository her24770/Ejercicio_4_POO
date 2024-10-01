package clases;

public class ReptilAcuatico extends Reptil{
    private String especie;
    private Boolean agua;
    private double nado;
    private double buceo;

    //MÉTODOS

    public ReptilAcuatico() {
    }

    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public Boolean getAgua() {
        return agua;
    }
    public void setAgua(Boolean agua) {
        this.agua = agua;
    }
    public double getNado() {
        return nado;
    }
    public void setNado(double nado) {
        this.nado = nado;
    }
    public double getBuceo() {
        return buceo;
    }
    public void setBuceo(double buceo) {
        this.buceo = buceo;
    }


}
