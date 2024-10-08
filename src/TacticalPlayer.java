/**
 * TacticalPlayer class, child of Player class, skips buying every 2nd chance
 */
public class TacticalPlayer extends Player {
    private boolean skipNext = true;

    /**
     * constructs tactical player with a name
     *
     * @param name name of the player
     */
    public TacticalPlayer(String name) {
        super(name);
    }

    /**
     * checks if player can buy a property
     * skips buying every other turn
     *
     * @param p property to buy
     * @return true if player buys this time
     */
    @Override
    public boolean canBuy(Property p) {
        if (skipNext) {
            skipNext = false;
            return balance >= p.getPrice();
        }
        System.out.println(this.name + " skipping this time");
        skipNext = true;
        return false;
    }
}