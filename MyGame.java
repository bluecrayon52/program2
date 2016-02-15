/*  
 * Author: Nathaniel Clay Arnold
 * Program 2 - MyGame
 * CSC230-02 Spring 2016
 */
package mygame;

import java.util.Scanner;
import java.util.InputMismatchException; 

public class MyGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        boolean Exception;
        String playAgain;
        boolean Again;

        do {
            Again = false;
            C4 testGame = new C4();

            System.out.println("Let's Play " + testGame.getName() + "\n");

            do {
                testGame.printBoard();
                System.out.print("Player " + testGame.getTurn()
                        + " choose a column: ");
                do {
                    try {
                        Exception = false;
                        testGame.playPiece(kb.nextInt());

                        testGame.nextturn(); 
                    } 
                    
                    catch (ArrayIndexOutOfBoundsException ex) {
                        Exception = true;
                        System.out.print("This column is out of bounds\n"
                                + "choose another column: ");
                    } 
                    
                    catch (ColFullException ex) {
                        Exception = true;
                        System.out.print("This column is full\n"
                                + "choose another column: ");
                    }
                    
                    catch (InputMismatchException ex){
                        Exception = true; 
                        System.out.println("Invalid input.");
                    }
                    

                } while (Exception == true);

            } while(testGame.isWinner() == false && testGame.isFull() == false);

            testGame.printBoard();

            testGame.nextturn();

            System.out.println("Player " + testGame.currentTurn()
                    + " is the winner");

            int validate;

            kb.nextLine();
            do {
                System.out.print("Do you want to play again?(Y/N): ");

                playAgain = kb.nextLine();
                validate = 0;

                if (playAgain.equalsIgnoreCase("y")) {
                    Again = true;

                } else if (playAgain.equalsIgnoreCase("n")) {
                    System.out.println("Thanks for playing " + testGame.getName()
                            + ", goodbye!");
                } else {
                    System.out.println("Invalid entry");
                    validate = 1;
                }

            } while (validate == 1);

        } while (Again == true);
    }
}
