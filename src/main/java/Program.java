import java.util.Scanner;

public class Program {
    private Game game;
    private final Scanner scanner;
    private String playerOne;
    private String playerTwo;
    private int playerOneThrow;
    private int playerTwoThrow;

    public Program() {
        this.scanner = new Scanner(System.in);
        this.game = new Game();
    }

    public void start() {
        beginGame();

        while (true) {
            diceThrow();
            gameLogic();
            if (restartGame().equals("n")) {
                break;
            }
        }
        gameWinnerInfo();
        gameWinTimesInfo();
    }

    public void beginGame() {
        System.out.println("2 Players play a dice game, the highest throw wins");
        System.out.println("The winner gets 3 points and if it is a tie, both get 1 point");

        System.out.println("Please put in a name, Player 1:");
        playerOne = scanner.nextLine();
        System.out.println("Please put in a name, Player 2:");
        playerTwo = scanner.nextLine();

    }

    public String restartGame() {
        System.out.println("Play again? [y/n]");
        return scanner.nextLine();
    }

    public void gameLogic() {
        if (playerOneThrow > playerTwoThrow) {
            System.out.println(playerOne + " wins the round! " + playerOneThrow + " beats " + playerTwoThrow);
            System.out.println(playerOne + " gets 3 points!");

            game.add(playerOne);
            game.setPlayerOnePoints(3);
        } else if (playerTwoThrow > playerOneThrow) {
            System.out.println(playerTwo + " wins the round! " + playerTwoThrow + " beats " + playerOneThrow);
            System.out.println(playerTwo + " gets 3 points!");

            game.add(playerTwo);
            game.setPlayerTwoPoints(3);
        } else {
            System.out.println("It's a tie! Both threw the number " + playerOneThrow);
            System.out.println("Both get 1 point");

            game.add("ties");
            game.setPlayerOnePoints(1);
            game.setPlayerTwoPoints(1);
        }
    }

    public void diceThrow() {
        System.out.println("Let's start the game! Players throw your die.");
        System.out.println();

        playerOneThrow = game.getDiceThrow();
        System.out.println(playerOne + " threw a " + playerOneThrow);

        playerTwoThrow = game.getDiceThrow();
        System.out.println(playerTwo + " threw a " + playerTwoThrow);

        System.out.println();
    }

    public void gameWinTimesInfo() {
        game.calculateWinningInfo(playerOne, playerTwo);

        System.out.println();
        System.out.println(playerOne + " has won " + game.getPlayerOneWins() + " times.");
        System.out.println(playerTwo + " has won " + game.getPlayerTwoWins() + " times.");
        System.out.println(playerOne + " and " + playerTwo + " have tied " + game.getTies() + " times.");
    }

    public void gameWinnerInfo() {
        if (game.getPlayerOnePoints() > game.getPlayerTwoPoints()) {
            System.out.println(playerOne + " has won with " + game.getPlayerOnePoints() + " points");
            System.out.println(playerTwo + " has " + game.getPlayerTwoPoints() + " points");
        } else if (game.getPlayerOnePoints() < game.getPlayerTwoPoints()) {
            System.out.println(playerTwo + " has won with " + game.getPlayerTwoPoints() + " points");
            System.out.println(playerOne + " has " + game.getPlayerOnePoints() + " points");
        } else {
            System.out.println(playerOne + " and " + playerTwo + " have both "
                    + game.getPlayerOnePoints() + " points");
        }
    }

}
