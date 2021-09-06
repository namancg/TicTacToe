package com.bridgelabz.tictactoe;
import java.util.*;
public class TicTacToe {
	static char[] board= new char[10];
	static char playerPawn,computer;
	static Scanner sc= new Scanner(System.in);
		public static void main(String args[])
		{
			System.out.println("TICTACTOE GAME");
			createBoard();
			choosePawn();
			showBoard();
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
}
