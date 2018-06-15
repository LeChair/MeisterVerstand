import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class MeisterModel {
	public int kleur1, kleur2, kleur3, kleur4;
	
	public MeisterModel(){
		
		Random random = new Random();
		kleur1 = random.nextInt(4 - 1 + 1) + 1;
		kleur2 = random.nextInt(4 - 1 + 1) + 1;
		kleur3 = random.nextInt(4 - 1 + 1) + 1;
		kleur4 = random.nextInt(4 - 1 + 1) + 1;

	}
	
	public ArrayList<Integer> getSecretgetal(){
		ArrayList<Integer> waardes = new ArrayList<Integer>();
		waardes.add(kleur1);
		waardes.add(kleur2);
		waardes.add(kleur3);
		waardes.add(kleur4);
		return waardes;
	}
}
