import processing.core.PApplet;
import java.awt.*;

public class Ellisse { //class that create an ellipse
    private float dim; //circle diameter
    private float cordX; //horizontal coordinate
    private float cordY; //vertical coordinate
    private Color colore; //instance of the class Color named "colore"
    private Color bordo; //instance of the class Color named "bordo"
    private final float DIM_DEFAULT = 100; //define a default dimension for the ellipse (100)
    private float alt; //height of the ellipse
    private float lung; //width of the ellipse

    private PApplet processing;

    public Ellisse(PApplet processing,float cordX,float cordY,Color colore, Color bordo,float lung ,float alt) {
        //constructor that intialize the variables
        this.processing = processing;
        this.cordX = cordX;
        this.cordY = cordY;
        if (dim > 0) {
            this.dim = dim;
        }else{
            this.dim= DIM_DEFAULT;
        }
        this.colore= colore;
        this.bordo = bordo;
        this.alt = alt;
        this.lung=lung;
    }


    public void show() { //show method to draw the ellipse on the screen
        processing.strokeWeight(5);  //stroke
        processing.stroke(bordo.getRGB()); //stroke color
        processing.fill(colore.getRGB()); //fill color
        processing.ellipse(cordX, cordY,lung,alt); //center X,Y e dim diameter
    }

    public float getDim() {
        return dim;
    } //setter and getter of the ellipse's variables

    public void setDim(float dim) {
        this.dim = dim;
    }

    public float getCordX() {
        return cordX;
    }

    public void setCordX(float cordX) {
        this.cordX = cordX;
    }

    public float getCordY() {
        return cordY;
    }

    public void setCordY(float cordY) {
        this.cordY = cordY;
    }

    public Color getColore() {
        return colore;
    }

    public void setColore(Color colore) {
        this.colore = colore;
    }

    public Color getBordo() {
        return bordo;
    }

    public void setBordo(Color bordo) {
        this.bordo = bordo;
    }

    public float getAlt() {
        return alt;
    }

    public void setAlt(float alt) {
        this.alt = alt;
    }

    public float getLung() {
        return lung;
    }

    public void setLung(float lung) {
        this.lung = lung;
    }

    public PApplet getProcessing() {
        return processing;
    }

    public void setProcessing(PApplet processing) {
        this.processing = processing;
    }
}
