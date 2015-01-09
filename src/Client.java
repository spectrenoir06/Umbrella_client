
public class Client {
	private	String	ip;
	private	int		port;
	private	String	hostname;
	private	String	login;
	private String	consol;
	
	public Client(String ip, int port)
	{
		super();
		this.ip = ip;
		this.port = port;
		this.consol = "";
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getConsol() {
		return consol;
	}

	public void setConsol(String consol) {
		this.consol = consol;
	}

	@Override
	public String toString() {
		return "Client [ip=" + ip + ", port=" + port + ", hostname=" + hostname
				+ ", login=" + login + "]";
	}
}
