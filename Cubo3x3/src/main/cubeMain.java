package main;
import cube.Cube;
import java.util.Random;

public class cubeMain{


    // Cosas que se pueden hacer: contar iteraciones hasta armarse, realizar infinitas repeticiones de un algo, pasarle un algo y que se realice
    // printear el cubo en modo Tira o en modo Pieza a pieza, saber si está armado o no.


  public static void main (String[]args)
  {

    Cube cubito = new Cube ();

    //cubito.B();
    
 //  cubito.print();
    
// B2 L' B F U D R B U D F' U2 B R2 U' L U  ... 1260
    
    String algo = "U R F L B F D2 R F' D' F U2 B R L R F' F L";
    
    
  
/*    int iteracionesMax = 0;  NO HAY MÁS DE 1260!!!
    
    while (iteracionesMax < 1261){
    azarAlgo = Cube.crearAlgoritmoAleatorio(20);
    cubito.setAlgoritmo(azarAlgo);
    iteracionesMax = cubito.resolverConIteraciones();
    } */ 
    
    String azarAlgo = "";
    cubito.toSolvedState();
    int contador = 0;
    
    while(contador == 0) {
    	
    	cubito.toSolvedState();
    	
    	azarAlgo = Cube.crearAlgoritmoAleatorio(10);
    	cubito.setAlgoritmo(azarAlgo);
     	cubito.realizarAlgoritmo(false);

    	if (cubito.isOllSolved()) {
    		System.out.println(cubito.getAlgoritmo());
    		cubito.printIsOllSolved();
    		contador++;
    	};
    	
    //	System.out.println(cubito);
        }
    


    
    

  }

}
