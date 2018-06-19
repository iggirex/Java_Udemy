
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    
    public boolean isVowel(char ch){
        
        String vowels = "AEIOU";
        
        if(vowels.indexOf(Character.toUpperCase(ch)) == -1){
            return false;
        }
        return true;
    }
    
    public void testIsVowel(){
        
        System.out.println(isVowel('a'));
        System.out.println(isVowel('b'));
        
        System.out.println(isVowel('i'));
        
    }
    
    public String replaceVowels(String phrase, char ch){
        
        StringBuilder result = new StringBuilder(phrase);
        
        for(int i = 0; i < result.length(); i++){
         
            if(isVowel(result.charAt(i))){
             
                result.setCharAt(i, ch);
                
            }
        }
        return result.toString();
    }
    
    public void testReplaceVowels(){
     
        System.out.println(replaceVowels("Iggi mayNE", '$'));
        
    }
    
    public String emphasize(String phrase, char ch){
        
        StringBuilder result = new StringBuilder(phrase);
        
        for(int i = 0; i < result.length(); i++){
            
            if(result.charAt(i) == Character.toUpperCase(ch) || result.charAt(i) == Character.toLowerCase(ch)){
                if(i % 2 == 0){
                    result.setCharAt(i, '*');
                } else {
                    result.setCharAt(i, '+');
                }
            }
        }
        return result.toString();
    }
    
    public void testEmphasize(){
     
            System.out.println(emphasize("dna ctgaaactga", 'a'));
            System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }

}
