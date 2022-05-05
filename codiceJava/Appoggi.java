import processing.core.PApplet;

public class Appoggi { //class to create the base of the grid
    private PApplet processing;
    private Rettangolo base1;
    private Rettangolo base2;
    private Ellisse baseSostegno;

    public Appoggi(PApplet processing) {
        this.processing = processing;
        base1 = new Rettangolo(processing,425,700,Costanti.BLU,Costanti.NERO,50,50);
        base2 = new Rettangolo(processing,1025,700,Costanti.BLU,Costanti.NERO,50,50);
        baseSostegno = new Ellisse(processing,745,750,Costanti.BLU,Costanti.NERO,750,50);

    }

    public void show(){
        baseSostegno.show();
        base1.show();
        base2.show();
    }
}
