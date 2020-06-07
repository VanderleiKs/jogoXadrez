package aplication;

import chess.ChessMatch;

public class App {

	public static void main(String[] args) {
		
		ChessMatch b = new ChessMatch();
		
		UI.printBoard(b.getPiece());
		
		
	}

}
