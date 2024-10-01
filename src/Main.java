import controlador.*;
import clases.*;
import vistas.Home;

import javax.swing.*;
import java.util.List;


public class Main {
    public static void main(String[] args) {
       Home viewHome = new Home();
        viewHome.setTitle("Registro Animal");
        viewHome.setContentPane(viewHome.getPanelHome());
        viewHome.setSize(1000,400);
        viewHome.setVisible(true);
        viewHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //PRUEBA PARA METODOS DE SERPIENTES
        SerpientesController serpienteC = new SerpientesController();
        List<Serpiente> serpientes = serpienteC.listSerpientes();
        List<Serpiente> historialS = serpienteC.historialSerpientes();

        System.out.println("popo");
        for (Serpiente serpiente : historialS){
            System.out.print(serpiente.toString());
        }

    }

}