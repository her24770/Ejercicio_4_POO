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
                System.out.print("esoo");
                Serpiente serpiente = new Serpiente(nombreCientifico, descripcionHabitat,vidaEsperanza, intercambio, temperatura, huevos, peso, peligroExt, dieta, longitud, especie, color, venenosa, tipoVeneno);
                serpientes.add(serpiente);
                System.out.print(serpiente);

            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return serpientes;
    }

    public void addSerpiente(Serpiente newSerpiente){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("reptilesSerpientesBD", true))){
            //Volver atributos en String
            String nuevaLinea = newSerpiente.getNombreCientifico() + "," +
                                newSerpiente.getDescripcionHabitat() + "," +
                                newSerpiente.getVidaEsperanza() + "," +
                                newSerpiente.getIntercambio() + "," +
                                newSerpiente.getTemperatura() + "," +
                                newSerpiente.getHuevos() + "," +
                                newSerpiente.getPeso() + "," +
                                newSerpiente.getPeligroExt() + "," +
                                newSerpiente.getDieta() + "," +
                                newSerpiente.getLongitud() + "," +
                                newSerpiente.getEspecie() + "," +
                                newSerpiente.getColor() + "," +
                                newSerpiente.getVenenosa() + "," +
                                newSerpiente.getTipoVeneno();
            //Escribir la linea en el csv
            bw.write(nuevaLinea);
            bw.newLine();
        }catch (IOException e){

        }
    }

    public List<Serpiente> historialSerpientes(){
        List<Serpiente> allserpientes = listSerpientes();
        List<Serpiente> intercambiados = listSerpientes();

        for (Serpiente serpiente : allserpientes){
            if (serpiente.getIntercambio() == true){
                intercambiados.add(serpiente);
            }
        }
        return intercambiados;
    }


}
