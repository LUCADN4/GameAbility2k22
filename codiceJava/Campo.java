import java.util.Random;

public class Campo { //class that define the logical field of the game
    private static final int RIGHE = 6; //number of rows
    private int[] pos_tutte; //position of every piece
    private static final int COLONNE = 7; //number of column
    private Pedina[][] vetPedine; //matrix of Pedina with column and rows
    private int pos; //two index for every parameter, column and rows
    private int posizione;

    public Campo(){
        //constructor to initialize the variables
        vetPedine = new Pedina[RIGHE][COLONNE];
        pos_tutte = new int[]{RIGHE,RIGHE,RIGHE,RIGHE,RIGHE,RIGHE,RIGHE};
        for(int k = 0;k < RIGHE;k++){
            for(int j = 0;j < COLONNE;j++){
                vetPedine[k][j] = new Pedina(TipoColore.TRASPARENTE);
            }
        }
    }

    public void inserisciPedina(TipoColore colore, String nome, int posizione){
        //put a piece inside the grid of the coordinate where the indicator is set
        Random rand = new Random();
        this.posizione = posizione;

        pos_tutte[posizione]--;
        if(pos_tutte[posizione] != -1){
            vetPedine[pos_tutte[posizione]][posizione].setColore(colore);
        }else{
            System.out.println("\n\nCOLONNA PIENA\n\n");
            pos_tutte[posizione] = 0;
        }
        pos = pos_tutte[posizione];

    }

    public int getPos() {
        return pos;
    } //setters and getter to obtain the variables

    public int getPosizione() {
        return posizione;
    }

    public boolean vittoriaDiagonale(){ //check the diagonal victory
        boolean win = false;
        //victory check yellow pieces
        int r = 5;
        int c = 0;
        for(int indice = 0;indice < 4;indice++){
            if((vetPedine[r][c].getColore() == TipoColore.GIALLO && vetPedine[r-1][c+1].getColore() == TipoColore.GIALLO && vetPedine[r-2][c+2].getColore() == TipoColore.GIALLO && vetPedine[r-3][c+3].getColore() == TipoColore.GIALLO) || (vetPedine[r][c].getColore() == TipoColore.ROSSO && vetPedine[r-1][c+1].getColore() == TipoColore.ROSSO && vetPedine[r-2][c+2].getColore() == TipoColore.ROSSO && vetPedine[r-3][c+3].getColore() == TipoColore.ROSSO)){
                win = true;
            }
            c++;
        }
        c = 6;
        for (int indice = 0; indice < 4;indice++){
            if((vetPedine[r][c].getColore() == TipoColore.GIALLO && vetPedine[r-1][c-1].getColore() == TipoColore.GIALLO && vetPedine[r-2][c-2].getColore() == TipoColore.GIALLO && vetPedine[r-3][c-3].getColore() == TipoColore.GIALLO) || (vetPedine[r][c].getColore() == TipoColore.ROSSO && vetPedine[r-1][c-1].getColore() == TipoColore.ROSSO && vetPedine[r-2][c-2].getColore() == TipoColore.ROSSO && vetPedine[r-3][c-3].getColore() == TipoColore.ROSSO)){
                win = true;
            }
            c--;
        }
        r = 3;
        c = 0;
        for (int indice = 0; indice < 4;indice++){
            if((vetPedine[r][c].getColore() == TipoColore.GIALLO && vetPedine[r-1][c+1].getColore() == TipoColore.GIALLO && vetPedine[r-2][c+2].getColore() == TipoColore.GIALLO && vetPedine[r-3][c+3].getColore() == TipoColore.GIALLO) ||( vetPedine[r][c].getColore() == TipoColore.ROSSO && vetPedine[r-1][c+1].getColore() == TipoColore.ROSSO && vetPedine[r-2][c+2].getColore() == TipoColore.ROSSO && vetPedine[r-3][c+3].getColore() == TipoColore.ROSSO)){
                win = true;
            }
            c++;
        }
        c = 6;
        for (int indice = 0; indice < 4;indice++){
            if((vetPedine[r][c].getColore() == TipoColore.GIALLO && vetPedine[r-1][c-1].getColore() == TipoColore.GIALLO && vetPedine[r-2][c-2].getColore() == TipoColore.GIALLO && vetPedine[r-3][c-3].getColore() == TipoColore.GIALLO) || (vetPedine[r][c].getColore() == TipoColore.ROSSO && vetPedine[r-1][c-1].getColore() == TipoColore.ROSSO && vetPedine[r-2][c-2].getColore() == TipoColore.ROSSO && vetPedine[r-3][c-3].getColore() == TipoColore.ROSSO)){
                win = true;
            }
            c--;
        }
        r = 2;
        c = 0;
        for (int indice = 0; indice < 4;indice++){
            if((vetPedine[r][c].getColore() == TipoColore.GIALLO && vetPedine[r-1][c+1].getColore() == TipoColore.GIALLO && vetPedine[r-2][c+2].getColore() == TipoColore.GIALLO && vetPedine[r-3][c+3].getColore() == TipoColore.GIALLO) || (vetPedine[r][c].getColore() == TipoColore.ROSSO && vetPedine[r-1][c+1].getColore() == TipoColore.ROSSO && vetPedine[r-2][c+2].getColore() == TipoColore.ROSSO && vetPedine[r-3][c+3].getColore() == TipoColore.ROSSO)){
                win = true;
            }
            c++;
        }
        c = 6;
        for (int indice = 0; indice < 4;indice++){
            if((vetPedine[r][c].getColore() == TipoColore.GIALLO && vetPedine[r-1][c-1].getColore() == TipoColore.GIALLO && vetPedine[r-2][c-2].getColore() == TipoColore.GIALLO && vetPedine[r-3][c-3].getColore() == TipoColore.GIALLO) || (vetPedine[r][c].getColore() == TipoColore.ROSSO && vetPedine[r-1][c-1].getColore() == TipoColore.ROSSO && vetPedine[r-2][c-2].getColore() == TipoColore.ROSSO && vetPedine[r-3][c-3].getColore() == TipoColore.ROSSO)){
                win = true;
            }
            c--;
        }


        return win;
    }

    public boolean vittoriaRiga(){
        //check the row victory
        boolean win = false;

        for(int r = 0;r < RIGHE;r++){
            for(int c = 0;c < 4;c++){
                if (vetPedine[r][c].getColore() == TipoColore.GIALLO && vetPedine[r][c + 1].getColore() == TipoColore.GIALLO && vetPedine[r][c + 2].getColore() == TipoColore.GIALLO && vetPedine[r][c + 3].getColore() == TipoColore.GIALLO) {
                    win = true;
                    break;
                }
            }

        }
        for(int r = 0;r < RIGHE;r++){
            for(int c = 0;c < 4;c++){
                if (vetPedine[r][c].getColore() == TipoColore.ROSSO && vetPedine[r][c + 1].getColore() == TipoColore.ROSSO && vetPedine[r][c + 2].getColore() == TipoColore.ROSSO && vetPedine[r][c + 3].getColore() == TipoColore.ROSSO) {
                    win = true;
                    break;
                }
            }

        }
        return win;
    }

    public boolean vittoriaColonna(){
        //check the column victory
        boolean win = false;

        for(int c = 0;c < COLONNE;c++){
            for(int r = 0;r < 3;r++){
                if (vetPedine[r][c].getColore() == TipoColore.GIALLO && vetPedine[r+1][c].getColore() == TipoColore.GIALLO && vetPedine[r+2][c].getColore() == TipoColore.GIALLO && vetPedine[r+2][c].getColore() == TipoColore.GIALLO) {
                    win = true;
                    break;
                }
            }

        }
        for(int c = 0;c < COLONNE;c++){
            for(int r = 0;r < 3;r++){
                if (vetPedine[r][c].getColore() == TipoColore.ROSSO && vetPedine[r+1][c].getColore() == TipoColore.ROSSO && vetPedine[r+2][c].getColore() == TipoColore.ROSSO && vetPedine[r+2][c].getColore() == TipoColore.ROSSO) {
                    win = true;
                    break;
                }
            }

        }
        return win;
    }

}
