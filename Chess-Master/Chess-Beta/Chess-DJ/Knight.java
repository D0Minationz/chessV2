package ser120.chess;
import ser120.chess.models.Board;

public class Knight extends Piece {
	
    public Knight(boolean white){
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
        // L-shape movement
        if((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)){
            return true;
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
		return firstLetter + "n";
	}

}
