package aplication;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class App {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ChessMatch b = new ChessMatch();
		
		
		while(true) {
			try {
				UI.clearScreen();	
				UI.printBoard(b.getPiece());
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(scan);
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(scan);
				
				ChessPiece capturedPiece = b.performChessMove(source, target);

			}
			catch(ChessException ex){
				System.out.println(ex.getMessage());
				scan.nextLine();
			}
			catch(InputMismatchException ex) {
				System.out.println(ex.getMessage());
				scan.nextLine();
			}
		}
	}

}
