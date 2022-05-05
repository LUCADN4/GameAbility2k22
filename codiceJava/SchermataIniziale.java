import processing.core.PApplet;
import java.awt.*;

public class SchermataIniziale { //define the start page of the game
    private PApplet processing;
    private PedinaGrafica[][] cerchi; //define a vector of the pieces

    public SchermataIniziale(PApplet processing) { //constructor to define every variable
        this.processing = processing;
        cerchi = new PedinaGrafica[31][18];
        int x = 30;
        int y = 20;
        for(int c = 0; c < 31; c++) {
            for (int r = 0; r < 18; r++) {
                cerchi[c][r] =new PedinaGrafica(processing, x, y, Costanti.BLU, Costanti.NERO, 50);
                y += 50;
            }
            x +=50;
            y = 20;
        }
        int[] xDisegno = new int[]{2,3,4,2,3,4,1,1,1,1,1,6,7,8,9,6,7,8,9,6,6,6,9,9,9,11,11,11,11,11,12,13,14,12,13,14,13,14,14,
                16,17,18,19,18,17,16,16,17,18,19,21,22,23,24,22,23,21,21,21,21,24,24,24,24,26,26,26,26,27,28,29,28,28};
        int[] yDisegno = new int[]{2,2,2,4,4,4,2,3,4,5,6,2,2,2,2,6,6,6,6,3,4,5,3,4,5,02,03,04,05,06,02,02,02,04,04,04,05,03,06,
                02,02,02,02,03,04,05,06,06,06,06,02,02,02,02,04,04,03,04,05,06,03,04,05,06,02,03,04,05,05,05,05,04,06};

        for(int k = 0; k < xDisegno.length;k++){
            cerchi[xDisegno[k]][yDisegno[k]].setColore(new Color(255, 255, 255));
            cerchi[xDisegno[k]][yDisegno[k]].setBordo(new Color(0,0,0));
        }
    }

    public void show(){ //shows every piece of the grid
        for(int c = 0; c < 31; c++) {
            for (int r = 0; r < 18; r++) {
                cerchi[c][r].show();
            }
        }
    }
}