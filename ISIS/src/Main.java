
import isis.models.CommandInterpreter;
import isis.models.Engine;
import isis.models.WorldImpl;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chobi
 */
public class Main {
    public static void main(String[] args) throws IOException{
       
            Engine engine = new Engine(new WorldImpl());
            
            engine.start();
      
    }
}
