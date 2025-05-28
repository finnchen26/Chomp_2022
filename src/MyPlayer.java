import java.awt.*;
import java.util.ArrayList;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    public ArrayList<Board> losingBoards = new ArrayList<>();

    public MyPlayer() {
        columns = new int[10];
        losingBoards.add(new Board(1, 0, 0));
        baseBoard();
        for (int i = 0; i < losingBoards.size(); i++){
            System.out.println("losing board: " + losingBoards.get(i).boards[0] + "" + losingBoards.get(i).boards[1] + "" + losingBoards.get(i).boards[2]);
        }

    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int column = 0;
        int row = 0;

        row = 1;
        column = 1;


        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        Point myMove = new Point(row, column);
        return myMove;
    }

    public void baseBoard() {
        for (int a = 1; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                for (int c = 0; c < 4; c++) {
                    if (a >= b && b >= c) {
                        oneMove(a, b, c);

                    }

                }
            }

        }

    }

    public void oneMove(int a, int b, int c) {
        boolean isLosingBoard = false;
        int tempA = a;
        int tempB = b;
        int tempC = c;
        System.out.println("Board: " + a + " " + b + " " + c);
        for (int i = 0; i < losingBoards.size(); i++) {
            if (a == losingBoards.get(i).boards[0] && b == losingBoards.get(i).boards[1] && c == losingBoards.get(i).boards[2]) {
                System.out.println("you lose!");
                isLosingBoard = true;
            }
        }


        if (c != 0) {
            for (int i = c; i > 0; i--) {
                tempC = tempC - 1;
                System.out.println(a + " " + b + " " + tempC);
                for (int j = 0; j < losingBoards.size(); j++) {
                    if (a == losingBoards.get(j).boards[0] && b == losingBoards.get(j).boards[1] && tempC == losingBoards.get(j).boards[2]) {
                        System.out.println("yay2");
                        System.out.println("losing board found!"+ ", " + " row = " + (tempC) + " column = 2");
                        isLosingBoard = true;
                    }
                }
            }
        }
        if (tempC == 0 && b > c) {
            for (int i = b; i > c; i--) {
                tempB = tempB - 1;
                System.out.println(a + " " + tempB +" " + c);
                for (int j = 0; j < losingBoards.size(); j++) {
                    if (a == losingBoards.get(j).boards[0] && tempB == losingBoards.get(j).boards[1] && c == losingBoards.get(j).boards[2]) {
                        System.out.println("yay3");
                        System.out.println("losing board found"+ ", " +" row = " + (tempB) + " column = 1");
                        isLosingBoard = true;
                    }
                }
            }
        }
        tempC = c;
        if (tempB == c) {
            for (int i = tempB; i > 0; i--) {
                tempB = tempB - 1;
                tempC = tempC - 1;
                System.out.println(a + " " + tempB + " " + tempC);
                for (int j = 0; j < losingBoards.size(); j++) {
                    if (a == losingBoards.get(j).boards[0] && tempB == losingBoards.get(j).boards[1] && tempC == losingBoards.get(j).boards[2]) {
                        System.out.println("yay4");
                        System.out.println("losing board found!"+ ", " + " row = " + (tempB) + " column = 1");
                        isLosingBoard = true;
                    }
                }
            }
        }
        tempA = a;
        tempB = b;
        tempC = c;

        if (a > b) {
            if (b == c) {
                for (int i = a-1; i > 0; i--) {
                    tempA = tempA - 1;
                    if (tempA == 0 && tempB == 0 && tempC == 0) {
                        System.out.println("0000");
                        break;
                    }
                    System.out.println(tempA + " " + tempB + " " + tempC);
                    for (int j = 0; j < losingBoards.size(); j++) {
                        if (tempA == losingBoards.get(j).boards[0] && tempB == losingBoards.get(j).boards[1] && tempC == losingBoards.get(j).boards[2]) {
                            System.out.println("yay5");
                            System.out.println("losing board found!" + ", " + " row = " + (tempA) + " column = 0");
                            isLosingBoard = true;
                        }
                    }
                }
            }
            if (b > c) {
                for (int i = 1; i > 0; i--) {
                    tempA = tempA - 1;
//                    tempB = tempB - 1;
                    if (tempC != 0) {
                        tempC = tempC - 1;
                    }
                    System.out.println(tempA + " " + tempB + " " + tempC);
                    for (int j = 0; j < losingBoards.size(); j++) {
                        if (tempA == losingBoards.get(j).boards[0] && tempB == losingBoards.get(j).boards[1] && tempC == losingBoards.get(j).boards[2]) {
                            System.out.println("yay6");
                            System.out.println("losing board found!"+ ", " + " row = " + (tempA) + " column = 0");
                            isLosingBoard = true;
                        }
                    }
                }
            }
        }

        tempA = a;
        tempB = b;
        tempC = c;

        if (a == b) {
            if (b > c) {
                for (int i = 1; i > 0; i--) {
                    tempA = tempA - 1;
                    tempB = tempB - 1;
                    if (tempA == 0) {
                        break;
                    }
                    System.out.println(tempA + " " + tempB + " " + tempC);
                    for (int j = 0; j < losingBoards.size(); j++) {
                        if (tempA == losingBoards.get(j).boards[0] && tempB == losingBoards.get(j).boards[1] && tempC == losingBoards.get(j).boards[2]) {
                            System.out.println("yay7");
                            System.out.println("losing board found!"+ ", " + " row = " + (tempA) + " column = 0");
                            isLosingBoard = true;
                        }
                    }
                    tempB = b;
                }
            }
            if (b == c) {
                for (int i = tempB; i > 0; i--) {
                    tempA = tempA - 1;
                    tempB = tempB - 1;
                    tempC = tempC - 1;
                    if (tempA == 0) {
                        break;
                    }
                    System.out.println(tempA + " " + tempB + " " + tempC);
                    for (int j = 0; j < losingBoards.size(); j++) {
                        if (tempA == losingBoards.get(j).boards[0] && tempB == losingBoards.get(j).boards[1] && tempC == losingBoards.get(j).boards[2]) {
                            System.out.println("yay8");
                            System.out.println("losing board found!"+ ", " + " row = " + (tempB-1) + " column = 1");
                            isLosingBoard = true;
                        }
                    }
                }
            }
        }

        if (isLosingBoard == false){
           losingBoards.add(new Board(a, b, c));
            System.out.println("i added board " + a + ", " + b + ", " + c);

        }
    }
}



