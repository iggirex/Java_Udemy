
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;

public class CaesarBreaker {
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
    
    public int maxIndex(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] count = new int[26];
        
        for(int k=0; k < message.length(); k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int index = alph.indexOf(ch);
            if(index != -1){
                count[index]++;
            }
        }
        
        int maxCount = 0;
        int maxIndex = 0;
        for(int k=0; k < count.length; k++){
            if(count[k] > maxCount){
                maxCount = count[k];
                maxIndex = k;
            }
        }
        return maxIndex;
    }

    public String statisticalDecrypt(String encrypted){
        int maxIndex = maxIndex(encrypted);
        int encryptKey = maxIndex - 4;
        int decryptKey = 26 - encryptKey;
        
        if(maxIndex < 4){
            decryptKey = 26 - (4 - maxIndex);
        }
        int x = 16;
        //System.out.println("we want to encrypt with " + x + " which gives us: " + encrypt(encrypted, decryptKey));
        //System.out.println(encrypt(encrypted, 26 - maxIndex));
        return encrypt(encrypted, decryptKey);
    }
    
    public String halfOfString(String message, int start){
        StringBuilder returnString = new StringBuilder();
        for(int i=start; i < message.length(); i+=2){
                returnString.append(message.charAt(i));
        }
        return returnString.toString();
    }
    
    
    
    public void decryptTwoKeys(String message){
        String key1String = halfOfString(message, 0);
        String key2String = halfOfString(message, 1);
        
        String key1Decrypted = statisticalDecrypt(key1String);
        String key2Decrypted = statisticalDecrypt(key2String);
        System.out.println("key1String: " + key1String + "\tand key2String: " + key2String);
        
        StringBuilder decryptedMessage = new StringBuilder();
        
        int string1Counter = 0;
        int string2Counter = 0;
        
        for(int i=0; i < message.length(); i++){
            if(i % 2 == 0){
                decryptedMessage.append(key1Decrypted.charAt(string1Counter));
                string1Counter++;
            } else{
                decryptedMessage.append(key2Decrypted.charAt(string2Counter));
                string2Counter++;
            }
        }
        
        //System.out.println("key1Decrypted: " + key1Decrypted + "\tand key2Decrypted: " + key2Decrypted);
        System.out.println("Decrypted message >>>> " + decryptedMessage.toString());
    }
    
    public void testDecryptTwoKeys(){
        String encrypted1 = encryptTwoKeys("hey there duderonemous", 14, 8);
        
        String encrypted2 = encryptTwoKeys("hey there cheese eater Peter Deedes", 14, 8);
        
        decryptTwoKeys(encrypted2);
        
        System.out.println("===============================");
        System.out.println("===============================");
        
    }
}
