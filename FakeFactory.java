
public class FakeFactory extends TokenFactory {


    public FakeFactory() {
    }

    @Override
    public Token createToken(Vector2D pos){
        int  n = Constant.RANDOMIZER.nextInt(Constant.TOKEN_PACK_MAX) + Constant.TOKEN_PACK_MIN;
        return new Fake(n,pos);
    }

}