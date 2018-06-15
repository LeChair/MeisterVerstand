import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class InvoerVeldPanel extends JPanel{
	public JButton invoerknop;
	Pawn pawn;
	private ArrayList<Pawn> buttons = new ArrayList<Pawn>();

	public InvoerVeldPanel(){
		setLayout(new GridLayout(1,4,1,1));
		
	
		for(int i = 0; i < 4;i++){
			buttons.add(new Pawn());
		}

		for(Pawn p : buttons){
			this.add(p);
			disablePawns();
		}

	}
	
	public void enablePawns(){
		for(Pawn p: buttons){
			p.setActive(true);
			p.setEnabled(true);
		}
	}
	
	public void disablePawns(){
		for(Pawn p: buttons){
			p.setActive(false);
			p.setEnabled(false);
		}
	}
	
	public ArrayList<Integer> getOpgegevengetal(){
		ArrayList<Integer> waardes = new ArrayList<Integer>();
		for(Pawn p: buttons){
			waardes.add(p.getValue());
		}
		return waardes;
	}
	
	public Pawn getPawn(int index){
		return buttons.get(index);
	}
	
}
