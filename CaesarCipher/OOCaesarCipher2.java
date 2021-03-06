
/**
 * Write a description of OOCaesarCipher2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OOCaesarCipher2 {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    int encryptionKey1;
    int encryptionKey2;
    
    public OOCaesarCipher2(int key1, int key2){
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        encryptionKey1 = key1;
        encryptionKey2 = key2;
        shiftedAlphabet1 = alphabet.substring(encryptionKey1) + alphabet.substring(0,encryptionKey1);
        shiftedAlphabet2 = alphabet.substring(encryptionKey2) + alphabet.substring(0,encryptionKey2);
    }
    
    public String getLetters(String input, int start){
        StringBuilder result = new StringBuilder();
        
        for(int i=start; i < input.length(); i+=2){
            result.append(input.charAt(i));
        }
        return result.toString();
    }
    
    public String encrypt(String input, String shiftedAlph){
        String result = "";
        
        for(int i=0; i < input.length(); i++){
            char inputCh = Character.toLowerCase(input.charAt(i));
            
            if(alphabet.indexOf(inputCh) != -1){
                int alphabetIdx = alphabet.indexOf(inputCh);
                char shiftedChar = shiftedAlph.charAt(alphabetIdx);
                result = result + shiftedChar;
            } else {
                result = result + inputCh;
            }
        }
        return result;
    }
    
    public void decryptTwo(String input, int dKey1, int dKey2){
        StringBuilder result = new StringBuilder();
        String letters1 = getLetters(input, 0);
        String letters2 = getLetters(input, 1);
        
        String encrypted1 = encrypt(letters1, shiftedAlphabet1);
        String encrypted2 = encrypt(letters2, shiftedAlphabet2);
        
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i < input.length(); i++){
            
            if(i % 2 == 0){
                result.append(encrypted1.charAt(count1));
                count1++;
            } else {
                result.append(encrypted2.charAt(count2));
                count2++;
            }
        }
        //return result.toString();
        
    }
    
    
    public String encryptTwo(String input){
        StringBuilder result = new StringBuilder();
        String letters1 = getLetters(input, 0);
        String letters2 = getLetters(input, 1);
        
        String encrypted1 = encrypt(letters1, shiftedAlphabet1);
        String encrypted2 = encrypt(letters2, shiftedAlphabet2);
        
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i < input.length(); i++){
            
            if(i % 2 == 0){
                result.append(encrypted1.charAt(count1));
                count1++;
            } else {
                result.append(encrypted2.charAt(count2));
                count2++;
            }
        }
        return result.toString();
    }
    
    public void weekTest(){
        //String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String message = "aaaaaaaaaaaaaaa";
        
        OOCaesarCipher2 cc2 = new OOCaesarCipher2(20, 8);
        //OOCaesarCipher2 cc2 = new OOCaesarCipher2(21, 8);
        
        System.out.println(cc2.encrypt(message,shiftedAlphabet1));
        
        System.out.println(cc2.encryptTwo(message));
    }
    
    public int maxIndex(String input){
        int[] letterCounts = new int[26];
        int maxIndex = 0;
        int maxIndexCount = 0;
        
        for(int i=0; i < input.length(); i++){
            char ch = Character.toLowerCase(input.charAt(i));
            int chIndex = alphabet.indexOf(ch);
            
            if(chIndex != -1){
                letterCounts[chIndex]++;
            }
        }
        
        
        for(int j=0; j<letterCounts.length; j++){
            
            if(letterCounts[j] > maxIndexCount){
                maxIndex = j;
                maxIndexCount = letterCounts[j];
            }
        }
        return maxIndex;
    }
    
    
    public void breakCaesarCipher(String input){
        String letters1 = getLetters(input, 0);
        String letters2 = getLetters(input, 1);
        
        String decrypted = "";
        
        int maxIndex1 = maxIndex(letters1);
        int maxIndex2 = maxIndex(letters2);
        
        System.out.println("letters2: " + letters1 + " and letters2: " + letters2);
        System.out.println("maxIndex1: " + maxIndex1 + " and maxIndex2: " + maxIndex2);
        
        int ecryptionKey1 = maxIndex1 - 4;
        int ecryptionKey2 = maxIndex2 -4;
        
        if(maxIndex1 < 4){
            encryptionKey1 = 26 - (4 - maxIndex1);
        }
        if(maxIndex2 < 4){
            encryptionKey2 = 26 - (4 - maxIndex2);
        }
        
        int decryptionKey1 = 26 - encryptionKey1;
        int decryptionKey2 = 26 - encryptionKey2;
        
        String shiftedAlphabet3 = alphabet.substring(decryptionKey1) + alphabet.substring(0,decryptionKey1);
        String shiftedAlphabet4 = alphabet.substring(decryptionKey2) + alphabet.substring(0,decryptionKey2);
        
        System.out.println("This is encryptionKey1: " + encryptionKey1 + " and encryptKey2: " + encryptionKey2);
        
        String decrypted1 = encrypt(letters1, shiftedAlphabet3);
        String decrypted2 = encrypt(letters2, shiftedAlphabet4);
        for(int i=0; i < letters1.length(); i++){
            decrypted = decrypted + decrypted1.charAt(i);
            
            System.out.println("this is decrypted2.length()" + decrypted2.length() + " and i: " + i);

            if(decrypted2.length() > i){
                decrypted = decrypted + decrypted2.charAt(i);
            }
        }
        System.out.println(">>>> decrypted String: " + decrypted);
    }
    
    public void testEncryptTwo(){
        OOCaesarCipher2 cc2 = new OOCaesarCipher2(1, 2);
        String input = "abcdEFG";
        
        String encrypted = cc2.encryptTwo(input);
        System.out.println("message: " + input + " with key1: " + cc2.encryptionKey1 + " and key2: " +
                            cc2.encryptionKey2 + " give encrypted message: " + encrypted);
    }
    
    public void testGetLetters(){
        String input = "abcdefGHIJK";
        String letters1 = getLetters(input, 0);
        String letters2 = getLetters(input, 1);
        System.out.println("This is letters1: " + letters1 + " and this is letters2 " + letters2);
    }
    
    public void testMaxIndex(){
        //System.out.println(maxIndex("a tea stinga"));
        //System.out.println(maxIndex("ba tea stbingabb"));
        System.out.println(maxIndex("CCc $c zzz"));
    }
    
    public void testBreakCaesarCipher(){
        //OOCaesarCipher2 cc2 = new OOCaesarCipher2(1, 2);
        OOCaesarCipher2 cc2 = new OOCaesarCipher2(10, 16);
        String message = "heeeeey duder, ye eateing dem cheese bees?";
        
        //String encrypted = cc2.encryptTwo(message);
        String encrypted = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        
        System.out.println("This is doubly encrypted message: " + encrypted);
        
        cc2.breakCaesarCipher(encrypted);
    }

}
