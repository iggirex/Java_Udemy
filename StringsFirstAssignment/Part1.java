
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    
    public String findSimpleGene(String dna){
        String simpleGene = "";
        int startIndex;
        int endIndex;
        
        if (dna.indexOf("ATG") != -1){
              startIndex = dna.indexOf("ATG");
        } else {
            return "";
        }
        if (dna.indexOf("TAA") != -1){
              endIndex = dna.indexOf("TAA");
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
        
        System.out.println("goodGene result: " + findSimpleGene(goodGene));
        System.out.println("notMultiple result: " + findSimpleGene(notMultiple));
        System.out.println("noATG result: " + findSimpleGene(noATG));
        System.out.println("noTAA result: " + findSimpleGene(noTAA));
        System.out.println("neither result: " + findSimpleGene(neither));
        
    }
}
