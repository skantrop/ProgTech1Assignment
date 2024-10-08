/**
 * GreedyPlayer, child of Player, buys only when has enough money
 */
public class GreedyPlayer extends Player {

    /**
     * constructs a greedy player with a name
     *
     * @param name name of the player
     */
    public GreedyPlayer(String name) {
        super(name);
    }

    /**
     * checks if player can buy property
     *
     * @param property property to buy
     * @return true if player has enough money
     */
    @Override
    public boolean canBuy(Property property) {
        return balance >= property.getPrice();
    }
}