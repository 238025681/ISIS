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
        int health = Integer.parseInt(groupParams[0]);
        int damage = Integer.parseInt(groupParams[1]);
        War warEffect = WarEffectFactory.getWarEffect(groupParams[2]);
        Attack attack = AttackFactory.getAttack(groupParams[3]);
        
        this.groups.put(name, new GroupImpl(name, health, damage, warEffect, attack));
    }

}
