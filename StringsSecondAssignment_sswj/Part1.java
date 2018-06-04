import java.lang.Math;
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int stopCodonCandidate = dna.indexOf(stopCodon, startIndex);
        
        if(stopCodonCandidate != -1 && dna.substring(startIndex, stopCodonCandidate).length() % 3 == 0){
            return stopCodonCandidate;
        }
        
      return dna.length();
    }
    
    public String findGene(String dna){
        
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){
            return "";
        }
        
        int closestStopCodonIndex = Math.min(findStopCodon(dna, startIndex, "TAA"),findStopCodon(dna, startIndex, "TAG"));
        closestStopCodonIndex = Math.min(closestStopCodonIndex, findStopCodon(dna, startIndex, "TGA"));
        
        if(closestStopCodonIndex == dna.length()){
            return "";
        }
        
        return dna.substring(startIndex, closestStopCodonIndex + 3);
    }
    
    public void printAllGenes(String dna){
        
        while(true){
         
            String geneFound = findGene(dna);
            
            if( !geneFound.isEmpty()){
                System.out.println("found this gene: " + geneFound);
                int startIndex = dna.indexOf(geneFound);
                int endOfGeneIndex = startIndex + geneFound.length();
                dna = dna.substring( endOfGeneIndex, dna.length());
            } else {  
            break;
            }
            
        }
        
    }
    
    public void testFindCodon(){
        
        String dna1 = "AGCGTGCACAGCAATGGACCAGTGGTAAAGCTCGC"; // 1 gene
        String dna2 = "";
        String dna3 = "ATTTAGATGGCCTAAATGGTGAGACAGTAAGGGCCCATGGTGTCTCCTTAGGCGTGT"; // 3 genes
        String dna4 = "TAGGAGCAAGATGGCGCCTCGTAGTAAATGCGCTAG"; // 1 gene, 1 almost-gene not mult of 3
        String dna5 = "GATTAGATGGTGCGCTTAGATGGTAATAGATTGTAA"; // 0 genes, 2 almost-genes not mult of 3
     
        System.out.println(findStopCodon(dna1, 0, "TAA"));
        
    }
    
    public void testFindGene(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
        String dna1 = "AGCGTGCACAGCAATGGACCAGTGGTAAAGCTCGC"; // 1 gene => ATGGACCAGTGGTAA
        String dna2 = "";
        String dna3 = "ATTTAGATGGCCTAAATGGTGAGACAGTAAGGGCCCATGGTGTCTCCTTAGGCGTGT"; // 3 genes => ATGGCCTAA, 
        String dna4 = "TAGGAGCAAGATGGCGCCTCGTAGTAAATGCGCTAG"; // 0 gene, 1 almost-gene not mult of 3
        String dna5 = "GATTAGATGGTGCGCTTAGATGGTAATAGATTGTAA"; // 0 genes, 2 almost-genes not mult of 3

        System.out.println("result for dna1 test: " + findGene(dna1));
        System.out.println("result for dna2 test: " + findGene(dna2));
        System.out.println("result for dna3 test: " + findGene(dna3));
        System.out.println("result for dna4 test: " + findGene(dna4));
        System.out.println("result for dna5 test: " + findGene(dna5));
    }
    
        public void testPrintAllGenes(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
        String dna1 = "AGCGTGCACAGCAATGGACCAGTGGTAAAGCTCGC"; // 1 gene => ATGGACCAGTGGTAA
        String dna2 = "";
        String dna3 = "ATTTAGATGGCCTAAATGGTGAGACAGTAAGGGCCCATGGTGTCTCCTTAGGCGTGT"; // 3 genes => ATGGCCTAA, 
        String dna4 = "TAGGAGCAAGATGGCGCCTCGTAGTAAATGCGCTAG"; // 0 gene, 1 almost-gene not mult of 3
        String dna5 = "GATTAGATGGTGCGCTTAGATGGTAATAGATTGTAA"; // 0 genes, 2 almost-genes not mult of 3

        printAllGenes(dna1);
        printAllGenes(dna2);
        printAllGenes(dna3);
        printAllGenes(dna4);
        printAllGenes(dna5);
    }
  
    
}
