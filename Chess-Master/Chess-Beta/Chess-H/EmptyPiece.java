package Chess;

public class EmptyPiece extends Piece {
    public EmptyPiece() {
        super("-", "N/A", 0);
    }

    public void move(Board board, String p, String oldLetter, int oldNumber, String newLetter, int newNumber) {
        if(!canMove(board, p, oldLetter, oldNumber, newLetter, newNumber)) {
            System.out.printf("You can't move an empty space from %s%d\n", oldLetter, oldNumber);
        }
    }

    public boolean canMove(Board board, String p, String oldLetter, int oldNumber, String newLeString, int newNumber) {
        return false;
    }
}
