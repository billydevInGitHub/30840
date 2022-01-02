package billydev.exp034_HowToIgnoreFoldersWithMutipleKeywordsInEclipseFolder;

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
		
		matcher = FileSystems.getDefault().getPathMatcher("glob:**.*");
		
		

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
	
	
	public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) {

		
		String pattern="glob:**metadata*";/////(1) **ignore*donotwant* will not match any folder; 
		                                            ////(2)**ignore**donotwant* will match folders that has both "ignore" and "donotwant" in the path chain !!
	//                                               //(3)**ignore**donotwant** will match folders that has both "ignore" and "donotwant" in the path chain !!
		                                             // above (2) (3) might be the same as (2) skip the folder, will not go any further if match !!
		PathMatcher matcher = FileSystems.getDefault().getPathMatcher(pattern);
		

		if(matcher.matches(path)){
			return FileVisitResult.SKIP_SUBTREE; 
		}		

		return FileVisitResult.CONTINUE;
	}
}


public class Path2{

public static void main(String[] args) throws IOException{
////mtp2q59
		MyFileChecker mfc = new MyFileChecker();
		Files.walkFileTree(Paths.get("C:\\Billydev080107\\wsCW7\\.metadata"), mfc);
		System.out.println(mfc.getCount());
	} 
}





