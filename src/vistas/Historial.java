package vistas;

import clases.ReptilAcuatico;
import clases.Serpiente;
import controlador.ReptilesAcuaticosController;
import controlador.SerpientesController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Historial extends  JFrame{
    private JList<String> jlistSerpientes;
    private JList<String> jlistAcuaticos;
    private JPanel panelHitorial;

    public JPanel getPanelHitorial() {
        return panelHitorial;
    }

    //controladores
    SerpientesController serpientesController = new SerpientesController();
    ReptilesAcuaticosController reptilesAcuaticosController = new ReptilesAcuaticosController();


    public Historial() {
        List<Serpiente> listSerpientes = serpientesController.historialSerpientes();
        DefaultListModel<String> listModelSerpientes = new DefaultListModel<>();
        for (Serpiente serpiente : listSerpientes) {
            listModelSerpientes.addElement(serpiente.getNombreCientifico());
        }
        jlistSerpientes.setModel(listModelSerpientes);




        List<ReptilAcuatico> listAcuaticos = reptilesAcuaticosController.historialReptilesAcuaticos();
        DefaultListModel<String> listModelAcuaticos = new DefaultListModel<>();
        for (ReptilAcuatico reptilAcuatico : listAcuaticos) {
            listModelAcuaticos.addElement(reptilAcuatico.getNombreCientifico());
        }
        jlistAcuaticos.setModel(listModelAcuaticos);
    }
}
