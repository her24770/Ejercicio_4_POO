package clases;

public class Serpiente extends Reptil{
    private String especie;
    private String color;
    private boolean venenosa;
    private boolean tipoVeneno;

    //Metodos

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
