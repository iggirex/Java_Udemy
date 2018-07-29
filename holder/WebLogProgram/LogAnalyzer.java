
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource fr = new FileResource();
         for(String line : fr.lines()){
             
             LogEntry le = WebLogParser.parseEntry(line);
             records.add(le);
         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIPs(){
         int count = 0;
         ArrayList<String> uniques = new ArrayList<String>();
            
            for(LogEntry le : records){
                String ip = le.getIpAddress();
                //System.out
                if(!uniques.contains(ip)){
                    uniques.add(ip);
                    count++;
                }
            }
         return count;
     }
     
     public void printAllHigherThanNum(int num){
         for(LogEntry le : records){
             System.out.println("num: " + num + " // and statusCode: " + le.getStatusCode());
             if(le.getStatusCode() > num){
                 System.out.println(le);
             }
         }
         
     }
}
