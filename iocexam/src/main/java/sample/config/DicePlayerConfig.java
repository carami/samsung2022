package sample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import sample.Dice;
import sample.Player;

@Configuration
@PropertySource({
	"classpath:game.properties"
})
public class DicePlayerConfig {
	@Bean
	public Dice dice(@Value("${face}") int face) {
//		int face  = 6;
		return new Dice(face);
	}
	
	@Bean
	public Player kang(Dice dice) {
		Player player = new Player();
		player.setDice(dice);
		player.setName("kang");
		return player;
	}
}
