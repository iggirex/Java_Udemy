
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
                    ipsOnDay.add(le);
                    
                    if(!uniquesOnDay.contains(ip)){
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
     
     public HashMap<String, Integer> countVisitsPerIP(){
         HashMap<String, Integer> counts = new HashMap<String, Integer>();
         
         for(LogEntry le : records){
             String ip = le.getIpAddress();
             if(counts.containsKey(ip)){
                 counts.put(ip, counts.get(ip) + 1);
             } else {
                 counts.put(ip, 1);
             }
         }
         return counts;
     }
     
     
     public int mostNumberVisitsByIP(HashMap<String, Integer> counts){
         int maxCount = 0;
         for(LogEntry le : records){
             String ip = le.getIpAddress();
             if(counts.get(ip) > maxCount){
                 maxCount = counts.get(ip);
             }
         }
         return maxCount;
     }
     
     public ArrayList<String> iPsMostVisits(HashMap<String, Integer> counts){
         ArrayList<String> maxIp = new ArrayList<String>();
         int maxCount = 0;
         
         for(String ip : counts.keySet()){
             int ipCount = counts.get(ip);
             if(ipCount > maxCount){
                 maxIp.clear();
                 maxIp.add(ip);
                 maxCount = ipCount;
             } else if(counts.get(ip) == maxCount){
                 maxIp.add(ip);
             }
         }
         return maxIp;
     }
     
     public HashMap<String, ArrayList<String>> iPsForDays(){
         HashMap<String, ArrayList<String>> daysVisits = new HashMap<String, ArrayList<String>>();
         for(LogEntry le : records){
             Date date = le.getAccessTime();
             String day = date.toString().substring(4, 10);
             
             if(daysVisits.containsKey(day)){
                 daysVisits.get(day).add(le.getIpAddress());
             } else {
                 ArrayList<String> ips = new ArrayList<String>();
                 ips.add(le.getIpAddress());
                 daysVisits.put(day, ips);
             }
         }
         return daysVisits;
     }
     
     public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> daysAndIps){
         int maxCount = 0;
         String maxDay = "";
         
         for(String day : daysAndIps.keySet()){
             int ipAmounts = daysAndIps.get(day).size();
             if(ipAmounts > maxCount){
                 maxCount = ipAmounts;
                 maxDay = day;
             }
         }
         return maxDay;
     }
     
     public void myMethod(Object obj) {
        if (obj instanceof String) {
            System.out.println("It's a String");
         }
        else {
            System.out.println("It's not a String");
         }
     }
     
     public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> daysAndIps, String day){
         ArrayList<String> resultIps = new ArrayList<String>();
         int maxVisits = 0;
         String newDay = day.substring(0,3) + day.substring(4,7);
         
         HashMap<String, ArrayList<String>> ipsForThisDay = iPsForDays();
         resultIps = ipsForThisDay.get(newDay);
         
         ArrayList<String> ok = new ArrayList<String>();
         for ( String key : ipsForThisDay.keySet() ) {
             System.out.println("WAAAA-" + key + "^^^^" );
             System.out.println(ipsForThisDay.get(key));
         }
         
         HashMap<String, Integer> counts = new HashMap<String, Integer>();
         for(String ip : resultIps){
             if(counts.containsKey(ip)){
                 counts.put(ip, counts.get(ip) + 1);
             } else {
                 counts.put(ip, 1);
             }
         }
       
         return iPsMostVisits(counts);
     }
     
}
