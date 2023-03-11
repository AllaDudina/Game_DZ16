import java.util.ArrayList;

public class Game {
    public static ArrayList<Player> playerList = new ArrayList<>();

    public void register(Player player) {
        playerList.add(player);

    }

    public Player findPlayer(String playerName) {
        for (Player player : playerList) {
            if (player.getName() == playerName) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = findPlayer(playerName1);
        Player player2 = findPlayer(playerName2);

        if (player1 == null || player2 == null) {
            throw new NotRegisteredException("One or more players are not registered");
        }
        if (player1.strength < player2.strength) {
            return 2;
        } else if (player1.strength > player2.strength) {
            return 1;
        } else {
            return 0;
        }
    }
}

