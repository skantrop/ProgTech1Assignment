import java.util.List;

/**
 * Game class
 */
public class Game {

    private final List<Player> players;
    private final List<Field> fields;
    private final List<Integer> dices;

    /**
     * constructs game with data from the database file
     *
     * @param database database with players, fields, and dices
     */

    public Game(Database database) {
        this.players = database.getPlayers();
        this.fields = database.getFields();
        this.dices = database.getDices();
    }

    /**
     * starts the game
     * continues game until we have dices list from file
     */
    public void start() {
        int round = 0;
        while (!dices.isEmpty() && !players.isEmpty()) {
            for (Player pl : players) {
                if (dices.isEmpty()) {
                    break;
                }
                round++;

                int dice = dices.remove(0);
                System.out.println("\n\nround "+round+"\n");
                System.out.println(pl.name+" is playing.");
                System.out.println(pl);
                pl.move(dice, fields); //steps are -1 to reach correct index in pos list


                if (pl.ranOut()) {
                    players.remove(pl);
                    System.out.println(pl.name + " lost!");
                    break;
                }
            System.out.println(pl);
            }
        }

        System.out.println("\nGame over\n");
    }
}
