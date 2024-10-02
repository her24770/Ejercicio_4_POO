package vistas;

import clases.Serpiente;
import controlador.SerpientesController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    //Controlador
    SerpientesController serpientesController=new SerpientesController();

    public FormsSerpiente(){
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
                    JOptionPane.showMessageDialog(null,"No puee enviar espacios vacios");
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
                   double costoMenor=0;
                   double costoMayor=0;
                   String recinto = "";
                   if (newSerpiente.getLongitud() < 1) {
                       recinto= "Pequeño (1-2 metros cuadrados )";
                       costoMenor=50+(1000*0.05*0.02*newSerpiente.getPeso());
                       costoMayor=50+(1000*0.05*0.05*newSerpiente.getPeso());
                   } else if (newSerpiente.getPeso() >= 1 && newSerpiente.getPeso() <= 2) {
                       recinto= "Mediano (2-4 metros cuadrados)";
                       costoMenor=200+(1000*0.05*0.03*newSerpiente.getPeso());
                       costoMayor=200+(1000*0.05*0.06*newSerpiente.getPeso());
                   } else {
                       recinto= "Grande (4-6 metros cuadrados)";
                       costoMenor=500+(1000*0.05*0.04*newSerpiente.getPeso());
                       costoMayor=500+(1000*0.05*0.08*newSerpiente.getPeso());
                   }

                   String message="Recinto : "+recinto+"   Costo : Q"+costoMenor+" -  Q"+costoMayor;
                   if(Integer.parseInt(inputPresupuesto.getText())<costoMenor){
                       JOptionPane.showMessageDialog(null,"El presupuesto no es suficiente para mantener la especie");
                   }else{
                       int respuesta = JOptionPane.showConfirmDialog(null, message, "Confirmación", JOptionPane.YES_NO_OPTION);
                       if (respuesta == JOptionPane.YES_OPTION) {
                           serpientesController.addSerpiente(newSerpiente);
                       } else if (respuesta == JOptionPane.NO_OPTION) {

                       }
                   }

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

    public boolean esSyN(String texto) {
        return texto.equalsIgnoreCase("s") || texto.equalsIgnoreCase("n");
    }

    public boolean esS(String texto) {
        return texto.equalsIgnoreCase("s");
    }

}
