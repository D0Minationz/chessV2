package Chess;

public class King extends Piece {
    public King(String color) {
        super("K", color, 1);
    }

    public void move(Board board, String p, String oldLetter, int oldNumber, String newLetter, int newNumber) {
        if(canMove(board, p, oldLetter, oldNumber, newLetter, newNumber)) {
            board.setPiece(board.translate(oldLetter, oldNumber), getRow(newNumber), getCol(newLetter));
            board.removePiece(getRow(oldNumber), getCol(oldLetter));
        } else {
            if(samePosition(oldLetter, oldNumber, newLetter, newNumber)) {
                System.out.printf("%s at %s%d can't move to itself at %s%d.\n",
                 "King", oldLetter, oldNumber, newLetter, newNumber);
            } else {
                System.out.printf("%s at %s%d can't move to %s%d\n", "King", 
                oldLetter, oldNumber, newLetter, newNumber);
            }
        }
    }

    public boolean canMove(Board board, String p, String oldLetter, int oldNumber, String newLetter, int newNumber) {
        int rowDifference = Math.abs(getRow(oldNumber) - getRow(newNumber));
        int colDifference = Math.abs(getCol(oldLetter) - getCol(newLetter));

        if(samePosition(oldLetter, oldNumber, newLetter, newNumber)) {
            return false;
        }

        if(rowDifference <= getMoves() && colDifference == 0) {
            if(board.translate(newLetter, newNumber) == "-" || board.translate(newLetter, newNumber) == "P") {
                return true;
            }  
        }
        return false;
    }
}