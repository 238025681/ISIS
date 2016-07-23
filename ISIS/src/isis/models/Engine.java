
package isis.models;

import isis.IO.Reader;
import isis.interfaces.World;
import isis.interfaces.Command;
import isis.interfaces.Group;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author chobi
 */
public class Engine {
    
    private World world;
    private Command commands;
    private Reader reader;

    public Engine(World world, Command command) throws IOException{
        this.world = world;
        this.commands = command;
        this.reader = new Reader();
    }
    
    public void run() throws IOException{
        
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!input.contains("apocalypse()")) {
            String[] params = input.split("\\.");
            String object = params[0];
            String command = params[1];
            
            if (!object.equals("world")) {
                if (command.contains("create")) {
                    Pattern patt =  Pattern.compile("\\b(\\()([a-zA-Z0-9 \\,\\s]+)");
                    Matcher match = patt.matcher(command);
                    
                    while (match.find()) {
                        
                        String[] fields = match.group(2).trim().split(",");
                        
                        world.create(object, fields);
                        
                    }
                }
                if (command.contains("attack")) {
                    String[] t = command.split("\\(");
                    String  target = t[1].substring(0, t[1].length() - 1);
                    Group attaker = world.getGroup().get(object);
                    Group targetGroup = world.getGroup().get(target);
                    attaker.attack(targetGroup);
                    
                    
                }
                
            }
            
            if (object.equals("world")) {
                
            }
            
            
            input = scan.nextLine();
        }
    
    
    }
    
    
    
}
