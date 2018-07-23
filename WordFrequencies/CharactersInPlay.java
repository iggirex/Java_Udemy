
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import edu.duke.FileResource;
public class CharactersInPlay {
    private ArrayList<String> names;
    private ArrayList<Integer> counts;
    
    public CharactersInPlay(){
        names = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }
    
    public void update(String person){
        // add character to names if not already there
        // add count to counts
        int characterIdx = names.indexOf(person);
                
        if(characterIdx == -1){
            names.add(person);
            counts.add(1);
        } else {
            counts.set(characterIdx, counts.get(characterIdx) + 1);
        }
    }
    
    public void findAllCharacters(){
        names.clear();
        counts.clear();
        FileResource fr = new FileResource();
        
        for(String l : fr.lines()){
            int periodIdx = l.indexOf(".");
            
            if(periodIdx != -1){
                String character = l.substring(0, periodIdx);
                update(character);
            }
        }
    }
    
    public void charactersWithNumParts(int num1, int num2){
        for(int i=0; i < names.size(); i++){
            int personCounts = counts.get(i);
            if(personCounts > num1 && personCounts < num2){
               System.out.println(names.get(i) + " >> " + personCounts); 
            }
        }
    }
    
    public void tester(){
        findAllCharacters();

        //for(int i=0; i < names.size(); i++){
        //    System.out.println(names.get(i) + " >> " + counts.get(i));
        //}
        charactersWithNumParts(9, 16);
        // estimate what a "main character" is - how many speaking parts to be "main"
        
        // test of macbethSmall, macBeth
    }
}
