
import java.awt.*;

public class Black extends Token {

    public Black(int count,Vector2D pos) {
        super(count,pos,Color.BLACK);
    }

    public int getCount(){
        return count/2;
    }


}