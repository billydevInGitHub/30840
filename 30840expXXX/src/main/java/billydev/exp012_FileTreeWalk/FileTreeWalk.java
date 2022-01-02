package billydev.exp012_FileTreeWalk;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class MyFileVisitor extends SimpleFileVisitor<Path> {
	public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes){
		System.out.println("file name:" + path.getFileName());
		System.out.println("file absolute name:" + path.toAbsolutePath());//added by myself to get the absolute path
		return FileVisitResult.CONTINUE;
}
	public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes){
		System.out.println("----------Directory name:" + path + "----------");
		return FileVisitResult.CONTINUE;
}
}


public class FileTreeWalk {
	public static void main(String[] args) {
//		if(args.length != 1) {
//			System.out.println("usage: FileWalkTree <source-path>");
//			System.exit(-1);
//		}
//		Path pathSource = Paths.get(args[0]);
		
		//121PD268
		Path pathSource =Paths.get("C:\\Billydev080107\\wsCW7\\BJEC");
		try {
			Files.walkFileTree(pathSource, new MyFileVisitor());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
