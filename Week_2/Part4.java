import edu.duke.*;
import java.io.File;

public class Part4 {

  public void test() {
    URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
    for (String line : ur.words()) {
    int p = line.toLowerCase().indexOf("youtube.com");
    if (p!=-1) {
        System.out.println(line); 
        int start = line.indexOf("\"", 0);
        int stop = line.lastIndexOf("\"", line.length());
        
        System.out.println(start);
        System.out.println(stop);
        String URL = line.substring(start, stop+1);
        
        System.out.println(URL);
    }
    
    }
    
  }
}
