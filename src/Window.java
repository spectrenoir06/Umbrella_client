

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;

public class Window {

	private JFrame frame;
	private JTextField txtLsla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 786, 613);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Client", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JClient client = new JClient();
		client.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(client);
		
		JClient client_1 = new JClient();
		client_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(client_1);
		
		JClient client_2 = new JClient();
		client_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(client_2);
		
		JClient client_3 = new JClient();
		client_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(client_3);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JTextPane txtpnSpectrenoirAt = new JTextPane();
		txtpnSpectrenoirAt.setText("# spectrenoir at Spectrenoir-PC in ~/eclipse/workspace/Umbrella_Client on git:master x [3:55:35]\n$ ls -la /\ntotal 116\ndrwxr-xr-x  26 root root  4096 janv.  7 03:16 .\ndrwxr-xr-x  26 root root  4096 janv.  7 03:16 ..\ndrwxr-xr-x   2 root root  4096 déc.  11 22:08 bin\ndrwxr-xr-x   4 root root  4096 déc.  28 00:55 boot\ndrwxrwxr-x   2 root root  4096 mai    3  2014 cdrom\ndrwxr-xr-x  16 root root  4240 janv.  7 03:28 dev\ndrwxr-xr-x 151 root root 12288 janv.  7 03:21 etc\ndrwxr-xr-x   3 root root  4096 mai    3  2014 home\nlrwxrwxrwx   1 root root    33 déc.  28 00:54 initrd.img -> boot/initrd.img-3.13.0-43-generic\nlrwxrwxrwx   1 root root    33 déc.  10 00:32 initrd.img.old -> boot/initrd.img-3.13.0-40-generic\ndrwxr-xr-x  27 root root  4096 déc.   9 21:42 lib\ndrwxr-xr-x   2 root root  4096 déc.   9 21:42 lib32\ndrwxr-xr-x   2 root root  4096 déc.   9 21:42 lib64\ndrwx------   2 root root 16384 mai    3  2014 lost+found\ndrwxr-xr-x   4 root root  4096 juin   9  2014 media\ndrwxr-xr-x   2 root root  4096 avril 11  2014 mnt\ndrwxr-xr-x   4 root root  4096 déc.  20 11:27 opt\ndr-xr-xr-x 217 root root     0 janv.  7 04:21 proc\ndrwxr-xr-x   2 root root  4096 oct.   4 00:07 $RECYCLE.BIN\ndrwx------  15 root root  4096 juil.  7  2014 root\ndrwxr-xr-x  29 root root   960 janv.  9 00:48 run\ndrwxr-xr-x   2 root root 12288 déc.  11 22:08 sbin\ndrwxr-xr-x   3 root root  4096 juil. 11 21:28 srv\ndr-xr-xr-x  13 root root     0 janv.  7 04:21 sys\ndrwxr-xr-x   2 root root  4096 août  28 17:02 System Volume Information\ndrwxrwxrwt  24 root root  4096 janv.  9 03:17 tmp\ndrwxr-xr-x  12 root root  4096 août  24 16:53 usr\ndrwxr-xr-x  13 root root  4096 avril 16  2014 var\nlrwxrwxrwx   1 root root    30 déc.  28 00:54 vmlinuz -> boot/vmlinuz-3.13.0-43-generic\nlrwxrwxrwx   1 root root    30 déc.  10 00:32 vmlinuz.old -> boot/vmlinuz-3.13.0-40-generic\n\n# spectrenoir at Spectrenoir-PC in ~/eclipse/workspace/Umbrella_Client on git:master x [3:55:39]\n$");
		panel_1.add(txtpnSpectrenoirAt);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		txtLsla = new JTextField();
		txtLsla.setText("ls -la /");
		panel_2.add(txtLsla, BorderLayout.CENTER);
		txtLsla.setColumns(10);
		
		JButton btnNewButton = new JButton("Enter");
		panel_2.add(btnNewButton, BorderLayout.EAST);
		
		
	}

}
