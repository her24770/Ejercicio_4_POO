package vistas;

import clases.Animal;
import clases.Serpiente;
import controlador.ReptilesAcuaticosController;
import controlador.SerpientesController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FormsSerpiente extends JFrame{
    private JPanel panelSerpiente;
    private JButton btnaddSerpiente;
    private JTextField inputNOmbre;
    private JTextField inputDieta;
    private JTextField inputLongitud;
    private JTextField inputEspecie;
    private JTextField inputCOlor;
    private JTextField inputVenenosa;
    private JTextField inputTipoVeneno;
    private JTextField inputDescripcionHabitat;
    private JTextField inputPeso;
    private JTextField inputVidaEzperanza;
    private JTextField inputTemperatura;
    private JTextField inputHuevos;
    private JTextField inputPeligroExt;
    private JTextField inputPresupuesto;

    public JPanel getPanelSerpiente() {
        return panelSerpiente;
    }

    //variables
    private Serpiente serpiente = null;
    private String estadoAcciones="add";

    public void setEstadoAcciones(String estadoAcciones) {
        this.estadoAcciones = estadoAcciones;
    }

    public void setSerpiente(Serpiente serpiente) {
        this.serpiente = serpiente;
    }

    //Controlador
    SerpientesController serpientesController=new SerpientesController();
    Home viewHome=new Home();

    public FormsSerpiente(){
        serpiente=(Serpiente) viewHome.getSelectedAnimal();
        System.out.println(serpiente);
        llenarinputs(serpiente);


        btnaddSerpiente.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Serpiente newSerpiente = new Serpiente();

               if ("".equals(inputNOmbre.getText())||"".equals(inputDieta.getText())||"".equals(inputDescripcionHabitat.getText()) ||
                    "".equals(inputLongitud.getText())||"".equals(inputVidaEzperanza.getText())||"".equals(inputEspecie.getText()) ||
                       "".equals(inputCOlor.getText())||"".equals(inputPeso.getText())||"".equals(inputVidaEzperanza.getText()) ||
                       "".equals(inputTemperatura.getText())||"".equals(inputVenenosa.getText())||"".equals(inputHuevos.getText())||
                       "".equals(inputHuevos.getText())||"".equals(inputPeligroExt.getText())
               ){
                    JOptionPane.showMessageDialog(null,"No puede enviar espacios vacios");
               }else{
                   newSerpiente.setNombreCientifico(inputNOmbre.getText());
                   newSerpiente.setDieta(inputDieta.getText());
                   newSerpiente.setDescripcionHabitat(inputDescripcionHabitat.getText());
                   newSerpiente.setEspecie(inputEspecie.getText());
                   newSerpiente.setColor(inputCOlor.getText());
                   if(esNumeroValido(inputLongitud.getText())||esNumeroValido(inputVidaEzperanza.getText())
                           ||esNumeroValido(inputPeso.getText())||esNumeroValido(inputTemperatura.getText())
                           ||esNumeroValido(inputHuevos.getText())){
                       newSerpiente.setLongitud(Integer.parseInt(inputLongitud.getText()));
                       newSerpiente.setVidaEsperanza(Integer.parseInt(inputVidaEzperanza.getText()));
                       newSerpiente.setPeso(Integer.parseInt(inputPeso.getText()));
                       newSerpiente.setTemperatura(Integer.parseInt(inputTemperatura.getText()));
                       newSerpiente.setHuevos(Integer.parseInt(inputHuevos.getText()));
                   }else{
                       JOptionPane.showMessageDialog(null,"Recuerde usar datos numericos en las casillas indicadas");
                   }
                   if (esSyN(inputVenenosa.getText())||esSyN(inputPeligroExt.getText())||esSyN(inputTipoVeneno.getText())){
                       newSerpiente.setVenenosa(esS(inputVenenosa.getText()));
                       newSerpiente.setTipoVeneno(esS(inputTipoVeneno.getText()));
                       newSerpiente.setPeligroExt(esS(inputPeligroExt.getText()));
                   }else{
                       JOptionPane.showMessageDialog(null,"Recuerde usar 's' o 'n' en casillas indicadas");
                   }
                   String message="Costo total (recinto + comida) : [" + serpientesController.presupuesto(newSerpiente)[0] + "-" + serpientesController.presupuesto(newSerpiente)[1] + "] Quetzales";
                   //
                   if (estadoAcciones=="add"){
                       if(1==2){
                           //Validacion de presupuesto
                           JOptionPane.showMessageDialog(null,"El presupuesto no es suficiente para mantener la especie");
                       }else{
                           int respuesta = JOptionPane.showConfirmDialog(null, message, "Confirmación", JOptionPane.YES_NO_OPTION);
                           if (respuesta == JOptionPane.YES_OPTION) {
                               serpientesController.addSerpiente(newSerpiente);
                           }
                       }
                   }else if(estadoAcciones=="inter"||estadoAcciones=="edit"){
                       System.out.println(estadoAcciones);
                       if(1==2){
                           JOptionPane.showMessageDialog(null,"El presupuesto no es suficiente para mantener la especie");
                       }else{
                           int respuesta = JOptionPane.showConfirmDialog(null, message, "Confirmación", JOptionPane.YES_NO_OPTION);
                           if (respuesta == JOptionPane.YES_OPTION) {
                               serpientesController.intercambio(serpiente,newSerpiente);
                           }
                       }
                   }
                   dispose();

                   //

               }
           }
        });
    }

    public boolean esNumeroValido(String texto) {
        try {
            double numero = Double.parseDouble(texto);
            return numero >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public double presupuestoActual() {
        SerpientesController serpientesController = new SerpientesController();
        ReptilesAcuaticosController acuaticosController = new ReptilesAcuaticosController();
        List<Animal> animales = new ArrayList<>();
        animales.addAll(serpientesController.listSerpientes());
        animales.addAll(acuaticosController.listReptilesAcuaticos());
        double presupuesto = 0;

        return presupuesto;
    }

    public boolean esSyN(String texto) {
        return texto.equalsIgnoreCase("s") || texto.equalsIgnoreCase("n");
    }

    public boolean esS(String texto) {
        return texto.equalsIgnoreCase("s");
    }

    public static String convertirBooleanoAString(boolean valor) {
        if (valor) {
            return "s";  // Si es true, retorna "s"
        } else {
            return "n";  // Si es false, retorna "n"
        }
    }

    public void llenarinputs(Serpiente serpienteiew){
        inputNOmbre.setText(serpienteiew.getNombreCientifico());
        inputDieta.setText(serpienteiew.getDieta());
        inputDescripcionHabitat.setText(serpienteiew.getDescripcionHabitat());
        inputVidaEzperanza.setText(Integer.toString(serpienteiew.getVidaEsperanza()));
        inputPeso.setText(Double.toString(serpienteiew.getPeso()));
        inputTemperatura.setText(Integer.toString(serpienteiew.getTemperatura()));
        inputHuevos.setText(Double.toString(serpienteiew.getHuevos()));
        inputPeligroExt.setText(convertirBooleanoAString(serpienteiew.getPeligroExt()));
        inputLongitud.setText(Double.toString(serpienteiew.getLongitud()));
        inputEspecie.setText(serpienteiew.getEspecie());
        inputCOlor.setText(serpienteiew.getColor());
        inputTipoVeneno.setText(convertirBooleanoAString(serpienteiew.getTipoVeneno()));
        inputVenenosa.setText(convertirBooleanoAString(serpienteiew.getVenenosa()));
    }



}
