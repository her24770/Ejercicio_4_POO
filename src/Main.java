import controlador.*;
import clases.*;
import vistas.Home;

import javax.swing.*;
import java.util.List;

/**
 * Programa taxonomico para intercambio de animales e ingreso de los individuos existentes al zoologico La Aurora
 * @author Gabriel hidalgo 24939, Josue hernandez 24770, Juan Ordoñez 24979
 * Fecha de inicio: 27-09-2024
 * Ultima edicion: 01-10-2024
 */
public class Main {
    //Levantamiento de vista
    public static void main(String[] args) {
        Home viewHome = new Home();
        viewHome.setTitle("Registro Animal");
        viewHome.setContentPane(viewHome.getPanelHome());
        viewHome.setSize(1000,400);
        viewHome.setVisible(true);
        viewHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}