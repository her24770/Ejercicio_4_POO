import vistas.Home;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Home viewHome = new Home();
        viewHome.setTitle("Registro Animal");
        viewHome.setContentPane(viewHome.getPanelHome());
        viewHome.setSize(1000,400);
        viewHome.setVisible(true);
        viewHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}