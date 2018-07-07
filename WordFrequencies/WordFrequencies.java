
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
                System.out.println("Thjis is myWords size: " + myWords.size() + " and index: " + idx);
                myWords.add(s);
                myFreqs.add(1);
            } else {
                myFreqs.set(idx, myFreqs.get(idx) + 1);
            }
        }
    }
    
    public int findIndexOfMax(){
        // returns index location of largest value in myFreqs
        // if tie, return first value
        return 0;
    }
    
    public void tester(){
        findUnique();
        for(int i=0; i < myWords.size(); i++){
            System.out.println("The word -" + myWords.get(i) + "- occurs " + myFreqs.get(i) + " many times");
        }
        
        //
        //findIndexOfMax();
    }
}
