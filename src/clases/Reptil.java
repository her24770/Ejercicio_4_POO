package clases;

public class Reptil extends Animal{
    protected int temperatura;
    protected  double huevos;
    protected  double peso;
    protected  boolean peligroExt;
    protected  String dieta;
    protected double longitud;

    public Reptil(String nombreCientifico, String descripcionHabitat, int vidaEsperanza, boolean intercambio, int temperatura, double huevos, double peso, boolean peligroExt, String dieta, double longitud) {
        super(nombreCientifico, descripcionHabitat, vidaEsperanza, intercambio);
        this.temperatura = temperatura;
        this.huevos = huevos;
        this.peso = peso;
        this.peligroExt = peligroExt;
        this.dieta = dieta;
        this.longitud = longitud;
    }

    public Reptil(){

    }

    public double getLongitud() {
        return longitud;
    }
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public void setTemperatura(int temperatura){
        this.temperatura = temperatura;
    }

    public int getTemperatura(){
        return temperatura;
    }

    public void setHuevos(double huevos){
        this.huevos = huevos;
    }
    public double getHuevos(){
        return huevos;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }
    public double getPeso(){
        return peso;
    }

    public void setPeligroExt(boolean peligroExt){
        this.peligroExt = peligroExt;
    }
    public boolean getPeligroExt(){
        return peligroExt;
    }

    public void setDieta(String dieta){
        this.dieta = dieta;
    }
    public String getDieta(){
        return dieta;
    }

    @Override
    public String toString() {
        return "";
    }
}
