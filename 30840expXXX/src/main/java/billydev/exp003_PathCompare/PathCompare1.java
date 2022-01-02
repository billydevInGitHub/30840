package billydev.exp003_PathCompare;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathCompare1 {
     //121PD257
	public static void main(String[] args) {
		Path path1 = Paths.get("Test");
		System.out.println("find out the absolute path :"+path1.toAbsolutePath()); //added by myself
		Path path2 = Paths.get("C:\\Billydev080107\\wsCW7\\BJEC\\Test");
		// comparing two paths using compareTo() method
		System.out.println("(path1.compareTo(path2) == 0) is: " + (path1.compareTo(path2) == 0));
		//comparing two paths using equals() method
		System.out.println("path1.equals(path2) is: " + path1.equals(path2));
		// comparing two paths using equals() method with absolute path
		System.out.println("path2.equals(path1.toAbsolutePath()) is "
		+ path2.equals(path1.toAbsolutePath()));
		
		
		//the following added by myself,so basically not see the difference between equals and compareTo
		System.out.println("(path2.compareTo(path1.toAbsolutePath()) == 0) is: " + (path2.compareTo(path1.toAbsolutePath()) == 0));
		
		
		
		System.out.println("=========================================");
		
	    //the following added by myself
	    System.out.println("\npath1 normalize() compare to path2 normalzie()"+ path1.normalize().compareTo(path2.normalize()));
	    System.out.println("\npath1 normalize() equals to path2 normalzie()"+ path1.normalize().equals(path2.normalize())); 
	    System.out.println("\npath2 normalize() compare to path1 normalzie()"+ path2.normalize().compareTo(path1.normalize()));
	    System.out.println("\npath2 normalize() equals to path1 normalzie()"+ path2.normalize().equals(path1.normalize()));
	    
	    
		Path path3 = Paths.get("C:\\Billydev080107\\wsCW7\\BJEC\\Test");
		System.out.println("\nPath2 equals to Path3: "+path2.equals(path3));
		
		//myself try to test toFile method ( but this one is using toFile method, converting to File old API 
		System.out.println("path3 toFile().exists() is: "+path3.toFile().exists());  
		}
	

}
