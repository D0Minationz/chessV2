package Chess;

public class Rook extends Piece {
    public Rook(String color) {
        super("R", color, 7);
    }

    public void move(Board board, String p, String oldLetter, int oldNumber, String newLetter, int newNumber) {
        if(canMove(board, p, oldLetter, oldNumber, newLetter, newNumber)) {
            board.setPiece(board.translate(oldLetter, oldNumber), getRow(newNumber), getCol(newLetter));
            board.removePiece(getRow(oldNumber), getCol(oldLetter));
        } else {
            int colDifference = Math.abs(getCol(oldLetter) - getCol(newLetter));

            if(samePosition(oldLetter, oldNumber, newLetter, newNumber)) {
                System.out.printf("%s at %s%d can't move to itself at %s%d.\n",
                 "Rook", oldLetter, oldNumber, newLetter, newNumber);
            } else if(oldLetter.equals(newLetter) && colDifference > 0 || !oldLetter.equals(newLetter) && colDifference <= getMoves()) {
                System.out.printf("%s at %s%d can't move diagonally to %s%d. \n",
             "Rook", oldLetter, oldNumber, newLetter, newNumber);
            } else {
                System.out.printf("%s at %s%d can't move to %s%d. There is a piece in the way\n",
                 "Rook", oldLetter, oldNumber, newLetter, newNumber);
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
            boolean piecesInWay = false;
            System.out.println("Row Loop:");
            // System.out.println("Row Differemce: " + rowDifference + " Col Difference: " + colDifference);
            for (int i = getCol(newLetter); i < rowDifference; i--) {
                if(getBoardData(i, colDifference) != "-") {
                    return false;
                }
            }

            if(!piecesInWay) {
                return true;
            }
        }

        if(colDifference <= getMoves() && rowDifference == 0) {
            boolean piecesInWay = false;
            System.out.println("Col Loop:");
            //System.out.println("Row Differemce: " + rowDifference + " Col Difference: " + colDifference);
            for (int i = getCol(newLetter); i < rowDifference; i--) {
                if(getBoardData(rowDifference, i) != "-") {
                    piecesInWay = true;
                }
            }

            if(!piecesInWay) {
                return false;
            }
        } else {
            return false;
        }
        System.out.println("Last resort");
        return true;
    }
}