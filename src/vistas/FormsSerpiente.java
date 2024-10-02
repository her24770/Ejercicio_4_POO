package vistas;

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
    private JTextField inputOlor;
    private JTextField inputVenenosa;
    private JTextField inputTipoVeneno;
    private JTextField inputPeso;
    private JTextField inputDescripcionHabitat;
    private JTextField inputIntercambio;
    private JTextField inputVidaEzperanza;
    private JTextField inputTemperatura;
    private JTextField inputHuevos;
    private JTextField inputPeligroExt;

    public JPanel getPanelSerpiente() {
        return panelSerpiente;
    }

    public FormsSerpiente(){
        btnaddSerpiente.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.out.println("HOLA");
           }
        });
    }
}
