package rocks.zipcodewilmington.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author leon on 6/22/18.
 */
public class Board {
     String [] h = new String [3];
     String [] v = new String[3];
     String [] d = new String [2];
     ArrayList<String> attempts = new ArrayList<String>();

    public Board(Character[][] matrix) {
        setD(matrix);
        setH(matrix);
        setV(matrix);

    }

    public Boolean isInFavorOfX() {


    return Winning("X");
    }

    public Boolean isInFavorOfO() {
        return Winning("O");
    }

    public Boolean isTie() {
        if(isInFavorOfO()) {
            return false;
        }
        else return !isInFavorOfX();
    }

    public String getWinner() {
        if (isInFavorOfO()) {
            return "O";
        } else if (isInFavorOfX()) {
            return "X";
        }
        return "";
    }

    public boolean Winning(String player) {
        setAttempts();
        String winner = player+player+player;
        for (String attempt : this.attempts) {
            if (attempt.equals(winner)) {
                return true;
            }
        }
        return false;
    }

    public void setH(Character [][] matrix) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i<3; i++) {
            for (int j=0; j<3; j++) {
                str.append(matrix[j][i].toString());
            }
            this.h[i] = str.toString();
            str = new StringBuilder();
        }
    }

    public void setV (Character [][] matrix) {
        StringBuilder str = new StringBuilder();
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                str.append(matrix[i][j].toString());
            }
            this.v[i] = str.toString();
            str = new StringBuilder();
        }
    }

    public void setD(Character [][] matrix) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i<3; i++) {
            str.append(matrix[i][i].toString());
        }
        this.d[0] = str.toString();
        str = new StringBuilder();
        int i=0;
        for(int j = 2;j>=0; j--) {
            str.append(matrix[j][i]).toString() ;
            i++;

        }
        this.d[1] = str.toString();
    }

    public void setAttempts() {
        attempts.addAll(Arrays.asList(this.v))
        ;attempts.addAll(Arrays.asList(this.h));
        attempts.addAll(Arrays.asList(this.d));
    }

}
