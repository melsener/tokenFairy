
import java.awt.*;

public abstract class Token implements AnimationEntity {

    public Token(int count, Vector2D pos,Color color) {
        this.count = count;
        this.position = pos;
        this.color = color;
    }

    protected int count;
    private Color color;
    private Vector2D position;

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public abstract int getCount();

    public void draw(Graphics2D g2d){
        //Draw circle
        Stroke oldStroke = g2d.getStroke();
        g2d.setPaint(color);
        g2d.setStroke(Constant.COURSE_BORDER);
        g2d.drawOval(position.getIntX(),position.getIntY(),Constant.TOKEN_WIDTH,Constant.TOKEN_HEIGHT);
        g2d.setStroke(oldStroke);
        //Draw count
        FontMetrics fm = g2d.getFontMetrics();
        double textWidth = fm.getStringBounds(Integer.toString(count) , g2d).getWidth();
        double textHeight = fm.getStringBounds(Integer.toString(count) , g2d).getHeight();
        g2d.drawString(Integer.toString(count), (int) (position.getIntX() + (Constant.TOKEN_WIDTH-textWidth)/2), (int) (position.getIntY()+(Constant.TOKEN_HEIGHT - textHeight)/2 )+fm.getAscent());
    }

    public void act(int deltaTime,Data data)
    {
    }

}