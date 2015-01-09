import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;


public class JClient extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public JClient() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("/home/spectrenoir/eclipse/java/icone.png"));
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Info", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, null));
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblLogin = new JLabel("adoussau");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblLogin);
		
		JLabel lblHostname = new JLabel("e1r10p12");
		lblHostname.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblHostname);
		
		JLabel lblIp = new JLabel("10.11.10.12");
		lblIp.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblIp);
		
		JLabel lblPort = new JLabel("1234");
		lblPort.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPort);

	}

}
