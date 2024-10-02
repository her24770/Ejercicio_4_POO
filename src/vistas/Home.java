package vistas;

import clases.*;
import controlador.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Home extends JFrame{
    private JPanel panelHome;
    private JList listAnimales;
    private JButton btnHistorial;
    private JButton btnIntercambiar;
    private JButton btnserpiente;
    private JButton btnAcuatico;
    private JButton btnAgregar;
    private JLabel labelDetallesAnial;

    //variables
    private boolean estado = true;

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
                estado=true;
                serpientesList=serpientesController.listSerpientes();
                DefaultListModel<String> listModel = new DefaultListModel<>();
                for(Serpiente serpiente : serpientesList){
                    listModel.addElement(serpiente.getNombreCientifico());
                }
                listAnimales.setModel(listModel);
            }
        });

        listAnimales.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = listAnimales.getSelectedIndex();
                if (estado){
                    labelDetallesAnial.setText(serpientesList.get(index).toString());
                }else{

                }
            }
        });

        btnAcuatico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estado=false;
                serpientesList=serpientesController.listSerpientes();
                DefaultListModel<String> listModel = new DefaultListModel<>();
                for(Serpiente serpiente : serpientesList){
                    listModel.addElement(serpiente.getNombreCientifico());
                }
                listAnimales.setModel(listModel);
            }
        });

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Agregar");
                FormsSerpiente viewFormSerpiente = new FormsSerpiente();
                viewFormSerpiente.setTitle("Registro Animal");
                viewFormSerpiente.setContentPane(viewFormSerpiente.getPanelSerpiente());
                viewFormSerpiente.setSize(1000,400);
                viewFormSerpiente.setVisible(true);
                viewFormSerpiente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });

    }

}
