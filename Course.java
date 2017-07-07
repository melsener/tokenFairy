
import java.awt.*;


public class Course implements AnimationEntity {


    public Course(String name, Color color,int minTokens, Vector2D position, int w) {
        this.name=name;
        this.color=color;
        this.minTokens=minTokens;
        this.position=position;
        this.RECTANGLE_WIDTH = w;
    }

    private String name;
    private Color color;
    private int minTokens;

    private Vector2D position;
    private int RECTANGLE_WIDTH;
    private int RECTANGLE_HEIGHT = Constant.COURSE_HEIGHT ;
    private int takenStudentCount = 0;

    public void draw(Graphics2D g2d) {
        //Draw Rectangle
        Font oldFont = g2d.getFont();
        g2d.setFont(Constant.COURSE_FONT);
        Stroke oldStroke = g2d.getStroke();
        g2d.setStroke(Constant.COURSE_BORDER);
        g2d.setPaint(Color.black);
        g2d.drawRect(position.getIntX(),position.getIntY(),RECTANGLE_WIDTH,RECTANGLE_HEIGHT);
        g2d.setStroke(oldStroke);
        g2d.setPaint(color);
        g2d.fillRect(position.getIntX(),position.getIntY(),RECTANGLE_WIDTH,RECTANGLE_HEIGHT);

        //Draw name
        g2d.setPaint(Color.BLACK);
        FontMetrics fm = g2d.getFontMetrics();
        double textWidth = fm.getStringBounds(name,g2d).getWidth();
        g2d.drawString(name, (int) (position.getIntX() + (RECTANGLE_WIDTH - textWidth) / 2),position.getIntY()+ (Constant.COURSE_HEIGHT/2)-5);

        //Draw min tokens
        textWidth = fm.getStringBounds("Min Tokens: " + Integer.toString(minTokens),g2d).getWidth();
        g2d.drawString("Min Tokens: " + Integer.toString( minTokens), (int) (position.getIntX() + (RECTANGLE_WIDTH - textWidth) / 2),position.getIntY()+(Constant.COURSE_HEIGHT/2)+5);

        //Draw taken student count
        textWidth = fm.getStringBounds("Students: " + Integer.toString(takenStudentCount),g2d).getWidth();
        g2d.drawString("Students: " + Integer.toString(takenStudentCount),(int) (position.getIntX() + (RECTANGLE_WIDTH - textWidth) / 2),position.getIntY()+Constant.COURSE_HEIGHT-10);
        g2d.setFont(oldFont);
    }
    public void setWidth(int w) {
        RECTANGLE_WIDTH = w;
    }
    public void setXPosition(double x) {
        position.setX(x);
    }
    public int getRECTANGLE_WIDTH() {
        return RECTANGLE_WIDTH;
    }
    public int getRECTANGLE_HEIGHT() {
        return RECTANGLE_HEIGHT;
    }
    public void incrementTakenStudentCount() {
        takenStudentCount++;
    }
    public Vector2D getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public int getMinTokens() {
        return minTokens;
    }

    public void act(int deltaTime, Data data) {
    }

}