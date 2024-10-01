package vistas;

import clases.*;
import controlador.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Home extends JFrame{
    private JPanel panelHome;
    private JList listAnimales;
    private JButton btnHistorial;
    private JButton btnAgregar;
    private JButton btnserpiente;
    private JButton btnAcuatico;
    private JButton agregarButton;

    //Listas
    List<Serpiente> serpientesList = new ArrayList<>();
    List<ReptilAcuatico> reptilesAcuaticosList = new ArrayList<>();
    //controllers
    SerpientesController serpientesController = new SerpientesController();


    public JPanel getPanelHome() {
        return panelHome;
    }


    public Home() {
        btnserpiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
