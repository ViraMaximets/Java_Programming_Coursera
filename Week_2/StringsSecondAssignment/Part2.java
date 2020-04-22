public class Part2 {

    public int howMany(String a, String b)
     {  
         int curr = b.indexOf(a);
         int alen = a.length();
         int sum = 0;
         while (curr != -1) {
             curr= b.indexOf(a, curr+alen);
             sum++;
         } 
        
         return sum;
     }
    
     
     public void testHowMany(){
         
         String a = "aa";
         
         String b = "JKDSGHaaaaKDFJVaaP"; //3
         int is = howMany(a,b);
         System.out.println(is);
         
         b = "JKDaaKDFJVaaaP"; //2
         is = howMany(a,b);
         System.out.println(is);
         
         b = "JKDaKDFJpaP"; //0
         is = howMany(a,b);
         System.out.println(is);
         
     }

}
