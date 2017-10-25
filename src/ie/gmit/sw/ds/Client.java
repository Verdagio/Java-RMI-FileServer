package ie.gmit.sw.ds;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.rmi.Naming;
import java.util.Scanner;

public class Client {

	public static void main (String[]args) throws Exception {
		boolean good = true;
		String fileName = "";
		int choice = 0;
		
		FileService fs = (FileService) Naming.lookup("rmi://127.0.0.1:1099/fileService");
		
		Scanner input = new Scanner(System.in);
		
		while(good) {
			
		
			System.out.printf("Please enter your desired action:\n 1:\tList all files on server\n 2: \tDownload a file\n 3:\tUpload a file\n 4:\tQuit\n:::\t\n");
			choice = input.nextInt();
			
			
			if(choice== 1) {
				System.out.println(fs.getFileNames().toString());
			}else if(choice ==2) {
				//download a file
				System.out.println("Enter file name: ");
				fileName = input.next();
				byte[] bytes = fs.getFile(fileName);
				FileOutputStream stream = new FileOutputStream("clientFiles/" + fileName);
				stream.write(bytes);
				stream.close();
			}else if(choice == 3) {
				//upload a file
				System.out.println("Enter file name: ");
				fileName = input.next();
				byte[] bytes = Files.readAllBytes(new File("clientFiles/" + fileName).toPath());
				fs.uploadFile(fileName, bytes);
			}else if(choice == 4) {	
				System.out.println("Exiting");
				good = false;
			}else {
				System.out.println("invalid input, try again");
			}
		}
		
	}
	
}
