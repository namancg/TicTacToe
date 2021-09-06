package com.bridgelabz.tictactoe;
import java.util.*;
public class TicTacToe {
	static char[] board= new char[10];
	static char playerPawn,computer;
	static Scanner sc= new Scanner(System.in);
	public static boolean playerStarts;
	public static char win;
		public static void main(String args[])
		{
			System.out.println("TICTACTOE GAME");
			createBoard();
			choosePawn();
			checkToss();
			//showBoard();
			desiredMove();
			isWinner();
		}
		static void createBoard() {
			for( int i=1;i<10;i++)
			{
					board[i]=' ';
			}
		}
		static void choosePawn() {
			System.out.println("CHOOSE THE PAWN TO PLAY WITH");
			playerPawn = Character.toUpperCase(sc.next().charAt(0));
			if(playerPawn == 'X')
			{
				System.out.println("YOU HAVE CHOSEN X");
				computer ='O';
				
			}
			else
				computer ='X';
		}
		static void showBoard()
		{
			for (int i = 1; i < 10; i++) {
			System.out.print(board[i] + "|");
			if (i % 3 == 0) {
				System.out.print("\n      \n");
			}
		}
		}
		static boolean playerMove(int userInput) 
		{
			if(board[userInput] == 'O' && board[userInput] == 'X') {
				return false;
			}
			else {
				System.out.println("GO AHEAD AND MAKE YOUR MOVE");
				return true;
			}
		}
		static void desiredMove() 
		{
			System.out.println("Enter the part of the board you want to make your move - 1 to 9");
			int userInput = sc.nextInt();
			if(playerMove(userInput))
				board[userInput] = playerPawn;
			else {
				System.out.println("Cell already occupied!. Choose a different cell;");
			}
			showBoard();
		}
		public static void checkToss() {
			int playerPos = 1;
			double tossResult = Math.floor(Math.random() * 10) % 2;
			if (tossResult == playerPos) 
			{
				playerStarts = true;
				System.out.println("PLAYER WON THE TOSS");
			} else 
			{
				playerStarts = false;
				System.out.println("COMPUTER WON THE TOSS");
			}
		}

		public static String isWinner() {
			System.out.println();
			if ((board[1] == board[2]) && (board[2] == board[3])) {
				if (playerPawn == board[1]) {
					return "Player Won this game";
				} else if (computer == board[1]) {
					return "Computer Won this game";
				}
			} else if ((board[4] == board[5]) && (board[5] == board[6])) {
				if (playerPawn == board[4]) {
					return "Player Won this game";
				} else if (computer == board[4]) {
					return "Computer Won this game";
				}
			} else if ((board[7] == board[8]) && (board[8] == board[9])) {
				if (playerPawn == board[7]) {
					return "Player Won this game";
				} else if (computer == board[7]) {
					return "Computer Won this game";
				}
			} else  if ((board[2] == board[5]) && (board[5] == board[8])) {
				if (playerPawn == board[2]) {
					return "Player Won this game";
				} else if (computer == board[2]) {
					return "Computer Won this game";
				}
			} else if ((board[3] == board[5]) && (board[5] == board[7])) {
				if (playerPawn == board[3]) {
					return "Player Won this game";
				} else if (computer == board[3]) {
					return "Computer Won this game";
				}
			} else if ((board[1] == board[4]) && (board[4] == board[7])) {
				if (playerPawn == board[4]) {
					return "Player Won this game";
				} else if (computer == board[4]) {
					return "Computer Won this game";
				}
			} else if ((board[1] == board[5]) && (board[5] == board[9])) {
				if (playerPawn == board[1]) {
					return "Player Won this game";
				} else if (computer == board[1]) {
					return "Computer Won this game";
				}
			} else if ((board[3] == board[6]) && (board[6] == board[9])) {
				if (playerPawn == board[3]) {
					return "Player Won this game";
				} else if (computer == board[3]) {
					return "Computer Won this game";
				}
			} else {
				return "Draw";
			}
			return "";
		}
}
