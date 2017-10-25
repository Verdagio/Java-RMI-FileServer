package ie.gmit.sw.ds;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface FileService extends Remote {
	public byte[] getFile(String fileName) throws RemoteException, IOException;
	public List<String> getFileNames()throws RemoteException;
	public void uploadFile(String fileName, byte[] content)throws RemoteException;
}
