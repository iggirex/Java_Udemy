import java.util.*;
import edu.duke.*;

public class Test {
    public void testSliceString(){
        VigenereBreaker vg = new VigenereBreaker();
        System.out.println(vg.sliceString("abcdefghijklm", 0, 3)); // adgjm
        System.out.println(vg.sliceString("abcdefghijklm", 1, 3)); // behk
        System.out.println(vg.sliceString("abcdefghijklm", 4, 5)); //ej
    }
    
    public void testTryKeyLength(){
        FileResource fr = new FileResource();
        String fileString = fr.asString();
        VigenereBreaker vg = new VigenereBreaker();
        int[] key = vg.tryKeyLength(fileString, 38,'e');
        
        String keyString = Arrays.toString(key);
        System.out.println(keyString);
    }
    
    public void testReadDictionary(){
        FileResource fr = new FileResource();
        VigenereBreaker vg = new VigenereBreaker();
        System.out.println(vg.readDictionary(fr).toString());
    }
    
    public void testMostCommonCharIn(){
        FileResource dictionaryFr = new FileResource();
        VigenereBreaker vg = new VigenereBreaker();
        HashSet<String> dictionary = vg.readDictionary(dictionaryFr);
        System.out.println("most common char in this dictionary is " + vg.mostCommonCharIn(dictionary));
    }
    
    public void testBreakVigenere(){
        VigenereBreaker vg = new VigenereBreaker();
        vg.breakVigenere();
    }
}
