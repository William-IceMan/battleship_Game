package com.thoughtworks.game;

import java.io.PrintStream;
import java.util.List;

public class PlayGame {

	Player player1, player2;
	
	public static void main(String[] args){
		PrintStream console = System.out;
		if(args.length == 0)
		{
			console.println("Missing fileName: Use java -jar <jarname> <filename>");
			System.exit(1);
		}
		
		List<String> input = ReadFileUtils.readFile(args[0]);
		for (String string : input) {
			console.println(string);
		}
		
		PlayGame playGame = new PlayGame();
		playGame.startGame(input, console);
		
	}
	
	public void startGame(List<String> input, PrintStream ps){
		player1 = new Player("Player-1");
		player2 = new Player("Player-2");
		
		player1.createBattleArea(input.get(0));
		player2.createBattleArea(input.get(0));
		
		addShipsToBattleArea(input);
		
		player1.addMissile(input.get(input.size()-2));
		player2.addMissile(input.get(input.size()-1));
		
		player1.getBattleArea().printBattleArea(ps);
		player2.getBattleArea().printBattleArea(ps);
		
		// PlayGame
		play(ps);
	}

	public void addShipsToBattleArea(List<String> input){
		// Add totalShips to each battleArea
		int totalShips = new Integer(input.get(1));
		player1.addAllShipsToBattleArea(totalShips);
		player2.addAllShipsToBattleArea(totalShips);
		
		// Add different type of ships to each battleArea
		for (int i = 0; i < totalShips; i++) {
			String [] battleShipDetail = input.get(i+2).split(" ");
			player1.addShipInBattleArea(battleShipDetail[0], new Integer(battleShipDetail[1]), new Integer(battleShipDetail[2]), battleShipDetail[3]);
			player2.addShipInBattleArea(battleShipDetail[0], new Integer(battleShipDetail[1]), new Integer(battleShipDetail[2]), battleShipDetail[4]);
		}
		
	}
	
	void play(PrintStream ps){
		
		boolean win = false;
		while(!win){
			
			if(shootUntil(player1, player2, ps)){
				break;
			}
			
			if(shootUntil(player2, player1, ps))
			{
				break;
			}
			
		}
	}
	
	private boolean shootUntil(Player playerA, Player playerB, PrintStream ps){
		boolean win = false;
		if(playerA.getMissiles().size() == 0){
			ps.println(playerA.getPlayerName() + " has no more missiles left to launch");
		}
		else
		{
			boolean hit = true;
			while(hit && playerA.getMissiles().size() > 0){
				hit = playerA.shoot(playerB, ps);
				if(playerB.isDown()){
					ps.println(playerA.getPlayerName() + " won the battle");
					win = true;
					break;
				}
			}
		}
		return win;
	}
	
}
