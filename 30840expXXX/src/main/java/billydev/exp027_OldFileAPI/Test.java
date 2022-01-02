package billydev.exp027_OldFileAPI;

import java.io.File;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		// This is for the test use of old File API 
		
		File f = new File("c:\\Temp\\testFile");
		f.mkdirs();   //need to make dir first for the following file creation 
		f = new File("c:\\Temp\\testFile\\newFile.txt");
		f.createNewFile(); // will throw exception if the specified path not existing ( mainly for the parent folder of the file)

	}

}
