package ser120.chess;
import ser120.chess.models.Board;

public class King extends Piece {

    public King(boolean white){
        super(white);
    }

    @Override
	public boolean canMove(Board board, int newRow, int newCol, int oldRow, int oldCol){

		// get the piece at destination
		Piece target = board.getPiece(newRow, newCol);

		// can't land on your own piece
		if(target != null && target.isWhite() == this.isWhite()){
			return false;
		}
		int rowDiff = Math.abs(newRow - oldRow);
		int colDiff = Math.abs(newCol - oldCol);
		// King moves 1 square in any direction
		if(rowDiff <= 1 && colDiff <= 1){
			return true;
		}
		// anything else is invalid (for now)
		return false;
	}
	public String getSymbol(){
		String firstLetter = "";
		if(white){
			firstLetter = "w";
		}else{
			firstLetter = "b";
		}
		return firstLetter + "k";
	}
}
