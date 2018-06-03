
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurances(String a, String b){

        int firstOccurance = b.indexOf(a);
        
        if (firstOccurance != -1){
        
            if (b.indexOf(a, firstOccurance + 1) != -1){
                return true;
            }
           
        }
        return false;
    }
    
    public String lastPart(String stringa, String stringb){
        
        int firstOccurance = stringb.indexOf(stringa);
        if (firstOccurance != -1){
        
            String lastPart = stringb.substring(firstOccurance + 2, stringb.length());
            return lastPart;
            }
           
        return stringb;
    }
    
    public void testingTwoOccurances(){
        String a1 = "by";
        String a2 = "A story by Abby Long";
        
        String b1 = "an";
        String b2 = "banana";
        
        String c1 = "poob";
        String c2 = "pajajdfkdjsal";
        
        System.out.println(">>>>>>>>>>>>>>>>>>>>");
        System.out.println(twoOccurances(a1, a2));
        System.out.println(twoOccurances(b1, b2));
        System.out.println(twoOccurances(c1, c2));
        
        System.out.println(lastPart(a1, a2));
        System.out.println(lastPart(b1, b2));
        System.out.println(lastPart(c1, c2));
        
    }
}
