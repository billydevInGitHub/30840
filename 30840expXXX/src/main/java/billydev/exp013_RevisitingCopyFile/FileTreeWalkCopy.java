package billydev.exp013_RevisitingCopyFile;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

//121PD270

//Our File visitor implementation that performs copy
class MyFileCopyVisitor extends SimpleFileVisitor<Path> {
	private Path source, destination;

	public MyFileCopyVisitor(Path s, Path d) {
		source = s;
		destination = d;
	}

	public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
		Path newd = destination.resolve(source.relativize(path));
		System.out.println("path is: "+path+"  source.relativize(path) is:  "
		          +source.relativize(path)+"  destination.resolve(source.relativize(path) is:  "+destination.resolve(source.relativize(path)));
		try {
			Files.copy(path, newd, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return FileVisitResult.CONTINUE;
	}

	public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) {
		Path newd = destination.resolve(source.relativize(path));
		try {
			Files.copy(path, newd, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return FileVisitResult.CONTINUE;
	}
}

public class FileTreeWalkCopy {
	public static void main(String[] args) {
		// if(args.length != 2) {
		// System.out.println("usage: FileTreeWalkCopy <source-path>
		// <destination-path>");
		// System.exit(1);
		// }
		// Path pathSource = Paths.get(args[0]);
		// Path pathDestination = Paths.get(args[1]);

		// need 2 input parameters source and destination
		// C:\Billydev080107\wsCW7\BJEC\src\ c:\temp\src
		Path pathSource = Paths.get("C:\\Billydev080107\\wsCW7\\BJEC\\src");
		Path pathDestination = Paths.get("c:\\temp\\src");

		try {
			Files.walkFileTree(pathSource, new MyFileCopyVisitor(pathSource, pathDestination));
			System.out.println("Files copied successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
