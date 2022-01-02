package billydev.exp016_PathResolveAndRelatvize;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

	public static void main(String[] args) {
		//From mtp1q32                    <-------------VERY IMPORTANT PART HERE
		Path p1 = Paths.get("\\photos\\vacation");
		Path p2 = Paths.get("\\yellowstone");
		             //Path p2=Paths.get("\\photos");  //child can also climb the parent 
		//System.out.println("p1.resolve(p2) is: "+p1.resolve(p2));
		System.out.println("p1.resolve(p2) is: "+p1.resolve(p2)+"��p1.relativize(p2) is: "+p1.relativize(p2));
          
		
		
		//add myself
		Path p3=Paths.get("billy");  //if billy has no root in the path, then it will throw exception
		//System.out.println(p1.resolve(p3)+"��"+p1.relativize(p3));	//a relative path can not be constructed when only one of the paths have a root component	
		System.out.println(p1.resolve(p3));//resolve still ok see below 
		  Path p3a=Paths.get("Helena");
		  System.out.println("p3 resolve(p3a) is: "+p3.resolve(p3a)); 
		  
		  
		//mtp1q47 from the comments: 
		System.out.println("Relativize for the same path: "+p1.relativize(p1));  //will get empty 
		
		//For any two normalized paths p and q, where q does not have a root component <---------first need to do  resolve, then can do relativize 
		// here p is p1, q is p3
		//this is kind : parent resolve child, then parent relativize the resolved child, get the child , make sense !! 
		System.out.println("p1.resolve(p3) is: "+p1.resolve(p3));   //now p3 is kind added some root stuff
		System.out.println("p1.relativize(p1.resolve(p3)) is: "+p1.relativize(p1.resolve(p3)));   //now it can be relativized 
		System.out.println("p1.relativize(p1.resolve(p3)).equals(p3) is: "+p1.relativize(p1.resolve(p3)).equals(p3));   //they always equal
		
		
		//add more 
		Path p4=Paths.get("/a/b");
		Path p5=Paths.get("/a/b/c/d");
		System.out.println("p4.relativize(p5)="+p4.relativize(p5));  //parent relativize child got child
		System.out.println("p5.relativize(p4)="+p5.relativize(p4));  //child relativize parent got .. stuff 
		
		//check if one has root , one not has root----------both mush have root component!!
//		Path p6=Paths.get("/a/b");
//		Path p7=Paths.get("b/c/d");
//		System.out.println("p6.relativize(p7)="+p6.relativize(p7)); 
//		System.out.println("p7.relativize(p6)="+p7.relativize(p6));  

		
		//if both are relative path , also ok !! rules seems the same as with the root !! 
		Path p8=Paths.get("a/b");
		Path p9=Paths.get("a/b/c/d");
		System.out.println("p8.relativize(p9)="+p8.relativize(p9));  //parent relativize child got child
		System.out.println("p9.relativize(p8)="+p9.relativize(p8));  //child relativize parent got .. stuff 
		
		
		
		//resolve: test if the other path has root component
		Path p10=Paths.get("a/b");
		Path p11=Paths.get("/"); // 
		System.out.println("p10.resolve(p11)="+p10.resolve(p11.getRoot()));  // if p11: "c:\\d\\e\\" then return c:\ ; if p11 : "/" then return \
		
		
		//170824: add more about toFile()
		Path p12=Paths.get("c:\\notexisting\\test.txt");
		File file= p12.toFile();
		System.out.println("file.getAbsolutePath() "+file.getAbsolutePath());
		System.out.println("file.exists() "+file.exists());
		
		
		//170824: add more about subPath()
		Path p13=Paths.get("c:\\p0\\p1\\p2\\p3\\test.txt");
		Path p14=p13.subpath(0, 2);
		System.out.println("P14 is:"+p14);
				
		
	}

}
