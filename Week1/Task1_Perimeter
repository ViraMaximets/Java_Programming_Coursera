import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
       int count = 0;
        for(Point currP : s.getPoints()) {
            count = count +1;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        int amount = getNumPoints(s);
        double leng = getPerimeter(s);
        double avrg = leng/amount;
        return avrg;
    }

    public double getLargestSide(Shape s) {
        double large = 0.0;
        Point prevPt=s.getLastPoint();
        for (Point currP : s.getPoints()) {
            double d = prevPt.distance(currP);
            if (d>large)
                {large=d;}
            prevPt = currP;
        }
        return large;
    }

    public double get_X(Point a){
        int x = a.getX();
        return x;
    }
    
    public double getLargestX(Shape s) {
        double largestX = 0;
        for (Point currP : s.getPoints()) {
        double x = get_X(currP);
        if (x>largestX)
        {largestX=x;}
        }
        return largestX;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        double avrleng = getAverageLength(s);
        double LargestSide = getLargestSide(s);
        System.out.println("perimeter = " + length);
        System.out.println("avrleng = " + avrleng);
        System.out.println("LargestSide = " + LargestSide);
    }
    
     public double getLargestPerimeterMultipleFiles() {
        double largstPer=0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
                FileResource fr = new FileResource(f);
                Shape s = new Shape(fr);
                double Perim = getPerimeter(s);
                if (Perim>largstPer)
                {largstPer=Perim;}
            }

        return largstPer;
        }
        
    public String getFileWithLargestPerimeter() {
        double largstPer=0.0;
        File lrgstFile = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
                FileResource fr = new FileResource(f);
                Shape s = new Shape(fr);
                double Perim = getPerimeter(s);
                if (Perim>largstPer)
                {largstPer=Perim;
                lrgstFile = f;
                }
            }
        return lrgstFile.getName();
    }
    
    public void testPerimeterMultipleFiles() {
        double largstPer = getLargestPerimeterMultipleFiles();
        System.out.println("largstPer = " + largstPer);
    }

    public void testFileWithLargestPerimeter() {
        String file = getFileWithLargestPerimeter();
        System.out.println("Largest perimeter file is: " + file);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }
    

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        //pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();


    }
}
