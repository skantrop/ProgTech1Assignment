/**
 * Lucky class, child  Field gives money to player
 */
public class Lucky extends Field {
    private final int amount;

    /**
     * constructs a lucky field with a position and money
     *
     * @param position position of the field
     * @param amount money to give to player
     */
    public Lucky(int position, int amount) {
        super(position);
        this.amount = amount;
    }

    /**
     * give money to player who stops on this field
     *
     * @param pl the player who lands on the field
     */
    @Override
    public void checkStatus(Player pl) {
        pl.receive(amount);
        System.out.println(pl.name+" received: "+amount+"\n");
    }

    @Override
    public String toString(){
        return "Lucky";
    }
}