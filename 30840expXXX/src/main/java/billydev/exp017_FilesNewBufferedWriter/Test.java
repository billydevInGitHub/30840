package billydev.exp017_FilesNewBufferedWriter;

import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Test {

	
	 public static void appendTest() throws Exception {
		 Path myPath = Paths.get("c:\\temp\\texttest.txt");
//		 UserPrincipal up = myPath.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("billy");
//		 Files.setOwner(myPath, up);
         try(
        		 BufferedWriter br = Files.newBufferedWriter(myPath,Charset.forName("UTF-8"),
        		new OpenOption[]{StandardOpenOption.APPEND, StandardOpenOption.DSYNC})
        		 //new OpenOption[]{StandardOpenOption.WRITE, StandardOpenOption.APPEND, StandardOpenOption.DSYNC})  //could be used if file not exists
			) {
			 	br.write("..appended.");
			 } 	 
		 	System.out.println("done");
		}
	 
	
	public static void main(String[] args) {
		//from mtp1q46 
		try {
			appendTest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
