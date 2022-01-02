package billydev.exp001_PathInfo;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInfo1 {
	public static void main(String[] args) {
		
		//121PD254
		
		// create a Path object by calling static method get() in Paths class
		Path testFilePath = Paths.get("C:\\test\\testfile.txt");
		// retrieve basic information about path
		System.out.println("Printing file information: ");
		System.out.println("\t file name: " + testFilePath.getFileName());//farthest object 
		System.out.println("\t root of the path: " + testFilePath.getRoot());
		System.out.println("\t parent of the target: " + testFilePath.getParent());
		System.out.println("\t name count  of the path: " + testFilePath.getNameCount());// added by myself
		System.out.println("\t test getName(0): " + testFilePath.getName(0));// added by myself, index begin from 0
		System.out.println("\t test getName(1): " + testFilePath.getName(1));// added by myself
//		System.out.println("\t test getName(2): " + testFilePath.getName(2));// added by myself   
//		System.out.println("\t test getName(3): " + testFilePath.getName(3));// added by myself
		                System.out.println("\t test normalize() : " + testFilePath.normalize());// added by myself
		                System.out.println("\t test normalize().toString(): " + testFilePath.normalize().toString());// added by myself
		// print path elements
		System.out.println("Printing elements of the path: ");
		int count=0;
		for(Path element : testFilePath) {
			count++;
			System.out.println("Count is: "+count+"  \n");
			System.out.println("\t path element: " + element);
		System.out.println("\t path element FileName: " + element.getFileName());//this line added by myself
		System.out.println("\t path element Name Count: " + element.getNameCount());//this line added by myself
		}
		}
}
