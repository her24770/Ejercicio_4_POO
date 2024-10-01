package Controlador;
import clases.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SerpientesController {
    public List<Serpiente> listSerpientes(){
        List<Serpiente> serpientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("reptilesAcuaticosBD.csv"))){
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
                int longevidad = Integer.parseInt(datos[7].trim());
                boolean peligroExt = Boolean.parseBoolean(datos[8].trim());
                String dieta = datos[9].trim();
                double longitud = Double.parseDouble(datos[10].trim());
                String especie = datos[11].trim();
                String color = datos[12].trim();
                boolean venenosa = Boolean.parseBoolean(datos[13].trim());
                boolean tipoVeneno = Boolean.parseBoolean(datos[14].trim());
                //Crear objeto y guardar en csv
                Serpiente serpiente = new Serpiente(nombreCientifico, descripcionHabitat,vidaEsperanza, intercambio, temperatura, huevos, peso, longevidad, peligroExt, dieta, longitud, especie, color, venenosa, tipoVeneno);
                serpientes.add(serpiente);

            }
        } catch (IOException e) {

        }
        return serpientes;
    }
}
