package vistas;

import clases.*;
import controlador.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;
import java.util.List;

public class Home extends JFrame {
    private JPanel panelHome;
    private JList<String> jlistAnimales;
    private JButton btnHistorial;
    private JButton btnIntercambiar;
    private JButton btnAgregar;
    private JLabel labelDetallesAnial;
    private JTextArea textAreaInformacion;
    private JList JListerFilterEspecie;

    // Variables
    private DefaultListModel<String> modelo;

    // Controllers
    SerpientesController serpientesController = new SerpientesController();
    ReptilesAcuaticosController acuaticosController = new ReptilesAcuaticosController();

    // Listas
    List<Animal> animalesList = new ArrayList<>();

    public void setAnimalesList(List<Animal> animalesList) {
        this.animalesList = animalesList;
    }

    public JPanel getPanelHome() {
        return panelHome;
    }

    public Home() {
        addJListAnimales("all");


        JListerFilterEspecie.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(JListerFilterEspecie.getSelectedIndex()==1){
                    addJListAnimales("serpientes");
                }else if (JListerFilterEspecie.getSelectedIndex()==2){
                    addJListAnimales("acuaticos");
                }else{
                    addJListAnimales("all");
                }
            }
        });


        jlistAnimales.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                textAreaInformacion.setText(animalesList.get(jlistAnimales.getSelectedIndex()).toString());

            }
        });

    }

    private void addJListAnimales(String filter) {
        modelo = new DefaultListModel<>();
        animalesList=new ArrayList<>();
        if(filter=="serpientes"){
            animalesList.addAll(serpientesController.listSerpientes());
        }else if (filter=="acuaticos"){
            animalesList.addAll(acuaticosController.listReptilesAcuaticos());
        }else{
            animalesList.addAll(acuaticosController.listReptilesAcuaticos());
            animalesList.addAll(serpientesController.listSerpientes());
        }
        for(Animal animal : animalesList) {
            modelo.addElement(animal.getNombreCientifico());
        }
        jlistAnimales.setModel(modelo);
    }
}
