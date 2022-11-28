package sample;

public class Dice {
	private int face;
	
	public Dice(int face) {
		this.face = face;
		System.out.println("Dice 생성자");
	}
	
	public int getNumber() {

		System.out.println("Dice getNumber()");
		return (int)(Math.random() * face) +1;
	}
}
