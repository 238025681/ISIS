/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.interfaces;

import java.util.Map;

/**
 *
 * @author chobi
 */
public interface World {
    
    public Map<String, Group> getGroup();
    
   public void create(String name, String... groupParams) ;
    
    
}
