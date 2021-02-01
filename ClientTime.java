
import java.net.*;
import java.io.*;

public class ClientTime {
	private ObjectInputStream reader;
	//private ObjectOutputStream writer;
	
	public ClientTime()	{
		try {
			System.out.println("\n Client Started");
			Socket socket1 = new Socket("localhost",4444);
			System.out.println("\n Connection Established!");
			reader = new ObjectInputStream(socket1.getInputStream());
			Object o = reader.readObject();
			System.out.println("Server Time is: "+o.toString());
			socket1.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] a) {
		new ClientTime();	
	} 

}
