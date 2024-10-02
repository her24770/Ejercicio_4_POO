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
    private JTextArea textAreaInformacion;

    //variables
    private boolean estado = true;
    DefaultListModel<String> listModel = new DefaultListModel<>();
    int indexListAnimales = listAnimales.getSelectedIndex();

    //Listas
    List<Serpiente> serpientesList = new ArrayList<>();
    List<ReptilAcuatico> acuaticosList = new ArrayList<>();
    //controllers
    SerpientesController serpientesController = new SerpientesController();
    ReptilesAcuaticosController acuaticosController = new ReptilesAcuaticosController();

    public JPanel getPanelHome() {
        return panelHome;
    }


    public Home() {
        btnserpiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estado=true;
                indexListAnimales=-1;
                serpientesList=serpientesController.listSerpientes();
                listModel.clear();
                for(Serpiente serpiente : serpientesList){
                    listModel.addElement(serpiente.getNombreCientifico());
                }
                listAnimales.setModel(listModel);
            }
        });

        listAnimales.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                indexListAnimales=listAnimales.getSelectedIndex();
                if (indexListAnimales!=-1){
                    if (estado){
                        textAreaInformacion.setText(serpientesList.get(indexListAnimales).toString());
                    }else{
                        textAreaInformacion.setText(acuaticosList.get(indexListAnimales).toString());
                    }
                }
            }
        });

        btnAcuatico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estado=false;
                indexListAnimales=-1;
                listModel.clear();
                acuaticosList=acuaticosController.listReptilesAcuaticos();
                for(ReptilAcuatico retiilAcuatico : acuaticosList){
                    listModel.addElement(retiilAcuatico.getNombreCientifico());
                }
                listAnimales.setModel(listModel);
            }
        });

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (estado){
                    FormsSerpiente viewFormSerpiente = new FormsSerpiente();
                    viewFormSerpiente.setTitle("Registro Animal");
                    viewFormSerpiente.setContentPane(viewFormSerpiente.getPanelSerpiente());
                    viewFormSerpiente.setSize(1000,400);
                    viewFormSerpiente.setVisible(true);
                    viewFormSerpiente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }else{
                    FormsAcuaticos vieFromAScuatico = new FormsAcuaticos();
                    vieFromAScuatico.setTitle("Registro Animal");
                    vieFromAScuatico.setContentPane(vieFromAScuatico.getPanelAcuatico());
                    vieFromAScuatico.setSize(1000,400);
                    vieFromAScuatico.setVisible(true);
                    vieFromAScuatico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            }
        });

        btnHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Historial viewHistorial = new Historial();
                viewHistorial.setTitle("Registro Animal");
                viewHistorial.setContentPane(viewHistorial.getPanelHitorial());
                viewHistorial.setSize(500,400);
                viewHistorial.setVisible(true);
                viewHistorial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });


    }

}
