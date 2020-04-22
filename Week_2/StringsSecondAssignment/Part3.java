public class Part3 {
    public int findStopCodon(String dna, int start, String stopCodon)
     {  
         int curr = dna.indexOf(stopCodon, start+3);
         while (curr != -1) {
         if ((curr-start) %3 == 0)
            return curr;
         else 
            {
             curr= dna.indexOf(stopCodon, curr+3);  
            }
        }
         return -1;
     }
    
     public String findGene(String dna, int start){
         if (start == -1)
            return "";
            
         int taaIndx = findStopCodon(dna, start, "TAA");
         int tagIndx = findStopCodon(dna, start, "TAG");
         int atgIndx = findStopCodon(dna, start, "ATG");
         
         int minIndx = 0;
         if ((taaIndx==-1) || (tagIndx!=-1)&&(taaIndx>tagIndx))
         {
             minIndx = tagIndx;
         }
         else 
         {
             minIndx = taaIndx;
            }
         
         if ((minIndx==-1) || (atgIndx!=-1)&&(minIndx>atgIndx))
         {
             minIndx = atgIndx;
         }
         
         if (minIndx != -1)
            return dna.substring(start, minIndx+3);


         return "";
     }
       
    public void countGenes(){
        String dna = "rr ATGhhhfffrrrTAG i ATGooTAAammmTAA p ATGTAA ";
        int sum = 0;
        int start = 0;
        while (true)
        {     
           String dn = findGene(dna, start); 
           if (dn.isEmpty())
                break;
  
           sum++;
           start = dna.indexOf(dn, start)+dn.length();
        }
        System.out.println(sum);
    }

}
