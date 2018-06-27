
/**
 * Write a description of TestOOCaesar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestOOCaesar {
    public void countLetters(){
            
    }
        
    public int maxIndex(String input){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] idxCounts = new int[26];
        int maxIdx = 0;
        
        for(int i=0; i < input.length(); i++){
            char ch = Character.toLowerCase(input.charAt(i));
            
            if(alphabet.indexOf(ch) != -1){
                int chIdx = alphabet.indexOf(ch);
                idxCounts[chIdx]++;
            }
        }
        
        for(int j=0; j < idxCounts.length; j++){
            if(idxCounts[j] > maxIdx){
                maxIdx = j;
            }
        }
        return maxIdx;
    }
    
    public String breakCaesarCipher(String encrypted){
        int key;
        int maxIdx = maxIndex(encrypted);
        int encryptionKey = maxIdx - 4;
        
        if(maxIdx < 4){
            encryptionKey = 26 - (4 - maxIdx);
        }
        System.out.println("Encryption key is: " + encryptionKey);

        int decryptionKey = 26 - encryptionKey;
        OOCaesarCipher cc = new OOCaesarCipher(decryptionKey);
        String decrypted = cc.encrypt(encrypted);
        return decrypted;
    }
    
    public void testBreakCaesarCipher(){
        String message0 = "aebecedefg";
        int key = 1;
        
        OOCaesarCipher cc = new OOCaesarCipher(key);
        String encrypted = cc.encrypt(message0);
        String decrypted = breakCaesarCipher(encrypted);
        
        System.out.print("Encrypt message " + message0 + " with key" + key + "this is message: " + 
                            encrypted + "\tAnd decrypt the message => " + decrypted); 
        
    }
    
    public void simpleTest(String input, int key){
        OOCaesarCipher cc = new OOCaesarCipher(key);
        String encrypted = cc.encrypt(input);
        String decrypted = cc.decrypt(encrypted);
        System.out.println("Encrypted String is: " + encrypted);
        System.out.println("Decrypted String is: " + decrypted);
        
        System.out.println("BreakCaesarCipher on message/key: " + input + "/" + key + ":\t" + 
                                breakCaesarCipher(input));

    }
    
    public void testMaxIndex(){
        System.out.print("Should be 2: " + maxIndex("aabbccccddeeffghi jklmnop q(*&rs"));
        System.out.print("Should be 25: " + maxIndex("azzabbcccczzzddeezffzghiz jklzmnzop qz(*&rs"));
    }
}
