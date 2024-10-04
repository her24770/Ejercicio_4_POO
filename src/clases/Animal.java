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
     * Recorre los csv y regresa una lista con los objetos guardados
     * @return lista de todas las serpientes
     */
    public List<Animal> list(){
        List<Animal> animales = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/bd/reptilesSerpientesBD.csv"))){
            String linea;
            boolean firstLine = true;

            while ((linea = br.readLine()) != null) {
                // Salta la primera linea del csv
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                //dividir la linea en atributos
                String[] datos = linea.split(",");
                //Definir el atributo correspondiente
                String nombreCientifico = datos[0].trim();
                String descripcionHabitat = datos[1].trim();
                int vidaEsperanza = Integer.parseInt(datos[2].trim());
                boolean intercambio = Boolean.parseBoolean(datos[3].trim());
                int temperatura = Integer.parseInt(datos[4].trim());
                double huevos = Double.parseDouble(datos[5].trim());
                double peso = Double.parseDouble(datos[6].trim());
                boolean peligroExt = Boolean.parseBoolean(datos[7].trim());
                String dieta = datos[8].trim();
                double longitud = Double.parseDouble(datos[9].trim());
                String especie = datos[10].trim();
                String color = datos[11].trim();
                boolean venenosa = Boolean.parseBoolean(datos[12].trim());
                boolean tipoVeneno = Boolean.parseBoolean(datos[13].trim());
                //Crear objeto y guardar en csv
                Serpiente serpiente = new Serpiente(nombreCientifico, descripcionHabitat,vidaEsperanza, intercambio, temperatura, huevos, peso, peligroExt, dieta, longitud, especie, color, venenosa, tipoVeneno);
                serpientes.add(serpiente);

            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return serpientes;
    }
}