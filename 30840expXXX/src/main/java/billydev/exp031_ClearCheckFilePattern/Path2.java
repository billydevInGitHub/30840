package billydev.exp031_ClearCheckFilePattern;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;



class MyFileChecker extends SimpleFileVisitor<Path>{
	
	private final PathMatcher matcher;
	private static int count;
	
	public MyFileChecker(){
		//option2
		matcher = FileSystems.getDefault().getPathMatcher("glob:**.*");//if changed to **.* all files matched 
		
		

	}
	
	void check(Path p){ 
		if(p != null && matcher.matches(p)){
			count++; 
			System.out.println("find a match file: "+p);
		} 
	}
	
	public int getCount(){
		return count;
	}
	
	public FileVisitResult visitFile(Path p, BasicFileAttributes attr){
		

		check(p); 
		return FileVisitResult.CONTINUE; 
	} 
	
}


public class Path2{

public static void main(String[] args) throws IOException{
////mtp2q59
		MyFileChecker mfc = new MyFileChecker();
		Files.walkFileTree(Paths.get("c:\\Temp\\works\\pathtest"), mfc);
		System.out.println(mfc.getCount());
	} 


}



