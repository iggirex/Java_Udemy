
/**
 * Write a description of fguiopa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.lang.Math;

public class fguiopa {
    
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
        
       int startIndex = findStartCodon(dna, currentIndex);

       int stopIndex = findStopCodonTAA(dna, startIndex);

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
    
    public int longerThan60(StorageResource geneCollection){
        int count = 0;
        
        for(String gene : geneCollection.data()){
            
            if(gene.length() > 60){
                count++;
            }
        }
        return count;
    }
    
    public int cgRatio(StorageResource geneCollection){
        
        int larger = 0;
        
        //System.out.println("This is geneCollection size: " + geneCollection.size());
        
        for(String gene : geneCollection.data()){
            int pos = 0;
            double count = 0;
            
            //System.out.println(">>>>>>>>>>> Inside loop of collection <<<<<<<<<<< ");
            //System.out.println("this is pos: " + pos + " // this is gene: " + gene + " // this is gene.indexOf(pos) " + gene.indexOf(pos));
            
            while (gene.indexOf(pos) != gene.length()){
                
                String currentLetter = gene.substring(pos, pos + 1);
                
                //System.out.println("this current letter: " + currentLetter + " and its index is: " + gene.indexOf(currentLetter) + " and gene.length() is: " + gene.length());
                //System.out.println("And this is position: " + pos + " and this is count: " + count);

                
                if (gene.substring(pos, pos + 1).equals("C") || gene.substring(pos, pos + 1).equals("G")){
                    count++;
                    //System.out.println(">>>>>>>>>> NOW this is count: " + count);
                }
                
                
                if(pos == gene.length() - 1){
                    break;
                }
                
                pos++;
            }
            
            if (count / gene.length() > 0.35){
                
                larger++;   
            }
            //System.out.println("$$$$$$ this is count: " + count + " and this is gene.length() : " + gene.length());
            //System.out.println("for gene: " + gene + " the CG Ratio is: " + count / gene.length());
        }
        
        //System.out.println("this is count: " + count);
        
        return larger;
        
        //double geneCollSize = geneCollection.size();
        
        //return count / geneCollSize;
    }
    
    
    public void testCgRatio(){
        
        StorageResource genes = new StorageResource();
        
        genes.add("TAGCTAATATTGCG"); // ratio = 5/14 => 0.3571
        genes.add("TAATATATATATATATATA"); // ratio = 0
        genes.add("GCCCGGGGCCCCGGGCCCGGGCC"); // ratio = 1
        genes.add("TGTCTGTCAGACAGAC"); // ratio = 0.5
        genes.add("TAGCTA"); // ratio = 2/6 => 0.33333
        genes.add("TAGCTAATATTGCG"); // ratio = 5/14 => 0.3571
        genes.add("GCCCGGGGCCCCGGGCCCGGGCC"); // ratio = 1
        genes.add("GCCCGGGGCCCCGGGCCCGGGCC"); // ratio = 1
        genes.add("TAATATATATATATATATA"); // ratio = 0
        genes.add("TAATATATATATATATATA"); // ratio = 0

        
        System.out.println("CG Ratios larger than 0.35 = " + cgRatio(genes));
        
    }
    
    public int howManyCTG(String dna){
        int startIndex = 0;
        int count = 0;
        
        while (true){
         
            startIndex = dna.indexOf("CTG", startIndex);
            
            if (startIndex == -1){
                return count;
            }
            
            count++;
            
            startIndex = startIndex + 3;
            
        }
        
    }
    
    public void testHowManyCTG(){
        
     String dna1 = "ACTGACTACTGTTCCACTCTGCTGCT"; // 4
     String dna2 = "TTCCCTGCTGCTGAGTACAGACGTACACTGCTGAGATCTGAGTCTG:"; // 7
     
     System.out.println("Should be 4: " + howManyCTG(dna1));
     System.out.println("Should be 7: " + howManyCTG(dna2));

    }
    
    public int findLongestGeneLength(StorageResource geneCollection){
        int longestLength = 0;
        
        for(String gene : geneCollection.data()){
            
            if (gene.length() > longestLength) {
                
                longestLength = gene.length();
                
            }
            
        }
        
        return longestLength;
    }
    
    public void testFindLongestGeneLength(){
        
        StorageResource genes = new StorageResource();
        
        genes.add("TAGCTAATATTGCG"); // 14
        genes.add("TAATATATATATATATATA"); // ratio = 0
        genes.add("GCCCGGGGCCCCGGGCCCGGGCCCGTGCA"); // 29
        genes.add("TGTCTGTCAGACAGAC"); // ratio = 0.5
        genes.add("TAGCTA"); // ratio = 2/6 => 0.33333
        genes.add("TAGCTAATATTGCG"); // ratio = 5/14 => 0.3571
        genes.add("GCCCGGGGCCCCGGGCCCGGGCC"); // ratio = 1
        genes.add("GCCCGGGGCCCCGGGCCCGGGCC"); // ratio = 1
        genes.add("TAATATATATATATATATA"); // ratio = 0
        genes.add("TAATATATATATATATATA"); // ratio = 0

        
        System.out.println("Longest gene length = " + findLongestGeneLength(genes));
        
        
        
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
        
        
        //FileResource fr = new FileResource("brca1line.fa");
        FileResource fr = new FileResource("GRch38dnapart.fa");
        
        String dnaTest = fr.asString();
        dnaTest = dnaTest.toUpperCase();
        
        StorageResource geneResults = findAllGenes(dnaTest);
        
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println(geneResults.size());
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("Number of genes longer than 60: " + longerThan60(geneResults));
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("Number of genes with CG ratio > 0.35: " + cgRatio(geneResults));
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("How many times CTG codons appear in dna: " + howManyCTG(dnaTest));
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("This is the longest gene length: " + findLongestGeneLength(geneResults));
        
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



