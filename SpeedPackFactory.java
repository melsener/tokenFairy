/**
 * Bonus: Factory of Special Token Pack that increments speed.
 */
public class SpeedPackFactory extends TokenFactory {

    public SpeedPackFactory(){
    }
    @Override
    public Token createToken(Vector2D pos) {

        return new SpeedPack(1,pos);
    }
}
