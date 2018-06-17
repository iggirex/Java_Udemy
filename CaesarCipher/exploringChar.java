
/**
 * Write a description of exploringChar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class exploringChar {
    
    
    public void charactersInString(String s){
        String charString = "";
        for(int i = 0; i < s.length(); i++){
         
            char ch = s.charAt(i);
            
            System.out.println(ch);
        }
    }
    
    public void testCharactersInString(){
     
        charactersInString("A#4FGtYHdY");
        
    }
    
    public void digitTest(String s){
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                System.out.println(ch + " is a digit");
            } else {
                System.out.println(ch + " is not a digit");
            }
        }
        
    }
    
    public void testDigitTest(){
     
        digitTest("A#4FGtYHdY");
        digitTest("jkd7843978fjio240j89894ijohdfljkhwej8904o%$#FRE3by6vy654$ tvet54c%$@A#4FGtYHdY");
        
    }

}
