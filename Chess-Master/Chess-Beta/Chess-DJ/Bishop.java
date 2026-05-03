package ser120.chess;
import ser120.chess.models.Board;

public class Bishop extends Piece {
	
    public Bishop(boolean white){
        super(white);
    }
	
    @Override
    public boolean canMove(Board board, int newRow, int newCol, int oldRow, int oldCol){
        //get destination piece
        Piece target = board.getPiece(newRow, newCol);
        //can't land on your own piece
        if(target != null && target.isWhite() == this.isWhite()){
            return false;
        }
        //must move diagonally
        if(Math.abs(newRow - oldRow) != Math.abs(newCol - oldCol)){
            return false;
        }
        int rowStep;
        int colStep;
        //determine direction
        if(newRow > oldRow){
            rowStep = 1;
        }else{
            rowStep = -1;
        }
        if(newCol > oldCol){
            colStep = 1;
        }else{
            colStep = -1;
        }
        int row = oldRow + rowStep;
        int col = oldCol + colStep;
        // check path
        while(row != newRow && col != newCol){
            if(board.getPiece(row, col) != null){
                return false; // blocked
            }
            row = row + rowStep;
            col = col + colStep;
        }
        return true;
    }
    
    public String getSymbol(){
		String firstLetter = "";
		if(white){
			firstLetter = "w";
		}else{
			firstLetter = "b";
		}
		return firstLetter + "b";
	}
}
