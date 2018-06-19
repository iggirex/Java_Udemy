
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.*;
import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        
        for(int i = 0; i < encrypted.length(); i++){
            boolean upper = false;
            char currChar = encrypted.charAt(i);
            
            if(Character.toUpperCase(currChar) == currChar){
                upper = true;
            }
            int idx = alphabet.indexOf(Character.toUpperCase(encrypted.charAt(i)));
            
            if(idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                if(upper){
                    encrypted.setCharAt(i, newChar);
                } else {
                    encrypted.setCharAt(i, Character.toLowerCase(newChar));
                }
            }
        }
        return encrypted.toString();
    }
    
    public void testCaesarCipher(){
        //System.out.println(encrypt("ABC", 1));
        //System.out.println(encrypt("ABC", 2));
        //System.out.println(encrypt("da FuNK?ster isimUS", 3));
        //System.out.println(encrypt("BCD", 1));
        
        //System.out.println(encrypt("I AM IGMA?STER 50 million!!!", 2));
        //System.out.println(encrypt("FREE CAKE IN THE CONFERECNCE ROOM", 17));
        int key = 23;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
        
    }
    
    public String encryptTwoKeys(String input, int key1, int key2){
        
        StringBuilder encrypted = new StringBuilder(input);
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        
        for(int i = 0; i < encrypted.length(); i++){
            boolean upper = false;
            char currChar = encrypted.charAt(i);
            
            if(Character.toUpperCase(currChar) == currChar){
                upper = true;
            }
            int idx = alphabet.indexOf(Character.toUpperCase(encrypted.charAt(i)));
            
            if(idx != -1){
                char newChar = ' ';
                if(i % 2 == 0){
                    newChar = shiftedAlphabet1.charAt(idx);
                } else {
                    newChar = shiftedAlphabet2.charAt(idx);
                }
                
                if(upper){
                    encrypted.setCharAt(i, newChar);
                } else {
                    encrypted.setCharAt(i, Character.toLowerCase(newChar));
                }
            }
        }
        return encrypted.toString();
    }
    
    public void testEncryptTwoKeys(){
     
        System.out.println(encryptTwoKeys("First Legion", 23, 17));
        //System.out.println(encryptTwoKeys(
    }
    

}