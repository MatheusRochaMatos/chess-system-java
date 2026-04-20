package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.exceptions.ChessException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces());
				IO.println();
				IO.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				IO.println();
				IO.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			}
			catch(ChessException e) {
				IO.print(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				IO.print(e.getMessage());
				sc.nextLine();
			}
		}
		
	}
}
