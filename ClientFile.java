
import java.net.*;
import java.io.*;

public class ClientFile {
	private ObjectInputStream reader;
	private ObjectOutputStream writer;
	
	public ClientFile()	{
		try {
			System.out.println("\n Client Started");
			Socket socket = new Socket("localhost",4444);
			System.out.println("\n Connection Established!");
			writer = new ObjectOutputStream(socket.getOutputStream());
			writer.flush();
			reader = new ObjectInputStream(socket.getInputStream());

			System.out.println("Enter File name: ");
			String string = new BufferedReader(new InputStreamReader(System.in)).readLine();
			writer.writeObject(string);
		
			System.out.println("Waiting for Server to Respond: ");
			String response = (String)reader.readObject();
			if(response.equals("File Not Found on Server."))
				System.out.println(response);
			else {
				System.out.println("Displaying file Contents: ");
				while(!response.equals("Done!")) {
					System.out.println(response);
					response = (String)reader.readObject();
				}
			}	
			socket.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] a) {
		new ClientFile();	
	}
} 
