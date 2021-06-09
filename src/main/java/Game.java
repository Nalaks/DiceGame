import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private final Random rng;
    private int playerOneWins;
    private int playerTwoWins;
    private int ties;
    private final List<String> gameList;
    private int playerOnePoints;
    private int playerTwoPoints;

    public Game() {
        this.rng = new Random();
        this.playerOneWins = 0;
        this.playerTwoWins = 0;
        this.ties = 0;
        this.gameList = new ArrayList<>();
        this.playerOnePoints = 0;
        this.playerOnePoints = 0;
    }

    public int getDiceThrow() {
        return rng.nextInt(6) + 1;
    }

    public void add(String winner) {
        gameList.add(winner);
    }

    public void calculateWinningInfo(String playerOne, String playerTwo) {
        for (String games : gameList) {
            if (games.equals(playerOne)) {
                playerOneWins++;
            } else if (games.equals(playerTwo)) {
                playerTwoWins++;
            } else if (games.equals("ties")) {
                ties++;
            }
        }
    }

    public int getPlayerOneWins() {
        return playerOneWins;
    }

    public int getPlayerTwoWins() {
        return playerTwoWins;
    }

    public int getTies() {
        return ties;
    }

    public void setPlayerOnePoints(int playerOnePoints) {
        this.playerOnePoints += playerOnePoints;
    }

    public void setPlayerTwoPoints(int playerTwoPoints) {
        this.playerTwoPoints += playerTwoPoints;
    }

    public int getPlayerOnePoints() {
        return playerOnePoints;
    }

    public int getPlayerTwoPoints() {
        return playerTwoPoints;
    }
}
