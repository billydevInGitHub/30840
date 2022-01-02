package billydev.exp021_MoreAboutOpenOptions;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Test {

	
	
	public static void main(String[] args) throws IOException {
		//from mtp2q55
		//need to do more test of the options ,like CREATE and CREATE_NEW difference etc. 
		 Path myPath = Paths.get("c:\\temp\\texttest.txt");

         try(
        		BufferedWriter br = Files.newBufferedWriter(myPath,Charset.forName("UTF-8"),
        		new OpenOption[]{StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE})
        		
			) {
			 	br.write("..appended.");
			 } 	 
		 	System.out.println("done");

	}

}
