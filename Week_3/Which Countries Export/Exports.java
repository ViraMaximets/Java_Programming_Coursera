import edu.duke.*;
import org.apache.commons.csv.*;

public class Exports {
    public void test() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        /* INFO OF COUNTIES
        parser = fr.getCSVParser();
        String res = countryInfo(parser, "Nauru");
        System.out.println(res);
         */
        

        /* COUNTRY HAS BOTH GOODS
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser,"fish","nuts");
        */
       
        /* AMOUNT OF EXPORTERS
        parser = fr.getCSVParser();
        int num = numberOfExporters(parser,"sugar");
        System.out.println(num);
        */
       
        // BIG Exporters
        parser = fr.getCSVParser();
        bigExporters(parser,"$999,999,999,999");
        
    
    }
    
    public String countryInfo (CSVParser parser, String country)
    {
        String goods = " ";
        String dollars = " ";
        Boolean is = false;
        for (CSVRecord record : parser)
        {
            if (record.get("Country").equals(country))
            {
                is = true;
                dollars = record.get("Value (dollars)");
                goods += (record.get("Exports")+ ", ");
                return (country + ": " + goods + ": " + dollars);
            }    
        }
        return (country + " NOT FOUND " );
        
    }
    
    public void listExportersTwoProducts(CSVParser parser,String exportItem1,String exportItem2)
    {
        for (CSVRecord record : parser)
        {
            String exp = record.get("Exports"); 
            if ((exp.indexOf(exportItem1)!=-1)&&(exp.indexOf(exportItem2)!=-1))
            {
              String country = record.get("Country");  
              System.out.println(country);
            }
        }
    }
    public int numberOfExporters (CSVParser parser,String exportItem)
    {
        int amount = 0;
        for (CSVRecord record : parser)
        {
            String exp = record.get("Exports");
            if (exp.indexOf(exportItem)!=-1)
            {
              amount++;
            }
        }
        return amount;
    }
    public void bigExporters (CSVParser parser,String amount)
    {
        int amntLength = amount.length();
        
        for (CSVRecord record : parser)
        {
           String dollars = record.get("Value (dollars)");
           int klkst = dollars.length();
           if (klkst>amntLength)
           {
               System.out.println(record.get("Country")+" "+dollars);
           }
        }
        System.out.println("end");
    }
}




