package isis.models;

import isis.IO.Reader;
import isis.interfaces.World;
import isis.interfaces.Command;
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
    private Scanner reader;
    private boolean isStarted;

    public Engine(World world) throws IOException {
        this.world = world;
        this.commands = new CommandInterpreter(this.world, this);
        this.reader = Reader.scanner(System.in);
        this.isStarted = false;
    }

    public void start() throws IOException {

        this.isStarted = true;
        

        while (isStarted) {
            
            String input = reader.nextLine();

            Pattern patt = Pattern.compile("\\.(.*?)\\(");
            Matcher match = patt.matcher(input);

            if (match.find()) {

                commands.dispatchCommand(match.group(1), input);

            }
           
        }

    }

    public void stop() {

        this.isStarted = false;
    }

}