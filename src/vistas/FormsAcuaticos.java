package vistas;

import clases.Animal;
import clases.ReptilAcuatico;
import controlador.ReptilesAcuaticosController;
import controlador.SerpientesController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FormsAcuaticos extends JFrame{
    private JPanel panelAcuatico;
    private JButton btnaddSerpiente;
    private JTextField inputNOmbre;
    private JTextField inputDieta;
    private JTextField inputLongitud;
    private JTextField inputEspecie;
    private JTextField inputAgua;
    private JTextField inputNado;
    private JTextField inputBuceo;
    private JTextField inputDescripcionHabitat;
    private JTextField inputPeso;
    private JTextField inputVidaEzperanza;
    private JTextField inputTemperatura;
    private JTextField inputHuevos;
    private JTextField inputPeligroExt;
    private JTextField inputPresupuesto;

    //controller
    ReptilesAcuaticosController acuaticosController = new ReptilesAcuaticosController();
    SerpientesController serpientesController = new SerpientesController();

    //variables
    private ReptilAcuatico reptilAcuatico = null;

    private double presupuesto;
    private String estadoAcciones = "add";

    public JPanel getPanelAcuatico() {
        return panelAcuatico;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public void setEstadoAcciones(String estadoAcciones) {
        this.estadoAcciones = estadoAcciones;
    }

    public void setReptilAcuatico(ReptilAcuatico reptilAcuatico) {
        this.reptilAcuatico = reptilAcuatico;
    }

    public void setReptilAcuatico2(ReptilAcuatico reptilAcuatico) {
        this.reptilAcuatico = reptilAcuatico;
        if (reptilAcuatico != null) {
            inputNOmbre.setText(reptilAcuatico.getNombreCientifico());
            inputDieta.setText(reptilAcuatico.getDieta());
            inputDescripcionHabitat.setText(reptilAcuatico.getDescripcionHabitat());
            inputVidaEzperanza.setText(Integer.toString(reptilAcuatico.getVidaEsperanza()));
            inputPeso.setText(Double.toString(reptilAcuatico.getPeso()));
            inputTemperatura.setText(Integer.toString(reptilAcuatico.getTemperatura()));
            inputHuevos.setText(Double.toString(reptilAcuatico.getHuevos()));
            inputPeligroExt.setText(convertirBooleanoAString(reptilAcuatico.getPeligroExt()));
            inputLongitud.setText(Double.toString(reptilAcuatico.getLongitud()));
            inputEspecie.setText(reptilAcuatico.getEspecie());
            inputAgua.setText(convertirBooleanoAString(reptilAcuatico.getAgua()));
            inputNado.setText(Double.toString(reptilAcuatico.getNado()));
            inputBuceo.setText(Double.toString(reptilAcuatico.getBuceo()));
        }
    }

    public FormsAcuaticos() {
            btnaddSerpiente.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ReptilAcuatico newAcuatico = new ReptilAcuatico();
                    if ("".equals(inputNOmbre.getText()) || "".equals(inputDieta.getText()) || "".equals(inputDescripcionHabitat.getText()) ||
                            "".equals(inputLongitud.getText()) || "".equals(inputVidaEzperanza.getText()) || "".equals(inputEspecie.getText()) ||
                            "".equals(inputPeso.getText()) || "".equals(inputVidaEzperanza.getText()) || "".equals(inputAgua.getText()) ||
                            "".equals(inputTemperatura.getText()) || "".equals(inputHuevos.getText()) || "".equals(inputNado.getText()) ||
                            "".equals(inputHuevos.getText()) || "".equals(inputPeligroExt.getText()) || "".equals(inputBuceo.getText())
                    ) {
                        JOptionPane.showMessageDialog(null, "No puee enviar espacios vacios");
                    } else {
                        newAcuatico.setNombreCientifico(inputNOmbre.getText());
                        newAcuatico.setDieta(inputDieta.getText());
                        newAcuatico.setDescripcionHabitat(inputDescripcionHabitat.getText());
                        if (esNumeroValido(inputLongitud.getText()) || esNumeroValido(inputVidaEzperanza.getText())
                                || esNumeroValido(inputPeso.getText()) || esNumeroValido(inputTemperatura.getText())
                                || esNumeroValido(inputHuevos.getText()) || esNumeroValido(inputNado.getText())
                                || esNumeroValido(inputBuceo.getText()) || esNumeroValido(inputPresupuesto.getText())) {
                            newAcuatico.setLongitud(Double.parseDouble(inputLongitud.getText()));
                            newAcuatico.setVidaEsperanza(Integer.parseInt(inputVidaEzperanza.getText()));
                            newAcuatico.setPeso(Double.parseDouble(inputPeso.getText()));
                            newAcuatico.setTemperatura(Integer.parseInt(inputTemperatura.getText()));
                            newAcuatico.setHuevos(Double.parseDouble(inputHuevos.getText()));
                            newAcuatico.setBuceo(Double.parseDouble(inputBuceo.getText()));
                            newAcuatico.setNado(Double.parseDouble(inputNado.getText()));
                        } else {
                            JOptionPane.showMessageDialog(null, "Recuerde usar datos numericos en las casillas indicadas");
                        }
                        if (esSyN(inputPeligroExt.getText()) || esSyN(inputAgua.getText())) {
                            newAcuatico.setPeligroExt(esS(inputPeligroExt.getText()));
                            newAcuatico.setPeligroExt(esS(inputAgua.getText()));
                        } else {
                            JOptionPane.showMessageDialog(null, "Recuerde usar 's' o 'n' en casillas indicadas");
                        }
                        if ("t".equals(inputEspecie.getText()) || "c".equals(inputEspecie.getText())) {
                            newAcuatico.setEspecie(inputEspecie.getText());
                        } else {
                            JOptionPane.showMessageDialog(null, "Especie solo puede ser 't' o 'c'");
                        }

                        String message="Costo total (recinto + comida) : [" + newAcuatico.presupuesto()[0] + "-" + newAcuatico.presupuesto()[1] + "] Quetzales";
                        if (estadoAcciones=="add"){
                            Animal animal = newAcuatico;
                            if(presupuesto < animal.presupuestoZoo(addJListAnimales()) + newAcuatico.presupuesto()[0]){
                                //Validacion de presupuesto
                                JOptionPane.showMessageDialog(null,"El presupuesto no es suficiente para mantener la especie");
                            }else{
                                int respuesta = JOptionPane.showConfirmDialog(null, message, "Confirmación", JOptionPane.YES_NO_OPTION);
                                if (respuesta == JOptionPane.YES_OPTION) {
                                    acuaticosController.addReptilAcuatico(newAcuatico);
                                }
                            }

                        }else if(estadoAcciones=="inter"||estadoAcciones=="edit"){
                            Animal animal = newAcuatico;
                            if(presupuesto < animal.presupuestoZoo(addJListAnimales())){
                                JOptionPane.showMessageDialog(null,"El presupuesto no es suficiente para mantener la especie");
                            }else{
                                int respuesta = JOptionPane.showConfirmDialog(null, message, "Confirmación", JOptionPane.YES_NO_OPTION);
                                if (respuesta == JOptionPane.YES_OPTION) {
                                    acuaticosController.intercambio(reptilAcuatico,newAcuatico);
                                }
                            }
                        }
                        dispose();
                    }
                }
            });
    }

    public boolean esNumeroValido (String texto){
        try {
            double numero = Double.parseDouble(texto);
            return numero >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean esSyN (String texto){
        return texto.equalsIgnoreCase("s") || texto.equalsIgnoreCase("n");
    }

    public boolean esS (String texto){
        return texto.equalsIgnoreCase("s");
    }

    public static String convertirBooleanoAString(boolean valor) {
        if (valor) {
            return "s";  // Si es true, retorna "s"
        } else {
            return "n";  // Si es false, retorna "n"
        }
    }

    public List<Animal> addJListAnimales() {
        List<Animal> animalesList = new ArrayList<>();
            animalesList.addAll(serpientesController.listSerpientes());
            animalesList.addAll(acuaticosController.listReptilesAcuaticos());
            return animalesList;

    }
}