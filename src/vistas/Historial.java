package vistas;

import clases.Animal;
import controlador.ReptilesAcuaticosController;
import controlador.SerpientesController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Historial extends  JFrame{
    private JList<String> jListhistorial;
    private JPanel panelHitorial;

    public JPanel getPanelHitorial() {
        return panelHitorial;
    }

    //controladores
    SerpientesController serpientesController = new SerpientesController();
    ReptilesAcuaticosController reptilesAcuaticosController = new ReptilesAcuaticosController();


    public Historial() {
        List<Animal> historialAnimal = new ArrayList<>();
        historialAnimal.addAll(reptilesAcuaticosController.historialReptilesAcuaticos());
        historialAnimal.addAll(serpientesController.historialSerpientes());
        DefaultListModel<String> listmodel = new DefaultListModel<>();
        for (Animal animal : historialAnimal) {
            listmodel.addElement(animal.getNombreCientifico());
        }
        jListhistorial.setModel(listmodel);
    }
}
