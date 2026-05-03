package ser120.chess.models;
import ser120.chess.Piece;
import ser120.chess.EmptyPiece;

public class Board {

	private int numRows;
	private int numCols;

	private Piece[][] boardData;

	public Board(int rows, int cols){
		this.numRows = rows;
		this.numCols = cols;
		this.boardData = new Piece[this.numRows][numCols];
		initializeEmptyBoard();

	}
	
    private void initializeEmptyBoard(){
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                //boardData[i][j] = new EmptyPiece(false);
            }
        }
    }
	//Prints the board
	public void showBoard(){
	    System.out.println("\n--- Current Chess Board ---");
		
		printHorizontalDivider();

		for(int i = 0; i < numRows; i++){
			System.out.print("| ");
			for(int j = 0; j < numCols; j++){
				try{
					System.out.print(boardData[i][j].getSymbol() + " | ");
				
				}catch(Exception e){
					
					System.out.print("--" + " | ");
				}
			}
			System.out.println();

			printHorizontalDivider();
		}
	}

	private void printHorizontalDivider(){
	    for(int k = 0; k < numCols; k++){
	        System.out.print("-----");
	    }
	    System.out.println("-");
	}

	public boolean isSquare(){
		return numCols==numRows;
	}

	
	public Piece[][] getBoardData(){
		return boardData;
	}
	
	public Piece getPiece(int newRow, int newCol){
		return boardData[newRow][newCol];
		
	}

	public void movePiece(int fromX, int fromY, int toX, int toY){
        boardData[toX][toY] = boardData[fromX][fromY];
        //boardData[fromX][fromY] = new EmptyPiece(false);
        boardData[fromX][fromY] = null;
    }
    
    public String[][] toStringBoard(){
		String[][] data = new String[8][8];
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				Piece p = boardData[i][j];
				if(p == null){
					data[i][j] = "--";
				}else{
					data[i][j] = p.toString(); // make sure each piece has this
				}
			}
		}
		return data;
	}

}
