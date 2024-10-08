import java.util.ArrayList;
import java.util.List;

/**
 * abstract class Player
 */
public abstract class Player {

    protected String name;
    protected int balance;
    protected int position;
    protected List<Property> properties;

    /**
     * constructs player with name
     * sets balance to 10000 and position to 0 (according to task)
     * initialize empty list of properties for player
     * @param name name of the player
     */
    public Player(String name) {
        this.name = name;
        this.balance = 10000;
        this.position = -1;
        this.properties = new ArrayList<>();
    }

    /**
     * move the player by steps
     * and check the field they stop on
     *
     * @param steps how many steps to move
     * @param fields list of all fields
     */
    public void move(int steps, List<Field> fields) {
        position += steps;
        if (position >= fields.size()) {position -= fields.size();}
        Field field = fields.get(position);
        System.out.println(name + " is on "+fields.get(position).toString());
        field.checkStatus(this);
    }

    /**
     * checks if player has money
     *
     * @return boolean value (true | flase) if balance is zero or less
     */
    public boolean ranOut() {
        return balance <= 0;
    }

    /**
     * checks if player can buy a property
     *
     * @param property the property to buy
     * @return true if player can buy it
     */
    public abstract boolean canBuy(Property property);

    /**
     * pay some money set balance to 0 if player is bankrupt
     *
     * @param amount the money to pay
     */
    public void pay(int amount) {
        if (balance < amount) {
            System.out.println(name + " does not have enough money to pay " + amount);
            balance = 0;
        } else {
            balance -= amount;
        }
    }


    /**
     * receive some money
     *
     * @param amount the money to receive
     */
    public void receive(int amount) {
        balance += amount;
    }
    /**
     * add a property to the player's "properties" list
     *
     * @param property property to add
     */
    public void appendProp(Property property) {
        properties.add(property);
    }

    @Override
    public String toString() {
        return name + " has: " + balance + "$, and " + (properties.size() > 0 ? properties.size() + " houses" : "no houses");

    }
}