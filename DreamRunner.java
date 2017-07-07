
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Dimension2D;
import java.util.*;

import javax.swing.*;

/**
 * 
 */
public class DreamRunner {

    public DreamRunner() {
        window = new JFrame("TokenDreams");
        window.setSize(800, 500);
        window.setMinimumSize(new Dimension(800,500));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        data = new Data(window.getWidth(),window.getHeight());
        display = new Display(data);
        window.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent ce) {
                data.setWindowSize(window.getContentPane().getWidth(),window.getContentPane().getHeight());
                data.reshape();
            }

        });

        //BONUS : Pause and Resume with Space Bar. Increment Tokens with Up key.
        window.addKeyListener(new KeyListener() {
                                  @Override
                                  public void keyTyped(KeyEvent e) {

                                  }

                                  @Override
                                  public void keyPressed(KeyEvent e) {
                                      if(e.getKeyCode() == KeyEvent.VK_SPACE)
                                      {     animationSwitch=!animationSwitch;
                                      }
                                      else if(e.getKeyCode() == KeyEvent.VK_UP)
                                      {
                                          display.incrementTokens();
                                      }
                                  }

                                  @Override
                                  public void keyReleased(KeyEvent e) {

                                  }
                              });
                window.add(display);
        window.setVisible(true);
        animationSwitch = true;
    }

    private JFrame window;
    private Display display;
    private Data data;
    private boolean animationSwitch;

    public static void main(String [] args) {
        DreamRunner dd = new DreamRunner();
        int counter = 0;
        while(true)
        {   if(dd.animationSwitch){
            dd.data.stepAllEntities(counter);
            if(counter==10)
                counter=0;
            dd.display.repaint();
            counter++;
            }
            try{Thread.sleep(50);}
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }

}