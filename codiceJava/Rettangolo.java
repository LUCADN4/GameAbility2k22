import processing.core.PApplet;
import java.awt.*;
public class Rettangolo { //class that create a rectangle
    private float alt;//height of the rectangle
    private float lung; //width of the rectangle
    private float cordX; //x coordinate
    private float cordY; //y coordinate
    private Color colore;  //colore riempimento
    private Color bordo;   //colore bordo

    private PApplet processing;
    public Rettangolo(PApplet processing,float cordX,float cordY,Color colore, Color bordo,float alt,float lung) {
        //constructor that initialize the variables
        this.processing = processing;
        this.cordX = cordX;
        this.cordY = cordY;
        this.colore= colore;
        this.bordo = bordo;
        this.alt = alt;
        this.lung=lung;
    }

    public void show() { //shows the rectangle
        processing.strokeWeight(5);//stroke lenght
        processing.stroke(bordo.getRGB());  //stroke color
        processing.fill(colore.getRGB());  //fill color
        processing.rect(cordX, cordY, lung, alt);  //X,Y,width,height
    }

    public float getAlt() {
        return alt;
    } //setters and getters of the rectangle's variables

    public void setAlt(float alt) {
        this.alt = alt;
    }

    public float getLung() {
        return lung;
    }

    public void setLung(float lung) {
        this.lung = lung;
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

    public PApplet getProcessing() {
        return processing;
    }

    public void setProcessing(PApplet processing) {
        this.processing = processing;
    }
}
