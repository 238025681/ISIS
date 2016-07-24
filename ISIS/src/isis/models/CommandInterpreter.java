/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.models;

import isis.interfaces.Command;
import isis.interfaces.Group;
import isis.interfaces.World;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author chobi
 */
public class CommandInterpreter implements Command{
    
    private World world;
    private Engine engine;

    
    public CommandInterpreter(World world, Engine engine) {
        this.world = world;
        this.engine = engine;
    }
    

    @Override
    public void akbar() {
    }

    @Override
    public void status() {
        System.out.print(world);
    }

    

    @Override
    public void attack(String attackGroup, String targetGroup) {
        
        Group attacker = world.getGroup().get(attackGroup);
        Group target = world.getGroup().get(targetGroup);
        
        attacker.attack(target);
        
    }

    @Override
    public void create(String name, String params) {
        String[] groupParameter = params.trim().split(",");
        world.create(name, groupParameter);
    }
    
    @Override
    public void dispatchCommand(String command, String input) {
        
        String[] tokens = input.split("\\.");
        
        String name = tokens[0];
        
        Pattern patt = Pattern.compile("\\((.*?)\\)");
        Matcher match = patt.matcher(tokens[1]);
        String params ="";
        
        if (match.find()) {
            params = match.group(1);
        }
        
        switch (command) {

            case "status":
                
                this.status();
                
                break;
                
            case "attack":
                
                this.attack(name, params);
                
                break;
                
            case "create":
                
                this.create(name, params);
                
                break;
                
            case "akbar":
                
               this.akbar();
               
                break;
                
                case "apocalypse":
                    
                    engine.stop();
                    break;
                    
            default:
                throw new AssertionError();
        }
    }

  
}
