package aplication;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class App {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ChessMatch b = new ChessMatch();
		
		
		while(true) {
		UI.printBoard(b.getPiece());
		System.out.println();
		System.out.print("Source: ");
		ChessPosition source = UI.readChessPosition(scan);
		
		System.out.println();
		System.out.print("Target: ");
		ChessPosition target = UI.readChessPosition(scan);
		
		ChessPiece capturedPiece = b.performChessMove(source, target);

		
		}
	}

}
