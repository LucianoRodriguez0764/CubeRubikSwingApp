package graphics;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class cuboMarco extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private cuboPanel lamina = new cuboPanel();	

	private ImageIcon icon = new ImageIcon(getClass().getResource("/images/icon3.png"));
	private key_controls kc = new key_controls(this.lamina);

	public cuboMarco() {
		
		setTitle("Cubo Rubik App");
		
		setBounds(350, 200, 500, 500);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setResizable(false);
		
		setIconImage(icon.getImage());
		
		addKeyListener(kc);
		
		for(Component comp : lamina.getComponents()) {
			comp.addKeyListener(kc);
		}
		
		add(lamina);
		
		setVisible(true);
						
		this.requestFocus(); //Fix the "R" initial focus
		
	}
	
	public static void main(String[] args) {
		
		new cuboMarco();
				
		
//		String s = c.algoStringBeautify("R    U D R' jkcdb");
//		
//		System.out.println(s);
		
//String s = c.getReverseAlgorithm("R2 D' L2 U B F'");
//		
//System.out.print(s);
		
	}
	
}
	
