import java.io.FileNotFoundException;

/**
 * class Main to run game
 */
public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        try {
            database.read("data.txt");
//            database.read("skipping_test_tp.txt");
//            database.read("one_player_buys_house.txt");
//            database.read("two_players_lose.txt");
//            database.read("all_players_lose.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
            System.exit(-1);
        }catch (InvalidInputException ex) {
        System.out.println("Invalid input!");
        System.exit(-1);
    }

        Game game = new Game(database);
        game.start();

        System.out.println("Result: ");
        if(database.getPlayers().isEmpty()){
            System.out.println("All players lost");
        }
        else {
            for (Player pl : database.getPlayers()) {
                System.out.println(pl);
            }
        }
    }
}
