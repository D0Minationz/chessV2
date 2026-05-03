package Chess;

public class Queen extends Piece {
    public Queen(String color) {
        super("Q", color, 7);
    }

    public void move(Board board, String p, String oldLetter, int oldNumber, String newLetter, int newNumber) {
        if(canMove(board, p, oldLetter, oldNumber, newLetter, newNumber)) {
            board.setPiece(board.translate(oldLetter, oldNumber), getRow(newNumber), getCol(newLetter));
            board.removePiece(getRow(oldNumber), getCol(oldLetter));
        } else {
            if(samePosition(oldLetter, oldNumber, newLetter, newNumber)) {
                System.out.printf("%s at %s%d can't move to itself at %s%d.\n",
                 "Queen", oldLetter, oldNumber, newLetter, newNumber);
            } else {
                System.out.printf("%s at %s%d can't move to %s%d\n", "Queen", 
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
            for (int i = getRow(newNumber); i <= rowDifference && i != 1; i--) {
                // System.out.println("Checking: " + i + ", " + oldCol);
                if(board.getBoardData(i, getCol(oldLetter)) != "-") {
                    // System.out.println("Issue: " + i + ", " + oldCol);
                    return false;
                }
            }
            return true;
        }

        if(colDifference <= getMoves() && rowDifference == 0) {
            for (int i = getCol(newLetter); i <= colDifference && i != 1; i--) {
                if(i == 0) {
                    i = 6;
                }
                //System.out.println("Checking: " + oldRow + ", " + i);
                if(board.getBoardData(getRow(oldNumber), i) != "-") {
                    //System.out.println("Issue: " + oldRow + ", " + i);
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}