package billydev.exp029_PosixFileAttributeView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermissions;

public class Test {

	public static void main(String[] args) {
		// mtp6q60
		
		Path file = Paths.get("C:\\Temp\\AUR_MT_BILL_CYCLE_2_00_05_V03_P.xml"); 
		PosixFileAttributes attrs;
		try {
			attrs = Files.getFileAttributeView(file, PosixFileAttributeView.class).readAttributes();
			System.out.format("%s %s%n", attrs.owner().getName(),PosixFilePermissions.toString(attrs.permissions()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
