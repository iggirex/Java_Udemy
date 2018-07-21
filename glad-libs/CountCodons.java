
/**
 * Write a description of CountCodons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

public class CountCodons {
    private HashMap<String, Integer> hmap;
    
    public CountCodons(){
        hmap = new HashMap<String, Integer>();
    }
    
    public Boolean hashMapContainsCodon(String codon){
        return hmap.containsKey(codon);
    }
    
    public void buildCodonMap(int start, String dna){
        hmap.clear();
        dna = dna.toUpperCase();
        
        for(int i = start; i < dna.length(); i = i + 3){
             if(i + 3 < dna.length() - 1){
                System.out.println("i = " + i + " and dna length is : " + dna.length());
                String codon = dna.substring(i, i + 3);
                System.out.println(codon);
                if(hashMapContainsCodon(codon)){
                    hmap.put(codon, hmap.get(codon) + 1);
                } else {
                    hmap.put(codon, 1);
                }
             }
        }
    }
    
    public String getMostCommonCodon(){
        int greatest = 0;
        String greatestCodon = "";
        for(String codon : hmap.keySet()){
            if(hmap.get(codon) > greatest){
                greatest = hmap.get(codon);
                greatestCodon = codon;
            }
        }
        return greatestCodon;
    }
    
    public void printCodonCounts(){
        for(String key: hmap.keySet()){
            System.out.println(key + " : " + hmap.get(key));
        }
        System.out.println("Most common codon: " + getMostCommonCodon());
    }
    
    public void testPrintCodonCounts(){
        FileResource fr = new FileResource();
        
        buildCodonMap(2, fr.asString());
        printCodonCounts();

        // in the reading frame, prints the most common codon and its count, and prints the codons and 
        // their number of occurrences for those codons whose number of occurrences in this reading 
        // frame are between two numbers inclusive
    }

}
