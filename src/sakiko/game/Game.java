package sakiko.game;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


/**
 * Author: Sakiko
 * Date: 10 August 2015
 * Version: 1.0
 * Description: This is a text-based game for user to guess 
 * 				the secret number.
 * Copyrights: All rights reserved.
 */

public class Game {
	
	int secretNum;
	int guess;
	int attempt = 0;
	boolean gameOver = false;
	private Scanner scan;
	
	// game loop
	public void gameLoop() {
		getSecretNum();
		
		while (!gameOver) {
			if(attempt < 10) {
				getUserInput();
				
			} else {
				messageGameOver();
				gameOver = true;
			}
		}
	}
	
	// get random secret number
	private int getSecretNum() {
		Random rand = new Random();
		secretNum = rand.nextInt(100) + 1;
		return secretNum;
	}
	
	// get user's input
	private int getUserInput() {

		try {
			scan = new Scanner(System.in);
			System.out.println("Enter your guess: ");
			guess = scan.nextInt();
			checkUserGuess();
		} catch (InputMismatchException e) {
			System.out.println("Please enter number only!");
		}
		return guess;
	}
	
	// check user's guess
	private boolean checkUserGuess() {
	
		if(guess < secretNum) {
			attempt++;
			messageTooSmall();
		}else if(guess > secretNum) {
			attempt++;
			messageTooBig();
		}else {
			messageCorrect();
			gameOver = true;
		}
		return gameOver;
	}
	
	// display message for too small guess
	private void messageTooSmall() {
		System.out.println("Too small!");
		System.out.println("This is your failed attempt " + attempt + "\n");
	}
	
	// display message for too big guess 
	private void messageTooBig() {
		System.out.println("Too big!");
		System.out.println("This is your failed attempt " + attempt + "\n");
	}
	
	// display message for correct guess
	private void messageCorrect() {
		System.out.println("Correct! You won the game! Congrats!");
	}
	
	// display message for gameOver
	private void messageGameOver() {
		System.out.println("Game Over!");
	}
		
	// main method
	public static void main(String[] args) {
		new Game().gameLoop();
	}
}
