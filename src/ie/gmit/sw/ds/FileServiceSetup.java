package ie.gmit.sw.ds;

import java.io.File;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileServiceSetup {

	public static void main(String[] args) throws Exception {
		
		File folder = new File("serverFiles/");
		List<File> fileList = new ArrayList<File>(Arrays.asList(folder.listFiles()));
		
		FileService fs = new FileServiceImpl(fileList);
		
		LocateRegistry.createRegistry(1099);
		Naming.rebind("fileService", fs);	
		
		System.out.println("Server Ready");
		
	}//main
}//class
