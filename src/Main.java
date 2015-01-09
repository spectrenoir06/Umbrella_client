
public class Main {

	public static void main(String[] args) throws Exception
	{
		System.out.println("Hello");
		
		Server server = new Server("localhost", 1234);
		
		while (true)
		{
			server.update();
		}
	}

}
