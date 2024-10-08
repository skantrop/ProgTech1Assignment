/**
 * CarefulPlayer class, child of Player class
 * buys in a round only for at most half the amount of his money.
 */
public class CarefulPlayer extends Player {

    /**
     * constructs careful player with name
     *
     * @param name name of player
     */
    public CarefulPlayer(String name) {
        super(name);
    }

    /**
     * checks if player can buy property
     * buys only if price is less than half of money he has
     *
     * @param pr property to buy
     * @return true if player can buy the property else false
     */
    @Override
    public boolean canBuy(Property pr) {
        return balance - pr.getPrice() >= (balance / 2);
    }
}