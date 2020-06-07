package aplication;

import board.Board;
import board.Position;

public class App {

	public static void main(String[] args) {
		
		Position pos = new Position(3, 5);
		System.out.println(pos);
		
		Board b = new Board(3, 5);
		System.out.println(b.piece());
		
	}

}
