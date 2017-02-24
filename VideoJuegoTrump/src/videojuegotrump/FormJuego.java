
package videojuegotrump;

import java.awt.Canvas;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author alefr
 */
public class FormJuego extends JFrame{
    private Thread t;
    private CanvasTrump c;
    
    public FormJuego(CanvasTrump c){       
        this.c = c;
        add(c);
        //Iniciar hilo
        t = new Thread(){
              public void run(){
                  updating();
              }
        };
        t.start();
     
        this.getContentPane().setBackground(Color.WHITE);
    }
    
    public void updating(){
        while (true){
            try {
                c.avanzarFondo();
                Thread.sleep(100);     
                c.repaint();

            } catch (InterruptedException ex) {
                Logger.getLogger(FormJuego.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
    }
}
