
/**
 * An object oriented Caesar cipher
 * including encryption and decryption functions
 * 
 * @author Iggi Aguerrevere
 * @version 6/26/18)
 */
public class OOCaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    public int mainKey;
    
    public OOCaesarCipher(int key){
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        mainKey = key;
    }
    
    public String encrypt(String input){
        String result = "";
        
        for(int i=0; i < input.length(); i++){
            char inputCh = Character.toLowerCase(input.charAt(i));
            
            if(alphabet.indexOf(inputCh) != -1){
                int alphabetIdx = alphabet.indexOf(inputCh);
                char shiftedChar = shiftedAlphabet.charAt(alphabetIdx);
                result = result + shiftedChar;
            } else {
                result = result + inputCh;
            }
        }
        return result;
    }
    
    public String decrypt(String encrypted){
        OOCaesarCipher cc = new OOCaesarCipher(26 - mainKey);
        String decrypted = cc.encrypt(encrypted);
        
        return decrypted;
    }
}
