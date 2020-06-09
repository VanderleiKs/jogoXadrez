package board;

public abstract class Piece {

	protected Position position;
	
	private Board board;
	
	public Piece(Board board){ 
		this.board = board;
	}
	
	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
		
	public boolean possibleMoves(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
		
	public boolean isThereAnyPossibleMoves() {
		boolean[][] mat = possibleMoves();
		for(int i = 0; i < possibleMoves().length; i++) {
			for(int j = 0 ; j < possibleMoves().length; j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
				
	}
	
	}
	
	

