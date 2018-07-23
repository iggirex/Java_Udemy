
/**
 * Write a description of WordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
import java.io.File;

public class WordsInFiles {
    private HashMap<String, ArrayList<String>> hmap;
    
    public WordsInFiles(){
        hmap = new HashMap<String, ArrayList<String>>();
    }
    
    private void addWordsFromFile(File f){
        System.out.println("------------------------");
        
        FileResource fr = new FileResource(f);
        String file = fr.toString();
        
        for(String word : fr.words()){
            String fileName = f.getName();
            
            if(hmap.containsKey(word)){
                System.out.println("word: " + word + "\nhmap.get(word)" + hmap.get(word));
                if(!hmap.get(word).contains(fileName)){
                    ArrayList<String> thisArray = hmap.get(word);
                    thisArray.add(fileName);
                    hmap.put(word, thisArray);
                }
            } else {
                hmap.put(word, new ArrayList<String>());
                
                ArrayList<String> thisArray = hmap.get(word);
                thisArray.add(fileName);
                hmap.put(word, thisArray);
            }
        }
    }
    
    private void buildWordFileMap(){
        hmap.clear();
        DirectoryResource dr = new DirectoryResource();
        
        for(File f : dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    
    private int maxNumber(){
        int max = 0;
        //String maxWord = null;
        for(String word : hmap.keySet()){
            ArrayList<String> ar = hmap.get(word);
            if(ar.size() > max){
                max = ar.size();
                //maxWord = word;
            }
        }
        return max;
    }
    
    private ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> result = new ArrayList<String>();
        for(String w : hmap.keySet()){
            if(hmap.get(w).size() == number){
                result = hmap.get(w);
            }
        }
        return result;
    }
    
    private void printFilesIn(String word){
        System.out.println(word + " = " + hmap.get(word));
    }
    
    public void tester(){
        // should call buildWordFileMap to select a group of files and build a HashMap of words, 
        // with each word mapped to an ArrayList of the filenames this word appears in, determine 
        // the maximum number of files any word is in, considering all words, and determine all the 
        // words that are in the maximum number of files and for each such word, print the filenames 
        // of the files it is in.
        buildWordFileMap();
        for(String word : hmap.keySet()){
            printFilesIn(word);
        }
        System.out.println("================");
        printFilesIn("cats");
    }

}
