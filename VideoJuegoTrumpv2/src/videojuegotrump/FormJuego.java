
package videojuegotrump;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


/**
 *
 * @author alefr
 */
public class FormJuego extends JFrame implements KeyListener{
    private Thread t;
    private CanvasTrump c;
    
    public FormJuego(CanvasTrump c){       
        this.c = c;
        this.addKeyListener(this); 
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
            /*
            try {
                c.avanzarFondo();
                Thread.sleep(100);     
                c.repaint();

            } catch (InterruptedException ex) {
                Logger.getLogger(FormJuego.class.getName()).log(Level.SEVERE, null, ex);
            }       
            */
            
            try {
                    FileInputStream fis;
                    Player player;
                    fis = new FileInputStream("C:\\Users\\alefr\\Music\\musica_juego.mp3");
                    BufferedInputStream bis = new BufferedInputStream(fis);

                    player = new Player(bis); // Llamada a constructor de la clase Player
                    player.play();          // Llamada al método play
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        
       if(e.getKeyCode()==39){
           try {
                c.avanzar();
                Thread.sleep(100);     
                c.repaint();

            } catch (InterruptedException ex) {
                Logger.getLogger(FormJuego.class.getName()).log(Level.SEVERE, null, ex);
            }    
       }
       if(e.getKeyCode()==37){
           try {
                c.retroceder();
                Thread.sleep(100);     
                c.repaint();

            } catch (InterruptedException ex) {
                Logger.getLogger(FormJuego.class.getName()).log(Level.SEVERE, null, ex);
            }    
       }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
