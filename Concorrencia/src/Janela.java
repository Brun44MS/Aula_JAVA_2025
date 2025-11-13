import java.awt.Color;
import static java.awt.Color.HSBtoRGB;
import java.awt.Graphics;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

/**
 * Classe criada 
 * @author Bruno Ferreira
 * @since Classe criada em 13/11/2025
 */
public class Janela extends Thread {
    
    JFrame frame = new JFrame();
    JTextField texto = new JTextField();
    int sleeptime;
    
    JPanel painel = new JPanel() {
            Image bg = new ImageIcon(getClass().getResource("/baixados.gif")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }
        };
    
    public Janela(){
        int x = (int)(Math.random() * 1520);
        int y = (int)(Math.random() * 680);
        float r,g,b;
        texto.setText("Bruno");
        
        //painel.add(texto);
        r =(float)(Math.random()*10);
        g =(float)(Math.random()*10);
        b =(float)(Math.random()*10000);
        //painel.setBackground(new Color(Color.HSBtoRGB(r,g,b)));
        //painel.setBackground(new Color(Color.HSBtoRGB((float)Math.random(),(float)Math.random()*100, (float)Math.random()*100)));
        //painel.setBackground(Color.getHSBColor((float)(Math.random()),(float)(Math.random()), (float)(Math.random())));
        sleeptime = (int) (Math.random() * 5000);
        frame.setSize(500, 500);
        frame.add(painel);
        frame.setLocation(x, y);
        frame.setVisible(true);
    }
    public void run(){
        try {
            Thread.sleep(sleeptime);
            //frame.dispose();
        } catch (InterruptedException ex) {
            Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
