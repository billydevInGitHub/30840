package billydev.exp022_CombinationOfFileOpenOptions;

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
		//from mtp3q2
		//need to do more test of the options ,like CREATE and CREATE_NEW difference etc. 
		 Path myPath = Paths.get("c:\\temp\\texttest2.txt");

         try(
        		 BufferedWriter br = Files.newBufferedWriter(myPath,Charset.forName("UTF-8"),
        		//new OpenOption[]{StandardOpenOption.WRITE, StandardOpenOption.DELETE_ON_CLOSE})   //ok
        		//new OpenOption[]{StandardOpenOption.READ, StandardOpenOption.DELETE_ON_CLOSE});   //not ok for read
        		//new OpenOption[]{StandardOpenOption.DELETE_ON_CLOSE, StandardOpenOption.TRUNCATE_EXISTING}); //ok
   				//new OpenOption[]{StandardOpenOption.APPEND, StandardOpenOption.CREATE_NEW})  //??seem ok after deletet the file
   				new OpenOption[]{StandardOpenOption.READ, StandardOpenOption.SYNC}); //read not allowed ? 
        				
        		
			) {
			 	br.write("123");
			 } 	 
		 	System.out.println("done");

	}

}
