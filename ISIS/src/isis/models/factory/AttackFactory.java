
package isis.models.factory;

import isis.interfaces.Attack;
import isis.models.Paris;
import isis.models.SU24;

/**
 *
 * @author chobi
 */
public class AttackFactory {
    
    public static Attack getAttack(String name){
        
        if (name.equals("Paris")) {
            return new Paris();
        } else if (name.equals("SU24")) {
            return new SU24();
        }
        
        return null;
    }
    
}
