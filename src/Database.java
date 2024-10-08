import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Database class to store fields, players, and dices
 * reads data from a file
 */
public class Database {

    private final List<Field> fields;
    private final List<Player> players;
    private final List<Integer> dices;

    /**
     * constructs empty database
     */
    public Database() {
        fields = new ArrayList<>();
        players = new ArrayList<>();
        dices = new ArrayList<>();
    }

    /**
     * reads game data from given file
     * creates fields, players, and dices
     *
     * @param filename name of the file to read
     * @throws FileNotFoundException if file is not found
     * @throws InvalidInputException if input is wrong
     */
    public void read(String filename) throws FileNotFoundException, InvalidInputException{
        Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));

        int numFields = sc.nextInt();
        for (int i = 0; i < numFields; i++) {
            String fieldType = sc.next();
            switch (fieldType) {
                case "P":
                    fields.add(new Property(i));
                    break;
                case "S":
                    fields.add(new Service(i, sc.nextInt()));
                    break;
                case "L":
                    fields.add(new Lucky(i, sc.nextInt()));
                    break;
                default:
                    throw new InvalidInputException();
            }
        }

        int numPlayers = sc.nextInt();
        for (int i = 0; i < numPlayers; i++) {
            String playerName = sc.next();
            String strategy = sc.next();
            switch (strategy) {
                case "GP":
                    players.add(new GreedyPlayer(playerName));
                    break;
                case "CP":
                    players.add(new CarefulPlayer(playerName));
                    break;
                case "TP":
                    players.add(new TacticalPlayer(playerName));
                    break;
                default:
                    throw new InvalidInputException();
            }
        }

        while (sc.hasNextInt()) {
            dices.add(sc.nextInt());
        }
    }

    public List<Field> getFields() {
        return fields;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Integer> getDices() {
        return dices;
    }
}
