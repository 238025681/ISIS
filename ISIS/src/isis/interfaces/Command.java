package isis.interfaces;

/**
 *
 * @author chobi
 */
public interface Command {


    public void dispatchCommand(String group, String input);

    void akbar();

    void status();
    
    public void attack(String attacker, String target);
    
    void create(String params, String name);
    

}
