import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class Display extends JPanel  {


    public Display(Data data) {
        super();
        this.data = data;
        setBackground(Color.WHITE);
        ae = new ArrayList<>();
    }

    private Data data;
    private ArrayList<AnimationEntity> ae;


    public Dimension getPreferredSize() {
        return new Dimension(data.windowWidth,data.windowHeight);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        ae.addAll(data.courses);
        ae.addAll(data.students);
        ae.addAll(data.tokens);
        ae.add(data.fairy);
        for(int i = 0 ; i < ae.size() ; i++)
        {   ae.get(i).draw(g2d);
        }
        ae.clear();
    }

    public void incrementTokens()
    {
        data.tokens.add(data.fairy.createToken(data.randomVectorGenerator(Constant.TOKEN_WIDTH,Constant.TOKEN_HEIGHT)));
    }

}
