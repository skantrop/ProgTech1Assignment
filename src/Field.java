/**
 * abstract class Field on the game board
 */
public abstract class Field {
    protected int position;

    /**
     * constructs field at a position
     *
     * @param position position on the board
     */
    public Field(int position) {
        this.position = position;
    }

    /**
     * abstract method that check what happens when player stops on field
     * (should be overwritten by child classes)
     *
     * @param p the player who goes on field
     */
    public abstract void checkStatus(Player p);
}





