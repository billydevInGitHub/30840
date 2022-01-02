package billydev.exp028_RelativeExample;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestRelative {

	public static void main(String[] args) {
		//from mtp5q36
		
        Path p1 = Paths.get("c:\\personal\\.\\photos\\..\\readme.txt");         
        Path p2 = Paths.get("c:\\personal\\index.html");         
        Path p3 = p1.relativize(p2);         
        
        System.out.println(p3);   //when do the relative path, seems original path is not normailized
        
        
        /////the following is added by myself 
        System.out.println(p1.normalize());   
        System.out.println(p2);
        Path p4=(p1.normalize()).relativize(p2);   
        System.out.println(p4);               //p4 is my original answer!!
	}

}
