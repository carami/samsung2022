package sample.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import sample.Dice;
import sample.Game;
import sample.Player;

@Configuration
@PropertySource({"classpath:game.properties"})
public class DicePlayerConfig {
	
	@Bean
	public Dice dice(@Value("${face}") int face) {
		return new Dice(face);
	}
	@Bean
	public Dice dice2(@Value("${face}") int face) {
		return new Dice(face);
	}
	@Bean
	public Player kang(Dice dice2) {
		Player player = new Player();
		player.setDice(dice2);
		player.setName("강경미");
		return player;
	}
	@Bean
	public Player kim(Dice dice) {
		Player player = new Player();
		player.setDice(dice);
		player.setName("김길동");
		return player;
	}
	@Bean
	public Player hong(Dice dice) {
		Player player = new Player();
		player.setDice(dice);
		player.setName("홍당무");
		return player;
	}
	@Bean
	public Player lee(Dice dice) {
		Player player = new Player();
		player.setDice(dice);
		player.setName("이이");
		return player;
	}
	
	@Bean
//	public Game game(Player kang, Player kim, Player hong, Player lee) {
	public Game game(List<Player> playerList) {
		Game game = new Game();
//		List<Player> playerList = new ArrayList();
//		playerList.add(lee);
//		playerList.add(kang);
//		playerList.add(hong);
//		playerList.add(kim);
		
		game.setPlayerList(playerList);
		return game;
	}
	
}
