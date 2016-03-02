
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;



/**
 *
 * @author xp
 */
public class Sprite {
    
    public Image imagen;
    
    public Sprite (){
        try{
            imagen = ImageIO.read(getClass().getResource("/black-white.png"));
        }
        catch(IOException ex){}
    }
    
    public Image obtenElPokemonQueEstaEnLaFilaYColumna(int fila, int columna){
        BufferedImage buffer = new BufferedImage(96,96,BufferedImage.TYPE_INT_ARGB);
        Image miniImagen = (Image)buffer;
        Graphics2D aux = null;
        aux = (Graphics2D) miniImagen.getGraphics();
        fila--;
        columna--;
        aux.drawImage(imagen,        //la imagen con todos los sprites
         0,                   //posición X en el miniImagen
         0,                   //posición Y en el miniImagen
         96,                  //ancho en el miniImagen
         96,                  //alto en el miniImagen
         96*columna ,                //posición inicial x dentro del sprite
         96*fila ,             //posición inicial y dentro del sprite
         96*columna + 96,              //ancho en el sprite  
         96*fila + 96,               //alto en el sprite
         null);
        return(miniImagen);
    }
    
}
