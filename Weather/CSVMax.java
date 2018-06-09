
/**
 * Write a description of CSVMax here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMax {

    public CSVRecord getLargestOfTwo(CSVRecord currentRow, CSVRecord largestSoFar){
        
        if(largestSoFar == null){
                largestSoFar = currentRow;
            } else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                
                if(currentTemp > largestTemp){
                    largestSoFar = currentRow;
                }
            }
        return largestSoFar;
    }
    
    public CSVRecord hottestHourInFile(CSVParser parser){
        CSVRecord largestSoFar = null;
        for( CSVRecord currentRow : parser){
         
            largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
        }
        return largestSoFar;
    }
    
    public void testHottestInDay() {
        //FileResource fr = new FileResource("data/2015/weather-2015-01-01.csv");
        FileResource fr = new FileResource();
        
        CSVRecord largest = hottestHourInFile(fr.getCSVParser());
        System.out.println("hottest temperature was: " + largest.get("TemperatureF") +
                            " at " + largest.get("TimeEST"));
    }
    
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldestHour = null;
        for(CSVRecord record : parser){
            
            if(coldestHour == null){
                coldestHour = record;
            } else {
                double thisTemperature = Double.parseDouble(record.get("TemperatureF"));
                double coldestTemperature = Double.parseDouble(coldestHour.get("TemperatureF"));
                
                if(thisTemperature < coldestTemperature && thisTemperature != -9999){
                    coldestHour = record;
                }
            }
        }
        return coldestHour;
    }
    
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        CSVRecord lowest = coldestHourInFile(parser);
        System.out.println("coldest temperature was " + lowest.get("TemperatureF") + " at " + lowest.get("TemperatureF"));
    }
   
    public CSVRecord hottestInManyDays() {
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
     
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord hottestRecordYet = hottestHourInFile(parser);
            
            largestSoFar = getLargestOfTwo(hottestRecordYet, largestSoFar);
        }
        return largestSoFar;
    }
    
    public void testHottestInManyDays(){
        CSVRecord largest = hottestInManyDays();
        System.out.println("hottest temperature was " + largest.get("TemperatureF") +
                            " at " + largest.get("DateUTC"));
    }
    
    public String fileWithColdestTemperature(){

        File coldestFile = null;
        CSVRecord coldestHourInColdestFile = null;
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()){
            //String fileName = f.getName();

            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord coldestHourInThisFile = coldestHourInFile(parser);
            
            if(coldestFile == null){
                coldestFile = f;
                coldestHourInColdestFile = coldestHourInThisFile;
            } else if (Double.parseDouble(coldestHourInThisFile.get("TemperatureF")) < Double.parseDouble(coldestHourInColdestFile.get("TemperatureF"))){
                coldestFile = f;
                coldestHourInColdestFile = coldestHourInThisFile;
            }
            
        }
        return coldestFile.getName();
    }
    
    public void testFileWithColdestTemperature(){
        String coldestFileName = fileWithColdestTemperature();
        System.out.println("File with the coldest temperature is: " + coldestFileName);
        
        FileResource coldestFile = new FileResource("./nc_weather/2015/" + coldestFileName);
        CSVParser parser = coldestFile.getCSVParser();
        
        System.out.println("This was the coldest hour on that day: " + coldestHourInFile(parser).get("TemperatureF"));
        
        CSVParser parser2 = coldestFile.getCSVParser();
        for (CSVRecord record : parser2){
                System.out.println(record.get("DateUTC") + " " + record.get("TemperatureF"));  
        }
        
    }
    
}
