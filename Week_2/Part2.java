public class Part2 {

    String findSimpleGene(String dna, int strtCodon, int stopCodon){
        String res = "";
        if (strtCodon==-1)
            {return "";}
        if (stopCodon==-1)
            {return "";}
            
        res = dna.substring(strtCodon, stopCodon+3);
        if (res.length() % 3 ==0)
        {return res;}
        else return "";
    }
    
    void testSimpleGene(){
        int strt, end;
        String dna = "ARGATGETVHTHTAAETHVT";
        System.out.println("DNA: " + dna);
        int strt1 = dna.indexOf("ATG");
        int strt2 = dna.indexOf("atg");
        int end1 = dna.indexOf("TAA", strt1+3);
        int end2 = dna.indexOf("taa", strt2+3);
        if (strt1==-1)
            strt=strt2;
        else strt = strt1;
        if (end1==-1)
            end=end2;
        else end = end1;
        String gene = findSimpleGene(dna, strt, end);
        System.out.println("GENE: "+ gene);
        
        dna = "dzfgbfatgkgjhdskjetaadfhb";
        System.out.println("dna: " + dna);
        strt1 = dna.indexOf("ATG");
        strt2 = dna.indexOf("atg");
        end1 = dna.indexOf("TAA", strt1+3);
        end2 = dna.indexOf("taa", strt2+3);
        if (strt1==-1)
            strt=strt2;
        else strt = strt1;
        if (end1==-1)
            end=end2;
        else end = end1;
        gene = findSimpleGene(dna, strt, end);
        System.out.println("GENE: "+ gene);
        
        dna = "ARGATGETVHTHrTAAETHVT";
        System.out.println("DNA with no %3: " + dna);
        strt1 = dna.indexOf("ATG");
        strt2 = dna.indexOf("atg");
        end1 = dna.indexOf("TAA", strt1+3);
        end2 = dna.indexOf("taa", strt2+3);
        if (strt1==-1)
            strt=strt2;
        else strt = strt1;
        if (end1==-1)
            end=end2;
        else end = end1;
        gene = findSimpleGene(dna, strt, end);
        System.out.println("GENE: "+ gene);
        
        dna = "ARGETVHTHrTAAETHVT";
        System.out.println("DNA with no ATG: " + dna);
        strt1 = dna.indexOf("ATG");
        strt2 = dna.indexOf("atg");
        end1 = dna.indexOf("TAA", strt1+3);
        end2 = dna.indexOf("taa", strt2+3);
        if (strt1==-1)
            strt=strt2;
        else strt = strt1;
        if (end1==-1)
            end=end2;
        else end = end1;
        gene = findSimpleGene(dna, strt, end);
        System.out.println("GENE: "+ gene);
        
        dna = "ARGATGETVHTHrETHVT";
        System.out.println("DNA with no TAA: " + dna);
        strt1 = dna.indexOf("ATG");
        strt2 = dna.indexOf("atg");
        end1 = dna.indexOf("TAA", strt1+3);
        end2 = dna.indexOf("taa", strt2+3);
        if (strt1==-1)
            strt=strt2;
        else strt = strt1;
        if (end1==-1)
            end=end2;
        else end = end1;
        gene = findSimpleGene(dna, strt, end);
        System.out.println("GENE: "+ gene);
        
        dna = "ATGTAA";
        System.out.println("DNA short: " + dna);
        strt1 = dna.indexOf("ATG");
        strt2 = dna.indexOf("atg");
        end1 = dna.indexOf("TAA", strt1+3);
        end2 = dna.indexOf("taa", strt2+3);
        if (strt1==-1)
            strt=strt2;
        else strt = strt1;
        if (end1==-1)
            end=end2;
        else end = end1;
        gene = findSimpleGene(dna, strt, end);
        System.out.println("GENE: "+ gene);
    }
    
    
}

