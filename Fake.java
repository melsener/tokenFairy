
import java.awt.*;
import java.util.*;

public class Fake extends Token {

    public Fake(int count,Vector2D pos) {
        super(count,pos,Color.BLUE);
    }
    public int getCount() {
        return 1;
    }

}