package graphics;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class key_controls extends KeyAdapter{
	
	cuboPanel lamina = new cuboPanel();
	
	public key_controls(cuboPanel lamina/*,cuboMarco marco*/) {
		this.lamina = lamina;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
		
		if(!(e.getComponent() ==  lamina.getComponent(3))) {
		//Si el Text field fue el que mandó, que no tome los movs por teclado
			
			
		if (e.getKeyCode()== KeyEvent.VK_D) {
			
			if(e.isAltDown()) {
				lamina.r_btn.requestFocus();
				lamina.cuboPanel.setAlgoritmo("R2");
				lamina.cuboPanel.realizarAlgoritmo();
				lamina.repaint();
			}else if(e.isControlDown()) {
				lamina.rprime_btn.doClick();
				lamina.rprime_btn.requestFocus();
			}else{
				lamina.r_btn.doClick();
				lamina.r_btn.requestFocus();
			}
			
		}else
		if (e.getKeyCode()== KeyEvent.VK_A) {

			if(e.isAltDown()) {
				lamina.l_btn.requestFocus();
				lamina.cuboPanel.setAlgoritmo("L2");
				lamina.cuboPanel.realizarAlgoritmo();
				lamina.repaint();
			}else if(e.isControlDown()) {
				lamina.lprime_btn.requestFocus();
				lamina.lprime_btn.doClick();
			}else{
				lamina.l_btn.requestFocus();
				lamina.l_btn.doClick();
			}
			
		}else
		if (e.getKeyCode()== KeyEvent.VK_W) {
			
			if(e.isAltDown()) {
				lamina.u_btn.requestFocus();
				lamina.cuboPanel.setAlgoritmo("U2");
				lamina.cuboPanel.realizarAlgoritmo();
				lamina.repaint();
			}else if(e.isControlDown()) {
				lamina.uprime_btn.requestFocus();
				lamina.uprime_btn.doClick();
			}else{
				lamina.u_btn.requestFocus();
				lamina.u_btn.doClick();
			}
			
		}else
		if (e.getKeyCode()== KeyEvent.VK_X) {
			
			if(e.isAltDown()) {
				lamina.d_btn.requestFocus();
				lamina.cuboPanel.setAlgoritmo("D2");
				lamina.cuboPanel.realizarAlgoritmo();
				lamina.repaint();
			}else if(e.isControlDown()) {
				lamina.dprime_btn.requestFocus();
				lamina.dprime_btn.doClick();
			}else{
				lamina.d_btn.requestFocus();
				lamina.d_btn.doClick();
			}
			
		}else
		if (e.getKeyCode()== KeyEvent.VK_S) {
			
			if(e.isAltDown()) {
				lamina.f_btn.requestFocus();
				lamina.cuboPanel.setAlgoritmo("F2");
				lamina.cuboPanel.realizarAlgoritmo();
				lamina.repaint();
			}else if(e.isControlDown()) {
				lamina.fprime_btn.requestFocus();
				lamina.fprime_btn.doClick();
			}else{
				lamina.f_btn.requestFocus();
				lamina.f_btn.doClick();
			}
			
		}else
		if (e.getKeyCode()== KeyEvent.VK_G) {
			
			if(e.isAltDown()) {
				lamina.b_btn.requestFocus();
				lamina.cuboPanel.setAlgoritmo("B2");
				lamina.cuboPanel.realizarAlgoritmo();
				lamina.repaint();
			}else if(e.isControlDown()) {
				lamina.bprime_btn.requestFocus();
				lamina.bprime_btn.doClick();
			}else{
				lamina.b_btn.requestFocus();
				lamina.b_btn.doClick();
			}
			
		}else
			if(e.getKeyCode()== KeyEvent.VK_SPACE){
				
				lamina.view_btn.requestFocus();
				lamina.view_btn.doClick();
				
			}else
			if(e.getKeyCode()== KeyEvent.VK_BACK_SPACE) {
				lamina.reset_btn.requestFocus();
				lamina.reset_btn.doClick();
			}
			else
			if(e.getKeyCode()== KeyEvent.VK_ENTER) {
				lamina.txt_field.requestFocus();
			}
			else
				if(e.getKeyCode()== KeyEvent.VK_LESS) {
					lamina.back_btn.requestFocus();
					lamina.back_btn.doClick();
				}
			
		
		} else { //Si efectivamente es Text Field
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				lamina.ok_btn.requestFocus();
				lamina.ok_btn.doClick();
			}
		}
	}
	

	@Override
	public void keyPressed(KeyEvent e) {

	}	

}
