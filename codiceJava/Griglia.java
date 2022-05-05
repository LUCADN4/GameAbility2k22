import processing.core.PApplet;


public class Griglia { //class that creates the game grid
    private PApplet processing;
    private PedinaGrafica[] pedineVuore; //empty circles of the grid
    private Rettangolo[] casella; //the rectangles that form the game grid
    private int larg; //width of the rectangles
    private float cordX; //horizontal coordinate
    private float cordY; //vertical coordinate
    private float cordXRect; //x coordinate of the rectangle
    private float cordYRect; //y coordinate of the rectangle


    public Griglia(PApplet processing) {
        //constructor to initialize the variables
        pedineVuore = new PedinaGrafica[42];
        casella = new Rettangolo[42];
        this.processing = processing;
        this.larg = 7;
        cordX=300;
        cordY=150;
        for(int k = 0; k < pedineVuore.length; k++){
            if (k % larg == 0 && k!=0) {
                cordX = 300;
                cordY+= 100;
            }

            pedineVuore[k] = new PedinaGrafica(processing,cordX,cordY,Costanti.BIANCO,Costanti.BIANCO,90);
            cordX+=150;
        }
        cordXRect=225;
        cordYRect=100;

        for(int k = 0; k < pedineVuore.length; k++){
            if (k % larg == 0 && k!=0) {
                cordXRect=225;
                cordYRect+=100;
            }
            casella[k] = new Rettangolo(processing,cordXRect,cordYRect,Costanti.BLU,Costanti.NERO,100,150);
            cordXRect+=150;
        }

    }

    public PedinaGrafica[] getPedineVuore() {
        return pedineVuore;
    } //return of the empty pieces

    public void show(){ //shows the rectangle and the pieces' outline
        for (Rettangolo k: casella){
            k.show();
        }

        for (PedinaGrafica k: pedineVuore){
            k.show();
        }


    }
}
