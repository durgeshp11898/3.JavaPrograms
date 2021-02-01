
import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerTime {
	private ServerSocket s;
	//private ObjectInputStream reader;
	private ObjectOutputStream writer;
	
	public ServerTime()	{
		try {
			s = new ServerSocket(4444);
			System.out.println("\n Server Started");
			Socket socket = s.accept();
			writer = new ObjectOutputStream(socket.getOutputStream());
			writer.writeObject(new SimpleDateFormat("HH:mm:ss").format(new Date()));
			socket.close();
			s.close();	
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	public static void main(String[] a) {
		new ServerTime();	
	} 

}
