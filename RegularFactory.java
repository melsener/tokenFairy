
import java.util.*;

/**
 * 
 */
public class RegularFactory extends TokenFactory {


    public RegularFactory() {
    }

    @Override
    public Token createToken(Vector2D pos){
        int  n = Constant.RANDOMIZER.nextInt(Constant.TOKEN_PACK_MAX) + Constant.TOKEN_PACK_MIN;
        return new Regular(n,pos);
    }

}