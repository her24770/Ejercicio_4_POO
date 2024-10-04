package controlador;
import clases.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para las funciones de Reptiles Acuaticos
 */
public class ReptilesAcuaticosController {
    /**
     * Recorre el csv y regresa una lista con los objetos guardados
     *
     * @return lista de todos los reptiles acuaticos
     */
    public List<ReptilAcuatico> listReptilesAcuaticos() {
        List<ReptilAcuatico> reptilesAcuaticos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/bd/reptilesAcuaticosBD.csv"))) {
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
                ReptilAcuatico reptilAcuatico = new ReptilAcuatico(nombreCientifico, descripcionHabitat, vidaEsperanza, intercambio, temperatura, huevos, peso, peligroExt, dieta, longitud, especie, agua, nado, buceo);
                reptilesAcuaticos.add(reptilAcuatico);

            }
        } catch (IOException e) {

        }
        return reptilesAcuaticos;
    }

    /**
     * Agrega un nuevo individuo al csv de reptiles acuaticos
     *
     * @param newReptilAcuatico reptil acuatico a agregar
     */
    public void addReptilAcuatico(ReptilAcuatico newReptilAcuatico) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/bd/reptilesAcuaticosBD.csv", true))) {
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
        } catch (IOException e) {

        }
    }

    /**
     * Muestra todos los individuos obtenidos por intercambio
     *
     * @return lista con los animales intercambiados
     */
    public List<ReptilAcuatico> historialReptilesAcuaticos() {
        List<ReptilAcuatico> allreptilesAcuaticos = listReptilesAcuaticos();
        List<ReptilAcuatico> intercambiados = new ArrayList<>();

        for (ReptilAcuatico reptilAcuatico : allreptilesAcuaticos) {
            if (reptilAcuatico.getIntercambio() == true) {
                intercambiados.add(reptilAcuatico);
            }
        }
        return intercambiados;
    }

    /**
     * Agrega un nuevo individuo a cambio de eliminar uno existente
     *
     * @param egreso  serpiente que egresada
     * @param ingreso serpiente ingresada
     * @return mensaje de error en caso de fallar
     */
    public String intercambio(ReptilAcuatico egreso, ReptilAcuatico ingreso) {
        String msg = "";

        List<ReptilAcuatico> allReptilesAcuaticos = listReptilesAcuaticos();
        List<String[]> nuevoCSV = new ArrayList<>();
        for (ReptilAcuatico reptilAcuatico : allReptilesAcuaticos) {
            if (reptilAcuatico.toString().equals(egreso.toString())) {
                int fila = allReptilesAcuaticos.indexOf(reptilAcuatico) + 1;

                allReptilesAcuaticos.set(fila - 1, ingreso);

                System.out.println(allReptilesAcuaticos);

                String nuevaFila =
                        ingreso.getNombreCientifico() + "," +
                                ingreso.getDescripcionHabitat() + "," +
                                Integer.toString(ingreso.getVidaEsperanza()) + "," +
                                Boolean.toString(ingreso.getIntercambio()) + "," +
                                Integer.toString(ingreso.getTemperatura()) + "," +
                                Double.toString(ingreso.getHuevos()) + "," +
                                Double.toString(ingreso.getPeso()) + "," +
                                Boolean.toString(ingreso.getPeligroExt()) + "," +
                                ingreso.getDieta() + "," +
                                Double.toString(ingreso.getLongitud()) + "," +
                                ingreso.getEspecie() + "," +
                                Boolean.toString(ingreso.getAgua()) + "," +
                                Double.toString(ingreso.getNado()) + "," +
                                Double.toString(ingreso.getBuceo());

                List<String[]> rows = new ArrayList<>();
                try (BufferedReader br = new BufferedReader(new FileReader("src/bd/reptilesAcuaticosBD.csv"))) {
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
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/bd/reptilesAcuaticosBD.csv"))) {
                    for (String[] row : rows) {
                        if (rows.indexOf(row) == fila) {
                            bw.write(nuevaFila);
                            bw.newLine();
                        } else {
                            bw.write(String.join(",", row));
                            bw.newLine();
                        }

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                msg = "Este animal no se encuentra dentro de nuestro inventario.";
            }
        }
        return msg;
    }

    public double[] presupuesto(ReptilAcuatico newReptilAcuatico) {
        double costoMenor;
        double costoMayor;

        if (newReptilAcuatico.getLongitud() < 100) {
            //Recinto pequeño 1-2 metros cuadrados
            costoMenor = 0;
            costoMayor = 0;
        } else if (newReptilAcuatico.getLongitud() >= 100 && newReptilAcuatico.getLongitud() <= 200) {
            //Recinto mediano 2-4 metros cuadrados
            costoMenor = 100 + (1000 * 0.05 * 0.8 * newReptilAcuatico.getPeso());
            costoMayor = 100 + (1000 * 0.05 * 0.15 * newReptilAcuatico.getPeso());
        } else {
            //Recinto grande 4-6 metros cuadrados
            costoMenor = 500 + (1000 * 0.05 * 0.10 * newReptilAcuatico.getPeso());
            costoMayor = 500 + (1000 * 0.05 * 0.20 * newReptilAcuatico.getPeso());
        }
        return new double[]{costoMenor, costoMayor};
    }

    public void eliminar(ReptilAcuatico reptilEliminar) {
//
        List<ReptilAcuatico> allReptilesAcuaticos = listReptilesAcuaticos();
        List<String[]> nuevoCSV = new ArrayList<>();
        for (ReptilAcuatico reptilAcuatico : allReptilesAcuaticos) {
            if (reptilAcuatico.toString().equals(reptilEliminar.toString())) {
                int fila = allReptilesAcuaticos.indexOf(reptilAcuatico) + 1;

                allReptilesAcuaticos.remove(fila -1);


                List<String[]> rows = new ArrayList<>();
                try (BufferedReader br = new BufferedReader(new FileReader("src/bd/reptilesAcuaticosBD.csv"))) {
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
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/bd/reptilesAcuaticosBD.csv"))) {
                    for (String[] row : rows) {
                            bw.write(String.join(",", row));
                            bw.newLine();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
//
//
//
//
//
//
//
//
// Lista para almacenar las filas del CSV excepto la del reptil a eliminar
//        List<String[]> rows = new ArrayList<>();
//        boolean esPrimeraLinea = true;
//
//        // Leer el archivo CSV y almacenar solo las filas que no coinciden con el reptil a eliminar
//        try (BufferedReader br = new BufferedReader(new FileReader("src/bd/reptilesAcuaticosBD.csv"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                // Saltar la primera línea que contiene encabezados
//                if (esPrimeraLinea) {
//                    esPrimeraLinea = false;
//                    continue;
//                }
//                String[] data = line.split(",");
//
//
//                // Crear un objeto temporal para verificar la igualdad
//                ReptilAcuatico reptil = new ReptilAcuatico(data[0], data[1], Integer.parseInt(data[2]),
//                        Boolean.parseBoolean(data[3]), Integer.parseInt(data[4]), Double.parseDouble(data[5]),
//                        Double.parseDouble(data[6]), Boolean.parseBoolean(data[7]), data[8],
//                        Double.parseDouble(data[9]), data[10], Boolean.parseBoolean(data[11]),
//                        Double.parseDouble(data[12]), Double.parseDouble(data[13]));
//
//                // Añadir a la lista solo si el objeto no es el que queremos eliminar
//                if (!reptil.equals(reptilEliminar)) {
//                    rows.add(data);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Sobreescribir el archivo CSV con los datos de 'rows' para excluir el reptil eliminado
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/bd/reptilesAcuaticosBD.csv"))) {
//            for (String[] row : rows) {
//                bw.write(String.join(",", row));
//                bw.newLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

}