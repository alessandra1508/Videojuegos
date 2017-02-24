/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegotrump;

/**
 *
 * @author alefr
 */
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author servkey
 */
public class ProoOfConcept2D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CanvasTrump canvas = new CanvasTrump();
        FormJuego fr = new FormJuego(canvas);
        fr.setSize(1000, 650);
       
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
}
