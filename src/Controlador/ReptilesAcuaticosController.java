package controlador;
import clases.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReptilesAcuaticosController {

    public List<ReptilAcuatico> listReptilesAcuaticos(){
        List<ReptilAcuatico> reptilesAcuaticos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/bd/reptilesAcuaticosBD.csv"))){
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
                boolean agua = Boolean.parseBoolean(datos[11].trim());
                double nado = Double.parseDouble(datos[12].trim());
                double buceo = Double.parseDouble(datos[13].trim());
                //Crear objeto y guardar en csv
                ReptilAcuatico reptilAcuatico = new ReptilAcuatico(nombreCientifico, descripcionHabitat,vidaEsperanza, intercambio, temperatura, huevos, peso, peligroExt, dieta, longitud, especie, agua, nado, buceo);
                reptilesAcuaticos.add(reptilAcuatico);

            }
        } catch (IOException e) {

        }
        return reptilesAcuaticos;
    }

    public void addReptilAcuatico(ReptilAcuatico newReptilAcuatico){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("reptilesAcuaticosBD", true))){
            //Volver atributos en String
            String nuevaLinea = newReptilAcuatico.getNombreCientifico() + "," +
                    newReptilAcuatico.getDescripcionHabitat() + "," +
                    newReptilAcuatico.getVidaEsperanza() + "," +
                    newReptilAcuatico.getIntercambio() + "," +
                    newReptilAcuatico.getTemperatura() + "," +
                    newReptilAcuatico.getHuevos() + "," +
                    newReptilAcuatico.getPeso() + "," +
                    newReptilAcuatico.getPeligroExt() + "," +
                    newReptilAcuatico.getDieta() + "," +
                    newReptilAcuatico.getLongitud() + "," +
                    newReptilAcuatico.getEspecie() + "," +
                    newReptilAcuatico.getAgua() + "," +
                    newReptilAcuatico.getNado() + "," +
                    newReptilAcuatico.getBuceo();
            //Escribir la linea en el csv
            bw.write(nuevaLinea);
            bw.newLine();
        }catch (IOException e){

        }
    }

    public List<ReptilAcuatico> historialReptilesAcuaticos(){
        List<ReptilAcuatico> allreptilesAcuaticos = listReptilesAcuaticos();
        List<ReptilAcuatico> intercambiados = listReptilesAcuaticos();

        for (ReptilAcuatico reptilAcuatico : allreptilesAcuaticos){
            if (reptilAcuatico.getIntercambio() == true){
                intercambiados.add(reptilAcuatico);
            }
        }
        return intercambiados;
    }

    public void updateReptilAcuatico(ReptilAcuatico updateReptilAcuatico, int filaAEditar){
        // Leer todas las filas del archivo CSV
        List<String[]> rows = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("reptilesAcuaticosBD.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Dividir cada línea por comas
                String[] data = line.split(",");
                rows.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (rows.size() > filaAEditar) {
            // Nueva fila que queremos poner en su lugar
            String[] nuevaFila = {updateReptilAcuatico.getNombreCientifico(),
                    updateReptilAcuatico.getDescripcionHabitat(),
                    Integer.toString(updateReptilAcuatico.getVidaEsperanza()),
                    Boolean.toString(updateReptilAcuatico.getIntercambio()),
                    Integer.toString(updateReptilAcuatico.getTemperatura()),
                    Double.toString(updateReptilAcuatico.getHuevos()),
                    Double.toString(updateReptilAcuatico.getPeso()),
                    Boolean.toString(updateReptilAcuatico.getPeligroExt()),
                    updateReptilAcuatico.getDieta(),
                    Double.toString(updateReptilAcuatico.getLongitud()),
                    updateReptilAcuatico.getEspecie(),
                    Boolean.toString(updateReptilAcuatico.getAgua()),
                    Double.toString(updateReptilAcuatico.getNado()),
                    Double.toString(updateReptilAcuatico.getBuceo()),
            };
            rows.set(filaAEditar, nuevaFila);  // Reemplazar la fila existente con la nueva fila
        }

        // Guardar los cambios escribiendo el archivo CSV de nuevo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("reptilesAcuaticosBD.csv"))) {
            for (String[] row : rows) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void intercambio(){




    }

}
