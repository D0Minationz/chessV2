package ser120.chess;
import ser120.chess.models.Board;

public class Queen extends Piece {

    public Queen(boolean white){
        super(white);
    }

    @Override
    public boolean canMove(Board board, int newRow, int newCol, int oldRow, int oldCol){

        Piece target = board.getPiece(newRow, newCol);

        // can't land on your own piece
        if(target != null && target.isWhite() == this.isWhite()){
            return false;
        }
        int rowDiff = Math.abs(newRow - oldRow);
        int colDiff = Math.abs(newCol - oldCol);
        if(newRow == oldRow || newCol == oldCol){
            // horizontal
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
                        return false;
                    }
                    col += step;
                }
            }
            // vertical
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
                        return false;
                    }
                    row += step;
                }
            }
            return true;
        }
        if(rowDiff == colDiff){
            int rowStep;
            int colStep;

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
            while(row != newRow && col != newCol){
                if(board.getPiece(row, col) != null){
                    return false;
                }
                row = row + rowStep;
                col = col + colStep;
            }
            return true;
        }
        // invalid move
        return false;
    }
    
    public String getSymbol(){
		String firstLetter = "";
		if(white){
			firstLetter = "w";
		}else{
			firstLetter = "b";
		}
		return firstLetter + "q";
	}
}
