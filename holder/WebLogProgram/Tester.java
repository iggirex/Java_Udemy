
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
    }
    
    public void testUniqueIP(){
        String file = "short-test_log";
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(file);
        System.out.println("File: " + file + " has this many unique IP addresses: " + la.countUniqueIPs());
        
    }
    
    public void testPrintAllHigherThanNum(){
        String file = "short-test_log";
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(file);
        la.printAllHigherThanNum(400);
    }
    
    public void testUniqueIPVisitsOnDay(){
        String file = "short-test_log2";
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(file);
        ArrayList<String> result = la.uniqueIPVisitsOnDay("Mar 17"); 
        System.out.println("Array is of size: " + result.size());
        for(int i=0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
    }
    
    public void testCountUniqueIPsInRange(){
        String file = "short-test_log2";
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(file);
        System.out.println(la.countUniqueIPsInRange(200, 299));
        
    }
}
