package com.bridgelabz.tictactoe;
import java.util.*;
import java.util.Random;
public class TicTacToe {
	static char[] board= new char[10];
	static char playerPawn,computer;
	static Scanner sc= new Scanner(System.in);
	public static boolean playerStarts;
	public static char win;
	private static int playLocation;
	private static boolean playerWinToss;
	private static boolean checkWinner = false;
	public static final Random randomGenerator = new Random();
		public static void main(String args[])
		{
			System.out.println("TICTACTOE GAME");
			createBoard();
			choosePawn();
			checkToss();
			//showBoard();
			//nextMove();
		    //isWinner();
			startGame();
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
		static void nextMove() 
		{
			System.out.println("Enter the part of the board you want to make your move - 1 to 9");
			int userInput = sc.nextInt();
			if(playerMove(userInput))
				board[userInput] = playerPawn;
			else {
				System.out.println("Cell already taken");
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
		
		public static void userMove() 
		{
			System.out.println("Player'S Turn");
			System.out.println("Enter from 1-9 to make a next move");
			while (true) {
				playLocation = sc.nextInt();
				sc.nextLine();
				if (isEmpty(playLocation) && playLocation < 10 && playLocation > 0) {
					board[playLocation] = playerPawn;
					showBoard();
					break;
				} else {
					System.out.println("Invalid Choice");

				}
			}
		}

		
		public static void computerMove()
		{
			System.out.println("Computer's Turn");
			do {		
				if (predictWinLocationAndBlock()) {
					occupyCornerOfBoard();
					if (occupyCenterOfBoard()) {
					}
					if (occupyOther()) {
					}
					if (predictWinLocationAndBlock()) {
					}
				}
			} while (!isEmpty(playLocation));
			board[playLocation] = computer;
		}
		public static void occupyCornerOfBoard()
		{
			
			int[] cornerOnBoard = { 1, 3, 7, 9 };
			int corner = randomGenerator.nextInt(3);
			playLocation = cornerOnBoard[corner];
		}

		
		public static boolean occupyCenterOfBoard() {
			if (board[1] != ' ' && board[3] != ' ' && board[7] != ' ' && board[9] != ' ') {
				if (isEmpty(5)) {
					playLocation = 5;
					return true;
				}
			}
			return false;
		}

		public static boolean occupyOther() {
			if (board[1] != ' ' && board[3] != ' ' && board[7] != ' ' && board[9] != ' ' && board[5] != ' ') {
				int[] notCorners = { 2, 4, 6, 8 };
				int notCorner = randomGenerator.nextInt(3);
				if (isEmpty(notCorners[notCorner])) {
					playLocation = notCorners[notCorner];
					return true;
				}
			}
			return false;
		}
		public static boolean predictWinLocationAndBlock()
		{
			if (board[1] == computer && board[2] == computer && board[3] == ' ')
			{
				playLocation = 3;
				return true;
			}
			if (board[1] == computer && board[3] == computer && board[2] == ' ') 
			{
				playLocation = 2;
				return true;
			}
			if (board[3] == computer && board[2] == computer && board[1] == ' ')
			{
				playLocation = 1;
				return true;
			}
			if (board[4] == computer && board[5] == computer && board[6] == ' ') 
			{
				playLocation = 6;
				return true;
			}
			if (board[4] == computer && board[6] == computer && board[5] == ' ')
			{
				playLocation = 5;
				return true;
			}
			if (board[6] == computer && board[5] == computer && board[4] == ' ')
			{
				playLocation = 4;
				return true;
			}
			if (board[7] == computer && board[8] == computer && board[9] == ' ')
			{
				playLocation = 9;
				return true;
			}
			if (board[7] == computer && board[9] == computer && board[8] == ' ')
			{
				playLocation = 8;
				return true;
			}
			if (board[9] == computer && board[8] == computer && board[7] == ' ') 
			{
				playLocation = 7;
				return true;
			}
			if (board[7] == computer && board[5] == computer && board[3] == ' ') 
			{
				playLocation = 3;
				return true;
			} 
			if (board[1] == computer && board[4] == computer && board[7] == ' ')
			{
				playLocation = 7;
				return true;
			}
			if (board[1] == computer && board[7] == computer && board[4] == ' ')
			{
				playLocation = 4;
				return true;
			}
			if (board[7] == computer && board[4] == computer && board[1] == ' ')
			{
				playLocation = 1;
				return true;
			}
			if (board[2] == computer && board[5] == computer && board[8] == ' ') 
			{
				playLocation = 8;
				return true;
			}
			if (board[2] == computer && board[8] == computer && board[5] == ' ')
			{
				playLocation = 5;
				return true;
			}
			if (board[8] == computer && board[5] == computer && board[2] == ' ')
			{
				playLocation = 2;
				return true;
			}
			if (board[3] == computer && board[6] == computer && board[9] == ' ')
			{
				playLocation = 9;
				return true;
			}
			if (board[3] == computer && board[9] == computer && board[6] == ' ') 
			{
				playLocation = 6;
				return true;
			}
			if (board[9] == computer && board[6] == computer && board[3] == ' ')
			{
				playLocation = 3;
				return true;
			}
			if (board[1] == computer && board[5] == computer && board[9] == ' ')
			{
				playLocation = 9;
				return true;
			}
			if (board[1] == computer && board[9] == computer && board[5] == ' ') 
			{
				playLocation = 5;
				return true;
			}
			if (board[9] == computer && board[5] == computer && board[1] == ' ') 
			{
				playLocation = 1;
				return true;
			}
			if (board[3] == computer && board[5] == computer && board[7] == ' ')
			{
				playLocation = 7;
				return true;
			}
			if (board[3] == computer && board[7] == computer && board[5] == ' ')
			{
				playLocation = 5;
				return true;
			}
			if (board[1] == playerPawn && board[2] == playerPawn && board[3] == ' ')
			{
				playLocation = 3;
				return true;
			}
			if (board[1] == playerPawn && board[3] == playerPawn && board[2] == ' ') 
			{
				playLocation = 2;
				return true;
			}
			if (board[3] == playerPawn && board[2] == playerPawn && board[1] == ' ')
			{
				playLocation = 1;
				return true;
			}
			if (board[4] == playerPawn && board[5] == playerPawn && board[6] == ' ') 
			{
				playLocation = 6;
				return true;
			}
			if (board[4] == playerPawn && board[6] == playerPawn && board[5] == ' ')
			{
				playLocation = 5;
				return true;
			}
			if (board[6] == playerPawn && board[5] == playerPawn && board[4] == ' ')
			{
				playLocation = 4;
				return true;
			}
			if (board[7] == playerPawn && board[8] == playerPawn && board[9] == ' ')
			{
				playLocation = 9;
				return true;
			}
			if (board[7] == playerPawn && board[9] == playerPawn && board[8] == ' ')
			{
				playLocation = 8;
				return true;
			}
			if (board[9] == playerPawn && board[8] == playerPawn && board[7] == ' ') 
			{
				playLocation = 7;
				return true;
			}
			if (board[7] == playerPawn && board[5] == playerPawn && board[3] == ' ') 
			{
				playLocation = 3;
				return true;
			} 
			if (board[1] == playerPawn && board[4] == playerPawn && board[7] == ' ')
			{
				playLocation = 7;
				return true;
			}
			if (board[1] == playerPawn && board[7] == playerPawn && board[4] == ' ')
			{
				playLocation = 4;
				return true;
			}
			if (board[7] == playerPawn && board[4] == playerPawn && board[1] == ' ')
			{
				playLocation = 1;
				return true;
			}
			if (board[2] == playerPawn && board[5] == playerPawn && board[8] == ' ') 
			{
				playLocation = 8;
				return true;
			}
			if (board[2] == playerPawn && board[8] == playerPawn && board[5] == ' ')
			{
				playLocation = 5;
				return true;
			}
			if (board[8] == playerPawn && board[5] == playerPawn && board[2] == ' ')
			{
				playLocation = 2;
				return true;
			}
			if (board[3] == playerPawn && board[6] == playerPawn && board[9] == ' ')
			{
				playLocation = 9;
				return true;
			}
			if (board[3] == playerPawn && board[9] == playerPawn && board[6] == ' ') 
			{
				playLocation = 6;
				return true;
			}
			if (board[9] == playerPawn && board[6] == playerPawn && board[3] == ' ')
			{
				playLocation = 3;
				return true;
			}
			if (board[1] == playerPawn && board[5] == playerPawn && board[9] == ' ')
			{
				playLocation = 9;
				return true;
			}
			if (board[1] == playerPawn && board[9] == playerPawn && board[5] == ' ') 
			{
				playLocation = 5;
				return true;
			}
			if (board[9] == playerPawn && board[5] == playerPawn && board[1] == ' ') 
			{
				playLocation = 1;
				return true;
			}
			if (board[3] == playerPawn && board[5] == playerPawn && board[7] == ' ')
			{
				playLocation = 7;
				return true;
			}
			if (board[3] == playerPawn && board[7] == playerPawn && board[5] == ' ')
			{
				playLocation = 5;
				return true;
			}
			else
				return false;
		}
		public static boolean isWinner() 
		{
			if (checkWinner)
				return true;
			if ((board[1] == computer && board[2] == computer && board[3] == computer)
					|| (board[4] == computer && board[5] == computer && board[6] == computer)
					|| (board[7] == computer && board[8] == computer && board[9] == computer)
					|| (board[1] == computer && board[4] == computer && board[7] == computer)
					|| (board[2] == computer && board[5] == computer && board[8] == computer)
					|| (board[3] == computer && board[6] == computer && board[9] == computer)
					|| (board[1] == computer && board[5] == computer && board[9] == computer)
					|| (board[3] == computer && board[5] == computer && board[7] == computer)) {
				System.out.println("Computer Won");
				checkWinner = true;
				return true;
			}
			if ((board[1] == playerPawn && board[2] == playerPawn && board[3] == playerPawn)
					|| (board[4] == playerPawn && board[5] == playerPawn && board[6] == playerPawn)
					|| (board[7] == playerPawn && board[8] == playerPawn && board[9] == playerPawn)
					|| (board[1] == playerPawn && board[4] == playerPawn && board[7] == playerPawn)
					|| (board[2] == playerPawn && board[5] == playerPawn && board[8] == playerPawn)
					|| (board[3] == playerPawn && board[6] == playerPawn && board[9] == playerPawn)
					|| (board[1] == playerPawn && board[5] == playerPawn && board[9] == playerPawn)
					|| (board[3] == playerPawn && board[5] == playerPawn && board[7] == playerPawn)) {
				System.out.println("Player Won");
				checkWinner = true;
				return true;
			}

			return false;
		}
		public static boolean isEmpty(int location) 
		{
			return board[location] == ' ';

		}
		public static boolean checkIfBoardFull() 
		{
			if ((board[1] != ' ') && (board[2] != ' ') && (board[3] != ' ') && (board[4] != ' ') && (board[5] != ' ')&& (board[6] != ' ') && (board[7] != ' ') && (board[8] != ' ') && (board[9] != ' ')) {

				return true;
			}
			return false;
		}
		public static void startGame() 
		{
			do {
				if (playerWinToss) {
					userMove();
					if (!checkIfBoardFull())
						computerMove();
				} else {
					computerMove();
					if (!checkIfBoardFull())
						userMove();
				}
			} while (!isWinner() && !checkIfBoardFull());
			if (checkIfBoardFull() && !isWinner())
				System.out.println("Game TIED.");

		}

}
