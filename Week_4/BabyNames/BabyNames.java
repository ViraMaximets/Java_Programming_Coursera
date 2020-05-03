import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyNames {
    public void testTotalBirths() 
    {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
    public void totalBirths(FileResource fr)
    {
        int ttlBirths = 0;
        int girlsNames = 0;
        int  boysNames = 0;
        int boyTotalBirths = 0;
        int girlTotalBirths = 0;
        for (CSVRecord currRow : fr.getCSVParser(false))
        {
            int num = Integer.parseInt(currRow.get(2));
            ttlBirths+=num;
            if (currRow.get(1).equals("F"))
                {
                     girlsNames++;
                     girlTotalBirths += num;   
                }
            else if (currRow.get(1).equals("M"))
                {
                    boysNames++;
                    boyTotalBirths += num; 
                }
        }
        System.out.println("Total children births = " + ttlBirths);
        System.out.println("Total girlsNames = " + girlsNames);
        System.out.println("Total boysNames = " + boysNames);
    }
    
    public void testGetRank()
    {
        int year = 1971;
        String name = "Frank";
        String gender = "M";
        
        int rank = getRank(year,name,gender);
        System.out.println("This name`s rank is = " + rank);
    }
    public int getRank(int year, String name, String gender)
    {
        FileResource fr = new FileResource
        ("C:/Users/User_2/Desktop/us_babynames/us_babynames_by_year/yob" + year + ".csv");
        
        int rank = 0;
        boolean t = false;
        
        for (CSVRecord currRow : fr.getCSVParser(false))
        {
            if (currRow.get(1).equals(gender))
            {
                rank++;
                if (currRow.get(0).equals(name))
                    {
                        t = true;
                        break;
                    }
            }
        }
        if (t)
            return rank;
        return -1;
    }
   
    
    public void testGetName() {
        int year = 1982;
        int rank = 450;
        String gender = "M";
        
        String name = getName(year, rank, gender);
        System.out.println(year + " rank " + rank + " is " + name);
    }
    public String getName(int year, int rank, String gender)
    {
        FileResource fr = new FileResource
        ("C:/Users/User_2/Desktop/us_babynames/us_babynames_by_year/yob" + year + ".csv");
        String name = "NO NAME";
        int here = 0;
        
        for (CSVRecord currRow : fr.getCSVParser(false))
        {
            if (currRow.get(1).equals(gender))
            {
                here++;
                if(rank==here)
                {
                    name = currRow.get(0);
                }
            }
        }
        
        return name;
    }

    public void testWhatIsNameInYear() {
        int year = 1974;
        int newYear = 2014;
        String gender = "M";
        String name = "Owen";
        
        whatIsNameInYear(year, name, gender, newYear);
    }
    public void whatIsNameInYear
    (int year, String name, String gender, int newYear)
    {
       int rank = getRank( year, name, gender);
       String newName = getName (year, rank, gender);
       
       System.out.println(name+" born in "+year+" would be "+
       newName+" if she was born in "+newYear);
    }
    
    public void testYearOfHighestRank() {
        String gender = "M";
        String name = "Mich";
        
        System.out.println(name + " most popular year is " + yearOfHighestRank(name, gender));
    }
    public int yearOfHighestRank(String name, String gender)
    {
        int rank = Integer.MAX_VALUE;
        int year = Integer.MIN_VALUE;
        
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles())
        {
            int currYear = Integer.parseInt(f.getName().substring(3, 7));
            int currRank = getRank(currYear,name, gender);
            
             if ((currRank != -1) && (currRank < rank))
                {
                    rank = currRank;
                    year=currYear;
                }
        }
        if (year == Integer.MIN_VALUE) {
            return -1;
        } else {
            return year;
        }
    }
    
    public void testGetAverageRank() {
        String gender = "M";
        String name = "Robert";
        
        System.out.println(name + " Average Rank is " + getAverageRank(name, gender));
    }
    public double getAverageRank(String name, String gender)
    {
        double rank = 0.0;
        int years = 0;
        
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles())
        {
            int currYear = Integer.parseInt(f.getName().substring(3, 7));
            int currRank = getRank(currYear,name, gender);
            rank+=currRank;
            years++;
        }
        if (years>0) 
            return rank/years;
        else 
            return  -1.0;
    }
    
    public void testGetTotalBirthsRankedHigher() {
        int year = 1990;
        String name = "Drew";
        String gender = "M";
        System.out.println("Total births higher than " + name + " is " + getTotalBirthsRankedHigher(year, name, gender));
    }
    public int getTotalBirthsRankedHigher(int year, String name, String gender)
    {
        int rank = getRank(year,name,gender);
        int totalBirths = 0;
        int currentRank = 0;
        
        FileResource fr = new FileResource
        ("C:/Users/User_2/Desktop/us_babynames/us_babynames_by_year/yob" + year + ".csv");
        for (CSVRecord record : fr.getCSVParser(false)) {
            String currentGender = record.get(1);
            
            if (currentGender.equals(gender)) {
                currentRank++;
                
                if (currentRank < rank) {
                    int currentBirths = Integer.parseInt(record.get(2));
                    totalBirths += currentBirths;
                } else {
                    break;
                }
            }
        }
        return totalBirths;
    }
    
    
}
