package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Animal {
    protected String nombreCientifico;
    protected String descripcionHabitat;
    protected int vidaEsperanza;
    protected boolean intercambio;


    /**
     * Constructor personalizado para cualquier animal
     * @param nombreCientifico nombre cientifico de la serpiente
     * @param descripcionHabitat cómo es el habitat de la serpiente
     * @param vidaEsperanza años que vive
     * @param intercambio fue obtenida por intercambio
     */
    public Animal(String nombreCientifico, String descripcionHabitat, int vidaEsperanza, boolean intercambio) {
        this.nombreCientifico = nombreCientifico;
        this.descripcionHabitat = descripcionHabitat;
        this.vidaEsperanza = vidaEsperanza;
        this.intercambio = intercambio;
    }

    /**
     * Constructor vacio Animal
     */
    public Animal(){
    }

    /**
     * @param intercambio define si el animal fue intercambiado o no
     */
    public void setIntercambio(boolean intercambio){
        this.intercambio = intercambio;
    }

    /**
     * @return define si el animal fue intercambiado o no
     */
    public boolean getIntercambio(){
        return intercambio;
    }

    /**
     * @param nombreCientifico El nombre cientifico del animal
     */
    public void setNombreCientifico(String nombreCientifico){
        this.nombreCientifico = nombreCientifico;
    }

    /**
     * @return El nombre cientifico del animal
     */
    public String getNombreCientifico(){
        return nombreCientifico;
    }

    /**
     * @param descripcionHabitat Describe el tipo de habitat en el que vive
     */
    public void setDescripcionHabitat(String descripcionHabitat){
        this.descripcionHabitat = descripcionHabitat;
    }

    /**
     * @return Describe el tipo de habitat en el que vive
     */
    public String getDescripcionHabitat(){
        return descripcionHabitat;
    }

    /**
     * @param vidaEsperanza La esperanza de Vida del animal
     */
    public void setVidaEsperanza(int vidaEsperanza){
        this.vidaEsperanza = vidaEsperanza;
    }

    /**
     * @return La esperanza de Vida del animal
     */
    public int getVidaEsperanza(){
        return vidaEsperanza;
    }

    /**
     * @return informacion del animal
     */
    public String toString() {
        return "\nNombre Cientifico: " + nombreCientifico +
                "\nDescripcion del Habitat: " + descripcionHabitat +
                "\nEsperanza de Vida: " + vidaEsperanza +
                "\nIntercambio: " + intercambio;
    }

    /**
     *
     * @param newAnimal animal al que se le realizara el presupuesto
     * @return
     */
    public double[] presupuesto(Animal newAnimal){
        double costoMenor;
        double costoMayor;


        //Recinto pequeño
        costoMenor=0;
        costoMayor=0;

        //recinto mediano
        costoMenor=1;
        costoMayor=1;

        //Recinto grande
        costoMenor=2;
        costoMayor=2;

        return new double[]{costoMenor,costoMayor};
    }

    public double presupuestoZoo(List<Animal> animales){
        double minBudget = 0;

        for (Animal animal : animales){
            minBudget += (animal.presupuesto(animal)[0] * 12);
        }
        return minBudget;
    }
}