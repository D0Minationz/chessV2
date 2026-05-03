package ser120.chess;

import java.util.Scanner;
import ser120.chess.game.GameManager;

public class App {

    public void scream(){
        //
    }

    public static void main(String[] args) {
        System.out.println("--- Starting SER120 Chess App ---");
        
        GameManager gm = new GameManager();
        
        Piece[][] boardData = gm.getBoard().getBoardData();
		
		boardSetUp(boardData);
		
		gm.runGame();
		
		boolean stopGame = false;
		while(!stopGame){
			Scanner myScanner = new Scanner(System.in);
			System.out.print("Which piece do you want to move? (Ex: A1) ");
			String startingPosition = myScanner.next();
			System.out.print("Where do you want to move that piece? (Ex: A2) ");
			String newPosition = myScanner.next();
			//new
			int[] startingPosXY = convertIndex(startingPosition);
			int[] endingPosXY = convertIndex(newPosition);
			System.out.println(startingPosXY[0] + ", " + startingPosXY[1]);
			System.out.println(endingPosXY[0] + ", " + endingPosXY[1]);

			gm.runGame(startingPosXY, endingPosXY);
			
			
			System.out.print("Do you want save, load, or exit: ");
			String command = myScanner.next();
			System.out.print("Do you want to keep playing or exit? ");
			String userEnd = myScanner.next();
			if(userEnd.equals("exit")){
				System.out.println("Goodbye");
				System.out.println("--- Session Ended ---");
				stopGame = true;
				System.exit(1);
			}
			if(command.equals("save")){
				gm.saveGame("chess.txt");
				continue;
			}
			if(command.equals("load")){
				gm.loadGame("chess.txt");
				continue;
			}
			
		}
		
	}
	
		
	public static void boardSetUp(Piece[][] boardData){
		boardData[0][0] = new Rook(false);
		boardData[0][1] = new Knight(false);
		boardData[0][2] = new Bishop(false);
		boardData[0][3] = new King(false);
		boardData[0][4] = new Queen(false);
		boardData[0][5] = new Bishop(false);
		boardData[0][6] = new Knight(false);
		boardData[0][7] = new Rook(false);

		//pawns
		for(int i = 0; i < 8; i++){
			boardData[1][i] = new Pawn(false);
			boardData[6][i] = new Pawn(true);
		}

		boardData[7][0] = new Rook(true);
		boardData[7][1] = new Knight(true);
		boardData[7][2] = new Bishop(true);
		boardData[7][3] = new King(true);
		boardData[7][4] = new Queen(true);
		boardData[7][5] = new Bishop(true);
		boardData[7][6] = new Knight(true);
		boardData[7][7] = new Rook(true);
	}
	
	
	public static int[] convertIndex(String index){
		//gets the letter
		char myChar = index.charAt(0);
		//gets the number
		int row = Integer.parseInt(index.substring(1)) - 1;
		//converts letter to number
		int col = Character.toUpperCase(myChar) - 'A';
		
		return new int[]{row, col};
		
	}
		

		
	
}
