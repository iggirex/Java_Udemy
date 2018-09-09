import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder sb = new StringBuilder();
        for(int i=whichSlice; i < message.length(); i= i  + totalSlices){
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker();
        
        for(int i=0; i < klength; i++){
            String lettersInThisKey = sliceString(encrypted, i, klength);
            key[i] = cc.getKey(lettersInThisKey);
        }
        return key;
    }

    public void breakVigenere () {
        HashMap<String, HashSet<String>> dictionaryCollection = new HashMap<String, HashSet<String>>();
        String languagesString = "Danish Dutch English French German Italian Portuguese Spanish";
        String[] languages = languagesString.split("\\W+");
        
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        
        for(String language : languages){
            System.out.println("/n               >>>> Adding Dictionary for:: " + language + "<<<</n");
            FileResource dictionaryFr = new FileResource("dictionaries/" + language);
            HashSet<String> dictionary = readDictionary(dictionaryFr);
            dictionaryCollection.put(language, dictionary);
        }
        
        String result = breakForAllLangs(encrypted, dictionaryCollection);
        System.out.println("\n\nDecrypted Message:: \n" + result);
    }
    
    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> result = new HashSet<String>();
        for(String line : fr.lines()){
            result.add(line.toLowerCase());
        }
        return result;
    }
    
    public int countWords(String message, HashSet<String> dictionary){
        int count = 0;
        String[] splitMessage = message.split("\\W+");
        
        for(String word : splitMessage){
            String lowerCaseWord = word.toLowerCase();
            if(dictionary.contains(lowerCaseWord)){
                count++;
            }
        }
        return count;
    }
    
    public char mostCommonCharIn(HashSet<String> dictionary){
        HashMap<String, Integer> letterCount = new HashMap<String, Integer>();
        int maxCount = 0;
        char mostCommonLetter = ' ';
        
        for(String word : dictionary){
            for(int i = 0; i < word.length(); i++){
                String c = word.charAt(i) + "";
                if(letterCount.get(c) == null){
                    letterCount.put(c, 0);
                } else {
                    letterCount.put(c, letterCount.get(c) + 1);
                }
            }
        }
        
        for(String key : letterCount.keySet()){
            int thisLetterCount = letterCount.get(key);
            if(thisLetterCount > maxCount){
                maxCount = thisLetterCount;
                mostCommonLetter = key.charAt(0);
            }
        }
        return mostCommonLetter;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        int maxKeyLength = 100;
        int maxCount = 0;
        int keyLengthWithMostCounts = 0;
        String result = "";
        int[] resultKey;
        char mostCommonChar = mostCommonCharIn(dictionary);
        for(int i=1; i <= maxKeyLength; i++){
            int[] key = tryKeyLength(encrypted, i, mostCommonChar);
            VigenereCipher vc = new VigenereCipher(key);
            String decrypted = vc.decrypt(encrypted);
            int count = countWords(decrypted, dictionary);
            
            if(count > maxCount){
                resultKey = key;
                maxCount = count;
                keyLengthWithMostCounts = i;
                result = decrypted;
            }
        }
        System.out.println("Key Length: " + keyLengthWithMostCounts);
        return result;
    }
    
    public String breakForAllLangs(String encrypted, HashMap<String, HashSet<String>> languages){
        int maxAmountOfValidWords = 0;
        String languageWithMostValidWords = "";
        
        for(String language : languages.keySet()){
            HashSet<String> dictionary = languages.get(language);
            String result = breakForLanguage(encrypted, dictionary);
            int wordCount = countWords(result,dictionary);
            System.out.println("$$ Language: -" + language + "- has valid amount of words: " + wordCount);
            
            if(wordCount > maxAmountOfValidWords){
                maxAmountOfValidWords = wordCount;
                languageWithMostValidWords = language;
            }
        }
        String decrypted = breakForLanguage(encrypted, languages.get(languageWithMostValidWords));
        System.out.println("Language is " + languageWithMostValidWords);
        System.out.println("Max amount of valid words counted: " + maxAmountOfValidWords);
        return decrypted;
    }
    
}
