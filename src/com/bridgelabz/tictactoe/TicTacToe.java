package com.bridgelabz.tictactoe;

public class TicTacToe {
	static char[] board= new char[10];
		public static void main(String args[])
		{
			System.out.println("TICTACTOE GAME");
			createBoard();
			
		}
		static void createBoard() {
			for( int i=0;i<10;i++)
			{
					board[i]=' ';
			}
		}
}
