
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;

public class WordLengths {

    public void countWordLengths(FileResource resource, int counts){
        
        int[] countArr = new int[counts];
        
        for(String word : resource.words()){
            int wordLength = 0;
            
            for(int k=0; k < word.length(); k++){
                char ch = word.charAt(k);
                
                if(k == 0 || k == word.length() - 1){
                    if(Character.isLetter(ch)){
                        wordLength++;
                        if(k > counts - 1){
                            wordLength = counts - 1;
                        }
                    }
                } else {
                    wordLength++;
                }
            }
            countArr[wordLength] += 1;
            System.out.println(word);
        }
        
        for(int i=0; i < countArr.length; i++){
            System.out.println(i + ":\t" + countArr[i]);
        }
    }
    
    public void testCountWordsLengths(){
        FileResource fr = new FileResource();
        
        countWordLengths(fr, 31);
        
    }
    
}
