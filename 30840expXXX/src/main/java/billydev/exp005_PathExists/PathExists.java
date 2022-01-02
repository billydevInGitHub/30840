package billydev.exp005_PathExists;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExists {

	//121PD260
	
	public static void main(String[] args) {
		//Path path = Paths.get(args[0]);
		
		Path path=Paths.get("C:\\Billydev080107\\wsCW7\\BJEC\\Test.lnk");//added myself

	//	Path path=Paths.get("C:\\Billydev080107\\wsCW7\\BJEC\\"); //added myself if want to check dir
		
	//	Path path=Paths.get("C:\\");  //added myself if want to check the root folder
		
//		if(Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
//		if(Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
		if(Files.exists(path)) {			
		     System.out.println("The file/directory " + path.getFileName() + " exists");
		
		
		     // check whether it is a file or a directory
		     if(Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
		    	 System.out.println(path.getFileName() + " is a directory");
		     }
		     else {
		    	 System.out.println(path.getFileName() +"  "+ path.toAbsolutePath()+ " is a file");
		     }
		}
		else {
			System.out.println("The file/directory " + path.getFileName() + " does not exist");
		}
	}
}
