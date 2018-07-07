
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
            
            //System.out.println("countArr of : " + k + " = " + count[k]);
            
            if(count[k] > maxCount){
                maxCount = count[k];
                maxIndex = k;
            }
        }
        return maxIndex;
    }
    
    public int newMaxIndex(int[] counts){
        int maxCount = 0;
        int maxIndex = 0;
        for(int k=0; k < counts.length; k++){
            if(counts[k] > maxCount){
                maxCount = counts[k];
                maxIndex = k;
            }
        }
        return maxIndex;
    }
    
    public int[] countLetters(String s){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        
        for(int i=0; i < s.length(); i++){
            char ch = Character.toLowerCase(s.charAt(i));
            int index = alph.indexOf(ch);
            
            if(index != -1){
                counts[index]++;
            }
        }
        return counts;
    }
    
    public int getKey(String s){
        int[] counts = countLetters(s);
        int maxIdx = newMaxIndex(counts);
        int encryptionKey = maxIdx - 4;
        
        if( maxIdx < 4){
            
            encryptionKey = 26 - (4 - maxIdx);
        }
        
        System.out.println("$$$ inside getKey and encryption is : " + encryptionKey);
        return encryptionKey;
    }
    
    public String decrypt(String encrypted){
        int encryptionKey = getKey(encrypted);
        int decryptionKey = 26 - encryptionKey;
        
        System.out.println("This is decryptionKey: " + decryptionKey);
        String decrypted = encrypt(encrypted, decryptionKey);
        return decrypted;
    }
    
    public void testDecrypt(){
     
        String encrypted1 = encrypt("Bees better then eves eets",10);
        String encrypted2 = encrypt("Bees better then eves eets",1);
        String encrypted3 = encrypt("Bent enter send went lent peet",1);
        //String encrypted1 = encrypt("Bees better then eves eets",10);
        //String encrypted1 = encrypt("Bees better then eves eets",10);
        
        decrypt(encrypted2);
    }

    public String statisticalDecrypt(String encrypted){
        int maxIndex = maxIndex(encrypted);
        System.out.println("this is maxIndex: " + maxIndex + "\tof encrypted message: " + encrypted);
        int encryptKey = maxIndex - 4;
        int decryptKey = 26 - encryptKey;
        
        if(maxIndex < 4){
            decryptKey = 26 - (4 - maxIndex);
        }
        System.out.println("Final decryption key is: " + decryptKey);
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
        System.out.println("key1String: " + key1String + "\tkey2String: " + key2String);
        
        String key1Decrypted = decrypt(key1String);
        String key2Decrypted = decrypt(key2String);
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
        String encrypted3 = encryptTwoKeys("hey there cheese eater Peter Deedes", 2, 8);
        
        //decryptTwoKeys(encrypted3);
        //decryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx");
        //decryptTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko");
        
        //decryptTwoKeys("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!");
        
        FileResource fr = new FileResource();
        decryptTwoKeys(fr.asString());
        System.out.println("===============================");
    }
    
    public void testGetKey(){
        String encrypted1 = encrypt("eeeeeeee", 10);
        String encrypted2 = encrypt("eve eve eve eve eve", 16);
        String encrypted3 = encrypt("eve eve eve eve eve", 2);
        
        getKey(encrypted3);
    }
    
    public void testCountLetters(){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] letterCounts = countLetters("aabbccddfghizzzzzz");
        for(int i=0; i < letterCounts.length; i++){
            System.out.println(alph.charAt(i) + ": " + letterCounts[i]);
            
        }
    }
}
