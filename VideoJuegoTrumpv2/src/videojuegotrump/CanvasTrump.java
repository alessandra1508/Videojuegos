
package videojuegotrump;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author alefr
 */
public class CanvasTrump extends Canvas{

    private int x = 10;
    private int y = 10;
    private int x_personaje = 10;
    private int y_personaje = 350;
    private int cont_per = 1;
    private BufferedImage sample;
    private BufferedImage personaje;
    
    private BufferedImage cargarImagen(String file){
        BufferedImage img = null;
        try{
            URL image = getClass().getResource(file);
            img = ImageIO.read(image);
        }catch(Exception e){
        }
         return img;
    }
    
    @Override
    public void paint(Graphics g)
    {       
         //g.setColor(Color.BLUE);     //Activa el color azul
         //g.fillOval(getX(), getY(), 60, 60); //Dibuja un óvalo
        // System.out.println("Entra");
         if (sample == null) sample = cargarImagen("fondo.png");
         g.drawImage(sample, x, 0, this);
         if (personaje == null) personaje = cargarImagen("trump1.png");
         g.drawImage(personaje, x_personaje, y_personaje, this);         

    }   

    @Override
    public void update(Graphics g)
    {
       // super.update(g);
        paint(g);
    }
    
    public void avanzar(){
        
        if(x_personaje < 550){
            x= x-5;
            x_personaje = x_personaje+10;

            if(cont_per==6) cont_per=1;
            cont_per++;

            personaje = cargarImagen("trump"+cont_per+".png");
        }
        
    }
    
    public void retroceder(){        
        if(x_personaje > 0){
            x= x+5;
            x_personaje = x_personaje-10;

            if(cont_per==6) cont_per=1;
            cont_per++;

            personaje = cargarImagen("trump"+cont_per+".png");
        }
        
    }
    
    
    
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    
}

