import processing.core.PApplet;
import java.awt.*;

public class IndicatoreDinamico extends Indicatore{ //a class that extends the previous one, Indicatore
    private float speedX; //speed of the horizontal coordinate
    private float speedY; //speed of the vertical coordinate
    private static final float DEFAULT_VEL = 1; //default speed

    public IndicatoreDinamico(PApplet processing) {
        super(processing, 50,40,40,30, //create a new indicatore matching super method with the Indicatore parameters already defined
                60,30, new Color(255,255,255),
                new Color(0,0,0));
        speedX = DEFAULT_VEL; //assign to speed of the horizontal coordinate the default one
        speedY = 0;
    }
}
