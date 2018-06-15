import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MeisterView extends JPanel {
	public JButton speelknop, raadknop;
	private ArrayList<InvoerVeldPanel> buttonpanels = new ArrayList<InvoerVeldPanel>();
	private ArrayList<PinPanel> pinpanels = new ArrayList<PinPanel>();
	
	public MeisterView() {
		setLayout(new GridLayout(10,12,1,1));
		
		for(int i = 0; i < 8;i++){
			buttonpanels.add(new InvoerVeldPanel());
			pinpanels.add(new PinPanel());
		}
		
		for(InvoerVeldPanel i : buttonpanels){
			add(i);
		}
		
		for(PinPanel i : pinpanels){
			add(i);
		}
		
		speelknop = new JButton("Spelen");
		raadknop = new JButton("Raden!");
		raadknop.setEnabled(false);
		
		add(speelknop);
		add(raadknop);
		
	}
	
	public InvoerVeldPanel getInvoerVeldPanel(int index){
		return buttonpanels.get(index);
	}
	
	public PinPanel getPinPanel(int index){
		return pinpanels.get(index);
	}
}
