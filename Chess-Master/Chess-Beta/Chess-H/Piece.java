package Chess;
public abstract class Piece extends Board {
    private String piece;
    private String color; 
    private int upToMoves;

    public Piece(String piece, String color, int upToMoves) {
        this.piece = piece;
        this.color = color;
        this.upToMoves = upToMoves;
    }

    abstract void move(Board board, String p, String oldLetter, int oldNumber, String newLetter, int newNumber);
    abstract boolean canMove(Board board, String p, String oldLetter, int oldNumber, String newLetter, int newNumber);
    
    public String getPiece() {
        if(getColor().equalsIgnoreCase("Black")) {
            return piece;
        }
        return piece;
    }

    public String getColor() {
        return color;
    }

    public int getMoves() {
        return upToMoves;
    }

    public void setMoves(int newMoves) {
        upToMoves = newMoves;
    }

    public boolean samePosition(String oldLetter, int oldNumber, String newLetter, int newNumber) {
        int rowDifference = Math.abs(getRow(oldNumber) - getRow(newNumber));
        int colDifference = Math.abs(getCol(oldLetter) - getCol(newLetter));

        if(rowDifference == 0 && colDifference == 0) {
            return true;
        }
        return false;
    }
}
