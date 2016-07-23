
package isis.models.factory;

import isis.interfaces.War;
import isis.models.Jihad;
import isis.models.Kamikaze;

/**
 *
 * @author chobi
 */
public class WarEffectFactory {
    
    public static  War getWarEffect (String name){
        if (name.equals("Jihad")) {
            return new Jihad();
        }else if (name.equals("Kamikaze")) {
            return new Kamikaze();
        }
    return null;
    }
    
}
