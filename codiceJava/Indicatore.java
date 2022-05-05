import processing.core.PApplet;
import java.awt.*;

public class Indicatore extends Triangolo{ //create a column indicatore through the extension of the class "Triangolo"
    private float speedX1; //horizontal speed of the vertex
    private float speedX2; //horizontal speed of the base
    private float speedX3; //horizontal speed of the base
    private float speedY; //vertical speed
    private static final float DEFEAULT_VEL = 1; //default speed
    private PApplet processing;

    public Indicatore(PApplet processing, int x1, int x2, int x3, int y1, int y2, int y3, Color colore, Color bordo) {
        //constructor that initialize the variables
        super(processing, x1, x2, x3, y1, y2, y3, colore, bordo);
        this.speedX1 = DEFEAULT_VEL;
        this.speedX2 = DEFEAULT_VEL;
        this.speedX3 = DEFEAULT_VEL;
        this.speedY = 0;
    }

    public void move(){ //method that moves the indicator of an x quantity
        setX1((getX1()+speedX1));
        setY1(getY1()+speedY);
        setX2((getX2()+speedX2));
        setY2(getY2()+speedY);
        setX3((getX3()+speedX3));
        setY3(getY3()+speedY);

        if(getX1() == 1275){
            setSpeedX1(-DEFEAULT_VEL);
            setSpeedX2(-DEFEAULT_VEL);
            setSpeedX3(-DEFEAULT_VEL);
        }
        if(getX1() == 225){
            setSpeedX1(DEFEAULT_VEL);
            setSpeedX2(DEFEAULT_VEL);
            setSpeedX3(DEFEAULT_VEL);
        }
    }

    public float getSpeedX1() {
        return speedX1;
    } //setters and getters to obtain the variables

    public float getSpeedX2() {
        return speedX2;
    }

    public float getSpeedX3() {
        return speedX3;
    }

    public void setSpeedX1(float speedX1) {
        this.speedX1 = speedX1;
    }

    public void setSpeedX2(float speedX2) {
        this.speedX2 = speedX2;
    }

    public void setSpeedX3(float speedX3) {
        this.speedX3 = speedX3;
    }

    public void setSpeedY(float vel){ this.speedY = vel; }

    public float getSpeedY(){ return this.speedY; }

    public void show(){ //method to show on the screen the indicator
        move(); //call the method "move"
        super.show(); //use the show method of the class Triangolo
    }

}
