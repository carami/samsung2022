package sample;

import java.util.List;

public class Game {
	private List<Player> playerList;
	
	public Game() {
		System.out.println("Game 생성자 실행");
	}
	
	public void setPlayerList(List<Player> playerList ) {
		System.out.println("game setPlayList 메서드 실행");
		this.playerList = playerList;
	}
	
	public void play() {
		System.out.println("Game play() 실행");
		for(Player player : playerList) {
			player.play();
		}
	}
	
}
