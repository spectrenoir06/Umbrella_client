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
			server.send("cmd:root");	
			sendUpdateClientList();
			clients = new ArrayList<Client>();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}		
	}
	
	public void cmd(String string, Client client)
	{
		String data;
		
		data = new JSONStringer()
					.object()
						.key("ip").value(client.getIp())
						.key("port").value(client.getPort())
						.key("cmd").value(string)
					.endObject()
					.toString();
		server.send("cmd:run:" + data);	
	}

	private void sendUpdateClientList()
	{
		server.send("cmd:client");
	}
	
	public void update()
	{
		String	data;
		
		data = server.receive();
		System.out.print(data);
		if (data.startsWith("jso:"))
		{
			if (data.startsWith("jso:lst:"))
				initClients(data.substring(8));
			else if ((data.startsWith("jso:dat:")))
			{
				JSONObject json = new JSONObject(data.substring(8));
				
				JSONObject tmp = json.getJSONObject("client");
				
				//System.out.println( tmp.getString("ip") + "  " +tmp.getInt("port"));
				
				//System.out.println(clients);
				
				for (Client c : clients)
				{
					//System.out.println( c.getPort() + "  " + tmp.getInt("port"));
					if (c.getIp().equals(tmp.getString("ip")) && c.getPort() == tmp.getInt("port"))
					{
						c.setConsol(c.getConsol() + json.getString("data") + "\n");
						//System.out.println("client trouver cmd = " + c.getConsol());
					}
				}
			
			}
		}
		//else
		{
			//System.out.print(data);
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

		System.out.println("InitClient");
		
        while (keys.hasNext())
        {
            JSONObject tmp = (JSONObject) json.get(keys.next());
            Client	clientTmp = new Client(tmp.getString("ip"), tmp.getInt("port"));
            try
            {
            	clientTmp.setHostname(tmp.getString("hostname"));
            	clientTmp.setLogin(tmp.getString("login"));
            }
            catch (JSONException e) 
            {
            	System.out.println("Erreur pas de Hostname");
            }
            System.out.println("new client = " + clientTmp);
            clients.add(clientTmp);
        }
	}

	public TcpServer getServer() {
		return server;
	}

	public void setServer(TcpServer server) {
		this.server = server;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}
	
}
