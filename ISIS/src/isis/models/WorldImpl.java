/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.models;

import isis.interfaces.Attack;
import isis.interfaces.Group;
import isis.interfaces.War;
import isis.interfaces.World;
import isis.models.factory.AttackFactory;
import isis.models.factory.WarEffectFactory;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author chobi
 */
public class WorldImpl implements World {

    private Map<String, Group> groups;

    public WorldImpl() {
        this.setGroup();
    }

    @Override
    public Map<String, Group> getGroup() {
        return this.groups;
    }

    public void setGroup() {
        
        this.groups = new TreeMap<>();

    }

    @Override
    public void create(String name, String... groupParams) {
      
        int health = Integer.parseInt(groupParams[0].trim());
        int damage = Integer.parseInt(groupParams[1].trim());
        War warEffect = WarEffectFactory.getWarEffect(groupParams[2].trim());
        Attack attack = AttackFactory.getAttack( groupParams[3].trim());
        
        this.groups.put(name, new GroupImpl(name, health, damage, warEffect, attack));
    }

    @Override
    public String toString() {
        //Group Cenko: 50 HP, 15 Damage
        StringBuilder sb = new StringBuilder();
        
        groups.entrySet().stream()
                .sorted((g1, g2) -> Integer.compare(g1.getValue().getHealth(), g2.getValue().getHealth()))
                .forEach(s1 ->{
                
                    sb.append(String.format("Group %s: %d HP, %d Damage", 
                            s1.getKey()
                            , s1.getValue().getHealth()
                            , s1.getValue().getDamage()));
                    
                    sb.append(System.lineSeparator());
                });
        
        return sb.toString();
    }
    
    

}
