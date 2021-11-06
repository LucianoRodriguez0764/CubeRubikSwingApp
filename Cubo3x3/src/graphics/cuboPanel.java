package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

class cuboPanel extends initialPanel{

	private static final long serialVersionUID = 1L;

	public cuboPanel() {
		
		setLayout(null);
		
		setMovingButtons();
		
		setActionListener();
		
		this.setBackground(new Color(252, 239, 219));
		
	}
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D)g;
		
		super.paintComponent(g);
		
		drawBG(g2);
		
		setLogoOnCorner(g2);
		
		drawCube(g2, viewing3D);

	}
	
	private void drawCube(Graphics2D g2, boolean viewing3d) {

		if(!viewing3D) {
			drawStickers(g2,0,cuboPanel,face0.x,face0.y);
			drawStickers(g2,1,cuboPanel,face1.x,face1.y);
			drawStickers(g2,2,cuboPanel,face2.x,face2.y);
			drawStickers(g2,3,cuboPanel,face3.x,face3.y);
			drawStickers(g2,4,cuboPanel,face4.x,face4.y);
			drawStickers(g2,5,cuboPanel,face5.x,face5.y);
			
			drawFace(g2,face0.x,face0.y);
			drawFace(g2,face1.x,face1.y);
			drawFace(g2,face2.x,face2.y);
			drawFace(g2,face3.x,face3.y);
			drawFace(g2,face4.x,face4.y);
			drawFace(g2,face5.x,face5.y);
			}
			else {
			drawStickers(g2,3,cuboPanel,face3.x,face3.y);
			drawFace(g2,face3.x,face3.y);
			drawInclinatedFace(g2,102,97); //TOP
			drawInclinatedFace2(g2,193,189); //SIDED
			drawStickers(g2,4,cuboPanel,face4.x,face4.y);
			drawFace(g2,face4.x,face4.y);
			drawStickers(g2,5,cuboPanel,face5.x,face5.y);
			drawFace(g2,face5.x,face5.y);
			drawStickers(g2,1,cuboPanel,240,189-137);
			drawFace(g2,240,189-137);
			}
		
	}

	private void setLogoOnCorner(Graphics2D g2) {

//		try {
//			ImageIcon full_logo = new ImageIcon(getClass().getResource("/images/full_logo.png"));//ADD src// for internal eclipse compilation
//			full_logo.paintIcon(this, g2,429, 5);
			
			Image full_logo = new ImageIcon(getClass().getResource("/images/full_logo.png")).getImage();//ADD src// for internal eclipse compilation
			g2.drawImage(full_logo,429, 5,null);
			
			g2.drawRect(428, 4 , 51, 51);
//		} 
//		catch (IOException e) {
//			g2.setColor(new Color(0, 0, 0));
//			g2.fillRect(428, 4 , 51, 51);
//		    g2.setColor(new Color(255, 0, 0));
//		    g2.drawString("Logo", 432, 20);
//		    g2.drawString("is", 432, 30);
//		    g2.drawString("missing", 432, 40);
//		}
		
		g2.setColor(new Color(120,120,120));
		g2.setFont(new Font("Sans-serif", Font.PLAIN, 10));
		g2.drawString("1.1 version", 429, 70);
		g2.setColor(Color.BLACK);
		
	}

	private void setActionListener() {
		
		butonActions accion = new butonActions();
		
		reset_btn.addActionListener(accion);
		ok_btn.addActionListener(accion);
		view_btn.addActionListener(accion);
		back_btn.addActionListener(accion);
		u_btn.addActionListener(accion); 
		uprime_btn.addActionListener(accion);
		d_btn.addActionListener(accion);
		dprime_btn.addActionListener(accion);
		f_btn.addActionListener(accion);
		fprime_btn.addActionListener(accion);
		r_btn.addActionListener(accion);
		rprime_btn.addActionListener(accion);
		l_btn.addActionListener(accion);
		lprime_btn.addActionListener(accion);
		b_btn.addActionListener(accion);
		bprime_btn.addActionListener(accion);
		save_state.addActionListener(accion);
		get_state.addActionListener(accion);
		
		
	}
	
	private void setMovingButtons() {
		
		r_btn.setBounds(10,300,30,30); 	r_btn.setMargin(getInsets());
		rprime_btn.setBounds(45,300,30,30); rprime_btn.setMargin(getInsets());
		l_btn.setBounds(80,300,30,30); l_btn.setMargin(getInsets());
		lprime_btn.setBounds(115,300,30,30); lprime_btn.setMargin(getInsets());
		u_btn.setBounds(10,335,30,30); u_btn.setMargin(getInsets());
		uprime_btn.setBounds(45,335,30,30); uprime_btn.setMargin(getInsets());
		d_btn.setBounds(80,335,30,30); d_btn.setMargin(getInsets());
		dprime_btn.setBounds(115,335,30,30); dprime_btn.setMargin(getInsets());
		f_btn.setBounds(10,370,30,30); f_btn.setMargin(getInsets());
		fprime_btn.setBounds(45,370,30,30); fprime_btn.setMargin(getInsets());
		b_btn.setBounds(80,370,30,30); b_btn.setMargin(getInsets());
		bprime_btn.setBounds(115,370,30,30); bprime_btn.setMargin(getInsets());
		
		reset_btn.setBounds(170,300, 70, 30);
		add(reset_btn);
		
		ok_btn.setMargin(getInsets());
		ok_btn.setBounds(310,334, 30, 30);
		add(ok_btn);
		
		view_btn.setMargin(getInsets());
		view_btn.setBounds(404,431, 80, 30);
		add(view_btn);
		
		txt_field.setName("Text Field Button");
		txt_field.setBounds(170,335, 130, 30);
	    add(txt_field);
	    
	    txt_label.setFont(new Font(getFont().getFamily(), Font.PLAIN, getFont().getSize()));
	    txt_label.setForeground(new Color(100,100,100));
	    txt_label.setBounds(170,360, 130, 30);
	    add(txt_label);
	    
	    txt_label2.setFont(new Font(getFont().getFamily(), Font.ITALIC, getFont().getSize()));
	    txt_label2.setForeground(new Color(120,120,120));
	    txt_label2.setBounds(170,380, 220, 30);
	    add(txt_label2);
	    
		back_btn.setMargin(getInsets());
		back_btn.setBounds(10,420,30,30);
		add(back_btn);
		
		save_state.setMargin(getInsets());
		save_state.setBounds(390,300, 90, 30);
		add(save_state);
		
		get_state.setMargin(getInsets());
		get_state.setBounds(390,335, 90, 30);
		add(get_state);

		add(u_btn);
		add(uprime_btn);
		add(r_btn);
		add(rprime_btn);
		add(l_btn);
		add(lprime_btn);
		add(f_btn);
		add(fprime_btn);
		add(b_btn);
		add(bprime_btn);
		add(d_btn);
		add(dprime_btn);
		
	}

	

	

	private void drawBG(Graphics2D g2) {

		g2.setColor(new Color(219, 232, 252));
		int desaligned = 0;
		
		for(int j=0; j<11; j++) {
		for(int i=0; i<6; i++) {
			if(j%2==1) {desaligned=50;} else {desaligned=0;}
			g2.fillRect(100*i -33 + desaligned,50*j +5 - 50, 50, 50);
		}
		}
		g2.setColor(Color.BLACK);

	}

	//Clase interna
	private	class butonActions implements ActionListener  {
		
		public ArrayList<String> movements = new ArrayList<String>();
		boolean isMoreThanOneUsed = false;
		int counter=0;

		{
			movements.ensureCapacity(30);
		}
		
		public void actionPerformed(ActionEvent e) {	
			
			Object source = e.getSource();
			boolean isAnAlgorithm = true;
			boolean isntBackAlgorithm = true;
			
			
			if(!isMoreThanOneUsed) {
				counter=0;
			}
			
			if(source==u_btn) {
				cuboPanel.setAlgoritmo("U");
				isAnAlgorithm=true;
				isMoreThanOneUsed = false;
			}
			else if(source==r_btn) {
				cuboPanel.setAlgoritmo("R");
				isAnAlgorithm=true;
				isMoreThanOneUsed = false;
			}
			else if(source==f_btn) {
				cuboPanel.setAlgoritmo("F");
				isAnAlgorithm=true;
				isMoreThanOneUsed = false;
			}
			else if(source==l_btn) {
				cuboPanel.setAlgoritmo("L");
				isAnAlgorithm=true;
				isMoreThanOneUsed = false;
			}
			else if(source==d_btn) {
				cuboPanel.setAlgoritmo("D");
				isAnAlgorithm=true;
				isMoreThanOneUsed = false;
			}
			else if(source==b_btn) {
				cuboPanel.setAlgoritmo("B");
				isAnAlgorithm=true;
				isMoreThanOneUsed = false;
			}
			else if(source==uprime_btn) {
				cuboPanel.setAlgoritmo("U'");
				isAnAlgorithm=true;
				isMoreThanOneUsed = false;
			}
			else if(source==dprime_btn) {
				cuboPanel.setAlgoritmo("D'");
				isAnAlgorithm=true;
				isMoreThanOneUsed = false;
			}
			else if(source==lprime_btn) {
				cuboPanel.setAlgoritmo("L'");
				isAnAlgorithm=true;
				isMoreThanOneUsed = false;
			}
			else if(source==rprime_btn) {
				cuboPanel.setAlgoritmo("R'");
				isAnAlgorithm=true;
				isMoreThanOneUsed = false;
			}
			else if(source==fprime_btn) {
				cuboPanel.setAlgoritmo("F'");
				isAnAlgorithm=true;
				isMoreThanOneUsed = false;
			}
			else if(source==bprime_btn) {
				cuboPanel.setAlgoritmo("B'");
				isAnAlgorithm=true;
				isMoreThanOneUsed = false;
			}
			else if(source==reset_btn){//Reset Algorithm
				cuboPanel.toSolvedState();
				movements.removeAll(movements);
				cuboPanel.setAlgoritmo("");
				System.out.println("El cubo se ha resuelto automáticamente");
				isAnAlgorithm=false;
				isMoreThanOneUsed = false;
			}else if(source==ok_btn) {
				if(cuboPanel.algoStringBeautify(txt_field.getText()) == "") {
					isAnAlgorithm=false;
					System.out.println("El algoritmo no pudo ser leido");
				} else {
				cuboPanel.setAlgoritmo(txt_field.getText());
				isAnAlgorithm=true;
				}
				txt_field.setText("");
				isMoreThanOneUsed = false;

			}
			else if(source==view_btn) {

				isAnAlgorithm=false;
				
				if(!viewing3D) {
				viewing3D=true;
				System.out.println("Vista gráfica cambiada (3D)");

				}else{
					viewing3D=false;
				System.out.println("Vista gráfica cambiada (Sticker Cross)");
					}
		}else if(source==back_btn) {
			
			isntBackAlgorithm=false;
			
			counter++;

			if(movements.size() > 30) {
				counter=1;
				movements.remove(0);
			}
			
			if(movements.size()-counter < 0) {
				System.out.println("No hay movimientos anteriores!");
				isAnAlgorithm=false;
				movements.removeAll(movements);
			} else {
			
			isAnAlgorithm=true;
			
			isMoreThanOneUsed=true;
			
			if(movements.get(movements.size()-counter)=="xxx") {
				counter++;}
//			}else {
			cuboPanel.setAlgoritmo(cuboPanel.getReverseAlgorithm(movements.get(movements.size()-counter)));
			movements.set(movements.size()-counter , "xxx");
// REHACER CON REMOVE EL QUE YA SE HIZO

			}

			
		}else if(source==save_state) {
			isAnAlgorithm=false;
			isMoreThanOneUsed = false;
			System.out.println("El estado de este Cubo Rubik fue guardado");
			
			saved_state.saveState(cuboPanel.stickers);

		}else if(source==get_state) {
			isAnAlgorithm=false;
			isMoreThanOneUsed = false;
			System.out.println("El estado de este Cubo Rubik ha sido restaurado");
			int[] newStickers = saved_state.getSavedState();
			
			for(int i=0; i<cuboPanel.stickers.length;i++ ) {
				cuboPanel.stickers[i] = newStickers[i];
			}

		}
			
			if(isAnAlgorithm) {
			if(movements.size()>30) {
				movements.remove(0);
				if(isntBackAlgorithm) {
				movements.add(cuboPanel.getAlgoritmo());
				}
			}else{
				if(isntBackAlgorithm) {
			movements.add(cuboPanel.getAlgoritmo());
				}
			}
			
			cuboPanel.realizarAlgoritmo();
			}
			isntBackAlgorithm=true;
			repaint();
		}
		
		
		
		
	}
}
