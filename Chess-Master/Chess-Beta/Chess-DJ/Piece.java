package ser120.chess;
import ser120.chess.models.Board;

public abstract class Piece {

    
    protected boolean white = false;

    public Piece(boolean white){
        this.setWhite(white);
    }

    public boolean isWhite(){
        return this.white;
    }

    public void setWhite(boolean white){
        this.white = white;
    }
    
    String name;
    public Piece(String name){
		this.name = name;
	}

    public abstract boolean canMove(Board board, int newRow, int newCol, int oldRow, int oldCol);
    
    public abstract String getSymbol();
}
