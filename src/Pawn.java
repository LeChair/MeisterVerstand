import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Pawn extends JButton {
	public int value;
	private boolean active = false;
	//private MeisterController controller;
	
	//public pawn(Meistercontroller controller)
	public Pawn(){
		this.setBackground(Color.GRAY);	
		this.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				value++;
				drawColor();
			}
		});
	}
	
	public void drawColor(){
		if(value == 1) {
			this.setBackground(Color.RED);
		} else if(value == 2){
			this.setBackground(Color.BLUE);
		} else if(value == 3){
			this.setBackground(Color.GREEN);
		} else if(value == 4){
			this.setBackground(Color.YELLOW);
		} else if(value == 5){
			this.setBackground(Color.RED);
			value=1;
		}
	}
	
	public void setActive(boolean b){
		this.active = b;
	}
	
	public int getValue(){
		return value;
	}
	
}
