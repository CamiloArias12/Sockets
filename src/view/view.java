package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class view extends JFrame {

    JPanel componentes = new JPanel();
    public view (){
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        panelComponentes();
    }
    public void panelComponentes(){
        componentes.setBounds(0, 0, 500, 500);
        componentes.setBackground(Color.BLUE);
        add(componentes);
    }

    
}
