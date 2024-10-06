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

public class Home extends JFrame {
    private JPanel panelHome;
    private JList<String> jlistAnimales;
    private JButton btnHistorial;
    private JButton btnIntercambiar;
    private JButton btnAgregar;
    private JLabel labelDetallesAnial;
    private JTextArea textAreaInformacion;
    private JList JListerFilterEspecie;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JButton btnPresupuesto;

    // Variables
    private DefaultListModel<String> modelo;
    private String estadoEspecie="all";
    private String estadoAccion="";
    private double presupuesto =0;
    private Animal selectedAnimal;

    public Animal getSelectedAnimal() {
        return selectedAnimal;
    }

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
                    estadoEspecie="serpientes";

                }else if (JListerFilterEspecie.getSelectedIndex()==2){
                    addJListAnimales("acuaticos");
                    estadoEspecie="acuaticos";
                }else{
                    addJListAnimales("all");
                    estadoEspecie="all";
                }
                jlistAnimales.clearSelection();
            }
        });


        jlistAnimales.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(jlistAnimales.getSelectedIndex()>=0){
                    estadoEspecie=identificarAnimal(animalesList.get(jlistAnimales.getSelectedIndex()));
                    selectedAnimal=animalesList.get(jlistAnimales.getSelectedIndex());
                    textAreaInformacion.setText(animalesList.get(jlistAnimales.getSelectedIndex()).toString());
                }else{
                    textAreaInformacion.setText("");
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


        btnPresupuesto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String datoIngresado = JOptionPane.showInputDialog(null, "Presupuesto anual:", "Quetzalez", JOptionPane.QUESTION_MESSAGE);
                if(!esNumeroValido(datoIngresado)){
                    JOptionPane.showMessageDialog(null, "No es dato numerico", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (datoIngresado != null && !datoIngresado.trim().isEmpty()) {
                    presupuesto = Double.parseDouble(datoIngresado);
                } else {
                    JOptionPane.showMessageDialog(null, "No ingresó ningún dato", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estadoAccion="add";
                if (estadoEspecie=="serpientes"){
                    FormsSerpiente viewFormSerpiente = new FormsSerpiente();
                    viewFormSerpiente.setEstadoAcciones("add");
                    viewFormSerpiente.setTitle("Registro Animal");
                    viewFormSerpiente.setContentPane(viewFormSerpiente.getPanelSerpiente());
                    viewFormSerpiente.setSize(1000,400);
                    viewFormSerpiente.setVisible(true);
                    viewFormSerpiente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    addJListAnimales("all");
                }else if (estadoEspecie=="acuaticos"){
                    FormsAcuaticos vieFromAScuatico = new FormsAcuaticos();
                    vieFromAScuatico.setEstadoAcciones("add");
                    vieFromAScuatico.setTitle("Registro Animal");
                    vieFromAScuatico.setContentPane(vieFromAScuatico.getPanelAcuatico());
                    vieFromAScuatico.setSize(1000,400);
                    vieFromAScuatico.setVisible(true);
                    vieFromAScuatico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    addJListAnimales("all");
                }else {
                    JOptionPane.showMessageDialog(null,"Debe elegir una especie para agregar");
                }
            }
        });



        btnIntercambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estadoAccion="inter";
                if (jlistAnimales.getSelectedIndex()>=0){
                    if (estadoEspecie=="serpientes"){
                        FormsSerpiente viewFormSerpiente = new FormsSerpiente();
                        viewFormSerpiente.setEstadoAcciones(estadoAccion);
                        viewFormSerpiente.setSerpiente((Serpiente) animalesList.get(jlistAnimales.getSelectedIndex()));
                        viewFormSerpiente.setTitle("Registro Animal");
                        viewFormSerpiente.setContentPane(viewFormSerpiente.getPanelSerpiente());
                        viewFormSerpiente.setSize(1000,400);
                        viewFormSerpiente.setVisible(true);
                        viewFormSerpiente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        addJListAnimales("all");
                    }else if (estadoEspecie=="acuaticos"){
                        FormsAcuaticos vieFromAScuatico = new FormsAcuaticos();
                        vieFromAScuatico.setEstadoAcciones(estadoAccion);
                        vieFromAScuatico.setReptilAcuatico((ReptilAcuatico) animalesList.get(jlistAnimales.getSelectedIndex()));
                        vieFromAScuatico.setTitle("Registro Animal");
                        vieFromAScuatico.setContentPane(vieFromAScuatico.getPanelAcuatico());
                        vieFromAScuatico.setSize(1000,400);
                        vieFromAScuatico.setVisible(true);
                        vieFromAScuatico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        addJListAnimales("all");
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"Debe elegir una especie para intercambiar");
                }

            }
        });


        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estadoAccion="edit";
                if (jlistAnimales.getSelectedIndex()>=0){
                    if (estadoEspecie=="serpientes"){
                        Serpiente editeSerpiente = (Serpiente) animalesList.get(jlistAnimales.getSelectedIndex());
                        FormsSerpiente viewFormSerpiente = new FormsSerpiente();
                        viewFormSerpiente.setEstadoAcciones(estadoAccion);
                        viewFormSerpiente.setSerpiente2(editeSerpiente);
                        viewFormSerpiente.setTitle("Registro Animal");
                        viewFormSerpiente.setContentPane(viewFormSerpiente.getPanelSerpiente());
                        viewFormSerpiente.setSize(1000,400);
                        viewFormSerpiente.setVisible(true);
                        viewFormSerpiente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        addJListAnimales("all");
                    }else if (estadoEspecie=="acuaticos"){
                        ReptilAcuatico editeAcuatico = (ReptilAcuatico) animalesList.get(jlistAnimales.getSelectedIndex());
                        FormsAcuaticos vieFromAScuatico = new FormsAcuaticos();
                        vieFromAScuatico.setEstadoAcciones(estadoAccion);
                        vieFromAScuatico.setReptilAcuatico2(editeAcuatico);
                        vieFromAScuatico.setTitle("Registro Animal");
                        vieFromAScuatico.setContentPane(vieFromAScuatico.getPanelAcuatico());
                        vieFromAScuatico.setSize(1000,400);
                        vieFromAScuatico.setVisible(true);
                        vieFromAScuatico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        addJListAnimales("all");
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"Debe elegir una especie para editar");
                }

            }
        });


        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jlistAnimales.getSelectedIndex()>=0){
                    Animal animalSelected =  animalesList.get(jlistAnimales.getSelectedIndex());
                    if (estadoEspecie=="serpientes"){
                        //serpientesController.eliminar((Serpiente) animalSelected);
                    }else if (estadoEspecie=="acuaticos"){
                        addJListAnimales("acuaticos");
                        System.out.println("hol.a");
                        acuaticosController.eliminar((ReptilAcuatico) animalSelected);
                        addJListAnimales("acuaticos");
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"Debe elegir una especie para editar");
                }

            }
        });

    }

    public void addJListAnimales(String filter) {
        modelo = new DefaultListModel<>();
        animalesList=new ArrayList<>();
        if(filter=="serpientes"){
            animalesList.addAll(serpientesController.listSerpientes());
        }else if (filter=="acuaticos"){
            animalesList.addAll(acuaticosController.listReptilesAcuaticos());
            for (Animal animal : animalesList){
                System.out.println(animal.toString());
            }
        }
        for(Animal animal : animalesList) {
            modelo.addElement(animal.getNombreCientifico());
        }
        jlistAnimales.setModel(modelo);
    }

    public boolean esNumeroValido(String texto) {
        try {
            double numero = Double.parseDouble(texto);
            return numero >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String identificarAnimal(Animal animal) {
        if(animal instanceof Serpiente) {
            return "serpientes";
        }else{
            return "acuaticos";
        }
    }

}
