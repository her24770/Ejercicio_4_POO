package clases;

/**
 * Guarda los datos de los animales de tipo Reptil
 */
public class Reptil extends Animal{
    protected int temperatura;
    protected  double huevos;
    protected  double peso;
    protected  boolean peligroExt;
    protected  String dieta;
    protected double longitud;

    /**
     * Constructor personalizado
     * @param nombreCientifico nombre cientifico del reptil
     * @param descripcionHabitat donde vive el reptil
     * @param vidaEsperanza años que vive
     * @param intercambio fue obtenido por intercambio
     * @param temperatura temp. corporal en celsius
     * @param huevos prom. huevos/puesta
     * @param peso peso en kg
     * @param peligroExt se encuentra en peligro de extincion
     * @param dieta carnivoro, omnivoro, herbivor
     * @param longitud medida de largo
     */
    public Reptil(String nombreCientifico, String descripcionHabitat, int vidaEsperanza, boolean intercambio, int temperatura, double huevos, double peso, boolean peligroExt, String dieta, double longitud) {
        super(nombreCientifico, descripcionHabitat, vidaEsperanza, intercambio);
        this.temperatura = temperatura;
        this.huevos = huevos;
        this.peso = peso;
        this.peligroExt = peligroExt;
        this.dieta = dieta;
        this.longitud = longitud;
    }

    /**
     * Constructor vacío
     */
    public Reptil(){

    }

    /**
     * @return largo del reptil en metros
     */
    public double getLongitud() {
        return longitud;
    }

    /**
     *
     * @param longitud largo del reptil en metros
     */
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    /**
     *
     * @param temperatura corporal en grados celsius
     */
    public void setTemperatura(int temperatura){
        this.temperatura = temperatura;
    }

    /**
     *
     * @return temp. corporal en C
     */
    public int getTemperatura(){
        return temperatura;
    }

    /**
     *
     * @param huevos prom. huevos/puesta
     */
    public void setHuevos(double huevos){
        this.huevos = huevos;
    }

    /**
     *
     * @return prom. huevos/puesta
     */
    public double getHuevos(){
        return huevos;
    }

    /**
     *
     * @param peso peso en kg
     */
    public void setPeso(double peso){
        this.peso = peso;
    }

    /**
     *
     * @return peso en kg
     */
    public double getPeso(){
        return peso;
    }

    /**
     *
     * @param peligroExt se encuentra en peligro de extincion
     */
    public void setPeligroExt(boolean peligroExt){
        this.peligroExt = peligroExt;
    }

    /**
     *
     * @return si se encuentra en peligro de extincion
     */
    public boolean getPeligroExt(){
        return peligroExt;
    }

    /**
     *
     * @param dieta tipo de alimentacion
     */
    public void setDieta(String dieta){
        this.dieta = dieta;
    }

    /**
     *
     * @return tipo de alimentacion
     */
    public String getDieta(){
        return dieta;
    }

    /**
     *
     * @return estado del objeto
     */
    @Override
    public String toString() {
        return "\nNombre cientifico: " + nombreCientifico +
                "\nHabitat: " + descripcionHabitat +
                "\nEsperanza de vida: " + vidaEsperanza +" años" +
                "\nIntercambio: " + intercambio +
                "\nTemperatura: " + temperatura + "° C" +
                "\nProm. huevos/puesta: " + huevos +
                "\nPeso: " + peso + " kg" +
                "\nEn peligro: " + peligroExt +
                "\nDieta: " + dieta +
                "\nLongitud: " + longitud + " metros";
    }
}
