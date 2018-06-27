
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
            System.out.println("This is ch: " + ch);
            
            if(alphabet.indexOf(ch) != -1){
                int chIdx = alphabet.indexOf(ch);
                System.out.println("this is chIdx: " + chIdx);
                idxCounts[chIdx]++;
            }
        }
        
        for(int j=0; j < idxCounts.length; j++){
            System.out.println("idxCounts[j] > maxIdx: " + idxCounts[j] + " > " + maxIdx);
            if(idxCounts[j] > maxIdx){
                
                maxIdx = j;
            }
        }
        return maxIdx;
    }
        
    public void breakCaesarCipher(){
     
    }
    
    public String breakCaesarCipher(String encrypted){
        int key;
        int maxIdx = maxIndex(encrypted);
        
        return "";
    }
    
    public void simpleTest(String input){
        OOCaesarCipher cc = new OOCaesarCipher(2);
        String encrypted = cc.encrypt(input);
        String decrypted = cc.decrypt(encrypted);
        System.out.println("Encrypted String is: " + encrypted);
        System.out.println("Decrypted String is: " + decrypted);

    }
    
    public void testMaxIndex(){
        System.out.print("Should be 2: " + maxIndex("aabbccccddeeffghi jklmnop q(*&rs"));
    }
}
