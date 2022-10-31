package sample;

import java.util.List;

public class Game {
	private List<Player> list;
	
	public Game() {
		System.out.println("game 생성자!!");
	}

	public void setList(List<Player> list) {
		System.out.println("Game setList()");
		this.list = list;
	}
	
	public void play() {
		System.out.println("game  play()");
		for(Player player : list) {
			player.play();
		}
	}
	
	
}	
