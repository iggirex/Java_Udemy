
/**
 * Write a description of listExporters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
    
public class listExporters {
    
    public void whoExportsCoffee(){
    
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser, "coffee");
    
    
    }
    
    public void listExporters(CSVParser parser, String exportOfInterest) {

        for( CSVRecord record : parser) {

            String export = record.get("Exports");
            
            //System.out.println("this is export: " + export);
            
            if (export.contains(exportOfInterest)){
                System.out.println(record.get("Country"));
            }
        
        }
    }
    
    
}

