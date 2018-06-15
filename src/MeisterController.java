import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.*;

public class MeisterController extends JPanel{
	SecretView secretview;
	MeisterView meisterview;
	MeisterModel meistermodel;
	IntroView introview;
	InvoerVeldPanel invoerveldpanel;
	PinPanel pinpanel;
	Pawn pawn;
	int turn;
	InvoerVeldPanel activePanel;
	PinPanel activePinPanel;
	
	public MeisterController(){
		setLayout(new BorderLayout());
		
		secretview = new SecretView();
		meisterview = new MeisterView();
		meistermodel = new MeisterModel();
		invoerveldpanel = new InvoerVeldPanel();
		pinpanel = new PinPanel();
		introview = new IntroView();
		pawn = new Pawn();
		
		if (meistermodel.kleur1 == 1){
			secretview.geheim1.setText("rood");
		} else if(meistermodel.kleur1 == 2){
			secretview.geheim1.setText("blauw");
		} else if(meistermodel.kleur1 == 3){
			secretview.geheim1.setText("groen");
		} else{
			secretview.geheim1.setText("geel");
		};
		
		if (meistermodel.kleur2 == 1){
			secretview.geheim2.setText("rood");
		} else if(meistermodel.kleur2 == 2){
			secretview.geheim2.setText("blauw");
		} else if(meistermodel.kleur2 == 3){
			secretview.geheim2.setText("groen");
		} else{
			secretview.geheim2.setText("geel");
		};

		if (meistermodel.kleur3 == 1){
			secretview.geheim3.setText("rood");
		} else if(meistermodel.kleur3 == 2){
			secretview.geheim3.setText("blauw");
		} else if(meistermodel.kleur3 == 3){
			secretview.geheim3.setText("groen");
		} else{
			secretview.geheim3.setText("geel");
		};
		
		if (meistermodel.kleur4 == 1){
			secretview.geheim4.setText("rood");
		} else if(meistermodel.kleur4 == 2){
			secretview.geheim4.setText("blauw");
		} else if(meistermodel.kleur4 == 3){
			secretview.geheim4.setText("groen");
		} else{
			secretview.geheim4.setText("geel");
		};
		
		meisterview.speelknop.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				turn = 0;
				introview.timer.start();
				introview.startTime = LocalTime.now();
				meisterview.speelknop.setEnabled(false);
				activePanel = meisterview.getInvoerVeldPanel(7);
				activePinPanel = meisterview.getPinPanel(7);
				activePanel.enablePawns();
				meisterview.raadknop.setEnabled(true);
			}
		});
		
		meisterview.raadknop.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					compare();
					activePanel.disablePawns();
					turn++;
					activePanel = meisterview.getInvoerVeldPanel(7-turn);
					activePinPanel = meisterview.getPinPanel(7-turn);
					activePanel.enablePawns();				
			}
		});
		
		add(secretview, BorderLayout.NORTH);
		add(meisterview, BorderLayout.CENTER);
		add(introview, BorderLayout.EAST);
	}
	
	public void compare(){
		ArrayList<Integer> playercode = activePanel.getOpgegevengetal();
		ArrayList<Integer> secretcode = meistermodel.getSecretgetal();
		Pin pin1 = pinpanel.getPins(0);
		Pin pin2 = pinpanel.getPins(1);
		Pin pin3 = pinpanel.getPins(2);
		Pin pin4 = pinpanel.getPins(3);
		if(playercode.get(0) == secretcode.get(0)){
			pin1.setBackground(Color.BLACK);
			System.out.println("zwart pinnetje op positie 1");
		} else if (playercode.get(1) == secretcode.get(1)){
			pin2.setBackground(Color.BLACK);
			System.out.println("zwart pinnetje op positie 2");
		} else if (playercode.get(2) == secretcode.get(2)){
			pin3.setBackground(Color.BLACK);
			System.out.println("zwart pinnetje op positie 3");
		} else if (playercode.get(3) == secretcode.get(3)){
			pin4.setBackground(Color.BLACK);
			System.out.println("zwart pinnetje op positie 4");
		}
		
		if(turn <= 7){
			if(playercode.get(0) == secretcode.get(0)){
				//geef een zwarte pin
				System.out.println("Voor pin1 is een zwarte pin");
				zwartepin1  = true;
			}
			if(playercode.get(1) == secretcode.get(1)){
				//geef een zwarte pin
				System.out.println("Voor pin2 is een zwarte pin");
				zwartepin2 = true;
			}
			if(playercode.get(2) == secretcode.get(2)){
				//geef een zwarte pin
				System.out.println("Voor pin3 is een zwarte pin");
				zwartepin3 = true;
			}
			if(playercode.get(3) == secretcode.get(3)){
				//geef een zwarte pin
				System.out.println("Voor pin4 is een zwarte pin");
				zwartepin4 = true;
			}
		
		if(playercode.get(0) == secretcode.get(0) && playercode.get(1) == secretcode.get(1) 
				&& playercode.get(2) == secretcode.get(2) && playercode.get(3) == secretcode.get(3)){
			System.out.println("Je hebt de code gekraakt!");
			introview.timer.stop();
			/*if (codemodel.secretpin1 == 1){
				secretButton[1].setBackground(Color.GREEN);
			} else if(codemodel.secretpin1 == 2){
				secretButton[1].setBackground(Color.RED);
			} else if(codemodel.secretpin1 == 3){
				secretButton[1].setBackground(Color.BLUE);
			} else if(codemodel.secretpin1 == 4){
				secretButton[1].setBackground(Color.YELLOW);
			} else if(codemodel.secretpin1 == 5){
				secretButton[1].setBackground(Color.CYAN);
			} else{
				secretButton[1].setBackground(Color.MAGENTA);
			}

			if (codemodel.secretpin2 == 1){
				secretButton[2].setBackground(Color.GREEN);
			} else if(codemodel.secretpin2 == 2){
				secretButton[2].setBackground(Color.RED);
			} else if(codemodel.secretpin2 == 3){
				secretButton[2].setBackground(Color.BLUE);
			} else if(codemodel.secretpin2 == 4){
				secretButton[2].setBackground(Color.YELLOW);
			} else if(codemodel.secretpin2 == 5){
				secretButton[2].setBackground(Color.CYAN);
			} else{
				secretButton[2].setBackground(Color.MAGENTA);
			}

			if (codemodel.secretpin3 == 1){
				secretButton[3].setBackground(Color.GREEN);
			} else if(codemodel.secretpin3 == 2){
				secretButton[3].setBackground(Color.RED);
			} else if(codemodel.secretpin3 == 3){
				secretButton[3].setBackground(Color.BLUE);
			} else if(codemodel.secretpin3 == 4){
				secretButton[3].setBackground(Color.YELLOW);
			} else if(codemodel.secretpin3 == 5){
				secretButton[3].setBackground(Color.CYAN);
			} else{
				secretButton[3].setBackground(Color.MAGENTA);
			}

			if (codemodel.secretpin4 == 1){
				secretButton[4].setBackground(Color.GREEN);
			} else if(codemodel.secretpin4 == 2){
				secretButton[4].setBackground(Color.RED);
			} else if(codemodel.secretpin4 == 3){
				secretButton[4].setBackground(Color.BLUE);
			} else if(codemodel.secretpin4 == 4){
				secretButton[4].setBackground(Color.YELLOW);
			} else if(codemodel.secretpin4 == 5){
				secretButton[4].setBackground(Color.CYAN);
			} else{
				secretButton[4].setBackground(Color.MAGENTA);
			}*/
		}

		if(playercode.get(0) == secretcode.get(1)){
			if(zwartepin2 == false){
				//geef een witte pin
				System.out.println("Voor pin1 is een witte pin");
			}
		}

		if(playercode.get(0) == secretcode.get(2)){
			if(zwartepin3 == false){
				//geef een witte pin
				System.out.println("Voor pin1 is een witte pin");
			}
		}

		if(playercode.get(0) == secretcode.get(3)){
			if(zwartepin4 == false){
				//geef een witte pin
				System.out.println("Voor pin1 is een witte pin");
			}
		}

		if(playercode.get(1) == secretcode.get(0)){
			if(zwartepin1 == false){
				//geef een witte pin
				System.out.println("Voor pin2 is een witte pin");
			}
		}
		if( playercode.get(1) == secretcode.get(2)){
			if(zwartepin3 == false){
				//geef een witte pin
				System.out.println("Voor pin2 is een witte pin");
			}
		}

		if(playercode.get(1) == secretcode.get(3)){
			if(zwartepin4 == false){
				//geef een witte pin
				System.out.println("Voor pin2 is een witte pin");
			}
		}

		if(playercode.get(2) == secretcode.get(0) ){
			if(zwartepin1 == false){
				//geef een witte pin
				System.out.println("Voor pin3 is een witte pin");
			}
		}
		if(playercode.get(2) == secretcode.get(1)){
			if(zwartepin2 == false){
				//geef een witte pin
				System.out.println("Voor pin3 is een witte pin");
			}
		}
		if(playercode.get(2) == secretcode.get(3)){
			if(zwartepin4 == false){
				//geef een witte pin
				System.out.println("Voor pin3 is een witte pin");
			}
		}
		if(playercode.get(2) == secretcode.get(0)){
			if(zwartepin1 == false){
				//geef een witte pin
				System.out.println("Voor pin4 is een witte pin");
			}
		}
		if(playercode.get(3) == secretcode.get(1)){

			if(zwartepin2 == false){
				//geef een witte pin
				System.out.println("Voor pin4 is een witte pin");
			}
		}
		if(playercode.get(3) == secretcode.get(2)){
			if(zwartepin3 == false){
				//geef een witte pin
				System.out.println("Voor pin4 is een witte pin");
			}
		}
		else if (playercode.get(0) != secretcode.get(0) && 
					playercode.get(0) != secretcode.get(1) && 
						playercode.get(0) != secretcode.get(2) && 
							playercode.get(0) != secretcode.get(3) && 
				pin2waarde != secretcode.get(0) && 
					pin2waarde != secretcode.get(1) && 
						pin2waarde != secretcode.get(2) && 
							pin2waarde != secretcode.get(3) &&
				pin3waarde != secretcode.get(0) &&
					pin3waarde != secretcode.get(1) &&
						pin3waarde != secretcode.get(2) &&
							pin3waarde != secretcode.get(3) &&
				pin4waarde != secretcode.get(0) &&
					pin4waarde != secretcode.get(1) &&
						pin4waarde != secretcode.get(2) &&
							pin4waarde != secretcode.get(3)){
			System.out.println("Geen pinnen");
		}
	}
		
	}
	
	
    public int getIntByColor(Color color){
		if(color == Color.RED){
			return 1;
		} else if(color == Color.BLUE){
			return 2;
		} else if(color == Color.GREEN){
			return 3;
		} else if(color == Color.YELLOW){
			return 4;
		}
		return turn;
    }
    
}
