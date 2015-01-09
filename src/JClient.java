import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;


public class JClient extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public JClient() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel photoPanel = new JPanel();
		photoPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Photo", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, null));
		add(photoPanel);
		photoPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		photoPanel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("/home/spectrenoir/eclipse/java/icone.png"));
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Info", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, null));
		add(infoPanel);
		infoPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblLogin = new JLabel("adoussau");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		infoPanel.add(lblLogin);
		
		JLabel lblHostname = new JLabel("e1r10p12");
		lblHostname.setHorizontalAlignment(SwingConstants.CENTER);
		infoPanel.add(lblHostname);
		
		JLabel lblIp = new JLabel("10.11.10.12");
		lblIp.setHorizontalAlignment(SwingConstants.CENTER);
		infoPanel.add(lblIp);
		
		JLabel lblPort = new JLabel("1234");
		lblPort.setHorizontalAlignment(SwingConstants.CENTER);
		infoPanel.add(lblPort);

	}

}
