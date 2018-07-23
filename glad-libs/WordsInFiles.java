
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
    private HashMap<String, Integer> wordCounts;
    
    public WordsInFiles(){
        hmap = new HashMap<String, ArrayList<String>>();
        wordCounts = new HashMap<String, Integer>();
    }
    
    private void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
        
        for(String word : fr.words()){
            word = word.toLowerCase();
            String fileName = f.getName();
            
            if(hmap.containsKey(word)){
                //System.out.println("word: " + word + "\nhmap.get(word)" + hmap.get(word));
                int prevCount = wordCounts.get(word);
                
                wordCounts.put(word, prevCount + 1);
                
                if(!hmap.get(word).contains(fileName)){
                    ArrayList<String> thisArray = hmap.get(word);
                    thisArray.add(fileName);
                    hmap.put(word, thisArray);
                }
            } else {
                hmap.put(word, new ArrayList<String>());
                
                wordCounts.put(word, 1);
                
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
                result.add(w);
            }
        }
        return result;
    }
    
    private void printFilesIn(String word){
        System.out.println(word + " = " + hmap.get(word));
    }
    
    private void doesWordAppear(){
        ArrayList<String> playList = hmap.get("tree");
        System.out.println("word tree appears in following plays: " + playList);
    }
    
    private int maxOccurences(){
        int max = 0;
        String maxWord = "";
        
        for(String word : wordCounts.keySet()){
            if(wordCounts.get(word) > max){
                max = wordCounts.get(word);
                maxWord = word;
            }
        }
        
        return max;
    }
    
    public void tester(){
        buildWordFileMap();
        for(String word : hmap.keySet()){
            printFilesIn(word);
        }
        System.out.println("================");
        printFilesIn("cats");
        System.out.println("Amount of unique words: " + hmap.size());
        System.out.println("amount of words in 4 files: " + wordsInNumFiles(4).size());
        doesWordAppear();
        
        System.out.println(maxOccurences());
    }

}
