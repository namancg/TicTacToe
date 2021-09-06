package com.bridgelabz.tictactoe;
import java.util.*;
public class TicTacToe {
	static char[] board= new char[10];
	static char playerPawn,computer;
	static Scanner sc= new Scanner(System.in);
	public static boolean playerStarts;
		public static void main(String args[])
		{
			System.out.println("TICTACTOE GAME");
			createBoard();
			choosePawn();
			checkToss();
			//showBoard();
			desiredMove();
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
			 	System.out.println( board[1] + "|" + board[2]  + "|" + board[3] + "  ");
		        System.out.println( board[4] + "|" + board[5]  + "|" + board[6] + "  ");
		        System.out.println( board[7] + "|" + board[8]  + "|" + board[9] + "  ");
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
}
