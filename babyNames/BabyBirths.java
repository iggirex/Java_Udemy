
/**
 * Write a description of BabyBirths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;

public class BabyBirths {
    
    public void printNames(){
        FileResource fr = new FileResource();
        for(CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100){
                System.out.println("Name " + rec.get(0) + " Gender " + rec.get(1) + " Num Born " + rec.get(2));
            }
        }
    }
    
    public void totalBirths(FileResource fr){
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int totalBoyNames = 0;
        int totalGirlNames = 0;
        for(CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            
            if(rec.get(1).equals("M")){
                totalBoys += numBorn;
                totalBoyNames++;
            } else {
                totalGirls += numBorn;
                totalGirlNames++;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("total boys = " + totalBoys);
        System.out.println("total girls = " + totalGirls);
        System.out.println("total amount of boys names: " + totalBoyNames);
        System.out.println("total amount of girl names: " + totalGirlNames);
    }
    
    public void testTotalBirths(){
     
        //FileResource fr = new FileResource("./us_babynames/us_babynames_by_year/yob2014.csv");
        FileResource fr = new FileResource();
        totalBirths(fr);
        
    }
    
    public int getRank(int year, String name, String gender){
        FileResource fr = new FileResource("./us_babynames/us_babynames_by_year/yob" + year + ".csv");
        //FileResource fr = new FileResource("./us_babynames/us_babynames_test/example-small.csv");
        CSVParser parser = fr.getCSVParser(false);
    
        int girlsRank = 0;
        int boysRank = 0;
    
        for(CSVRecord rec : parser){
            
            if(rec.get(1).equals("F") && rec.get(1).equals(gender)){
                girlsRank++;
                if(rec.get(0).equals(name)){
                    return girlsRank;
                }
                
            } else if(rec.get(1).equals("M") && rec.get(1).equals(gender)){
                boysRank++;
                if(rec.get(0).equals(name)){
                    return boysRank;
                }
            }
        }
        return -1;
    }
    
    public void testGetRank(){
        
        //System.out.println("In 2012 Mason's Male name was ranked: " + getRank(2012, "Mason", "M"));
        //System.out.println(getRank(2012, "Matson", "M"));
        //System.out.println(getRank(2012, "Mason", "F"));
        System.out.println("Frank in 1971 was ranked: " + getRank(1971, "Frank", "M"));
        //System.out.println("Emily in 1960 was ranked: " + getRank(1960, "Emily", "F"));
    }
    
    public String getName(int year, int rank, String gender){
    
        FileResource fr = new FileResource("./us_babynames/us_babynames_by_year/yob" + year + ".csv");
        CSVParser parser = fr.getCSVParser(false);
        int recordsRankGirls = 0;
        int recordsRankBoys = 0;
        for(CSVRecord rec : parser){
            if(rec.get(1).equals("F")){
                recordsRankGirls++;
                if(recordsRankGirls == rank && rec.get(1).equals(gender)){
                    return rec.get(0);
                }
            } else if(rec.get(1).equals("M")){
                recordsRankBoys++;
                
                if(recordsRankBoys == rank && rec.get(1).equals(gender)){
                    return rec.get(0);
                } 
            }
        }
        return "NO NAME";
    }
    
    public void testGetName(){
        
        //System.out.println("In 2012 the 5th ranked F name was: " + getName(2012, 5, "F"));
        //System.out.println("In 1980 the 350th ranked F name was: " + getName(1980, 350, "F"));
        System.out.println("In 1982 the 450th ranked M name was: " + getName(1982, 450, "M"));
    }
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        
        FileResource yearFR = new FileResource("./us_babynames/us_babynames_by_year/yob" + year + ".csv");
        FileResource newYearFR = new FileResource("./us_babynames/us_babynames_by_year/yob" + newYear + ".csv");
        
        //FileResource yearFR = new FileResource("./us_babynames/us_babynames_test/yob" + year + "short.csv");
        //FileResource newYearFR = new FileResource("./us_babynames/us_babynames_test/yob" + newYear + "short.csv");
        
        CSVParser yearParser = yearFR.getCSVParser(false);
        CSVParser newYearParser = newYearFR.getCSVParser(false);
        int yearRank = 0;
        int newYearRank = 0;
        

        for(CSVRecord rec : yearParser){
            
            if(rec.get(1).equals(gender)){
                yearRank++;
                if(rec.get(0).equals(name)){  
                    break;   
                }
            }
        }

        for(CSVRecord rec : newYearParser){
            
            if(rec.get(1).equals(gender)){
                newYearRank++;
                if(yearRank == newYearRank){  
                    System.out.println(name + " born in " + year + " would be " + rec.get(0) + " if born in " + newYear);
                    break;
                }
            }
        }
    }
    
    public void testWhatIsNameInYear(){
        //whatIsNameInYear("Jacob", 2012, 2014, "M");
        //System.out.println("Susan born in 1972 would be " + whatIsNameInYear("Susan", 1972, 2014, "F") + " in 2014");
        //whatIsNameInYear("Susan", 1972, 2014, "F");
        whatIsNameInYear("Owen", 1974, 2014, "M");
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        int count = 0;
        
        FileResource fr = new FileResource("./us_babynames/us_babynames_by_year/yob" + year + ".csv");
        //FileResource fr = new FileResource("./us_babynames/us_babynames_test/yob" + year + "short.csv");
        CSVParser parser = fr.getCSVParser(false);
    
        for(CSVRecord rec : parser){
            
            if(rec.get(1).equals("F") && rec.get(1).equals(gender)){
                                
                if(rec.get(0).equals(name)){
                    return count;
                }
                count += Integer.parseInt(rec.get(2));
            } else if(rec.get(1).equals("M") && rec.get(1).equals(gender)){

                if(rec.get(0).equals(name)){
                    return count;
                }
                count += Integer.parseInt(rec.get(2));
            }
        }
        return -1;
    }
    
    public void testGetTotalBirthsRankedHigher(){
        
        System.out.println(getTotalBirthsRankedHigher(2012, "Ethan", "M"));
        System.out.println("Total number of girls in 1990 with names ranked higher than Emily: " + 
                            getTotalBirthsRankedHigher(1990, "Emily", "F"));
        System.out.println("Total number of girls in 1990 with names ranked higher than Drew: " + 
                            getTotalBirthsRankedHigher(1990, "Drew", "M"));
    }
    
    public int yearOfHighestRank(String name, String gender){
        
        DirectoryResource dr = new DirectoryResource();
        int yearOfHighestRank = -1;
        int highestRank = 0;
        for(File f : dr.selectedFiles()){

            int year = Integer.parseInt(f.getName().substring(3, 7));
            //FileResource fr = new FileResource("./us_babynames/us_babynames_test/yob" + year + "short.csv");
            FileResource fr = new FileResource("./us_babynames/us_babynames_by_year/yob" + year + ".csv");
            CSVParser parser = fr.getCSVParser(false);
            
            int thisRank = getRank(year, name, gender);
            //System.out.println("#### getting thisRank: " + thisRank + " and this is highestRank: " + highestRank);
            
            if(highestRank == 0 && thisRank > 0){
                highestRank = thisRank;
                yearOfHighestRank = year;
                //System.out.println("highestRank == 0 and now setting highestRank to: " + highestRank
            }
            
            System.out.println("This is the year: " + year + " // and this is thisRank: " + thisRank + " // and this is highestRank: " + highestRank);
            if(thisRank < highestRank && thisRank > 0){
                highestRank = thisRank;
                yearOfHighestRank = year;
            }
            //System.out.println(">>>>>> DID THE HUGHEST RANK CHANGE??? highestRank: " + highestRank);
        }
        return yearOfHighestRank;
    }
    
    public void testYearOfHighestRank(){
        //System.out.println("Should be 2012 => " + yearOfHighestRank("Mason", "M"));
        //System.out.println(yearOfHighestRank("Mich", "M"));
        //System.out.println(yearOfHighestRank("Jacob", "M"));
        System.out.println(yearOfHighestRank("Genevieve", "F"));
    }

    public double getAverageRank(String name, String gender){
        
        DirectoryResource dr = new DirectoryResource();
        double rankTotal = -1;
        int count = 0;
        for(File f : dr.selectedFiles()){
            int year = Integer.parseInt(f.getName().substring(3, 7));
            //FileResource fr = new FileResource("./us_babynames/us_babynames_test/yob" + year + "short.csv");
            FileResource fr = new FileResource("./us_babynames/us_babynames_by_year/yob" + year + ".csv");
            CSVParser parser = fr.getCSVParser(false);
            
            String fileName = f.getName();
            
            
            double thisRank = getRank(year, name, gender);
                
            if(thisRank != -1 && rankTotal == -1){
                rankTotal++;
                count++;
                rankTotal += thisRank;
            } else if(thisRank != -1){
                count++;
                rankTotal += thisRank;
            }
        }
        if (rankTotal == -1){
            return rankTotal;
        } else {
            return rankTotal/ count;
        }
    }
    
    public void testgetAverageRank(){
        //System.out.println("Should be 3.0 => " + getAverageRank("Mason", "M"));
        //System.out.println("Should be 2.66 => " + getAverageRank("Jacob", "M"));
        System.out.println("Average rank of Susan over all data files is: " + getAverageRank("Susan", "F"));
        System.out.println("Average rank of Robert over all data files is: " + getAverageRank("Robert", "M"));
    }
    

}
