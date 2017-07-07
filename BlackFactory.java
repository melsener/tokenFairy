
public class BlackFactory extends TokenFactory {


    public BlackFactory() {
        super();
    }

    public Token createToken(Vector2D pos) {
        int  n = Constant.RANDOMIZER.nextInt(Constant.TOKEN_PACK_MAX) + Constant.TOKEN_PACK_MIN;
        return new Black(n,pos);
    }

}