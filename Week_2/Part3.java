public class Part3 {

    int twoOccurrences(String a, String b){
        int start=0;
        int counter = 0;
        while (true)
        {
            int p = b.indexOf(a,start);
            if (p==-1)
               break;
               
            counter++;
            start=p+1;
        }
        
        return counter;
    }
    
    String lastPart(String a, String b){
        int blength = b.length();
        int alength = a.length();
        int p = b.indexOf(a);
        if (p==-1)
            return b;
        else 
        {
            String res = b.substring(p+alength);
            return res;
        }
    }
    
    void test()
    {
        String a = "an";
        String b = "banana";
        int count = twoOccurrences(a,b);
        if (count>=2)
            System.out.println(">=2!");
            
        else System.out.println("<2");
        String lastP = lastPart(a,b);
        System.out.println(lastP);
        
        String c = "zoo";
        String d = "forest";
        count = twoOccurrences(c,d);
        if (count>=2)
            System.out.println(">=2!");
            
        else System.out.println("<2");
        lastP = lastPart(c,d);
        System.out.println(lastP);
        
    }

}
