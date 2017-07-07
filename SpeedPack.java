import java.awt.*;

/**
 * Bonus: Special Token Pack that increments speed.
 */
public class SpeedPack extends Token {
    public SpeedPack(int count,Vector2D pos) {
        super(count,pos, Color.ORANGE);
    }
    public int getCount() {
        return count;
    }
}
