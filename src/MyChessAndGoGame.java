package P3;

import java.util.*;
public class MyChessAndGoGame {
	public static void main(String[] args) {
		String game;
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Please input the name of game(chess or go):");
			game = scanner.nextLine();
			if(game.equals("chess") || game.equals("go")){
				break;
			}else {
				System.out.println("There is no such game!");
			}
		}
		//scanner.close();
		if(game.equals("chess")) {
			ChessGame chessGame = new ChessGame();
			chessGame.initGame();
			chessGame.playGame();
			chessGame.endGame();
		}else {
			GoGame goGame = new GoGame();
			goGame.initGame();
			goGame.playGame();
			goGame.endGame();
		}
	}
}
