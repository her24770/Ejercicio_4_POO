package vistas;

import clases.ReptilAcuatico;
import controlador.ReptilesAcuaticosController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    //controller
    ReptilesAcuaticosController acuaticosController = new ReptilesAcuaticosController();

    public JPanel getPanelAcuatico() {
        return panelAcuatico;
    }

    public FormsAcuaticos(){
        btnaddSerpiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReptilAcuatico newAcuatico = new ReptilAcuatico();
                if ("".equals(inputNOmbre.getText())||"".equals(inputDieta.getText())||"".equals(inputDescripcionHabitat.getText()) ||
                        "".equals(inputLongitud.getText())||"".equals(inputVidaEzperanza.getText())||"".equals(inputEspecie.getText()) ||
                        "".equals(inputPeso.getText())||"".equals(inputVidaEzperanza.getText()) ||"".equals(inputAgua.getText()) ||
                        "".equals(inputTemperatura.getText())||"".equals(inputHuevos.getText())||"".equals(inputNado.getText()) ||
                        "".equals(inputHuevos.getText())||"".equals(inputPeligroExt.getText())||"".equals(inputBuceo.getText())
                ){
                    JOptionPane.showMessageDialog(null,"No puee enviar espacios vacios");
                }else{
                    newAcuatico.setNombreCientifico(inputNOmbre.getText());
                    newAcuatico.setDieta(inputDieta.getText());
                    newAcuatico.setDescripcionHabitat(inputDescripcionHabitat.getText());
                    newAcuatico.setEspecie(inputEspecie.getText());
                    if(esNumeroValido(inputLongitud.getText())||esNumeroValido(inputVidaEzperanza.getText())
                            ||esNumeroValido(inputPeso.getText())||esNumeroValido(inputTemperatura.getText())
                            ||esNumeroValido(inputHuevos.getText())||esNumeroValido(inputNado.getText())
                            ||esNumeroValido(inputBuceo.getText())){
                        newAcuatico.setLongitud(Integer.parseInt(inputLongitud.getText()));
                        newAcuatico.setVidaEsperanza(Integer.parseInt(inputVidaEzperanza.getText()));
                        newAcuatico.setPeso(Integer.parseInt(inputPeso.getText()));
                        newAcuatico.setTemperatura(Integer.parseInt(inputTemperatura.getText()));
                        newAcuatico.setHuevos(Integer.parseInt(inputHuevos.getText()));
                        newAcuatico.setHuevos(Integer.parseInt(inputBuceo.getText()));
                        newAcuatico.setHuevos(Integer.parseInt(inputNado.getText()));
                    }else{
                        JOptionPane.showMessageDialog(null,"Recuerde usar datos numericos en las casillas indicadas");
                    }
                    if (esSyN(inputPeligroExt.getText())||esSyN(inputAgua.getText())){
                        newAcuatico.setPeligroExt(esS(inputPeligroExt.getText()));
                        newAcuatico.setPeligroExt(esS(inputAgua.getText()));
                    }else{
                        JOptionPane.showMessageDialog(null,"Recuerde usar 's' o 'n' en casillas indicadas");
                    }
                    acuaticosController.addReptilAcuatico(newAcuatico);
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
