package cube;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributes;

public class SaveState {
	
	public FileWriter esc;
	public FileReader lec ;
	public Cube cube;
	public int[] stateArray = new int[54];
	public int stateNumber = 1; // First state, 54 multiples
	public File f  = new File("states.dat");
	
	public SaveState(Cube cube) {
		this.cube = cube;
	}
	
	public SaveState() {
		
	}
	
	public void saveState(int[] state) {
		
//		System.out.println(getClass().getResource("savedstates/states.dat").getPath());
		
		try {
			
			setHiddenAttrib(f.toPath(), false);
			
			f = new File("states.dat");
			
			f.setWritable(true);
			f.setReadable(true);
			
			esc = new FileWriter(f);
			
			
			for(int i=0; i<54; i++) {
				char j = ((Integer)state[i]).toString().charAt(0);
				esc.write(j);
			}
			
			esc.close();
		
			
			setHiddenAttrib(f.toPath(), true);
		
			f.setWritable(false);
			f.setReadable(false);
			
		}catch(IOException e) {
				
			System.err.println("Error al guardar estado del cubo de Rubik");
			e.printStackTrace();
		}
		
		
		
	}
	
	public int[] getSavedState() { 	
		
		try {
			
			setHiddenAttrib(f.toPath(), false);
			
			f = new File("states.dat");
			
			f.setWritable(true);
			f.setReadable(true);
						
			lec = new FileReader(new File("states.dat"));
			
			for(int i=0; i<54; i++) {

				stateArray[i]= Character.getNumericValue(((char)lec.read()));
				
			}
			
			
			
		
		}catch(IOException  e) {
				
			System.err.println("Error al cargar el estado del cubo de Rubik");
			e.printStackTrace();
				
		} finally {
				
				try {
					lec.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				f = new File("states.dat");
				
				setHiddenAttrib(f.toPath(), true);

				f.setWritable(true);
				f.setReadable(true);
				
			}
		
			return stateArray;
		
	}
	
	private static void setHiddenAttrib(Path filePath, boolean active) {		
	    try {
	      DosFileAttributes attr = Files.readAttributes(filePath, DosFileAttributes.class);
	      System.out.println(filePath.getFileName() + " Hidden attribute is " + attr.isHidden());
	      Files.setAttribute(filePath, "dos:hidden", active);
	      attr = Files.readAttributes(filePath, DosFileAttributes.class);
//	      System.out.println(filePath.getFileName() + " Hidden attribute is " + attr.isHidden());
	    } catch (IOException e) {
	      e.printStackTrace();
	    } 
	  }

//	
//	public static void main (String args[]) {
//		
//		SaveState s = new SaveState();
//		
//		Cube c = new Cube();
//		
//		c.setAlgoritmo(Cube.crearAlgoritmoAleatorio(10));
//		c.realizarAlgoritmo();
//		
//		System.out.println(c);
//
//		s.saveState(c.stickers);
//		
//		int[] array = s.getSavedState();
//		
//		for(int i: array) {
//			System.out.print(i);
//		}
//		
		
//	}
	
	}
