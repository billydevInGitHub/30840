package billydev.exp030_MoreAboutNormalize;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

	public static void main(String[] args) {
		// mtp2q64  how to normalize a path without root
		// I changed a lot 
		
        //Path p1 = Paths.get("c:\\personal\\.\\photos\\..\\readme.txt");  
		//Path p1 = Paths.get("personal\\.\\photos\\..\\readme.txt");  //do not include a root then do normalize, it is fine
		Path p1 = Paths.get("."); //does not have a root and all are redundant ( this is what I guess0
        Path p2 = p1.normalize();         
        System.out.println(p2);

	}

}
