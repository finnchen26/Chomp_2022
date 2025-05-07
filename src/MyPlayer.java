import java.awt.*;
import java.util.ArrayList;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;




    public MyPlayer() {
        columns = new int[10];
        baseBoard();
        oneMove(3, 3, 3);
        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
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

    public void baseBoard(){
       for (int a = 1; a < 4; a++){
           for (int b = 0; b < 4; b++){
               for (int c = 0; c < 4; c++){
                   if (a >= b && b >= c){
                       System.out.println(a + " " + b + " " + c);
                   }

               }
           }

       }
    }


    public void oneMove(int a, int b, int c) {
        int tempA = a;
        int tempB = b;
        int tempC = c;
        System.out.println("Printing out all possible one moves");
        System.out.println("base board: " + a + " " + b + " " + c);
        if (c != 0) {
            for (int i = c; i > 0; i--) {
                tempC = tempC - 1;
                System.out.println(a + " " + b + " " + tempC);
            }
        }
        if (tempC == 0 && b > c) {
            for (int i = b; i > c; i--) {
                tempB = tempB - 1;
                System.out.println(a + " " + tempB + " " + c);
            }
        }
        tempC = c;
        if (tempB == c) {
            for (int i = tempB; i > 0; i--) {
                tempB = tempB - 1;
                tempC = tempC - 1;
                System.out.println(a + " " + tempB + " " + tempC);
            }
        }
        tempA = a;
        tempB = b;
        tempC = c;

        if (a > b) {
            if (b == c) {
                for (int i = 1; i > 0; i--) {
                    tempA = tempA - 1;
                    System.out.println(tempA + " " + tempB + " " + tempC);
                }
            }
            if (b > c) {
                for (int i = 1; i > 0; i--) {
                    tempA = tempA - 1;
                    tempB = tempB - 1;
                    tempC = tempC - 1;
                    System.out.println(tempA + " " + tempB + " " + tempC);
                }
            }
        }

        a = tempA;
        b = tempB;
        c = tempC;

        if (a == b) {
            if (b > c) {
                for (int i = 1; i > 0; i--) {
                    tempA = tempA - 1;
                    tempB = tempB - 1;
                    System.out.println(tempA + " " + tempB + " " + tempC);
                    b = tempB;
                }
            }
            if (b == c) {
                for (int i = tempB; i > 0; i--) {
                    tempA = tempA - 1;
                    tempB = tempB - 1;
                    tempC = tempC - 1;
                    System.out.println(tempA + " " + tempB + " " + tempC);
                }
            }
        }

    }}
