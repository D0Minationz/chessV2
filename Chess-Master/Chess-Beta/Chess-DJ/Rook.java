package ser120.chess;
import ser120.chess.models.Board;

public class Rook extends Piece {
	
	public Rook(boolean white){
        super(white);
    }
	
	@Override
    public boolean canMove(Board board, int newRow, int newCol, int oldRow, int oldCol){
        // get destination piece
        Piece target = board.getPiece(newRow, newCol);
        // can't land on your own piece
        if(target != null && target.isWhite() == this.isWhite()){
            return false;
        }
        // must move in straight line
        if(newRow != oldRow && newCol != oldCol){
            return false;
        }
        // moving horizontally
        if(newRow == oldRow){
            int step;
            if(newCol > oldCol){
                step = 1;
            }else{
                step = -1;
            }
            int col = oldCol + step;
            while(col != newCol){
                if(board.getPiece(oldRow, col) != null){
                    return false; // blocked
                }
                col += step;
            }
        }
        // moving vertically
        if(newCol == oldCol){
            int step;
            if(newRow > oldRow){
                step = 1;
            }else{
                step = -1;
            }
            int row = oldRow + step;
            while(row != newRow){
                if(board.getPiece(row, oldCol) != null){
                    return false; // blocked
                }
                row += step;
            }
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
		return firstLetter + "r";
	}
        
	
	
}
