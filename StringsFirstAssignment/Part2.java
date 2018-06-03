
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    
    public String findSimpleGene(String dna, String startCodon, String stopCodon){

        String simpleGene = "";
        int startIndex;
        int endIndex;
        String firstLetter = Character.toString(dna.charAt(0));
        
        if (firstLetter == firstLetter.toLowerCase()){
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }
        
        String firstLetterLowerCase = firstLetter.toLowerCase();
        
        if (firstLetterLowerCase.equals(firstLetter)){
            
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }
        
        if (dna.indexOf(startCodon) != -1){
              startIndex = dna.indexOf(startCodon);
        } else {
            return "";
        }
        if (dna.indexOf(stopCodon) != -1){
              endIndex = dna.indexOf(stopCodon);
        } else {
            return "";
        }
        
        simpleGene = dna.substring(startIndex, endIndex + 3);
        
        if(simpleGene.length() % 3 == 0){
            return simpleGene;
        }
        return "";
    }
    
    public void testSimpleGene(){
    
        String goodGene = "TCGAAATGGACTCGGCGTAACAGACCAT";
        String notMultiple = "TCGAAATGGACTCGCGTAACAGACCAT";
        String noATG = "TGACAGTTCGAAGATCTATAA";
        String noTAA = "GCTCATGGTCACAG";
        String neither = "ATTCGCACATCGTAGAACCAGGGACTCCG";
        String lowerCase = "atgtgcgtcgtgaacaagtgcgtcacgcagtaagtgcgta";
        String mixedCase = "atgACgCTAgcgGtTaA";
        
        String startCodon = "ATG";
        String stopCodon = "TAA";
        
        System.out.println("goodGene result: " + findSimpleGene(goodGene, startCodon, stopCodon));
        System.out.println("notMultiple result: " + findSimpleGene(notMultiple, startCodon, stopCodon));
        System.out.println("noATG result: " + findSimpleGene(noATG, startCodon, stopCodon));
        System.out.println("noTAA result: " + findSimpleGene(noTAA, startCodon, stopCodon));
        System.out.println("neither result: " + findSimpleGene(neither, startCodon, stopCodon));
        System.out.println("lower case result: " + findSimpleGene(lowerCase, startCodon, stopCodon));
        System.out.println("mixed case result: " + findSimpleGene(mixedCase, startCodon, stopCodon));
        
    }
}
