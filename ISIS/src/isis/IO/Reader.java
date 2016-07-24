/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author chobi
 */
public class Reader {
    
    public static InputStreamReader inStreamReader(InputStream in){
        return new InputStreamReader(in);
    }
    public static BufferedReader bufferedReader(InputStream in){
        return new BufferedReader(inStreamReader(in));
    }
    public static Scanner scanner(InputStream in){
        return new Scanner(inStreamReader(in));
    }
}
    

