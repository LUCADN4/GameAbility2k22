import processing.core.PApplet;

import java.awt.*;

public class PedinaDinamica extends PedinaGrafica{ //an extension of the previous class, pedinaGrafica
    private float speedX; //horizontal speed
    private float speedY; //vertical speed
    private static final float DEFEAULT_VEL = 1; //default speed
    private PApplet processing;

    public PedinaDinamica(PApplet processing, float cordX, float cordY, Color colore, Color bordo, float dim){
        //constructor to initialize pedinaDinamica's variables
        super(processing,cordX,cordY,colore,bordo,dim);
        speedX = DEFEAULT_VEL;
        speedY = 0;
    }

    public void move(){ //method that moves the pieces inside the grid at the position requested
        setCordX(getCordX()+speedX);
        setCordY(getCordY()+speedY);

        if(getCordX() == 1200){
            setSpeedX(-DEFEAULT_VEL);
        }
        if(getCordX() == 250){
            setSpeedX(DEFEAULT_VEL);
        }
    }

    public void setSpeedX(float vel){ this.speedX = vel; } //setters and getters of the variables

    public void setSpeedY(float vel){ this.speedY = vel; }

    public float getSpeedX(){ return this.speedX; }

    public float getSpeedY(){ return this.speedY; }

    public void show(){
        move(); //move the circle
        super.show(); //use the show method of the class pedinaGrafica
    }

}
