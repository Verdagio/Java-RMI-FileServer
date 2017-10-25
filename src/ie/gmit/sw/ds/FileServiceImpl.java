package ie.gmit.sw.ds;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl extends UnicastRemoteObject implements FileService {
	
	private static final long serialVersionUID = 1L;
	private File file;
	private List<File> fileList;
	
	public FileServiceImpl(List<File> fileList) throws RemoteException {
		super();
		this.fileList = fileList;
		//System.out.println(getFileNames().toString());

	}
	
	public byte[] getFile(String fileName) throws RemoteException, IOException{
		return Files.readAllBytes(new File("serverFiles/" + fileName).toPath());

	}//get file by name

	public List<String> getFileNames() throws RemoteException {
		List<String> names = new ArrayList<String>();
		
		for(File f : fileList) {
			names.add(f.getName());
		}//for each file in the file list add the name to the list of names
		
		return names;
	}//get file names 

	
	public void uploadFile(String fileName, byte[] content) {
		
		try {
			FileOutputStream stream = new FileOutputStream("clientFiles/" + fileName);
			stream.write(content);
			stream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//upload file

}
