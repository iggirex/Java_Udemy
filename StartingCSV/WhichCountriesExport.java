
/**
 * Write a description of listExporters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
    
public class WhichCountriesExport {

    public void listExporters(CSVParser parser, String exportOfInterest) {

        for( CSVRecord record : parser) {

            String export = record.get("Exports");
            
            if (export.contains(exportOfInterest)){
                System.out.println(record.get("Country"));
            }
        
        }
    }
    
    public String countryInfo(CSVParser parser, String country){
        String result = "";
        
        for (CSVRecord record : parser){
            String thisCountry = record.get("Country");
            
            if (thisCountry.contains(country)) {
                //System.out.println(record.get("Country") + ": " + record.get("Exports") + record.get("Value (dollars)"));
                result = record.get("Country") + ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
            }
        }
        if (result.equals("")){
            return "NOT FOUND";
        }
        return result;
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for(CSVRecord record : parser){
            
            //System.out.println("inside the loop");
            
            String countryName = record.get("Country");
            String export = record.get("Exports");
            
            //System.out.println("this is country: " + countryName + " // and this is its exports: " + export);
            
            if (export.contains(exportItem1) && export.contains(exportItem2)){
                System.out.println(countryName);
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int counter = 0;
        
        for(CSVRecord record : parser){
            String export = record.get("Exports");
            
            if(export.contains(exportItem)){
                counter++;
            }
        }
        return counter;
    }
    
    public void bigExporters(CSVParser parser, String dollarAmount){
        
        for(CSVRecord record : parser){
            String value = record.get("Value (dollars)");
            
            if (value.length() > dollarAmount.length()){
                
                System.out.println(record.get("Country") + " " + value); 
            }
        }
    }
    
    public void tester(){
     
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        //System.out.println(countryInfo(parser, "Germany"));
        //System.out.println(countryInfo(parser, "Nauru"));
        
        //listExportersTwoProducts(parser, "gold", "diamonds");
        
        //System.out.println(numberOfExporters(parser, "sugar") + " countries export sugar");
        
        bigExporters(parser, "$999,999,999,999");
    }
    
        public void whoExportsCoffee(){
    
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser, "coffee");
    
    
    }
    
}