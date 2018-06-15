import javax.swing.*;
import java.awt.*;

public class SecretView extends JPanel {
	public JLabel titel,geheim1,geheim2,geheim3,geheim4;
	
	public SecretView() {
		setLayout(new GridLayout(1,1,1,1));
		
		titel = new JLabel();
		titel.setText("MeisterVerstand");
		
		geheim1 = new JLabel();
		geheim2 = new JLabel();
		geheim3 = new JLabel();
		geheim4 = new JLabel();
		
		add(geheim1);
		add(geheim2);
		add(geheim3);
		add(geheim4);
		add(titel);
	}
	
}
