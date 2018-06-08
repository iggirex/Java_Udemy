import java.lang.Math;
import edu.duke.*;

public class Part1 {

    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int stopCodonCandidate = dna.indexOf(stopCodon, startIndex);
        
        if(stopCodonCandidate != -1 && dna.substring(startIndex, stopCodonCandidate).length() % 3 == 0){
            return stopCodonCandidate;
        }
        else {
            findStopCodon(dna, stopCodonCandidate + 1, stopCodon);
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
        
        //System.out.println("At start Index: " + startIndex + " And stop codon index: " + closestStopCodonIndex + " and dna: " + dna.substring(startIndex, closestStopCodonIndex + 2));
        
        if(closestStopCodonIndex == dna.length()){
            return "";
        }
        
        
        
        return dna.substring(startIndex, closestStopCodonIndex + 2);
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
    
       public StorageResource getAllGenes(String dna){
        
        StorageResource store = new StorageResource();
           
        while(true){
         
            String geneFound = findGene(dna);
            
            if( !geneFound.isEmpty()){
                System.out.println("found this gene: " + geneFound);
                store.add(geneFound);
                int startIndex = dna.indexOf(geneFound);
                int endOfGeneIndex = startIndex + geneFound.length();
                dna = dna.substring( endOfGeneIndex, dna.length());
            } else {  
            break;
            }
            
        }
        return store;
    }
    
    public void processGenes(StorageResource sr){
        int greaterThan9Char = 0;
        int cgRatioGreaterThan9 = 0;
        int longestGeneLength = 0;
        
        for(String s : sr.data()){
            
            StorageResource allGenes = getAllGenes(s);
            
            String geneFound = findGene(s);
            
            System.out.println("This is dna string: " + s);
            System.out.println("This dna has " + allGenes.size() + " number of genes");
            System.out.println("This is geneFound: " + geneFound);
            
            if(s.length() > longestGeneLength){
                //longestGeneLength = s.length();
            }
            if(s.length() > 9){
                greaterThan9Char++;
                //System.out.print(s + " / / ");
            }
            if(cgRatio(s) > 0.35){
                cgRatioGreaterThan9++;
                System.out.print(" ####### this dna has C-G ratio > 0.35: " + s + " / / ");
            }
            
        }
        //System.out.print("Number of strings that are longer than 9 char: " + greaterThan9Char + " / / ");
        //System.out.print("CG Ratio > 9 count: " + cgRatioGreaterThan9 + " / / ");
        //System.out.println("Longest Gene length: " + longestGeneLength + " / / ");
        
        
        
        
    }
    
    public void testFileGenes(){
     
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
        
        //System.out.println(dna6);
        
        dna = dna.toUpperCase();
        
        //System.out.println(dna);
        
        System.out.println(">>>>>>>>>>>");
        printAllGenes(dna);
        
        StorageResource allGenes = getAllGenes(dna);
        
        processGenes(allGenes);
        //printAllGenes("ATTTAGATGGCCTAAATGGTGAGACAGTAAGGGCCCATGGTGTCTCCTTAGGCGTGT");
        
        
        
    }
    
    public void testProcessGenes(){
        
        StorageResource dnaSR = new StorageResource();
        
        String dna1 = "AGCGTGCACAGCAATGGACCAGTGGTAAAGCTCGCATGTGTCGCGTGCGTGCGTCAAACCCTCTCCACTAA"; // 2 gene
        String dna2 = "";
        String dna3 = "ATTTAGATGGCCTAAATGGTGAGACAGTAAGGGCCCATGGTGTCTCCTTAGGCGTGT"; // 3 genes
        String dna4 = "TAGGAGCAAGATGGCGCCTCGTAGTAAATGCGCTAG"; // 1 gene, 1 almost-gene not mult of 3
        String dna5 = "GATTAGATGGTGCGCTTAGATGGTAATAGATTGTAA"; // 0 genes, 2 almost-genes not mult of 3
        
        FileResource fr = new FileResource("brca1line.fa");
        String dna6 = fr.asString();
        dna6 = dna6.toUpperCase();
        
        dnaSR.add(dna1);
        dnaSR.add(dna2);
        dnaSR.add(dna3);
        dnaSR.add(dna4);
        dnaSR.add(dna5);
        dnaSR.add(dna6);
        
        processGenes(dnaSR);
        
        //StorageResource allGenes = getAllGenes(dna6);
        
        //System.out.println("Number of genes in this string: " + allGenes.size());
        
        //printAllGenes(dna6.toUpperCase());
        
    }
    
    public double cgRatio(String dna){
        double count = 0.00;
        
        for(int i = 0; i < dna.length(); i++){
            
            if (dna.charAt(i) == 'G' || dna.charAt(i) == 'C'){
                count++;
            }
            
            
        }
        return count/dna.length();
    }
    
    public void testCgRatio(){
        
        String dna =  "ATGCCATAG";
        
        System.out.println(cgRatio(dna));
        
    }
    
    public void testGetAllGenes(){
        
        String dna = "ATTTAGATGGCCTAAATGGTGAGACAGTAAGGGCCCATGGTGTCTCCTTAGGCGTGTAGCGTGCACAGCAATGGACCAGTGGTAAAGCTCGC";
        
        StorageResource geneCollection = getAllGenes(dna);
        
        for(String s : geneCollection.data()){
            System.out.println(">>> " + s);
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
