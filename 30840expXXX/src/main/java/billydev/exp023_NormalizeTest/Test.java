package billydev.exp023_NormalizeTest;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

	public static void main(String[] args) {
		// from mtp3q21
		Path p1 = Paths.get("c:\\..\\temp\\test.txt");    
		
		System.out.println(p1.normalize().toUri());
		

		// from mtp2q64
        p1 = Paths.get("c:\\personal\\.\\photos\\..\\readme.txt");         
        Path p2 = p1.normalize();         
        System.out.println(p2);
		
	}

}
