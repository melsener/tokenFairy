
import java.awt.*;
import java.util.*;


public class Regular extends Token {


    public Regular(int count,Vector2D pos) {
        super(count,pos,Color.GREEN);
    }


    public int getCount(){
        return count;
    }


}