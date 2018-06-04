
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    
    public int howMany(String stringa, String stringb){
     
        int startIndex = 0;
        int howMany = 0;
        
        while(startIndex != -1){
            
            howMany++;
            startIndex = stringb.indexOf(stringa, startIndex + 3);
            
        }
        return howMany;
    }
    
    public void testHowMany(){
        
         System.out.println(howMany("GAA", "ATGAACGAATTGAATC")); // => 3
         System.out.println(howMany("ATG", "ATGAACGAATTGAATC")); // => 1
        
    }

}
