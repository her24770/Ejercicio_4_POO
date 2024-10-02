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
//        controlador.SerpientesController serpienteC = new controlador.SerpientesController();
//        List<Serpiente> serpientes = serpienteC.listSerpientes();
//        List<Serpiente> historialS = serpienteC.historialSerpientes();
//
//        System.out.println("popo");
//        for (Serpiente serpiente : historialS){
//            System.out.print(serpiente.toString());
//        }



        //PRUEBA PARA METODOS DE REPTILES ACUATICOS

        ReptilesAcuaticosController reptilAcuaticoC = new ReptilesAcuaticosController();
        ReptilAcuatico newReptilAcuatico = new ReptilAcuatico("Skibidi Pomni", "Acuatico", 34, false, 78, 3, 34, true, "caca seca", 34, "Toilet", false, 45, 98);
        reptilAcuaticoC.addReptilAcuatico(newReptilAcuatico);

        List<ReptilAcuatico> reptilesAcuaticos = reptilAcuaticoC.listReptilesAcuaticos();
        List<ReptilAcuatico> historialA = reptilAcuaticoC.historialReptilesAcuaticos();

        System.out.println("ICKKCK");
        for (ReptilAcuatico reptilAcuatico : historialA){
            System.out.print(reptilAcuatico.toString());
        }

    }

}