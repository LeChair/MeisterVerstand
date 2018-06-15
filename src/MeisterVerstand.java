import javax.swing.*;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.lang.Math;

public class MeisterVerstand extends JFrame { // je opstart class
	public static void main(String args[]) {
		JFrame frame = new MeisterVerstand();
		frame.setSize(1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("MeisterVerstand");
		frame.setContentPane(new MeisterController());
		frame.setVisible(true);
		frame.setLocation(400, 100);
	}
}