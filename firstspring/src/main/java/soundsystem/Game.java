package soundsystem;

import java.util.List;

public class Game {
    private List<Player> list;

    public Game(){
        System.out.println("Game()");
    }

    public void setPlayerList(List<Player> list){
        System.out.println("Game.setPalyerList()");
        this.list = list;
    }

    public void play(){
        System.out.println("Game.play()");
        for(Player player : list){
            player.play();
        }
    }
}
