package ser120.chess.game;

import ser120.chess.models.CoolBoard;
import ser120.chess.Piece;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import ser120.chess.Pawn;
import ser120.chess.Rook;
import ser120.chess.Knight;
import ser120.chess.Bishop;
import ser120.chess.Queen;
import ser120.chess.King;

public class GameManager {
	private CoolBoard board;
	
	public GameManager(){
		this.board = new CoolBoard(8,8);
	}
	
	public void runGame(int[] startingPosition, int[] endingPosition){
		System.out.println("GameManager: Initializing engine...");
		int oldRow = startingPosition[0];
		int oldCol = startingPosition[1];
		int newRow = endingPosition[0];
		int newCol = endingPosition[1];
		Piece p = board.getPiece(oldRow, oldCol);
		if(p == null){
			System.out.println("No piece at that position.");
			return;
		}
		if(p.canMove(board, newRow, newCol, oldRow, oldCol)){
			board.movePiece(oldRow, oldCol, newRow, newCol);
			System.out.println("Move successful!");
		}else{
			System.out.println("Invalid move.");
		}
		board.showBoard();
        System.out.println("GameManager: Ready for Green's move.");
	}
	
	public void runGame(){
		System.out.println("GameManager: Initializing engine...");
        board.showBoard();
        System.out.println("GameManager: Ready for Green's move.");
	}
	
	public CoolBoard getBoard(){
		return board;
	}
	
	public void saveGame(String filename){
		try {
			FileWriter writer = new FileWriter(filename);
			String[][] data = board.toStringBoard();
			for(int i = 0; i < 8; i++){
				for(int j = 0; j < 8; j++){
					writer.write(data[i][j] + " ");
				}
				writer.write("\n");
			}
			writer.close();
			System.out.println("Game saved!");
			
		} catch(IOException e){
			System.out.println("Error saving game.");
		}
	}
	
	public void loadGame(String filename){
		try {
			Scanner fileScanner = new Scanner(new File(filename));
			for(int i = 0; i < 8; i++){
				for(int j = 0; j < 8; j++){
					String piece = fileScanner.next();

					if(piece.equals("--")){
						board.setPiece(i, j, null);
					}else{
						board.setPiece(i, j, createPiece(piece));
					}
				}
			}
			fileScanner.close();
			System.out.println("Game loaded!");
			board.showBoard();

		} catch(Exception e){
			System.out.println("Error loading game.");
		}
	}
	
	private Piece createPiece(String code){
        boolean isWhite = code.charAt(0) == 'w';
        
        char type = code.charAt(1);
        
        if(type == 'p') return new Pawn(isWhite);
        if(type == 'r') return new Rook(isWhite);
        if(type == 'n') return new Knight(isWhite);
        if(type == 'b') return new Bishop(isWhite);
        if(type == 'q') return new Queen(isWhite);
        if(type == 'k') return new King(isWhite);
        
        return null;
    }
}
