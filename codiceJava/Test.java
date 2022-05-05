import processing.core.PApplet;
import processing.core.PImage;
import utility.InputTastiera;
import java.awt.*;

public class Test extends PApplet {
    private Griglia g; //create an object of griglia and names it "g"
    private Arduino arduino; //create an object of arduino and names it "arduino"
    private Appoggi a; //create an object of Appoggi and names it "a"
    private SchermataIniziale s; //create an object of SchermataIniziale and names it "s"
    private int mode; //defines an int that we will use to switch tabs, from the start of the game to the end victory.
    PImage photo; //defines the photos that will be put inside the game
    PImage photo1; //defines the photos that will be put inside the game
    PImage fine2; //defines the photos that will be put inside the game
    PImage sfondo;//defines the photos that will be put inside the game
    PImage fine1;//defines the photos that will be put inside the game
    PImage start;//defines the photos that will be put inside the game
    PImage pareggio;//defines the photos that will be put inside the game
    PImage personaggio;//defines the photos that will be put inside the game
    PImage pedinaGialla;//defines the photos that will be put inside the game
    PImage fr;//defines the photos that will be put inside the game
    PImage drg;//defines the photos that will be put inside the game
    PImage personagg;//defines the photos that will be put inside the game
    PImage pedinaRossa;//defines the photos that will be put inside the game
    Campo c; //create an object of Campo and names it "c"
    int pedineInserite = 0; //define a variable called "pedineInserite" that we will need oto know how many pieces we used
    String giocatore1; //define the first player of the game
    String giocatore2; //define the second player of the game
    boolean [] keys; //define a boolean vector that we need to use the keyboard keys
    int[] posizioniX; //define a vector of integer values that we need to know each position of the pieces inside the grid (horizontal)
    int[] posizioniY; //define a vector of integer values that we need to know each position of the pieces inside the grid (vertical)
    int indice; //define an index that we need as a storage for the players' moves
    boolean buttonClicked; //define a boolean variable that we use to update the start button at the main page
    Indicatore pedinaDinamica; //define an object of Indicatore and names it "pedinaDinamica"
    int posizione; //define an integer variable, it's used as an index like "indice"
    private Button btn; //is an object of Bottone called "btn"

    public static void main(String[] args)  {
        PApplet.main("Test");
    } //we define the main of the test using PApplet library

    public void settings() {
        fullScreen();
    } //we set the screen size on fullscreen

    public void setup() {
        posizioniX = new int[]{300, 450, 600, 750, 900, 1050, 1200}; //vector that contains the position to draw every piece (horizontal)
        posizioniY = new int[]{150, 250, 350, 450, 550, 650}; //vector that contains the position to draw every piece (vertical)
        s = new SchermataIniziale(this);
        //int boundRate = 115200; //we use this boundRate to communicate with the software Arduino,
        // 115200 represent the amount of data we can pass throught the softwares
        //this.arduino = new Arduino("COM5", boundRate); //we initialize the standard port which connect the arudino physically
        //this.arduino.openConnection(); //we open the connection of the arduino using the instance of the class "Arduino"
        //boolean connected = arduino.openConnection(); //we define a boolean variable to know if the arduino can communicate with java or not
        //System.out.println("connection established: " + connected); //we print on the screen the result of the connection
        photo = loadImage("images.jpeg"); //we assign the images with their path to a variable
        fine1 = loadImage("fp1vers2.png");//we assign the images with their path to a variable
        fine2 = loadImage("fp2vers2.jpeg");//we assign the images with their path to a variable
        sfondo = loadImage("sfondo.png");//we assign the images with their path to a variable
        pedinaGialla = loadImage("schermatapgialla.png");//we assign the images with their path to a variable
        pedinaRossa = loadImage("schermataprossa.png");//we assign the images with their path to a variable
        drg = loadImage("drago.png");//we assign the images with their path to a variable
        personaggio = loadImage("personaggio.png");//we assign the images with their path to a variable
        pareggio = loadImage("pareggiovers2.png");//we assign the images with their path to a variable
        personagg = loadImage("soggettone.png");//we assign the images with their path to a variable
        fr = loadImage("l.png");//we assign the images with their path to a variable
        g = new Griglia(this); //create an instance for the class "Griglia" and names it g
        a = new Appoggi(this); //create an instance for the class "Appoggi" and names it a
        photo1 = loadImage("Forza4b.jpg");//we assign the images with their path to a variable
        start = loadImage("modifica.png");//we assign the images with their path to a variable
        mode = 1; //initialize the variable to 1
        indice = 0; //initialize the variable to 0
        buttonClicked = true; //initialize the variable to true
        InputTastiera t = new InputTastiera(); //enable the flow of the keyboard keys through the class "InputTastiera"
        c = new Campo(); //create the game field
        pedinaDinamica = new Indicatore(this, 225, 175, 275, 90, 50, 50, Costanti.ROSSO, Color.black);
        //is the indicator that slides horizontally from left to right
        giocatore1 = "giocatore1"; //assign a default name to giocatore 1
        giocatore2 = "giocatore2"; //assign a default name to giocatore 2
        keys = new boolean[128]; //assing the space for the boolean vector of the keyboard
        posizione = 0; //initialize the position to 0
    }

        public void draw() { //method that shows the game
        switch (mode) { //switch case for the different slides of the game
            case 1 -> { //start page case
                background(0, 0, 0); //set the background to black
                s.show(); //show the start page
                fill(255, 255, 255);
                stroke(0,0,0);
                circle(width / 2, 580, 125); //draw the start button
                image(start, 330,240);//insert the images in the slide
                image(pedinaGialla, 100,400);
                image(pedinaRossa, 1150,425);
                update();
            }
            case 2 -> {
                image(sfondo, 0, 0);
                pedinaDinamica.show(); //through the function pedinaDinamica we insert the pieces inside the game grid
                g.show(); //shows the grid
                a.show(); //shows the support pieces at the base of the grid
                image(personaggio, 1260, -75); //insert the characters' images
                image(fr, 1250, 600);
                image(personagg, 10, 450);
                image(drg, -35,70);
            }
            case 3 -> {
                delay(2500); //we set a delay of 2.5 seconds to show the player won and then the victory slide
                image(fine2, 0,0); //image of the victory of the second player
                //this.arduino.closeConnection(); //close the connection with the arduino
            }
            case 4 -> {
                delay(2500); //we set a delay of 2.5 seconds to show the player won and then the victory slide
                image(fine1, 0,0); //image of the victory of the first player
                //this.arduino.closeConnection(); //close the connection with the arduino
            }
            case 5 -> {
                delay(2500); //we set a delay of 2.5 seconds to show the player won and then the draw slide
                image(pareggio, 0,0); //image of the draw between the two players
                //this.arduino.closeConnection(); //close the connection with the arduino
            }
        }
    }

    private int trovaIndice(int x, int y) { //method that we use to know players' turns
        posizioniX = new int[]{300, 450, 600, 750, 900, 1050, 1200};
        posizioniY = new int[]{150, 250, 350, 450, 550, 650};
        int tro = -1;
        int k = 0;
        while (k < g.getPedineVuore().length && tro == -1) {
            if (g.getPedineVuore()[k].getCordX() == posizioniX[x] && g.getPedineVuore()[k].getCordY() == posizioniY[y]) {
                tro = k;
            } else k++;
        }
        return tro;
    }

    void update() { //method of the button
        if (buttonClicked) {
            mode = 1;
        } else {
            mode = 2;
            background(205, 133, 63);
            g.show();
            a.show();
            image(photo, 1220, 50);
        }
    }

    boolean overCircle(int x, int y, int diameter) { //method that uses a specific way to overwrite the circle and use it as a button
        float disX = x - mouseX;
        float disY = y - mouseY;
        if (sqrt(sq(disX) + sq(disY)) < diameter/2 ) {
            return true;
        } else {
            return false;
        }
    }

    public void mousePressed() { //method to know if over the circle is pressed the mouse
        if (overCircle(width/2,580,125)) {
            buttonClicked = !buttonClicked;
        }
    }

    public void keyPressed() { //method to enable keyboard keysc
        keyRepeatEnabled = false;
        if(key == ' ' || key == 'F'){ //shows if the "f" key is pressed
            if(pedinaDinamica.getX1() >= 225 && pedinaDinamica.getX1() < 375) posizione = 0; //if the piece's indicator is between 225 and 375 of x coordinates,
                // then the piece is going to be put inside the first column
            else if(pedinaDinamica.getX1() >= 375 && pedinaDinamica.getX1() < 525) posizione = 1;//if the piece's indicator is between 375 and 525 of x coordinates,
                // then the piece is going to be put inside the second column
            else if(pedinaDinamica.getX1() >= 525 && pedinaDinamica.getX1() < 675) posizione = 2;//if the piece's indicator is between 525 and 675 of x coordinates,
                // then the piece is going to be put inside the third column
            else if(pedinaDinamica.getX1() >= 675 && pedinaDinamica.getX1() < 825) posizione = 3;//if the piece's indicator is between 675 and 825 of x coordinates,
                // then the piece is going to be put inside the fourth column
            else if(pedinaDinamica.getX1() >= 825 && pedinaDinamica.getX1() < 975) posizione = 4;//if the piece's indicator is between 825 and 975 of x coordinates,
                // then the piece is going to be put inside the fifth column
            else if(pedinaDinamica.getX1() >= 975 && pedinaDinamica.getX1() < 1125) posizione = 5;//if the piece's indicator is between 975 and 1125 of x coordinates,
                // then the piece is going to be put inside the sixth column
            else if(pedinaDinamica.getX1() >= 1125 && pedinaDinamica.getX1() < 1275) posizione = 6;//if the piece's indicator is between 1125 and 1275 of x coordinates,
            // then the piece is going to be put inside the seventh column
            //arduino.serialWrite("1"); //used to set the arduino pin of the hand to HIGH so it do the predefinite movement
        }

        if(pedineInserite != 42 && !c.vittoriaColonna() && !c.vittoriaRiga() && !c.vittoriaDiagonale()) {
            //checks vertical, horizontal and diagonal victories
            if (pedineInserite % 2 == 0) {

                c.inserisciPedina(TipoColore.ROSSO, giocatore1, posizione);
                int altezza = c.getPos();
                int colonna = c.getPosizione();
                indice = trovaIndice(colonna, altezza);
                g.getPedineVuore()[indice].setColore(new Color(255, 0, 0));
                pedineInserite++;
                g.show();
                if (c.vittoriaRiga() || c.vittoriaColonna() || c.vittoriaDiagonale()) {
                    System.out.println("ha vinto il giocatore " + giocatore1);
                    textSize(75);
                    fill(10, 12, 14);
                    mode = 4;


                }
                if (!c.vittoriaColonna() && !c.vittoriaRiga() && !c.vittoriaDiagonale() && pedineInserite == 42) {
                    System.out.println("Pareggio");
                    mode = 5;

                }
            } else {

                c.inserisciPedina(TipoColore.GIALLO, giocatore2, posizione);
                int altezza = c.getPos();
                int colonna = c.getPosizione();
                indice = trovaIndice(colonna, altezza);
                g.getPedineVuore()[indice].setColore(new Color(255, 255, 0));
                g.show();
                pedineInserite++;
                if (c.vittoriaRiga() || c.vittoriaColonna() || c.vittoriaDiagonale()) {
                    System.out.println("ha vinto il giocatore " + giocatore2);
                    textSize(75);
                    fill(10, 12, 14);
                    mode = 3;

                }
                if (!c.vittoriaColonna() && !c.vittoriaRiga() && !c.vittoriaDiagonale() && pedineInserite == 42) {
                    mode = 5;

                }
            }
        }else{
            if (!c.vittoriaColonna() && !c.vittoriaRiga() && !c.vittoriaDiagonale() && pedineInserite == 42) {
                mode = 5;

            }
        }
    }
}