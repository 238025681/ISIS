/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author chobi
 */
public class Reader {
    
   public Scanner consoleRead(){
      Scanner scan = new Scanner(System.in);
      
    return scan;
   }
   
   public BufferedReader br (){
       try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
       return reader;    
       } catch (IOException ioe) {
           System.out.println(ioe.getMessage());
       }
       return null;
   }
    
}
