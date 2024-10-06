package clases;

public class Serpiente extends Reptil{
    private String especie;
    private String color;
    private boolean venenosa;
    private boolean tipoVeneno;

    //Metodos

    /**
     * Constructor serpientes
     */
    public Serpiente(){

    }
    /**
     * Constructor para serpientes venenosas
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
     * @param color color de la serpiente
     * @param venenosa determina si es venenosa
     * @param tipoVeneno clase de veneno: neutoxico o hemotoxico
     */

    public Serpiente(String nombreCientifico, String descripcionHabitat, int vidaEsperanza, boolean intercambio, int temperatura, double huevos, double peso, boolean peligroExt, String dieta, double longitud, String especie, String color, boolean venenosa, boolean tipoVeneno) {
        super(nombreCientifico, descripcionHabitat, vidaEsperanza, intercambio, temperatura, huevos, peso, peligroExt, dieta, longitud);
        this.especie = especie;
        this.color = color;
        this.venenosa = venenosa;
        this.tipoVeneno = tipoVeneno;
    }

    /**
     Constructor para serpientes no venenosas
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
     * @param color color de la serpiente
     * @param venenosa determina si es venenosa
     */
    public Serpiente(String nombreCientifico, String descripcionHabitat, int vidaEsperanza, boolean intercambio, int temperatura, double huevos, double peso, boolean peligroExt, String dieta, double longitud, String especie, String color, boolean venenosa) {
        super(nombreCientifico, descripcionHabitat, vidaEsperanza, intercambio, temperatura, huevos, peso, peligroExt, dieta, longitud);
        this.especie = especie;
        this.color = color;
        this.venenosa = venenosa;
    }

    /**
     * @param especie especie de serpiente
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * @return especie de serpiente
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * @param color color de la serpiente
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return color de la serpiente
     */
    public String getColor() {
        return color;
    }

    /**
     * @param venenosa es o no es venenosa
     */
    public void setVenenosa(Boolean venenosa) {
        this.venenosa = venenosa;
    }

    /**
     * @return es o no es venenosa
     */
    public Boolean getVenenosa() {
        return venenosa;
    }

    /**
     * @param tipoVeneno true neurotoxico, false hemotoxico
     */
    public void setTipoVeneno(Boolean tipoVeneno) {
        this.tipoVeneno = tipoVeneno;
    }

    /**
     * @return tipo del veneno de la serpiente
     */
    public Boolean getTipoVeneno() {
        return tipoVeneno;
    }

    /**
     * @return informacion de la serpiente
     */
    @Override
    public String toString() {
        int costoRecinto=0;
        double costoAlimentoMenor=0;
        double costoAlimentoMayor=0;
        String recinto = "";
        if (longitud < 1) {
            recinto= "Pequeño (1-2 metros cuadrados )";
            costoRecinto=50;
            costoAlimentoMenor=(1000*0.05*0.02*peso);
            costoAlimentoMayor=(1000*0.05*0.05*peso);
        } else if (longitud >= 1 && longitud <= 2) {
            recinto= "Mediano (2-4 metros cuadrados)";
            costoAlimentoMenor=(1000*0.05*0.03*peso);
            costoAlimentoMayor=(1000*0.05*0.06*peso);
            costoRecinto=200;
        } else {
            recinto= "Grande (4-6 metros cuadrados)";
            costoRecinto=500;
            costoAlimentoMenor=(1000*0.05*0.04*peso);
            costoAlimentoMayor=(1000*0.05*0.08*peso);
        }


        String type = null;
        if (tipoVeneno) {
            type = "\nTipo de veneno: Neurotoxico";
        }
        else{
            type = "\nTipo de veneno: Hemotoxico";
        };

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
                "\nColor: " + color +
                "\nVenenosa: " + venenosa +
                "\nRecinto: " + recinto +
                "\nCosto Recinto: Q" + costoRecinto+
                "\nCosto alimento mensual: Q" + costoAlimentoMenor+"  -  Q"+costoAlimentoMayor+
                type;
    }
    @Override
    public double[] presupuesto(){
        double costoMenor;
        double costoMayor;


            if (longitud < 1) {
                //Recinto Pequeño (1-2 metros cuadrados );
                costoMenor=50+(1000*0.05*0.02*peso*31);
                costoMayor=50+(1000*0.05*0.05*peso*31);
            } else if (longitud >= 1 && longitud <= 2) {
                //Recinto Mediano 2-4 metros
                costoMenor=200+(1000*0.05*0.03*peso*31);
                costoMayor=200+(1000*0.05*0.06*peso*31);
            } else {
                //Recinto Grande 4-6 metros
                costoMenor=500+(1000*0.05*0.04*peso*31);
                costoMayor=500+(1000*0.05*0.08*peso*31);
            }
        return new double[] {costoMenor, costoMayor};
    }
}
