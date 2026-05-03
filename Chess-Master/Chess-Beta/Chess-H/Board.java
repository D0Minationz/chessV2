package Chess;

public class Board {
    private int length;
    private int width;
    private String [][] boardData;

    public Board() {
        this.length = 8;
        this.width = 8;
        boardData = new String[getLength()][getWidth()];
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String[][] getBoardData() {
        return boardData;
    }

    public String getBoardData(int row, int col) {
        return boardData[row][col];
    }

    public String getBoardData(String letter, int number) {
        return translate(letter, number);
    }
    public int getBoardDataLength() {
        return boardData.length;
    }

    public void printBoard() {
        String horizontalLine = "--------------------------------------------------------";
        String verticalLine = "|";
        String space = "  ";
        int rowNumber = getBoardDataLength();

        System.out.println("\t\tCurrent Chess Board");
        System.out.println("   A      B      C      D      E      F      G      H   ");
        System.out.println(horizontalLine);
        
        for(int i = 0; i < getBoardDataLength(); i++) {
            for(int j = 0; j < getBoardDataLength(); j++) {
                System.out.print(verticalLine + space);
                printBoardData(i, j); 
                System.out.print(space + verticalLine);

                if(j == getBoardDataLength() - 1) {
                    System.out.print(space + rowNumber);
                    rowNumber--;
                    System.out.println();
                }
            }
            System.out.println(horizontalLine);
        }
    }

    public void printBoardData() {
        for(int row = 0; row < boardData.length; row++) {
            for(int col = 0; col < boardData.length; col++) {
                System.out.print(boardData[row][col] + "   ");
            }
            System.out.println();
        }
    }

    public void printBoardData(int row, int col) {
        System.out.print(boardData[row][col]);
    }
    
    public void setBoardData() {
        Piece userKing = new King("White");
        Piece enemyKing = new King("Black");

        Piece userQueen = new Queen("White");
        Piece enemyQueen = new Queen("Black");

        Piece userRook = new Rook("White");
        Piece enemyRook = new Rook("Black");

        Piece userBishop = new Bishop("White");
        Piece enemyBishop = new Bishop("Black");

        Piece userKnight = new Knight("White");
        Piece enemyKnight = new Knight("Black");

        Piece userPawn = new Pawn("White");
        Piece enemyPawn = new Pawn("Black");
        
        // pawns
        for(int i = 0; i < boardData.length; i++) {
            boardData[1][i] = enemyPawn.getPiece();
            boardData[6][i] = userPawn.getPiece();
        }

        // rook, knight, bishop
        for(int i = 0; i < boardData.length; i+=7) {
            boardData[0][i] = enemyRook.getPiece();
            boardData[7][i] = userRook.getPiece();
        }

        for(int i = 1; i < boardData.length; i+=5) {
            boardData[0][i] = enemyKnight.getPiece();
            boardData[7][i] = userKnight.getPiece();
        }

        for(int i = 2; i < boardData.length; i+=3) {
            boardData[0][i] = enemyBishop.getPiece();
            boardData[7][i] = userBishop.getPiece();
        }

        // king, queen
        for(int i = 3; i < 5; i++) {
            boardData[0][3] = enemyKing.getPiece();
            boardData[0][4] = enemyQueen.getPiece();
            boardData[7][3] = userKing.getPiece();
            boardData[7][4] = userQueen.getPiece();
        }

        for(int i = 0; i < boardData.length; i++) {
            String emptySpace = "-";
            boardData[2][i] = emptySpace;
            boardData[3][i] = emptySpace;
            boardData[4][i] = emptySpace;
            boardData[5][i] = emptySpace;
        }
    }

    public String translate(String letter, int number) {
        return boardData[getRow(number)][getCol(letter)];
    }

    public void setPiece(String piece, int row, int col) {
        boardData[row][col] = piece;
    }

    public void removePiece(int row, int col) {
        boardData[row][col] = "-";
    }
    
    public Piece choosePiece(String letter, int number) {
        Piece king = new King("White");
        Piece queen = new Queen("White");
        Piece rook = new Rook("White");
        Piece knight = new Knight("White");
        Piece bishop = new Bishop("White");
        Piece pawn = new Pawn("White");
        Piece noPiece = new EmptyPiece();

        if(translate(letter, number).equals("K")) {
            return king;
        }

        if(translate(letter, number).equals("Q")) {
            return queen;
        }

        if(translate(letter, number).equals("R")) {
            return rook;
        }

        if(translate(letter, number).equals("B")) {
            return bishop;
        }

        if(translate(letter, number).equals("H")) {
            return knight;
        }

        if(translate(letter, number).equals("P")) {
            return pawn;
        } else {
            return noPiece;
        }
    }

    public int getRow(int number) {
        int row = 0; 

        switch(number) {
            case 1:
                row = 7;
                break;
            case 2:
                row = 6;
                break;
            case 3:
                row = 5;
                break;
            case 4:
                row = 4;
                break;
            case 5:
                row = 3;
                break;
            case 6:
                row = 2;
                break;
            case 7:
                row = 1;
                break;
            case 8:
                row = 0;
                break;
        }

        return row;
    }

    public int getCol(String letter) {
        int col = 0;

        switch (letter) {
            case "A":
                col = 0;
                break;
            case "B":
                col = 1;
                break;
            case "C":
                col = 2;
                break;
            case "D":
                col = 3;
                break;
            case "E":
                col = 4;
                break;
            case "F":
                col = 5;
                break;
            case "G":
                col = 6;
                break;
            case "H":
                col = 7;
                break;
        }

        return col;
    }
}