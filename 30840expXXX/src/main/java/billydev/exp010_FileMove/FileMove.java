package billydev.exp010_FileMove;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileMove {
	//121PD266
	public static void main(String[] args) {
		if(args.length != 2){
			System.out.println("usage: FileMove <source-path> <destination-path>");
			System.exit(-1);
		}
		Path pathSource = Paths.get(args[0]);
		Path pathDestination = Paths.get(args[1]);
		try {
			Files.move(pathSource, pathDestination, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Source file moved successfully");
			
			
			//added myself
			//create a symbolic link (TBD) 	
			
			//move a symoblic link
			pathSource=Paths.get("C:\\temp\\ss.txt - Shortcut");//this line need to be improved
			pathDestination=Paths.get("C:\\temp\\dd.txt-shortcut");
			Files.move(pathSource, pathDestination, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Symoblic link moved successfully");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
}
