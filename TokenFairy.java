
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TokenFairy implements AnimationEntity {


    public TokenFairy() {
        factories = new ArrayList<>();
        factories.add(new RegularFactory());
        factories.add(new FakeFactory());
        factories.add(new BlackFactory());

        speedFactory = new SpeedPackFactory();
        img = new BufferedImage[2];
        imageIndex = 0;
        try{
            img[0] = ImageIO.read(Constant.FAIRY_LEFT);
            img[1] = ImageIO.read(Constant.FAIRY_RIGHT);
            Constant.FAIRY_IMG_WIDTH = img[imageIndex].getWidth();
            Constant.FAIRY_IMG_HEIGHT = img[imageIndex].getHeight();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        }
    private List<TokenFactory> factories;
    private SpeedPackFactory speedFactory;
    private Vector2D position;
    private BufferedImage [] img;
    private int imageIndex;

    public Token createToken(Vector2D pos) {
        int  n = Constant.RANDOMIZER.nextInt(factories.size());
        return factories.get(n).createToken(pos);
    }
    public void setPosition(Vector2D position)
    {
        this.position = position;
    }
    public void draw(Graphics2D g2d) {
        g2d.drawImage(img[imageIndex],position.getIntX(),position.getIntY(),null);
    }

    public void act(int deltaTime,Data data) {

        if(deltaTime == 5) {
            this.position = data.randomVectorGenerator(img[imageIndex].getWidth(),img[imageIndex].getHeight());
            imageIndex = Constant.RANDOMIZER.nextInt(img.length);
        }
        int tokenC = data.tokens.size();

        //BONUS: SOMETIMES GENERATE SPEED PACK
        if(Constant.RANDOMIZER.nextInt(Constant.SPEED_PACK_PROBABILITY) == 1)
            data.tokens.add(speedFactory.createToken(data.randomVectorGenerator(Constant.TOKEN_WIDTH,Constant.TOKEN_HEIGHT)));

        for (int i = 0; i < Constant.AVAILABLE_TOKENS - tokenC; i++) {
            data.tokens.add(this.createToken(data.randomVectorGenerator(Constant.TOKEN_WIDTH,Constant.TOKEN_HEIGHT)));
        }

    }

}