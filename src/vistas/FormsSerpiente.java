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
                    System.out.println(newSerpiente);
                   serpientesController.addSerpiente(newSerpiente);
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
