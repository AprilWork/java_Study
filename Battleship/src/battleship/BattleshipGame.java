package battleship;

import java.util.Random;
import java.util.Scanner;

public class BattleshipGame {
	Ocean ocean;
	
	public BattleshipGame() {
		// TODO Auto-generated constructor stub
		this.ocean = new Ocean();
	}

	protected static int[][] getShotsArray(String str) {
		//TODO
		String[] shotsStr;
		int[][] shots = new int[5][2];
		try {
			
			shotsStr = str.split(";");
			for (int i = 0; i < shotsStr.length; i++) {
				shotsStr[i] = shotsStr[i].trim();
			}
			//System.out.println(shotsStr[1]);

			String[] XY;
			for (int i = 0; i < shotsStr.length; i++) {
				XY = shotsStr[i].split(",");
				shots[i][0] = Integer.parseInt(XY[0]);
				shots[i][1] = Integer.parseInt(XY[1]);
			}
		} 
		catch (NumberFormatException e) {
			
		}
		finally {
			
		}
		return shots;
	}
	
	public static int[][] getShotsArray(Random rand) {
		//TODO
		//input imitation
		
		int[][] shots = new int[5][2];
		for (int i = 0; i < shots.length; i++) {
			int x = rand.nextInt(20);
			int y = rand.nextInt(20);
			shots[i][0] = x;
			shots[i][1] = y;
			System.out.println(shots[i][0] + " " + shots[i][1]);
		}
		return shots;
		//end input imitation
	}
	
	public static void shots5Count(int[][] shots, BattleshipGame myGame) {
		//TODO
		for (int i = 0; i < shots.length; i++) {
			if (myGame.ocean.shootAt(shots[i][0], shots[i][1])) {
				System.out.println("Hit! " + shots[i][0] + "!" + shots[i][1]);
				if (myGame.ocean.getShipArray()[shots[i][0]][shots[i][1]].isSunk()) {
					System.out.println("You just sank a " + 
						myGame.ocean.getShipArray()[shots[i][0]][shots[i][1]].getShipType());
				}
					
			} else {
				System.out.println("Miss! " + shots[i][0] + "!" + shots[i][1]);
			}
				
		}
	}
	
	public static void main(String[] args) {
		// TODO I want to create Windows or Android GUI for the game
		
		int[][] shots; 
		boolean endGame = false;
		//Random rand = new Random();
		Scanner input = new Scanner(System.in);
		String str = "";
		
		BattleshipGame myGame = new BattleshipGame();
		myGame.ocean.placeAllShipsRandomly();
		myGame.ocean.print();
		System.out.println("The input format should look like this: 1,1; 0,3; 7,3; 9,11; 12,17");
		System.out.println("Input 5 pair of numbers: ");
		do {
			str = input.nextLine();
			// input string to array of int
			//shots = getShotsArray(rand);
			shots = getShotsArray(str);
			// shoot
			shots5Count(shots,myGame);
			// print result
			myGame.ocean.print();
			if (myGame.ocean.isGameOver()) {
				System.out.println("Game is over");
				System.out.println(myGame.ocean.getShotsFired() + " shots were required.");
			}
			System.out.print("end game (y/n): ");
			str = input.nextLine();
			
			if (str.equalsIgnoreCase("y")) { 
				endGame = true; 
				System.out.println("end game");
			} else {
				endGame = false; 
				str = "";
				System.out.print("Input next 5 pair of numbers: ");
			}
			
		} while ((!endGame) && (!myGame.ocean.isGameOver()));
		
		System.out.println("You sanken " + myGame.ocean.getShipsSunk() + 
				" ships. You required "  + myGame.ocean.getShotsFired() + " shots.");
		
		// close Scanner
		input.close();

	}

}
