import processing.core.PApplet;
import java.awt.*;

public class Triangolo { //class that create triangles
    private float x1; //x coordinate of the vertex
    private float x2; //x coordinate of the left base
    private float x3; //x coordinate of the right base
    private float y1; //y coordinate of the vertex
    private float y2; //y coordinate of the left base
    private float y3; //y coordinate of the right base
    private Color colore; //define the color instance of the class Color
    private Color bordo; //define another instance of the Color class, called bordo
    private PApplet processing; //define the processing instance

    public Triangolo(PApplet processing,float x1, float x2, float x3, float y1, float y2, float y3, Color colore, Color bordo) {
        //constructor to initialize every variable
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.colore = colore;
        this.bordo = bordo;
        this.processing = processing;
    }

    public float getX1() {
        return x1;
    } //getters and setters to obtain the x and y coordinates and the color of bordo and of the triangle

    public float getX2() {
        return x2;
    }

    public float getX3() {
        return x3;
    }

    public float getY1() {
        return y1;
    }

    public float getY2() {
        return y2;
    }

    public float getY3() {
        return y3;
    }

    public Color getColore() {
        return colore;
    }

    public Color getBordo() {
        return bordo;
    }

    public PApplet getProcessing() {
        return processing;
    }

    public void setX1(float x1) {
        this.x1 = x1;
    }

    public void setX2(float x2) {
        this.x2 = x2;
    }

    public void setX3(float x3) {
        this.x3 = x3;
    }

    public void setY1(float y1) {
        this.y1 = y1;
    }

    public void setY2(float y2) {
        this.y2 = y2;
    }

    public void setY3(float y3) {
        this.y3 = y3;
    }

    public void setColore(Color colore) {
        this.colore = colore;
    }

    public void setBordo(Color bordo) {
        this.bordo = bordo;
    }

    public void setProcessing(PApplet processing) {
        this.processing = processing;
    }

    public void show(){//method that effectively draws the triangle on the screen
        processing.strokeWeight(3);  //stroke
        processing.stroke(bordo.getRGB()); //board color
        processing.fill(colore.getRGB()); //fill color
        processing.triangle(x1,y1,x2,y2,x3,y3); //center,x and diameter of the triangle
    }
}
