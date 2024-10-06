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

    /**
     * Constructor vacio Reptil Acuatico
     */
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

    /**
     * @return informacion del Reptil Acuatico
     */
    @Override
    public String toString() {
        String recinto = "";
        int costorecinto=0;
        double costoAlimentacionMenor=0;
        double costoAlimentacionMayor=0;
        if (especie=="t"){
            if (longitud < 20) {
                recinto= "Pequeño (1-2 metros cuadrados )";
                costorecinto=50;
                costoAlimentacionMenor=(1000*0.05*0.05*peso);
                costoAlimentacionMayor=(1000*0.05*0.10*peso);
            } else if (longitud >= 20 && longitud <= 40) {
                recinto= "Mediano (2-4 metros cuadrados)";
                costorecinto=200;
                costoAlimentacionMenor=(1000*0.05*0.8*peso);
                costoAlimentacionMayor=(1000*0.05*0.15*peso);
            } else {
                recinto= "Grande (4-6 metros cuadrados)";
                costorecinto=500;
                costoAlimentacionMenor=(1000*0.05*0.10*peso);
                costoAlimentacionMayor=(1000*0.05*0.20*peso);
            }
        }else{
            if (longitud < 100) {
                recinto= "Pequeño (1-2 metros cuadrados )";
                costorecinto=50;
                costoAlimentacionMenor=(1000*0.05*0.05*peso);
                costoAlimentacionMayor=(1000*0.05*0.10*peso);
            } else if (longitud >= 100 && longitud <= 200) {
                costorecinto=100;
                recinto= "Mediano (2-4 metros cuadrados)";
                costoAlimentacionMenor=(1000*0.05*0.8*peso);
                costoAlimentacionMayor=(1000*0.05*0.15*peso);
            } else {
                recinto= "Grande (4-6 metros cuadrados)";
                costoAlimentacionMenor=(1000*0.05*0.10*peso);
                costoAlimentacionMayor=(1000*0.05*0.20*peso);
                costorecinto=500;
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
                "\nRecinto: " + recinto+
                "\nCosto Recinto: " + costorecinto+
                "\nCosto alimentacion: Q" + costoAlimentacionMenor+" -  Q"+costoAlimentacionMayor;
    }

    @Override
    public double[] presupuesto() {
        double costoMenor;
        double costoMayor;

        if (longitud < 40) {
            //Recinto pequeño 1-2 metros cuadrados
            costoMenor = 50 + (0.05*0.05*1000*peso*31);
            costoMayor = 50 + (0.05*0.1*1000*peso*31);
        } else if (longitud >= 40 && longitud <= 100) {
            //Recinto mediano 2-4 metros cuadrados
            costoMenor = 200 + (1000 * 0.05 * 0.8 * peso*31);
            costoMayor = 200 + (1000 * 0.05 * 0.15 * peso *31);
        } else {
            //Recinto grande 4-6 metros cuadrados
            costoMenor = 500 + (1000 * 0.05 * 0.10 * peso*31);
            costoMayor = 500 + (1000 * 0.05 * 0.20 * peso*31);
        }
        return new double[]{costoMenor, costoMayor};
    }
}
