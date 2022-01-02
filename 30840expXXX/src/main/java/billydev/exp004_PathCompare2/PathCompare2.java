package billydev.exp004_PathCompare2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathCompare2 {
	//121PD259
	public static void main(String[] args) throws IOException {
		Path path1 = Paths.get("Test");
		Path path2 = Paths.get("C:\\Billydev080107\\wsCW7\\BJEC\\Test");
		System.out.println("Files.isSameFile(path1, path2) is: "
		+ Files.isSameFile(path1, path2));  //if we give non-existing file, it will give exception!!
		}

}
