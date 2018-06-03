
import edu.duke.*;

/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {
    public String readUrlFile(){
        
        URLResource url = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String s : url.lines()){
            //System.out.println(s);
            if(s.indexOf("youtube") !=-1 || s.indexOf("YouTube") !=-1 || s.indexOf("YOUTUBE") !=-1){
                //System.out.println(">>>>>>>>>>>>>>>>>>>>");
                //System.out.println(s);
                //System.out.println(">>>>>>>>>>>>>>>>>>>>");
                
                int hrefPosition = s.indexOf("href");
                int beginYT = s.indexOf("\"", hrefPosition);
                int stopYT = s.indexOf("\"", beginYT + 1);
                
                String youtubeAddress = s.substring(beginYT + 1, stopYT);
                
                System.out.println(youtubeAddress);
                
                
                
            }
        }
    return "something";
    }
    
    public void testFindWebLinks(){
     
        
        
        //String urlOutput = readUrlFile("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        //System.out.println(urlOutput);
        
    }
    
}
