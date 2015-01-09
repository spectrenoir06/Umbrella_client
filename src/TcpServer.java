import java.io.*;
import java.net.*;

public class TcpServer
{
	private Socket socket;
	private DataOutputStream serverIn;
	private BufferedReader serverOut;
	
	public TcpServer(String ip, int port) throws Exception
	{
		socket		= new Socket(ip, port);
		serverOut	= new BufferedReader(new InputStreamReader(socket.getInputStream()));
		serverIn	= new DataOutputStream(socket.getOutputStream());
	}

	public void send(String str) throws IOException
	{
		serverIn.writeBytes(str + "\n");
	}
	
	public String receive() throws IOException
	{
		return (serverOut.readLine() + "\n");
	}
	public void finalize() throws IOException
	{
		 socket.close();
	}
}