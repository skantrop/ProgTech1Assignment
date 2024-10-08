/**
 * Service class, child of Field class, takes money from player
 */
public class Service extends Field {
    private final int amount;

    /**
     * constructs service field with fee amount
     *
     * @param position position of service field
     * @param amount money to take from player
     */
    public Service(int position, int amount) {
        super(position);
        this.amount = amount;
    }

    /**
     * takes money from player
     *
     * @param pl the player who stops on field
     */
    @Override
    public void checkStatus(Player pl) {
        System.out.println(pl.name+" has "+pl.balance+" and fined for "+ amount+"\n");
        pl.pay(amount);
    }

    @Override
    public String toString(){
        return "Service";
    }
}