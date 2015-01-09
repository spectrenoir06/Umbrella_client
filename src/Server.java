import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.*;

public class Server {
	private TcpServer	server;
	private ArrayList<Client> clients;
	public Server(String ip, int port) {
		try
		{
			server = new TcpServer(ip, port);
			cmd("root");	
			sendUpdateClientList();
			clients = new ArrayList<Client>();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}		
	}
	
	private void cmd(String string) throws IOException
	{
		server.send("cmd:" + string);	
	}

	private void sendUpdateClientList() throws IOException
	{
		server.send("cmd:client");
	}
	
	public void update() throws IOException
	{
		String	data;
		
		data = server.receive();
		System.out.print(data);
		if (data.startsWith("jso:"))
		{
			if (data.startsWith("jso:lst:"))
				initClients(data.substring(8));
			else if ((data.startsWith("jso:lst:")))
				disconnectClient(data.substring(8));
			
		}
		else
		{
			System.out.print(data);
		}
	}
	private void disconnectClient(String substring)
	{
		System.out.println("Client disconnect " + substring);
	}

	private void initClients(String string)
	{
		JSONObject json = new JSONObject(string);
		Iterator<String> keys = json.keys();

        while (keys.hasNext())
        {
            JSONObject tmp = (JSONObject) json.get(keys.next());
            Client	clientTmp = new Client(	tmp.getString("ip"), tmp.getInt("port"));
            try
            {
            	clientTmp.setHostname(tmp.getString("hostname"));
            	clientTmp.setLogin(tmp.getString("login"));
            }
            catch (JSONException e) 
            {
            	System.out.println("Erreur pas de Hostname");
            }
            clients.add(clientTmp);
        }
	}
	
}
