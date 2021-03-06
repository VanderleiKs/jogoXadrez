package aplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class App {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		
		
		while(!chessMatch.getCheckMate()) {
			try {
				UI.clearScreen();	
				UI.printMatch(chessMatch, captured);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(scan);
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPiece(), possibleMoves);
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(scan);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
				if(capturedPiece != null) {
					captured.add(capturedPiece);
				}
				
				if(chessMatch.getPromoted() != null) {
					System.out.print("Enter with piece for promotion (B/N/Q/R): ");
					String type = scan.nextLine().toUpperCase();
					while(!type.equals("B") && !type.equals("N") && !type.equals("Q") && !type.equals("R")){
						System.out.print("Invalid piece, Enter with piece for promotion (B/N/Q/R): ");
						type = scan.nextLine().toUpperCase();
					}
					chessMatch.replacePromotedPiece(type);
				}

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
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
	}

}
