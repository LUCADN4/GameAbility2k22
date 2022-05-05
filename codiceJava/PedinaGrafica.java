import java.awt.*;
import processing.core.PApplet;

public class PedinaGrafica { //class to create the piece of the grid
    private float dim; //circle diameter
    private float cordX; //x coordinate
    private float cordY; //y coordinate
    private Color colore; //instance of the class Color, named colore
    private Color bordo; //instance of the class Color, named bordo
    private final float DIM_DEFAULT = 100; //default dimension to assing at the circle in case it's less than 0

    private PApplet processing; //window object which is used in

    public PedinaGrafica(PApplet processing, float cordX, float cordY, Color colore, Color bordo, float dim) {
        //constructor to initialize every variable
        this.processing = processing;
        this.cordX = cordX;
        this.cordY = cordY;
        if (dim > 0) {
            this.dim = dim;
        }else{
            this.dim = DIM_DEFAULT;
        }
        this.colore= colore;
        this.bordo = bordo;
    }


    public void show() {
        processing.strokeWeight(3);  //stroke
        processing.stroke(bordo.getRGB()); //stroke color
        processing.fill(colore.getRGB()); //fill color
        processing.circle(cordX, cordY, dim); //center X,Y e dimension diameter
    }

    public void setDim(float dim) {
        if (dim >= 0) this.dim = dim;
    } //setters and getters for circle's variables

    public float getDim(){ return dim; }

    public void setCordX(float x){
        cordX = x;
    }

    public void setCordY(float y){
        cordY = y;
    }

    public void setColore(Color colore){
        this.colore = colore; //new color()
    }

    public PApplet getProcessing() {
        return processing;
    }

    public void setProcessing(PApplet processing) {
        this.processing = processing;
    }

    public float getCordX(){
        return cordX;
    }

    public float getCordY(){
        return cordY;
    }

    public Color getColore(){
        return colore;
    }

    public Color getBordo(){
        return bordo;
    }

    public void setBordo(Color colore){
        bordo = colore;
    }

}
