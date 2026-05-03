package Chess;
import java.util.Scanner;
import java.lang.Thread;

public class GameManager {
    private final String red = "\u001b[31;1m";
    private final String noColor = "\u001b[0m";
    private Scanner input;
    private Board gameBoard;

    public GameManager() {
        input = new Scanner(System.in);
        gameBoard = new Board();
        gameBoard.setBoardData();
    }

    public Board getBoard() {
        return gameBoard;
    }

    public void loading() {
        Thread thread = new Thread();
        try {
            System.out.println("Creating a board...");
            thread.sleep(1500);
            System.out.println("Setting up the pieces...");
            thread.sleep(1250);
            System.out.println("Initializing input...");
            thread.sleep(1250);
        } catch (InterruptedException e) {
            // I am aware of catching being a bad part
            // of designing and creating software.
            // I don't think this will create terrible bugs
            // or be the root cause of bugs hiding.
            // This function just simulates a loading using the Thread class.
        }

    }
    
    public void runGame() {
        boolean gameRunning = true;
        
        System.out.println("\t\t\tWelcome to Chess!");
        System.out.println("You may exit when you type 'EXIT' to end the game. Press [ENTER] to play:");
        input.nextLine();
        loading();
        while(gameRunning) {
            System.out.println("Do you want to exit? Type 'EXIT' or hit [ENTER] to continue:");
            String choice = input.nextLine();
            
            if(choice.equals("EXIT")) {
                gameRunning = false;
            }

            gameBoard.printBoard();

            if(didWin()) {
                gameRunning = false;
                System.out.println("A king has been defeated. You won");
                break;
            }

            System.out.println("What piece would you like to choose? (Ex. D2, D4)");
            String oldLetter = IO.readln("Letter: ");
            int oldNumber = Integer.parseInt(IO.readln("Number: "));

            String currentPiece = gameBoard.getBoardData(oldLetter, oldNumber);
            System.out.println("Current Piece: " + currentPiece);

            Piece chosenPiece = gameBoard.choosePiece(oldLetter, oldNumber);

            String newLetter = IO.readln("New Letter: ");
            int newNumber = Integer.parseInt(IO.readln("New Number: "));

            chosenPiece.move(getBoard(), chosenPiece.getPiece(), oldLetter, oldNumber, newLetter, newNumber);
        }
        System.out.println("The game has ended. Thank you for playing!");
    }

    public boolean didWin() {
        int kingCount = 0;
        for (int i = 0; i < gameBoard.getBoardDataLength(); i++) {
            for (int j = 0; j < gameBoard.getBoardDataLength(); j++) {
                if(gameBoard.getBoardData(i, j).equals("K")) {
                    kingCount++;
                }
            }
        }

        if(kingCount == 1) {
            return true;
        }
        return false;
    }
}
