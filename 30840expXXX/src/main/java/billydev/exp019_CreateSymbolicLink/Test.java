package billydev.exp019_CreateSymbolicLink;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

	public static void main(String[] args) {
		// refer to:  https://docs.oracle.com/javase/tutorial/essential/io/links.html 

		Path newLink = Paths.get("testfile.link");;
		Path target =Paths.get("C:\\test\\testfile.txt");;
		try {
		    Files.createSymbolicLink(newLink, target);
		} catch (IOException x) {
		    System.err.println(x);
		} catch (UnsupportedOperationException x) {
		    // Some file systems do not support symbolic links.
		    System.err.println(x);
		}
		
	}

}
