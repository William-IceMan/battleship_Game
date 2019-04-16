package com.thoughtworks.game;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class PlayGameTest {

	static PlayGame playGame = new PlayGame();
	static List<String> input_player2;
	static List<String> input_player1;
	
	@BeforeClass
	public static void setup(){
		input_player1 = ReadFileUtils.readFile("test_case1.txt");
		input_player2 = ReadFileUtils.readFile("test_case2.txt");
	}

	@Test
	public void Should_Player2Win_When_Play(){
		playGame.startGame(input_player1, System.out);
		assertTrue(playGame.player1.isDown());
	}
	@Test
	public void Should_Player1Win_When_Play(){
		playGame.startGame(input_player2, System.out);
		assertTrue(playGame.player2.isDown());
	}
}
