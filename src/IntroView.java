import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import javax.swing.Timer;

public class IntroView extends JPanel {
	JLabel textLabel, timerTextLabel, timerCountLabel;
	public Timer timer = new Timer(20, new TimerHandler());
	LocalTime startTime=LocalTime.now();
	LocalTime currentTime=LocalTime.now();
	
	public IntroView(){
		setLayout(new GridLayout(1,1,1,1));
		
		timerTextLabel = new JLabel("                  Verstreken tijd: ");
		timerCountLabel = new JLabel("0 seconden");
		
		
		
		add(timerTextLabel);
		add(timerCountLabel);
		
	}
	
	class TimerHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			currentTime = LocalTime.now();
			long elapsedtime= ChronoUnit.MILLIS.between(startTime, currentTime);
			if (elapsedtime>480000){
				timerTextLabel.setText("Time's up!");
			}

			timerCountLabel.setText((int)(elapsedtime/1000) +" seconden" );
			if (elapsedtime>=480000) {
				timer.stop();
			}
		}
	}
	
}