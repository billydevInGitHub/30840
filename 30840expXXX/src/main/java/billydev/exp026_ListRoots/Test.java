package billydev.exp026_ListRoots;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		//mtp4q24
		
		File[] roots =File.listRoots(); 
		for(File f : roots){
				System.out.println(f); 
		}

	

	
		Iterable<Path> roots2 =FileSystems.getDefault().getRootDirectories();
		for(Path p : roots2){
			System.out.println(p); 
		}
		
		Iterator iter=roots2.iterator(); 
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
	}
}
