package ser120.chess;
import ser120.chess.models.Board;

public class EmptyPiece extends Piece {
	
	public EmptyPiece(boolean white){
        super(white);
    }
	
	@Override
	public boolean canMove(Board board, int newRow, int newCol, int oldRow, int oldCol){

		return false;
	}
	
	public String getSymbol(){
		return "--";
	}
}
