package billydev.exp025_DirectoryStreamAndGlobPattern;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

	public static void main(String[] args) {
		// from mtp2q41
		Path dir = Paths.get("c:\\Temp");                 
		//INSERT CODE HERE  
		try{ 
			DirectoryStream<Path> ds = Files.newDirectoryStream(dir, "*.{gif,jpeg,txt}");
		
		    for(Path p : ds){               
			    System.out.println(p);           
			}        
		}catch(Exception e){             
			e.printStackTrace();         
	 }

	}

}
