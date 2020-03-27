public class Part1 {

    String findSimpleGene(String dna){
        String res = "";
        int strt = dna.indexOf("ATG");
        if (strt==-1)
            {return "";}
        
        int end = dna.indexOf("TAA", strt+3);
        if (end==-1)
            {return "";}
            
        res = dna.substring(strt, end+3);
        if (res.length() % 3 ==0)
        {return res;}
        else
        return "";
    }
    
    void testSimpleGene(){
    
        String dna = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("DNA: " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("GENE "+ gene);
        
        dna = "ARGATGETVHTHrTAAETHVT";
        System.out.println("DNA with no %3: " + dna);
        gene = findSimpleGene(dna);
        System.out.println("GENE "+ gene);
        
        dna = "ARGETVHTHrTAAETHVT";
        System.out.println("DNA with no ATG: " + dna);
        gene = findSimpleGene(dna);
        System.out.println("GENE "+ gene);
        
        dna = "ARGATGETVHTHrETHVT";
        System.out.println("DNA with no TAA: " + dna);
        gene = findSimpleGene(dna);
        System.out.println("GENE "+ gene);
        
        dna = "ATGTAA";
        System.out.println("DNA short: " + dna);
        gene = findSimpleGene(dna);
        System.out.println("GENE "+ gene);
    }    
}
