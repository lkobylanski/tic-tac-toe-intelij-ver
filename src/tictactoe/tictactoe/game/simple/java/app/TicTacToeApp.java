/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoe.game.simple.java.app;

import java.util.Scanner;

/**
 *
 * @author lukas
 */
public class TicTacToeApp {
    
    // Set winning condition
    static boolean thereIsAWinner = false;

    public static void main(String[] args) {
        // Create new board using utility class
        String[][] gameBoard = UtilityClassDisplayBoard.createEmptyBoard();

        // Display empty board ready to be played
        UtilityClassDisplayBoard.displayCurrentBoardState(gameBoard);

        // Create new match TicTacToeMatch class instance - representing the whole match that will be played
        TicTacToeMatch newMatch = new TicTacToeMatch(gameBoard);

        // Create do while loop - which will call repeatedly makeAMove and checkIfThereIsWinner methods until someone will win
        do {
            newMatch.makeAMove(gameBoard);
            thereIsAWinner = newMatch.checkIfThereIsWinner();
        } while (!thereIsAWinner);
        
        System.out.println();
        System.out.printf("!!!  GAME OVER !!!\n\nThe winning player is: the player %s. \nCongratulations!%n", newMatch.isWinner);
        System.out.println();
        System.out.println("* * * * * *");
        System.out.println();
        System.out.printf("The winning sequence achieved by the player %s is: %n", newMatch.isWinner);
        
        // Winning sequence and the winner are set by the makeAMove method in an instance of TicTacToeMatch - newMatch in our case
        // Those object properties are passed as arguments to utility calls to clearly display winning sequence
        UtilityClassDisplayBoard.displayWinningSequence(newMatch.winningSequence, newMatch.isWinner);
        
        System.out.println();
        System.out.println("Thank you for playing! :)");
    }
}
