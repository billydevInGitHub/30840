package billydev.exp024_OldFileAPI;

import java.io.File;

public class Test {

	
	public static void main(String[] args){
		//mtp3q16 
		
		File f = new File("c:\\Temp\\a\\b\\c\\d\\e");
		
		System.out.println("Calling f.mkdir() the return value is:"+f.mkdir());  //return false, will not throw exception   //can only make one dir
		System.out.println("Calling f.mkdirs() the return value is:"+f.mkdirs()); //can make a bunch of dir at the same time 
//		
		System.out.println("Calling f.getParentFile() return : "+f.getParentFile());   //seems not check the actual file system 
		
		System.out.println("Calling f.getParent() return : "+f.getParent());          //getParent return String while getParentFile return File
		
		
		//added by myself
		System.out.println("Calling f.getName() return :"+f.getName()); //only the last one of the name 
	}
}
