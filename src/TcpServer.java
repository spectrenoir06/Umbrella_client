import java.io.*;
import java.net.*;

public class TcpServer
{
	private Socket socket;
	private DataOutputStream serverIn;
	private BufferedReader serverOut;
	
	public TcpServer(String ip, int port)
	{
		try
		{
			socket		= new Socket(ip, port);
			serverIn	= new DataOutputStream(socket.getOutputStream());
			serverOut	= new BufferedReader(new InputStreamReader(socket.getInputStream()));	
		}
		catch (Exception e)
		{
			System.out.println("Impossible d'initialiser la connection");
		}
	}

	public void send(String str)
	{
		try {
			System.out.println(str);
			serverIn.writeBytes(str + "\n");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public String receive()
	{
		String str;
		try {
			str = serverOut.readLine() + "\n";
			System.out.println(str);
			return (str);
		} catch (IOException e) {
			e.printStackTrace();
			return("");
		}
	}
	public void finalize()
	{
		 try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}