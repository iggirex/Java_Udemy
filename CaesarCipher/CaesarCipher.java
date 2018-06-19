
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        
        for(int i = 0; i < encrypted.length(); i++){
            
            char currChar = Character.toUpperCase(encrypted.charAt(i));
            System.out.println("currChar: " + currChar); 
            int idx = alphabet.indexOf(currChar);
            
            if(idx != -1){
                
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }
    
    public void testCaesarCipher(){
        System.out.println(encrypt("ABC", 1));
        System.out.println(encrypt("ABC", 2));
        System.out.println(encrypt("da FuNK?ster isimUS", 3));
        //System.out.println(encrypt("BCD", 1));
        
        //System.out.println(encrypt("I AM IGMA?STER 50 million!!!", 2));
        
        System.out.println(encrypt("FREE CAKE IN THE CONFERECNCE ROOM", 17));
        
    }
    

}
