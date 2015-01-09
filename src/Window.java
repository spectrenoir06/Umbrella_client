

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Window {

	private JFrame frame;
	private JTextField cmdText;
	private String text;
	private static Server server;
	private static JTextArea display;
	private	ArrayList<JClient> clients;
	JClient currentClient;
	JPanel clientPanel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		Window	window = new Window();
		window.frame.setVisible(true);
	
	server = new Server("localhost", 1234);
	
	window.initClients();
	
	while(true)
	{
		window.update();
	}
}

	private void initClients() {
		clients = new ArrayList<JClient>();
		for (Client	c : server.getClients())
		{
			System.out.println("salut " + c);
			clients.add(new JClient(c, this));
		}
		for (JClient jc : clients)
			clientPanel.add(jc);
	}

	public void update()
	{
		server.update();
		updateConsol();
	}

	private void updateConsol() {
		try
		{
			display.setText(currentClient.getClient().getConsol());
		}
		catch (Exception e)
		{
			
		}
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
		//setServer(new Server("localhost", 1234));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 786, 613);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		text = "";
		JPanel InfoPanel = new JPanel();
		frame.getContentPane().add(InfoPanel, BorderLayout.NORTH);
		
		JLabel clientNb = new JLabel("Umbrela Manager");
		clientNb.setFont(new Font("Dialog", Font.BOLD, 15));
		clientNb.setHorizontalAlignment(SwingConstants.CENTER);
		InfoPanel.add(clientNb);
		
		JScrollPane clientsScrollPane = new JScrollPane();
		clientsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		clientsScrollPane.setBorder(new TitledBorder(null, "Client", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		frame.getContentPane().add(clientsScrollPane, BorderLayout.WEST);
		
		clientPanel = new JPanel();
		clientsScrollPane.setViewportView(clientPanel);

		clientPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel consolPanel = new JPanel();
		frame.getContentPane().add(consolPanel);
		consolPanel.setLayout(new BorderLayout(0, 0));
		
		display = new JTextArea(0, 0);
		display.setWrapStyleWord(true);
		display.setFont(new Font("Monospaced", Font.PLAIN, 12));
		display.setLineWrap(true);
		display.setTabSize(2);
		display.setText(text);
		display.setEditable(false); // set textArea non-editable
		JScrollPane scroll = new JScrollPane(display);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		consolPanel.add(scroll, BorderLayout.CENTER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel cmdPanel = new JPanel();
		consolPanel.add(cmdPanel, BorderLayout.SOUTH);
		cmdPanel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(arg0);
				server.getClients().get(0).setConsol(server.getClients().get(0).getConsol() + "==> " + cmdText.getText() + "\n");
				server.cmd(cmdText.getText(), server.getClients().get(0));
				cmdText.setText("");
			}
		});
		cmdPanel.add(btnNewButton, BorderLayout.EAST);
		
		cmdText = new JTextField();
		cmdText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10)
				{
					server.getClients().get(0).setConsol(server.getClients().get(0).getConsol() + "==> " + cmdText.getText() + "\n");
					server.cmd(cmdText.getText(), server.getClients().get(0));
					cmdText.setText("");
				}
			}
		});
		cmdText.setText("ls -la");
		cmdPanel.add(cmdText, BorderLayout.CENTER);
		cmdText.setColumns(10);
		
	}

	public JTextField getCmdText() {
		return cmdText;
	}

	public void setCmdText(JTextField cmdText) {
		this.cmdText = cmdText;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public void setCurrentClient(JClient jClient) {
		currentClient = jClient;
		display.setText(currentClient.getClient().getConsol());
	}
}
