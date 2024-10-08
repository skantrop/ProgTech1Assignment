/**
 * Property class, child of Field class, players can buy it
 */
public class Property extends Field {
    private Player owner;
    private boolean hasHouse;

    /**
     * constructs property at given position
     *
     * @param position position of the property
     */
    public Property(int position) {
        super(position);
        this.owner = null;
        this.hasHouse = false;
    }

    public Player getOwner() {
        return owner;
    }

    public boolean isHasHouse() {
        return hasHouse;
    }

    /**
     * get price of property
     *
     * @return price based on if it has owner and house
     */
    public int getPrice() {
        if (owner == null) {
            return 1000;
        } else {
            if (hasHouse) {
                return 2000;
            } else {
                return 500;
            }
        }
    }

    @Override
    public void checkStatus(Player pl) {
        if (owner == null) {
            if (pl.canBuy(this)) {
                owner = pl;
//                pl.appendProp(this);
                pl.pay(1000);
                System.out.println(pl.name + " paid 1000 and is an owner of field at position " + position);
            }
        } else if (owner != pl) {
            int rent = getPrice();
            pl.pay(rent);
            owner.receive(rent);
            System.out.println(pl.name + " paid " + rent + " to owner " + owner.name);
        } else if (owner == pl) {
            if (!hasHouse) {
                System.out.println(pl.name+" is on her own field");
                int houseCost = 4000;
                if (pl.balance >= houseCost) {
                    pl.pay(houseCost);
                    hasHouse = true;
                    System.out.println(pl.name+" built a house");
                    pl.appendProp(new Property(position));
                } else {
                    System.out.println(pl.name+" does not have enough money to build a house.");
                }
            } else {
                System.out.println(pl.name+" already has a house");
            }
        }
    }

    @Override
    public String toString(){
        return "Property";
    }
}