import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zelmad.TennisService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisTest {

    public TennisService tennisService;

    @BeforeEach
    void setUp(){
        tennisService = new TennisService();
    }

    @Test
    public void test_player_a_win() {
        String winnerPlayer = tennisService.getWinner("ABABAA");
        String expectedWinner = "Player A wins the game";
        assertEquals(winnerPlayer, expectedWinner);
    }

    @Test
    public void test_player_b_win() {
        String winnerPlayer = tennisService.getWinner("BABABB");
        String expectedWinner = "Player B wins the game";
        assertEquals(winnerPlayer, expectedWinner);
    }

    @Test
    public void test_player_a_b_deuce_a_win() {
        String winnerPlayer = tennisService.getWinner("ABABABAA");
        String expectedWinner = "Player A wins the game";
        assertEquals(winnerPlayer, expectedWinner);
    }

    @Test
    public void test_player_a_b_deuce_b_win() {
        String winnerPlayer = tennisService.getWinner("ABABABBABB");
        String expectedWinner = "Player B wins the game";
        assertEquals(winnerPlayer, expectedWinner);
    }
}
