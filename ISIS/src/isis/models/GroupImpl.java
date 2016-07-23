
package isis.models;

import isis.interfaces.Attack;
import isis.interfaces.Group;
import isis.interfaces.War;

/**
 *
 * @author chobi
 */
public class GroupImpl implements Group {
    
    private String name;
    private int health;
    private int damage;
    private War warEffect;
    private Attack attack;
    private boolean isAttack;

    public GroupImpl(String name, int health, int damage, War warEffect, Attack attack) {
        this.setHealth(health);
        this.setDamage(damage);
        this.setWarEffect(warEffect);
        this.setAttack(attack);
        this.setName(name);
        this.isAttack = false;
    }

    public boolean isIsAttack() {
        return isAttack;
    }

    public void setIsAttack(boolean isAttack) {
        this.isAttack = isAttack;
    }
    
    

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
    

    private void setHealth(int health) {
        this.health = health;
    }

    private void setDamage(int damage) {
        this.damage = damage;
    }

    private void setWarEffect(War warEffect) {
        this.warEffect = warEffect;
    }

    private void setAttack(Attack attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }
    
    

    @Override
    public void attack(Group group) {
        this.isAttack = true;
        //TODO ...
        
    }

}
