package clases;

public class Reptil extends Animal{
    private int temperatura;
    private  double huevos;
    private  double peso;
    private  int longevidad;
    private  boolean peligroExt;
    private  String dieta;
    private double longitud;

    public Reptil(int temperatura, double huevos, double peso, int longevidad, boolean peligroExt, String dieta){
        this.temperatura = temperatura;
        this.huevos = huevos;
        this.peso = peso;
        this.longevidad = longevidad;
        this.peligroExt = peligroExt;
        this.dieta = dieta;
    }

    public Reptil(){

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

    public void setLongevidad(int longevidad){
        this.longevidad = longevidad;
    }
    public int getLongevidad(){
        return longevidad;
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
