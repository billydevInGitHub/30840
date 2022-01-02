package billydev.exp008_FileAttributesMore;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;

public class FileAttributes2 {
	
	public static void main(String[] args) {
		
		//121PD263
		
		//Path path = Paths.get(args[0]);
		
		Path path=Paths.get("C:\\Billydev080107\\wsCW7\\BJEC\\Test");//added myself
		
		try {
		BasicFileAttributes fileAttributes = Files.readAttributes(path,	BasicFileAttributes.class);
		
		System.out.println("File size: " + fileAttributes.size());
		System.out.println("isDirectory: " + fileAttributes.isDirectory());
		System.out.println("isRegularFile: " + fileAttributes.isRegularFile());
		System.out.println("isSymbolicLink: " + fileAttributes.isSymbolicLink());
		System.out.println("File last accessed time: " + 	fileAttributes.lastAccessTime());
		System.out.println("File last modified time: " +	fileAttributes.lastModifiedTime());
		System.out.println("File creation time: " + fileAttributes.creationTime());
		
		
		//the following added by myself,so we can go through all the attributes
		System.out.println("******************");
		Map<String, Object> am=Files.readAttributes(path, "*", LinkOption.NOFOLLOW_LINKS);
		for(String attributeName:am.keySet()){
			System.out.println(attributeName+" :"+am.get(attributeName));
		}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	
	
}
