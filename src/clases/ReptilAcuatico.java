package clases;

public class ReptilAcuatico extends Reptil{
    private String especie;
    private boolean agua;
    private double nado;
    private double buceo;

    //MÉTODOS

    /**
     * Constructor de reptiles acuaticos
     * @param nombreCientifico nombre cientifico de la serpiente
     * @param descripcionHabitat cómo es el habitat de la serpiente
     * @param vidaEsperanza años que vive
     * @param intercambio fue obtenida por intercambio
     * @param temperatura grados Celsius de su temperatura corporal
     * @param huevos promedio de huevos por puesta
     * @param peso peso de la serpiente (kg)
     * @param peligroExt se encuentra en peligro de extincion
     * @param dieta carnivoro, omnivoro, herbivoro
     * @param longitud largo de la serpiente
     * @param especie nombre de la especie
     * @param agua Determina si nada en agua dulce o salada
     * @param nado Indica la velocidad de nado maxima del reptil
     * @param buceo Determina en minutos el tiempo que el teptil puede pasar bajo agua sin respirar
     */

    public ReptilAcuatico(String nombreCientifico, String descripcionHabitat, int vidaEsperanza, boolean intercambio, int temperatura, double huevos, double peso, boolean peligroExt, String dieta, double longitud, String especie, boolean agua, double nado, double buceo) {
        super(nombreCientifico, descripcionHabitat, vidaEsperanza, intercambio, temperatura, huevos, peso, peligroExt, dieta, longitud);
        this.especie = especie;
        this.agua = agua;
        this.nado = nado;
        this.buceo = buceo;
    }

    public ReptilAcuatico(){

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

    public String toString() {
        String recinto = "";
        int costoMantener=0;
        if (especie=="t"){
            if (longitud < 20) {
                recinto= "Pequeño (1-2 metros cuadrados )";
                costoMantener=50;
            } else if (longitud >= 20 && longitud <= 40) {
                recinto= "Mediano (2-4 metros cuadrados)";
                costoMantener=200;
            } else {
                recinto= "Grande (4-6 metros cuadrados)";
                costoMantener=500;
            }
        }else{
            if (longitud < 100) {
                recinto= "Pequeño (1-2 metros cuadrados )";
                costoMantener=50;
            } else if (longitud >= 100 && longitud <= 200) {
                costoMantener=100;
                recinto= "Mediano (2-4 metros cuadrados)";
            } else {
                recinto= "Grande (4-6 metros cuadrados)";
                costoMantener=500;
            }
        }



        return "\nNombre cientifico: " + nombreCientifico +
                "\nHabitat: " + descripcionHabitat +
                "\nEsperanza de vida: " + vidaEsperanza +" años" +
                "\nIntercambio: " + intercambio +
                "\nTemperatura: " + temperatura + "° C" +
                "\nProm. huevos/puesta: " + huevos +
                "\nPeso: " + peso + " kg" +
                "\nEn peligro: " + peligroExt +
                "\nDieta: " + dieta +
                "\nLongitud: " + longitud + " metros" +
                "\nEspecie: " + especie +
                "\nAgua: " + agua +
                "\nVelocidad de Nado: " + nado + " km/h "+
                "\nTiempo de Buceo: " + buceo + "min"+
                "\nRecinto: " + recinto;
    }

}
