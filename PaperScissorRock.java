package com.project.game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PaperScissorRock {

	final static int ROCK = 1, SCISSOR = 2, PAPER = 3;
	final static String playA = "A";
	final static String playB = "B";

	static int playerScoreA = 0;
	static int playerScoreB = 0;
	static int tieScore = 0;
	static int round = 100;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		showMenu();

		int count = 1;
		while (count <= round) {
			pintRounds(count);
			playerSelect(playA);

			try {
				int playerA = scan.nextInt();
				if (checkInput(playerA)) {
					playerSelect(playB);
					int playerB = scan.nextInt();
					if (checkInput(playerB)) {
						playersPlay(playerA, playerB);
						count++;
					} else {
						printInvalid();
					}
				} else {
					printInvalid();
				}
			} catch (InputMismatchException e) {
				printInvalid();
				scan.next();
			} catch (Exception e) {
				scan.next();
			}
			
		}
		printResult(playerScoreA, playerScoreB);
	}

	public static boolean checkInput(int player) {
		if (player >= 1 && player <= 3) {
			return true;
		}
		return false;
	}

	public static void printResult(int playerScoreA, int playerScoreB) {
		printPlayer(playA, playerScoreA);
		printPlayer(playB, playerScoreB);
		printTie();

		if (playerScoreA > playerScoreB) {
			printPlayerWin(playA, playerScoreA, playerScoreB);
		} else if (playerScoreB > playerScoreA) {
			printPlayerWin(playB, playerScoreB, playerScoreA);
		} else {
			printDraw();
		}
	}

	public static void playersPlay(int playerA, int playerB) {

		if (playerA == playerB) {
			printDraw();
			tieScore++;
		} else {
			switch (playerA) {
			case ROCK:
				if (playerB == SCISSOR) {
					printWinner(playA);
					playerScoreA++;
				} else {
					printWinner(playB);
					playerScoreB++;
				}
				break;
			case SCISSOR:
				if (playerB == PAPER) {
					printWinner(playA);
					playerScoreA++;
				} else {
					printWinner(playB);
					playerScoreB++;
				}
				break;
			case PAPER:
				if (playerB == ROCK) {
					printWinner(playA);
					playerScoreA++;
				} else {
					printWinner(playB);
					playerScoreB++;
				}
				break;
			}
		}
	}

	public static void showMenu() {
		System.out.println("Welcome to Rock Paper Scissor Game!");
		System.out.println("Choose (1) for ROCK");
		System.out.println("Choose (2) for SCISSOR");
		System.out.println("Choose (3) for PAPER\n\n");
	}

	static void playerSelect(String pSel) {
		System.out.print("Player " + pSel + " select: ");
	}

	public static void pintRounds(int count) {
		System.out.println("Round " + count + " of " + round);
	}

	public static void printWinner(String win) {
		System.out.println("PLAYER " + win + " WINS!\n");
	}

	public static void printInvalid() {
		System.out.println("Invalid input!\n");
	}

	public static void printDraw() {
		System.out.println("DRAW!\n");
	}

	public static void printTie() {
		System.out.println("Tie: " + tieScore + " of " + round + " games");
	}

	public static void printPlayer(String win, int playerScore) {
		System.out.println("Player " + win + " wins " + playerScore + " of " + round + " games");
	}

	public static void printPlayerWin(String player, int playerWin, int playerLost) {
		System.out.println("Winner is Player " + player + " (" + playerWin + " to " + playerLost + " wins)");
	}

}
