package billydev.exp020_GlobPatternWithDirectoryVisit;

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
		matcher = FileSystems.getDefault().getPathMatcher("glob:**.java");
		
		
		//original 
		//matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");
	}
	
	void check(Path p){ 
		if(p != null && matcher.matches(p)){
			count++; 
		} 
	}
	
	public int getCount(){
		return count;
	}
	
	public FileVisitResult visitFile(Path p, BasicFileAttributes attr){
		
		//option1 because of the getFileName() is the fathest element, we can find the match  
//		Path lastName=p.getFileName();
//		check(lastName);

		
		//option2 change the pattern 
		
		
		//orig  -- with out option1 and option2 , no matches 
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





