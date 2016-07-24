package isis.interfaces;

/**
 *
 * @author chobi
 */
public interface Group {

    void attack(Group group);

    public String getName();
    public int getHealth();
    public int getDamage();
}
