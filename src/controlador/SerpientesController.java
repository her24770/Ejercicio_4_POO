package controlador;
import clases.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para funciones de la clase Serpiente
 */
public class SerpientesController {

    /**
     * Recorre el csv y regresa una lista con los objetos guardados
     * @return lista de todas las serpientes
     */
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
                Serpiente serpiente = new Serpiente(nombreCientifico, descripcionHabitat,vidaEsperanza, intercambio, temperatura, huevos, peso, peligroExt, dieta, longitud, especie, color, venenosa, tipoVeneno);
                serpientes.add(serpiente);

            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return serpientes;
    }

    /**
     * Agrega un nuevo individuo al csv de serppientes
     * @param newSerpiente serpiente a agregar
     */
    public void addSerpiente(Serpiente newSerpiente){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/bd/reptilesSerpientesBD.csv", true))){
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

    /**
     * Muestra todos los individuos obtenidos por intercambio
     * @return lista con los animales intercambiados
     */
    public List<Serpiente> historialSerpientes(){
        List<Serpiente> allserpientes = listSerpientes();
        List<Serpiente> intercambiados = new ArrayList<>();

        for (Serpiente serpiente : allserpientes){
            if (serpiente.getIntercambio()){
                intercambiados.add(serpiente);
            }
        }
        return intercambiados;
    }

    /**
     * Agrega un nuevo individuo a cambio de eliminar uno existente
     * @param egreso serpiente que egresada
     * @param ingreso serpiente ingresada
     * @return mensaje de error en caso de fallar
     */
    public String intercambio(Serpiente egreso, Serpiente ingreso){
        String msg = "";

        List<Serpiente> allSerpientes = listSerpientes();

        List<String[]> nuevoCSV = new ArrayList<>();

        for(Serpiente serpiente: allSerpientes){
            if(serpiente.toString().equals(egreso.toString())){
                int fila = allSerpientes.indexOf(serpiente)+1;

                allSerpientes.set(fila-1, ingreso);

                System.out.println(allSerpientes);

                String nuevaFila =
                        ingreso.getNombreCientifico()+","+
                                ingreso.getDescripcionHabitat()+","+
                                Integer.toString(ingreso.getVidaEsperanza())+","+
                                Boolean.toString(ingreso.getIntercambio())+","+
                                Integer.toString(ingreso.getTemperatura())+","+
                                Double.toString(ingreso.getHuevos())+","+
                                Double.toString(ingreso.getPeso())+","+
                                Boolean.toString(ingreso.getPeligroExt())+","+
                                ingreso.getDieta()+","+
                                Double.toString(ingreso.getLongitud())+","+
                                ingreso.getEspecie()+","+
                                ingreso.getColor() + ","+
                                Boolean.toString(ingreso.getVenenosa())+","+
                                Boolean.toString(ingreso.getTipoVeneno())
                        ;

                List<String[]> rows = new ArrayList<>();
                try (BufferedReader br = new BufferedReader(new FileReader("src/bd/reptilesSerpientesBD.csv"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        // Dividir cada línea por comas
                        String[] data = line.split(",");
                        rows.add(data);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Guardar los cambios escribiendo el archivo CSV de nuevo
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/bd/reptilesSerpientesBD.csv"))) {
                    for (String[] row : rows) {
                        if(rows.indexOf(row) == fila){
                            bw.write(nuevaFila);
                            bw.newLine();
                        }
                        else{
                            bw.write(String.join(",", row));
                            bw.newLine();
                        }

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            else{
                msg = "Este animal no se encuentra dentro de nuestro inventario.";
            }
        }
        return msg;
    }

}
