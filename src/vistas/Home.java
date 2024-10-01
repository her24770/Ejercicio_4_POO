package vistas;

import clases.ReptilAcuatico;
import clases.Serpiente;

import javax.swing.*;
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


    public JPanel getPanelHome() {
        return panelHome;
    }


    public Home() {


    }

}
