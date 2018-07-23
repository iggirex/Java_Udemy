
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import edu.duke.FileResource;
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        
        for(String s : fr.words()){
            s = s.toLowerCase();
            int idx = myWords.indexOf(s);
            if (idx == -1){
                myWords.add(s);
                myFreqs.add(1);
            } else {
                myFreqs.set(idx, myFreqs.get(idx) + 1);
            }
        }
    }
    
    public int findIndexOfMax(){
        int largest = 0;
        int largestIdx = 0;
        
        for(int i=0; i < myWords.size(); i++){
            if(myFreqs.get(i) > largest){
                largest = myFreqs.get(i);
                largestIdx = i;
            }
        }
        return largestIdx;
    }
    
    public void tester(){
        findUnique();
        int max = findIndexOfMax();
        System.out.println("WWTTTFFFF");
        System.out.println("Amount of unique words: " + myWords.size());
        for(int i=0; i < myWords.size(); i++){
            System.out.println(myFreqs.get(i) + " " + myWords.get(i));
        }
        System.out.println("helllo?");
        System.out.println("Amount of unique words: " + myWords.size());
        System.out.println("The word that occurs most often and its count are: " + myWords.get(max) + " " + myFreqs.get(max));
    }
}
