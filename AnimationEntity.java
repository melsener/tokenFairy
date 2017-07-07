
import java.awt.*;

public interface AnimationEntity {

    void draw(Graphics2D g2d);
    void act(int deltaTime, Data data);

}