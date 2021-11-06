package graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cube.Cube;
import cube.SaveState;

public abstract class initialPanel extends JPanel {

	private static final long serialVersionUID = 1L;

public Cube cuboPanel = new Cube();
	
	protected final Point face0 = new Point(100,10); // White
    protected final Point face1 = new Point(280,100); // Green
    protected final Point face2 = new Point(190,100); // Orange
    protected final Point face3 = new Point(100,100); // Blue
    protected final Point face4 = new Point(10,100); // Red
    protected final Point face5 = new Point(100,190); // Yellow	
	
    protected JTextField txt_field=new JTextField();
    protected JLabel txt_label=new JLabel("Insert an Algorithm");
    protected JLabel txt_label2=new JLabel("(only R L F U D B, primes and doubles)");
    protected JButton reset_btn = new JButton("Reset");	
    protected JButton ok_btn = new JButton("OK");
    protected JButton view_btn = new JButton("Change View");
    protected JButton back_btn=new JButton("<");
    protected JButton save_state=new JButton("Save State");
    protected JButton get_state=new JButton("Backup State");

    
    protected JButton u_btn=new JButton("U");
    protected JButton uprime_btn=new JButton("U'");
    protected JButton d_btn=new JButton("D");
    protected JButton dprime_btn=new JButton("D'");
    protected JButton f_btn=new JButton("F");
    protected JButton fprime_btn=new JButton("F'");
    protected JButton l_btn=new JButton("L");
    protected JButton lprime_btn=new JButton("L'");
    protected JButton r_btn=new JButton("R");
    protected JButton rprime_btn=new JButton("R'");
    protected JButton b_btn=new JButton("B");
    protected JButton bprime_btn=new JButton("B'");
	
	protected int[] xp = {0,15,45,30,0};
	protected int[] yp = {0,-15,-15,0,0};
	
	protected int[] xpB = {0,45,135,90,0};
	protected int[] ypB = {0,-45,-45,0,0};	
	
	protected int[] xp2 = {0,0,15,15,0};
	protected int[] yp2 = {0,-30,-45,-15,0};
	
	protected int[] xpB2 = {0,0,45,45,0};
	protected int[] ypB2 = {0,-90,-135,-45,0};
	
	protected boolean viewing3D = false;
	
	SaveState saved_state = new SaveState(cuboPanel);
	
	
	
	protected void drawStickers(Graphics2D g2, int face, Cube cube, int a, int b) {		
		
		for(int i=0;i<3;i++) {
		for(int j=0;j<3;j++) {
			
		    Color c = numberToColor(cube.stickers[(getStickersIds(face, false)[(i*3)+j])]);
			g2.setColor(c);
			g2.fill(new Rectangle(a+j*30, b+i*30, 30, 30));
			g2.setColor(new Color(0,0,0));
		
		}
		}

		
	}

	protected void drawFace(Graphics2D g2, int a, int b) {
		
		for(int i=0;i<3;i++) {
		for(int j=0;j<3;j++) {
		g2.drawRect(a+j*30, b+i*30, 30, 30);
		}
		}
		
		BasicStroke oldStroke= (BasicStroke) g2.getStroke();
		g2.setStroke(new BasicStroke((float)3));
		g2.drawRect(a, b, 90, 90);
		g2.setStroke(oldStroke);
		
		
	}
	
	protected void drawInclinatedFace(Graphics2D g2, int a, int b) {
							
		for(int i=0; i<3; i++) {
			
		for(int j=0; j<3; j++) {
			
			changeXPYP((30*j)+a+15*i, b-(15*i));
			
			Color c = numberToColor(cuboPanel.stickers[(getStickersIds(0, true)[(i*3)+j])]);
			g2.setColor(c);
			
			g2.fill( new Polygon(xp,yp,5));
			
			g2.setColor(new Color(0,0,0));
			
			g2.drawPolygon(xp,yp,5);
			
			
			resetXPYP();
			
		}
		
		}


		BasicStroke oldStroke= (BasicStroke) g2.getStroke();
		g2.setStroke(new BasicStroke((float)3));
		
		
		changeXPBYPB(a, b);
		g2.drawPolygon(xpB,ypB,5);
		resetXPBYPB();
		
		g2.setStroke(oldStroke);
		
		
	}
		
	protected void resetXPYP() {
		
		xp[0]=0;
		xp[1]=15;
		xp[2]=45;
		xp[3]=30;
		xp[4]=0;
		yp[0]=0;
		yp[1]=-15;
		yp[2]=-15;
		yp[3]=0;
		yp[4]=0;
			
	}
	
	protected void resetXPBYPB() {
		
		xpB[0]=0;
		xpB[1]=45;
		xpB[2]=135;
		xpB[3]=90;
		xpB[4]=0;
		ypB[0]=0;
		ypB[1]=-45;
		ypB[2]=-45;
		ypB[3]=0;
		ypB[4]=0;
			
	}
	
	protected void changeXPYP(int dxp, int dyp) {/********/
		
		for (int i=0; i<5; i++) {
		xp[i]+=dxp;
		yp[i]+=dyp;
		}
	}
	
	protected void changeXPBYPB(int dxpb, int dypb) {/********/
		
		for (int i=0; i<5; i++) {
		xpB[i]+=dxpb;
		ypB[i]+=dypb;
		}
	}
	
	protected void drawInclinatedFace2(Graphics2D g2, int a, int b) {
		
		for(int i=0; i<3; i++) {
			
		for(int j=0; j<3; j++) {
			
			changeXP2YP2(a+ 15*i, b + -30*j - 15*i);
			
			Color c = numberToColor(cuboPanel.stickers[(getStickersIds(2, true)[(i*3)+j])]);
			g2.setColor(c);
			
			g2.fill( new Polygon(xp2,yp2,5));
			
			g2.setColor(new Color(0,0,0));
			
			g2.drawPolygon(xp2,yp2,5);
			
			resetXP2YP2();
			
		}
		
		}


		BasicStroke oldStroke= (BasicStroke) g2.getStroke();
		g2.setStroke(new BasicStroke((float)3));
		
		
		changeXPB2YPB2(a,b);
		g2.drawPolygon(xpB2,ypB2,5);
		resetXPB2YPB2();
		
		g2.setStroke(oldStroke);
		
		
	}
	
	protected void resetXP2YP2() {
		
		xp2[0]=0;
		xp2[1]=0;
		xp2[2]=15;
		xp2[3]=15;
		xp2[4]=0;
		yp2[0]=0;
		yp2[1]=-30;
		yp2[2]=-45;
		yp2[3]=-15;
		yp2[4]=0;
			
	}
	
	protected void resetXPB2YPB2() {
		
		xpB2[0]=0;
		xpB2[1]=0;
		xpB2[2]=45;
		xpB2[3]=45;
		xpB2[4]=0;
		ypB2[0]=0;
		ypB2[1]=-90;
		ypB2[2]=-135;
		ypB2[3]=-45;
		ypB2[4]=0;
			
	}
	
	protected void changeXP2YP2(int dxp2, int dyp2) {/********/
		
		for (int i=0; i<5; i++) {
		xp2[i]+=dxp2;
		yp2[i]+=dyp2;
		}
	}
	
	protected void changeXPB2YPB2(int dxpb2, int dypb2) {/********/
		
		for (int i=0; i<5; i++) {
		xpB2[i]+=dxpb2;
		ypB2[i]+=dypb2;
		}
	}
	
	protected int[] getStickersIds(int face, boolean inclinated) {
		
		if(!inclinated) {
		switch(face) {
		
		case 0:
			int[] stickers0 = {30,6,31,9,0,7,33,8,32};
			return stickers0 ;
		case 1:
			int[] stickers01 = {35,10,34,15,1,14,43,22,42};
			return stickers01 ;
		case 2:
			int[] stickers02 = {37,11,36,17,2,16,45,23,44};
			return stickers02 ;
		case 3:
			int[] stickers03 = {39,12,38,19,3,18,47,24,46};
			return stickers03 ;
		case 4:
			int[] stickers04 = {41,13,40,21,4,20,49,25,48};
			return stickers04 ;
		case 5:
			int[] stickers05 = {53,28,52,29,5,27,50,26,51};
			return stickers05 ;
		
		}
		
		}else{
			
			
		switch(face) {
		
		case 0://For front
			int[] stickers0 = {33,8,32,9,0,7,30,6,31};
			return stickers0 ;
		case 2://For sided
			int[] stickers02 ={45,17,37,23,2,11,44,16,36};
			return stickers02 ;
			
			}	
			
			
		}
		
		return null;
		
	}
	
	protected Color numberToColor(int index) {
		
		if(index==0) {
			return new Color(255,255,255);
		}else
		if(index==1) {
			return new Color(63, 253, 85);
		}else
		if(index==2) {
			return new Color(255, 173, 31);
		}else
		if(index==3) {
			return new Color(66, 139, 255);
		}else
		if(index==4) {
			return new Color(255,61,61);
		}
		else
		if(index==5) {
			return new Color(255,238,0);	
		}else 
			return new Color(0,0,0);
		
	}

}
