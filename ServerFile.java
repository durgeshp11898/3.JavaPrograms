
import java.net.*;
import java.io.*;

public class ServerFile {
	private ServerSocket s;
	private ObjectInputStream reader;
	private ObjectOutputStream writer;
	private FileReader f1;
	private String line;
	
	public ServerFile()	{
		try {
			s = new ServerSocket(4444);
			System.out.println("\n Server Started");
			Socket socket = s.accept();
			writer = new ObjectOutputStream(socket.getOutputStream());
			writer.flush();
			reader = new ObjectInputStream(socket.getInputStream());
			System.out.println("Waiting for File name: ");
			Object incoming = reader.readObject();
			File f = new File("file/",(String)incoming);
			
			if(f.exists() && f.isFile()) {
				try {
					System.out.println("Client Requested for file :" +f + "\n Status: File Found..!");
					f1 = new FileReader(f);
					BufferedReader br2 = new BufferedReader(f1);	
					while((line = br2.readLine())!= null) {
						writer.writeObject(line);
						writer.flush();
					}
					writer.writeObject("Done!");
				}catch(IOException e) { System.out.println(e); } 
			}
			else {
				System.out.println("Client Requested for file :" +f + "\n Status: File NOT Found..!");
				writer.writeObject("File Not Found on Server.");
			}
			
			socket.close();
			s.close();	
		}catch(IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] a) {
		new ServerFile();	
	} 

}
