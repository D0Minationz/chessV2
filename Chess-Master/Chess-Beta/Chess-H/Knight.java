package Chess;

public class Knight extends Piece {
    public Knight(String color) {
        super("H", color, 3);
    }

    public void move(Board board, String p, String oldLetter, int oldNumber, String newLetter, int newNumber) {
        if(canMove(board, p, oldLetter, oldNumber, newLetter, newNumber)) {
            board.setPiece(board.translate(oldLetter, oldNumber), getRow(newNumber), getCol(newLetter));
            board.removePiece(getRow(oldNumber), getCol(oldLetter));
        } else {
            if(samePosition(oldLetter, oldNumber, newLetter, newNumber)) {
                System.out.printf("%s at %s%d can't move to itself at %s%d.\n",
                 "Knight", oldLetter, oldNumber, newLetter, newNumber);
            } else {
                System.out.printf("%s at %s%d can't move to %s%d\n", "Knight", 
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

        return true;
    }
}