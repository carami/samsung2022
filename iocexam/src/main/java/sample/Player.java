package sample;

public class Player {
	private String name;
	private Dice dice;
	
	
	public Player() {
		System.out.println("Player 생성자!! ");
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		System.out.println("Player setName()");
		this.name = name;
	}


	public void setDice(Dice dice) {
		System.out.println("Player setDice()");
		this.dice = dice;
	}
	
	public void play() {
		System.out.println(name + "은 주사위를 던져서 "+ dice.getNumber() +" 가 나왔습니다.");
	}
	
}
