
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
    
    public CSVRecord getSmallestOfTwo(CSVRecord currentRow, CSVRecord smallestSoFar){
        if(currentRow.get("Humidity") != "N/A"){
            if(smallestSoFar == null){
                smallestSoFar = currentRow;
            } else {
                double currentHumidity = Double.parseDouble(currentRow.get("Humidity"));
                double smallestHumidity = Double.parseDouble(smallestSoFar.get("Humidity"));
                    if(currentHumidity < smallestHumidity){
                        smallestSoFar = currentRow;
                    }
            }
        return smallestSoFar; 
        }
        return smallestSoFar;
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestHumidityRecord = null;
        
        for (CSVRecord record : parser){
         
            if (lowestHumidityRecord == null){
                lowestHumidityRecord = record;
            }
            lowestHumidityRecord = getSmallestOfTwo(record, lowestHumidityRecord);
        }
        return lowestHumidityRecord;
    }
    
    public void testLowestHumidityFile(){
        
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        
        System.out.println("Lowest humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
        
    }
    
    public CSVRecord lowestHumidityInManyFiles(){
     
        CSVRecord lowestHumidityRecord = null;
        
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()){
            
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            
            CSVRecord lowestHumidityInThisFile = lowestHumidityInFile(parser);
            
            lowestHumidityRecord = getSmallestOfTwo(lowestHumidityInThisFile, lowestHumidityRecord);
        }
        return lowestHumidityRecord;
    }
    
    public void testLowestHumidityInManyFiles(){
        
        CSVRecord lowestHumidity = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + lowestHumidity.get("Humidity") + " at " + lowestHumidity.get("DateUTC"));
        
    }
    
    public double averageTemperatureInFile(CSVParser parser){
        double addedTemperatures = 0;
        double hourCount = 0;
        for (CSVRecord record : parser){
            double thisTemperature = Double.parseDouble(record.get("TemperatureF"));
            addedTemperatures += thisTemperature;
            hourCount++;
        }
        return addedTemperatures/hourCount;
    }
    
    public void testAverageTemperatureInFile(){
    
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        System.out.println("Average temperature was: " + averageTemperatureInFile(parser));
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
    
        double addedTemperatures = 0;
        double hourCount = 0;
        for (CSVRecord record : parser){
            if (Double.parseDouble(record.get("Humidity")) >= value){
                double thisTemperature = Double.parseDouble(record.get("TemperatureF"));
                addedTemperatures += thisTemperature;
                hourCount++;
            }
        }
        if(addedTemperatures == 0){
            return 0;
        }
        return addedTemperatures/hourCount;
    }
    
    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double averageTemp = averageTemperatureWithHighHumidityInFile(parser, 80);
        
        if(averageTemp == 0){
            System.out.println("No temperature with that humidity");
        } else {
            System.out.println("Average Temp when high Humidity is " + averageTemp);
        }
    }
}
