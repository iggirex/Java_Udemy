
/**
 * Write a description of FindDna here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

//import edu.duke.StorageResource;
import edu.duke.*;
import java.lang.Math;

public class FindDna {
    
    public int findStartCodon(String dna, int index){
        int startIndex = dna.indexOf("ATG", index);
        
        return startIndex;
    }
    
    public void testFindStartCodon(){
        System.out.println(findStartCodon("GGGTTCTGTGAGATTAGGTAATGGGGTTTAG", 0)); // 20
        System.out.println(findStartCodon("GTCGAGAGACATAGACATGGCTAGATCGTAGCGTGA", 0)); // 16
        System.out.println(findStartCodon("ATGGTCATGGAGACACGAACAGAATG", 15)); // 23
        System.out.println(findStartCodon("ATGCCCCCCGGGGATGGCTAATAAATGTTTGAAATGGTAAGGCAATAAGCAATGGTGTGCGCGCAAAACCCCGGTTGGGCCGCATGCGCATAA", 0)); // 0
    }
   
    public int findStopCodonTAA(String dna, int currentIndex){
        
        int startIndex = currentIndex;
        int stopIndexCandidate = dna.indexOf("TAA", currentIndex);

        //System.out.println(">>>>> stopCandidate is starting off at: " + stopIndexCandidate);
        while (stopIndexCandidate != -1){
            stopIndexCandidate = dna.indexOf("TAA", currentIndex);
            
            int numberBetweenStartAndCandidate = stopIndexCandidate - startIndex;
            //System.out.println("This is stopCandidate: " + stopIndexCandidate + " // this is currentIndex: " + currentIndex + " // This is numberBetweenStartAndCandidate: " + numberBetweenStartAndCandidate);
            
            if(numberBetweenStartAndCandidate % 3 == 0){
                return stopIndexCandidate;
            }
            else {
                currentIndex = stopIndexCandidate + 1;
            }
        }     
        return -1;
    }
    // start = ATG, stop = TAA TGA TAG
    public void testFindStopCodonTAA(){
        System.out.println("Should be 18: " + findStopCodonTAA("GGGTTCTGTGAGATTAGGTAATGGGGTTTAG", 0));
        System.out.println("Should be -1: " + findStopCodonTAA("GTCGAGAGACATAGACATGGCTAGATCGTAGCGTGA", 0));
        System.out.println("Should be -1: " + findStopCodonTAA("ATGGTCATGGAGACACGAACAGAATGTAA", 28));
        System.out.println("Should be 26: " + findStopCodonTAA("ATGGTAATGGAGACACGAACAGAATGTAA", 8));
        System.out.println("Should be 18: " + findStopCodonTAA("ATGCCCCCCGGGGATGGCTAATAAATGTTTGAAATGGTAAGGCAATAAGCAATGGTGTGCGCGCAAAACCCCGGTTGGGCCGCATGCGCATAA", 0));
        System.out.println("Should be 38: " + findStopCodonTAA("ATGCCCACCCGGGGATGGCTAATAAATGTTTGAAATGGTAAGGCAATAAGCAATGGTGTGCGCGCAAAACCCCGGTTGGGCCGCATGCGCATAA", 0));
        System.out.println("Should be 46: " + findStopCodonTAA("ATGCCCACCCGGGGATGGCTAATAAATGTTTGAAATGGTAAGGCAATAAGCAATGTAAGTGTGCGCGCAAAACCCCGGTTGGGCCGCATGCGCATAA", 40));
        System.out.println("Should be 27: " + findStopCodonTAA("CCCTTTATGGGGTTTGTAAGTGTAACCTAA", 6));
    }
    
    public int findStopCodon(String dna, int currentIndex, String stopCodon){
        
        int startIndex = currentIndex;
        int stopIndexCandidate = dna.indexOf(stopCodon, currentIndex);

        //System.out.println(">>>>> stopCandidate is starting off at: " + stopIndexCandidate);
        while (stopIndexCandidate != -1){
            stopIndexCandidate = dna.indexOf(stopCodon, currentIndex);
            
            int numberBetweenStartAndCandidate = stopIndexCandidate - startIndex;
            //System.out.println("This is stopCandidate: " + stopIndexCandidate + " // this is currentIndex: " + currentIndex + " // This is numberBetweenStartAndCandidate: " + numberBetweenStartAndCandidate);
            
            if(numberBetweenStartAndCandidate % 3 == 0){
                return stopIndexCandidate;
            }
            else {
                currentIndex = stopIndexCandidate + 1;
            }
        }     
        return dna.length();
    }
    
    public void testFindStopCodon(){
        System.out.println("Should be 9: " + findStopCodon("GGGTTCTGCTGAGATTAGGTAATGGGGTTTAG", 0, "TGA"));
        System.out.println("Should be 18: " + findStopCodon("GGGTTCTGCGTGAGATTATGAGGTAATGGGGTTTAG", 0, "TGA"));
        System.out.println("Should be 21: " + findStopCodon("GGGTTCATGCTGCGTGAGATTTGAATGAGGTAATGGGGTTTAG", 6, "TGA"));
        System.out.println("Should be 27: " + findStopCodon("GGGTTCATGCTGCGTGAGATTCTGAATTGAGAGGTAATGGGGTTTAG", 6, "TGA"));
        System.out.println("Should be 28: " + findStopCodon("GGGTTCTATGCTGCGTGAGATTCTGAATTGAGAGGTAATGGGGTTTAG", 7, "TGA"));
        System.out.println("Should be -1: " + findStopCodon("GGGTTCTATGCTGCGTGAGATTCTGAATTGAGAGGTAATGGCGGTTTGGTTTCAG", 40, "TGA"));
        
        System.out.println("Should be 12: " + findStopCodon("GTCGAGAGACAVTAGACATGGCTAGATCGTAGCGTGA", 0, "TAG"));
        System.out.println("Should be 21: " + findStopCodon("GTCGAGAGACATAGACATGGCTAGATCGTAGCGTGA", 0, "TAG"));
        System.out.println("Should be -1: " + findStopCodon("ATGGTCATGGAGACACGAACAGAATGTAACTTGCCCCCCGTGTG", 28, "TAG"));
        System.out.println("Should be 27: " + findStopCodon("ATGGTAATGGAGACACGAACTAGAGAATAGTAA", 0, "TAG"));
        System.out.println("Should be 18: " + findStopCodon("ATGCCCCCCGGGGTAGATTAGGGCTAATAAATGTTTGAAATGGTAAGGCAATAAGCAATGGTGTGCGCGCAAAACCCCGGTTGGGCCGCATGCGCATAA", 0, "TAG"));
        System.out.println("Should be 20: " + findStopCodon("GAATGCCCCCCGGGGTAGATTAGGGCTAATAAATGTTTGAAATGGTAAGGCAATAAGCAATGGTGTGCGCGCAAAACCCCGGTTGGGCCGCATGCGCATAA", 2, "TAG"));
        
        System.out.println("Should be 9: " + findStopCodon("ATGCCCACCTGACGGGGATGGCTAATAAATGTTTGAAATGGTAAGGCAATAAGCAATGGTGTGCGCGCAAAACCCCGGTTGGGCCGCATGCGCATAA", 0, "TGA"));
        System.out.println("Should be 19: " + findStopCodon("GATGCCCACCCTGAGGGGATGAGCTAATAAATGTTTGAAATGGTAAGGCAATAAGCAATGTAAGTGTGCGCGCAAAACCCCGGTTGGGCCGCATGCGCATAA", 1, "TGA"));
        System.out.println("Should be -1: " + findStopCodon("CTCCTTTATGGGGTTTGTAAGTGATAACCTAA", 7, "TGA"));
    }
    
    
    public String findGene(String dna){
       int currentIndex = 0;
        
       // find first instance of ATG (STARTINDEX) -> at index 0
       int startIndex = findStartCodon(dna, currentIndex);
       // find instance of TAA (STOPINSTANCE) after ATG (STARTINDEX) -> 18
       int stopIndex = findStopCodonTAA(dna, startIndex);
       //System.out.println("This is startIndex: " + startIndex + " this is stopIndex: " + stopIndex);
       
       
       
       // add to collection (GENE COLLECTION)
       // update STARTINDEX
      
       // starting from index after stop codon find first instance of ATG -> index 25
       // find instance of TAA after ATG -> 38
       // is it multiple of 3 -> no
       // find instance of TAA after last instance of TAA -> index 46
       // is it multiple of 3 --> yes
       // add to collection
       // update STARTINDEX
       
       if (stopIndex != -1){
           return dna.substring(startIndex, stopIndex + 3);
       }
       return "";
    }
    
    public void testFindGene(){
     
        System.out.println("The gene found should be ATGCCCCCCGGGGATGGCTAA : " + findGene("ATGCCCCCCGGGGATGGCTAATAAATGTTTGAAATGGTAAGGCAATAAGCAATGGTGTGCGCGCAAAACCCCGGTTGGGCCGCATGCGCATAA"));
        System.out.println("The gene found should be ATGCCCTGGGTGTCTCCCCTCATGAGATAGCCCCCCTAA : " + findGene("AACAGAATGCCCTGGGTGTCTCCCCTCATGAGATAGCCCCCCTAAATGGGTTGAAGAGGGATGTAGTAAATGCCCCCCTAA"));
        //System.out.println("The gene found should be ATGGGGTTTGTAAGTGTAACCTAA : " + findGene("CCCTTT-ATG-GGG-TTT-GTA-AGT-GTA-ACC-TAA"));
        System.out.println("The gene found should be ATGGGGTTTGTAAGTGTAACCTAA : " + findGene("CCCTTTATGGGGTTTGTAAGTGTAACCTAA"));
        System.out.println("The gene found should be EMPTY STRING : " + findGene("CCCTTTATGGGGTTTGTCCCCAGTGTAACC"));
    }
    
    public StorageResource findAllGenes(String dna){
        StorageResource geneResults = new StorageResource();
        
        int currentIndex = 0;
        while(true){
            
            if(currentIndex >= dna.length()){
                break;
            }
         
            int startIndex = findStartCodon(dna, currentIndex);
            
            int stopIndex = 0;
            if (findStopCodon(dna, startIndex, "TAA") > 0){
                if (findStopCodon(dna, startIndex, "TAG") > 0){
                    stopIndex = Math.min(findStopCodon(dna, startIndex, "TAA"), findStopCodon(dna, startIndex, "TAG"));
                }
                else {
                    stopIndex = Math.min(stopIndex, findStopCodon(dna, startIndex, "TAA"));
                }
            }
            if (findStopCodon(dna, startIndex, "TGA") > 0){
                stopIndex = Math.min(stopIndex, findStopCodon(dna, startIndex, "TGA"));
            }
            
            System.out.println("$$$$ startIndex is: " + startIndex + " // stopIndex is: " + stopIndex + " // current index is: " + currentIndex + " // dna.length() is: " + dna.length());
            
            if(stopIndex == -1 || startIndex == -1 || stopIndex == dna.length()){
                break;
            } else {
                System.out.println(">>>>>>: " + dna.substring(startIndex, stopIndex + 3));
                geneResults.add(dna.substring(startIndex, stopIndex + 3));
                currentIndex = stopIndex + 3;
            }
        }
        return geneResults;
        
    }
    
    public void testFindAllGenes(){
        // 3 genes - ATGCCCCCCGGGGATGGCTAA >> startIndex: 0 >> stopIndex: 18, ATG-TTT-GAA-ATG-GTA-AGG-CAA-TAA >> startIndex: 24 >> stopIndex: 45
        // ATG-GTG-TGC-GCG-CAA-AAC-CCC-GGT-TGG-GCC-GCA-TGC-GCA-TAA >> startIndex: 51 >> stopIndex: 90
        // String dna1 = "ATG-CCC-CCC-GGG-GAT-GGC-TAA-TAA-ATG-TTT-GAA-ATG-GTA-AGG-CAA-TAA-GCA-ATG-GTG-TGC-GCG-CAA-AAC-CCC-GGT-TGG-GCC-GCA-TGC-GCA-TAA";        
        String dna1 = "ATGCCCCCCGGGGATGGCTAATAAATGTTTGAAATGGTAAGGCAATAAGCAATGGTGTGCGCGCAAAACCCCGGTTGGGCCGCATGCGCATAA";
        
        // 3 genes - ATGCCCCCCGGGGATGGCTAG >> startIndex: 0 >> stopIndex: 18, ATG-TTT-GAA-ATG-GTA-AGG-CAA-TGA >> startIndex: 24 >> stopIndex: 45
        // ATG-GTG-TGC-GCG-CAA-AAC-CCC-GGT-TGG-GCC-GCA-TGC-GCA-TAG >> startIndex: 51 >> stopIndex: 90
        // String dna1 = "ATG-CCC-CCC-GGG-GAT-GGC-TAA-TAA-ATG-TTT-GAA-ATG-GTA-AGG-CAA-TAA-GCA-ATG-GTG-TGC-GCG-CAA-AAC-CCC-GGT-TGG-GCC-GCA-TGC-GCA-TAA";        
        String dna2 = "ATGCCCCCCGGGGATGGCTAGTAAATGTTTGAAATGGTAAGGCAATGAGCAATGGTGTGCGCGCAAAACCCCGGTTGGGCCGCATGCGCATAG";
        
        // 3 genes - ATGCCCCCCGGGGATGGCTAG >> startIndex: 1 >> stopIndex: 19, ATG-TTT-GAA-ATG-GTA-AGG-CAA-TGA >> startIndex: 25 >> stopIndex: 46
        // ATG-GTG-TGC-GCG-CAA-AAC-CCC-GGT-TGG-GCC-GCA-TGC-GCA-TAG >> startIndex: 52 >> stopIndex: 91
        // String dna1 = "ATG-CCC-CCC-GGG-GAT-GGC-TAA-TAA-ATG-TTT-GAA-ATG-GTA-AGG-CAA-TAA-GCA-ATG-GTG-TGC-GCG-CAA-AAC-CCC-GGT-TGG-GCC-GCA-TGC-GCA-TAA";        
        String dna3 = "TATGCCCCCCGGGGATGGCTAGTAAATGTTTGAAATGGTAAGGCAATGAGCAATGGTGTGCGCGCAAAACCCCGGTTGGGCCGCATGCGCATAG";
        
        //System.out.println("=============================================================================");
        //System.out.println("Example 1 should have 3 genes => ATGCCCCCCGGGGATGGCTAA >> startIndex: 0 >> stopIndex: 18");
        //System.out.println("ATG-TTT-GAA-ATG-GTA-AGG-CAA-TAA >> startIndex: 24 >> stopIndex: 45");
        //System.out.println("ATG-GTG-TGC-GCG-CAA-AAC-CCC-GGT-TGG-GCC-GCA-TGC-GCA-TAA >> startIndex: 51 >> stopIndex: 90");
        //System.out.println("=============================================================================");
        //findAllGenes(dna1);
        
        //System.out.println("=============================================================================");
        //System.out.println("Example 2 should have 3 genes => ATGCCCCCCGGGGATGGCTAG >> startIndex: 0 >> stopIndex: 18");
        //System.out.println("ATG-TTT-GAA-ATG-GTA-AGG-CAA-TGA >> startIndex: 24 >> stopIndex: 45");
        //System.out.println("ATG-GTG-TGC-GCG-CAA-AAC-CCC-GGT-TGG-GCC-GCA-TGC-GCA-TAG >> startIndex: 51 >> stopIndex: 90");
        //System.out.println("=============================================================================");
        //findAllGenes(dna2);
        
        //System.out.println("=============================================================================");
        //System.out.println("Example 3 should have 3 genes => ATGCCCCCCGGGGATGGCTAG >> startIndex: 1 >> stopIndex: 19");
        //System.out.println("ATG-TTT-GAA-ATG-GTA-AGG-CAA-TGA >> startIndex: 25 >> stopIndex: 46");
        //System.out.println("ATG-GTG-TGC-GCG-CAA-AAC-CCC-GGT-TGG-GCC-GCA-TGC-GCA-TAG >> startIndex: 52 >> stopIndex: 91");
        //System.out.println("=============================================================================");
        //findAllGenes(dna3);
        
        
        FileResource fr = new FileResource("brca1line.fa");
        String dnaTest = fr.asString();
        dnaTest = dnaTest.toUpperCase();
        
        StorageResource geneResults = findAllGenes(dnaTest);
        
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println(geneResults.size());
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        
        // 3 genes - ATG-CCC-TGG-GTG-TCT-CCC-CTC-ATG-AGA-TAG, ATG-AGA-TAG-CCC-CCC-TAA-ATG-GGT-TGA-AGA-GGG-TCC-TAG
        // ATG-TAG-TAA-ATG-CCC-CCC-TAA
        //String dna2 = "AAC-AGA-ATG-CCC-TGG-GTG-TCT-CCC-CTC-ATG-AGA-TAG-CCC-CCC-TAA-ATG-GGT-TGA-AGA-GGG-ATG-TAG-TAA-ATG-CCC-CCC-TAA";
        String dna4 = "AACAGAATGCCCTGGGTGTCTCCCCTCATGAGATAGCCCCCCTAAATGGGTTGAAGAGGGATGTAGTAAATGCCCCCCTAA";
        
        // 3 genes - ATG-CCC-TGG-GTG-TCT-CCC-CTC-ATG-AGA-TAG, ATG-AGA-TAG-CCC-CCC-TAA-ATG-GGT-TGA-AGA-GGG-TCC-TAG
        // ATG-TAG-TAA-ATG-CCC-CCC-TAA        
        //String dna3 = "GAAC-AGA-ATG-CCC-TGG-GTG-TCT-CCC-CTC-ATG-AGA-TAG-CCC-CCC-TAA-ATG-GGT-TGA-AGA-GGG-ATG-TAG-TAA-ATG-CCC-CCC-TAA";
        String dna5 = "GAACAGAATGCCCTGGGTGTCTCCCCTCATGAGATAGCCCCCCTAAATGGGTTGAAGAGGGATGTAGTAAATGCCCCCCTAA";
        
        
        
        
        
        //StorageResource genes1 = findAllGenes(dna1);
        //StorageResource genes2 = findAllGenes(dna2);
        //StorageResource genes3 = findAllGenes(dna3);
        
    }

}
