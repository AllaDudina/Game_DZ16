import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();

    Player player1 = new Player(1, "playerName1", 10);
    Player player2 = new Player(2, "playerName2", 15);

    @Test
    public void shouldRoundIfAllRegistered() {

        game.register(player1);
        game.register(player2);

        int result1 = game.round("playerName1", "playerName2");
        Assertions.assertEquals(2, result1);

        int result2 = game.round("playerName2", "playerName1");
        Assertions.assertEquals(1, result2);

        int result3 = game.round("playerName1", "playerName1");
        Assertions.assertEquals(0, result3);

    }

    @Test

    public void shouldRoundIfOneRegistered() {

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("playerName1", "playerName3");
        });

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("playerName3", "playerName1");
        });
    }

    @Test

    public void shouldGetID(){
        game.register(player1);

        int result = player1.getId();

        Assertions.assertEquals(1, result);
    }

    @Test

    public void shouldSetId(){
        game.register(player2);

        int result = player2.getStrength();

        Assertions.assertEquals(15, result);
    }

    }

