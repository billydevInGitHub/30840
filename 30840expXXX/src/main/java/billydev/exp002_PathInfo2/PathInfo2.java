package billydev.exp002_PathInfo2;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInfo2 {

	public static void main(String[] args) throws IOException {
		//121PD255
		
		//get a path object with relative path
		Path testFilePath = Paths.get(".\\Test");   //this looks like traditional relative path
		          System.out.println("The realpath is: " + testFilePath.toRealPath(LinkOption.NOFOLLOW_LINKS));
		//Path testFilePath = Paths.get("Test");// added by myself, if we use pure relative path, the following will look better
		System.out.println("The file name is: " + testFilePath.getFileName());  //the same as last one 
		System.out.println("It's URI is: " + testFilePath.toUri()); //can be used in browser
		System.out.println("It's absolute path is: " + testFilePath.toAbsolutePath()); //seems simply put path together
		                                                                               //compare with toUri, it does not have the protocol name and also it use backslash instead of slash in uri
		System.out.println("It's normalized path is: " + testFilePath.normalize()); //seems remove redundant symbols, make the path looks very normal !!
		                                                                            //normalized path seems the remove redundant, also if orig is relative path, normalized one also relative
		                                                                            //if orig is absolute path, then normalized is aboslute see Exp001
		System.out.println("It's normalized path toString is: " + testFilePath.normalize().toString());//added by myself
		// get another path object with normalized relative path
		Path testPathNormalized = Paths.get(testFilePath.normalize().toString()); //relative path (need to be normalized) could also use as input
		System.out.println("It's normalized absolute path is: " +
		testPathNormalized.toAbsolutePath());
		
		System.out.println("It's normalized real path is: " +
		testFilePath.toRealPath (LinkOption.NOFOLLOW_LINKS)); //this is the only way to check with real file system, actually it will throw exception if file not exists!!
		                                                      //if we remove "C:\Billydev080107\wsCW7\BJEC\Test" file, then an Exception will be thrown here
		                                                          //if we make "C:\Billydev080107\wsCW7\BJEC\Test" an shortcut in windows, still same exception thrown !!  
		Path ttPath=Paths.get(testFilePath.toAbsolutePath().toString());//added by myself
		System.out.println("The new path is :"+ttPath);// absolute path is a simple add of path elements
		                                               // better to have path normalized then toString 
				
		//121PD256
		Path dirName = Paths.get("D:\\OCPJP7\\programs\\NIO2\\");
		Path resolvedPath = dirName.resolve("Test");  //if the directory name and file name are given separately , we can use this to resolve 
		System.out.println("Resolved path is: "+resolvedPath);    //again, not related to any real path stuff 

	
	    //mtp2q64
	    Path p1 = Paths.get("c:\\personal\\.\\photos\\..\\readme.txt"); 
	    Path p2 = p1.normalize(); 
	    System.out.println("Normalized path is: "+p2);  //remove dup and redudant stuff 
	    
	    //mtp3q33
	     Path p3 = Paths.get("c:\\main\\project\\Starter.java");          
	     String root = p3.getRoot().toString();    
	     System.out.println("root is: "+ root);
	     
	     System.out.println("\np3.getName(0) is: "+p3.getName(0)+ " \np3.getName(1) is: "+p3.getName(1)+" \np3.getName(2) is:"+p3.getName(2));
	     
	     //System.out.println("\np3.getName(3) is:"+ p3.getName(3));   //Exception
	    
	     //mtp2q64 commment last line: 
         //Returns:
         //the resulting path or this path if it does not contain redundant name elements; an empty path is returned if this path does have a root                       component and all name elements are redundant
		    Path p3a = Paths.get(""); //??still not sure the above case
		    Path p4 = p3a.normalize(); 
		    System.out.println("p4 is:"+p4);	     
	    
	}
}
