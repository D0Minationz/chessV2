package ser120.chess;
import ser120.chess.models.Board;

public class Pawn extends Piece {
	
	public Pawn(boolean white){
        super(white);
    }
	
	@Override
    public boolean canMove(Board board, int newRow, int newCol, int oldRow, int oldCol){
        // get the piece at destination
		Piece target = board.getPiece(newRow, newCol);
		//can't land on your own piece
		if(target != null && target.isWhite() == this.isWhite()){
			return false;
		}
		int direction;
		//white goes up, black goes down
		if(this.isWhite()){
			direction = -1;
		}else{
			direction = 1;
		}
		//move forward 1 (must be empty)
		if(newCol == oldCol && newRow == oldRow + direction){
			if(target == null){
				return true;
			}
		}
		//capture diagonally
		if(Math.abs(newCol - oldCol) == 1 && newRow == oldRow + direction){
			if(target != null && target.isWhite() != this.isWhite()){
				return true;
			}
		}
		return false;
	}
	
	public String getSymbol(){
		String firstLetter = "";
		if(white){
			firstLetter = "w";
		}else{
			firstLetter = "b";
		}
		return firstLetter + "p";
	}
	
}
