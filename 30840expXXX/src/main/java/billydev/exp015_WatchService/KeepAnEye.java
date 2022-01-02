package billydev.exp015_WatchService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class KeepAnEye {

	//121PD274
	// only files directly belong to src create or modify will reflect, but deletion no message 
	public static void main(String[] args) {
		Path path = Paths.get("C:\\Billydev080107\\wsCW7\\BJEC\\src");  
		WatchService watchService = null;
		try {
			watchService = path.getFileSystem().newWatchService();
			path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//infinite loops
		for(;;){
			WatchKey key = null;
			try {
				key = watchService.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 	iterate for each event
			for(WatchEvent<?> event:key.pollEvents()){
				switch(event.kind().name()){
				case "OVERFLOW":
					System.out.println("We lost some events");
					break;
				case "ENTRY_MODIFY":
					System.out.println("File " + event.context() + " is changed!");
					break;    //seems only create a new file is as modified thing 
				}
			}
			//resetting the key is important to receive subsequent notifications
			key.reset();
		}//end of for infinite loop
	}
}
