import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class PinPanel extends JPanel{
	Pin pin;
	private ArrayList<Pin> pins = new ArrayList<Pin>();

	public PinPanel(){
		setLayout(new GridLayout(2,2,1,1));
		
	
		for(int i = 0; i < 4;i++){
			pins.add(new Pin());
		}

		for(Pin p : pins){
			this.add(p);
		}

	}
	
	public void enablePins(){
		for(Pin p: pins){
			p.setEnabled(true);
		}
	}
	
	public void disablePins(){
		for(Pin p: pins){
			p.setEnabled(false);
		}
	}
	
	public Pin getPins(int index){
		return pins.get(index);
	}
	
	
}
