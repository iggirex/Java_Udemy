import edu.duke.*;
import java.util.*;

public class GladLibMap {
    private ArrayList<String> usedWords;
    private HashMap<String, ArrayList<String>> replacers;
    private Random myRandom;
    private int replacedWords;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    public GladLibMap(){
        replacers = new HashMap<String, ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLibMap(String source){
        replacers = new HashMap<String, ArrayList<String>>();
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
        replacers.clear();
        String[] sources = {"adjective", "noun", "color", "country", "name",
                        "animal", "timeframe", "verb", "fruit"};
        
        for(int i=0; i < sources.length; i++){
            String category = sources[i];
            ArrayList<String> wordList = readIt(source + "/" + category + ".txt");
            replacers.put(category, wordList);
        }
        usedWords = new ArrayList<String>();
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        ArrayList<String> replacerList = replacers.get(label);
        
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        return randomFrom(replacers.get(label));
        //return "**UNKNOWN**";
    }
    
    private Boolean hasItBeenUsed(String w){
        if(usedWords.contains(w)){
            return true;
        }
        return false;
    }
    
    private String processWord(String w){
        replacedWords++;
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        
        while(hasItBeenUsed(sub)){
            sub = getSubstitute(w.substring(first+1,last));
        }
        usedWords.add(sub);
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    public int totalWordsInMap(){
        int counter = 0;
        for(String category : replacers.keySet()){
            counter += replacers.get(category).size();
        }
        return counter;
    }
    
    public void makeStory(){
        usedWords.clear();
        replacedWords = 0;
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate3.txt");
        printOut(story, 60);
        System.out.println("\n" + replacedWords);
        System.out.println("\nTotal words stored in HashMap: " + totalWordsInMap());
    }
}
