package billydev.exp006_FilePermissions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePermissions {

	public static void main(String[] args) {
		//121PD260
		
		
		//Path path = Paths.get(args[0]);
		
		Path path=Paths.get("C:\\temp\\ttt.txt");//added myself
		
		System.out.printf( "Readable: %b, Writable: %b, Executable: %b ",
		Files.isReadable(path), Files.isWritable(path), Files.isExecutable(path));
		}
}
