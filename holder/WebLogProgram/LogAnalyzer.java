
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
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
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
                if(!uniques.contains(ip)){
                    uniques.add(ip);
                    count++;
                }
            }
         return count;
     }
     
     public ArrayList<String> uniqueIPs(){
         ArrayList<String> uniques = new ArrayList<String>();
            
            for(LogEntry le : records){
                String ip = le.getIpAddress();
                if(!uniques.contains(ip)){
                    uniques.add(ip);
                }
            }
         return uniques;
     }
     
     public void printAllHigherThanNum(int num){
         for(LogEntry le : records){
             if(le.getStatusCode() > num){
                 System.out.println(le);
             }
         }
         
     }
     
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
         ArrayList<LogEntry> ipsOnDay = new ArrayList<LogEntry>();
         ArrayList<String> uniquesOnDay = new ArrayList<String>();
         
            for(LogEntry le : records){
                String accessTime = le.getAccessTime().toString();
                String ip = le.getIpAddress();

                if(le.getAccessTime().toString().contains(someday)){
                    System.out.println("IN LOOP access time is: " + le.getAccessTime());
                    ipsOnDay.add(le);
                    
                    if(uniquesOnDay.contains(ip)){
                        uniquesOnDay.add(ip);
                    }
                }
            }
         return uniquesOnDay;
     }
     
     public int countUniqueIPsInRange(int low, int high){
        int inRange = 0;
        
        for(LogEntry le : records){
                int sc = le.getStatusCode();
                if(sc >= low && sc <= high){
                    System.out.println("IN LOOP status cod is: " + le.getStatusCode());
                    inRange++;
                }
            }    
        return inRange;
     }
}
