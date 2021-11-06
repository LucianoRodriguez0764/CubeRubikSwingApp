package cube;

import java.util.ArrayList;
import java.util.Random;


public class Cube{
    
    public int[] stickers = new int[54];
    
    // 0 white (top) 1 green (back) 2 orange (right) 3 blue 4 red 5 yellow
    // 6 centers, U-B-R-F-L-D
    // 4 stickers on top(begin on UB-UR), 8 on top sides(UB-UR), 8 on middle layer (first is BL-BR), 8 on bottom sides(DB-DR), 4 on bottom (DB-DR)
    // 4 stickers on top (UBL, 8 on top sides (the B sticker of UBD and then UBL the B sticker), 8 bottom sides (same), 4 bottom (same)
    
    public final int[] solvedState ={        // Indices...
                            0,1,2,3,4,5,     // 0-5
                            0,0,0,0,         // 6-9
                            1,2,3,4,         // 10-13
                            1,1,2,2,3,3,4,4, // 14-21
                            1,2,3,4,         // 22-25
                            5,5,5,5,         // 26-29
                            0,0,0,0,         // 30-33
                            1,1,2,2,3,3,4,4, // 34-41
                            1,1,2,2,3,3,4,4, // 42-49
                            5,5,5,5          // 50-53
    };
    
    
    private String algoritmo = "R U R' U'F";
    
/******************************************************************************/    
    
    public Cube(){
        
    toSolvedState();
        
    }
    
    public void setAlgoritmo(String alg){
        
        this.algoritmo = algoStringBeautify(alg);
       
    }
    public String getAlgoritmo(){
        
        return this.algoritmo;
        
    }
/******************************************************************************/    

    public void toSolvedState(){
        
        for (int i=0; i<54; i++){
        this.stickers[i] = solvedState[i];
        }
        
    }
    
    public static char[] toColor(int[] sticks){
        
        char[] charSticks = new char[54];
        
        for (int i=0; i< sticks.length; i++){
        switch(sticks[i]){
            
            case 0: charSticks[i]= 'B'; break;
            case 1: charSticks[i]= 'V'; break;
            case 2: charSticks[i]= 'N'; break;
            case 3: charSticks[i]= 'Z'; break;
            case 4: charSticks[i]= 'R'; break;
            case 5: charSticks[i]= 'A'; break;
            default: charSticks[i]= 'x'; break;
            
            }
        }
        
        return charSticks;
    }
/***********************  ELEMENTAL MOVES  **********************************/    
    public void U(){
        
        int auxiliarSticker;
        //4 Edges
        auxiliarSticker = stickers[6]; 
        stickers[6] = stickers[9];
        stickers[9] = stickers[8];
        stickers[8] = stickers[7];
        stickers[7] = auxiliarSticker;
        
        auxiliarSticker = stickers[10]; 
        stickers[10] = stickers[13];
        stickers[13] = stickers[12];
        stickers[12] = stickers[11];
        stickers[11] = auxiliarSticker;
        
        //4 corners
        auxiliarSticker = stickers[30]; 
        stickers[30] = stickers[33];
        stickers[33] = stickers[32];
        stickers[32] = stickers[31];
        stickers[31] = auxiliarSticker;
        
        auxiliarSticker = stickers[34]; 
        stickers[34] = stickers[40];
        stickers[40] = stickers[38];
        stickers[38] = stickers[36];
        stickers[36] = auxiliarSticker;
        
        auxiliarSticker = stickers[41]; 
        stickers[41] = stickers[39];
        stickers[39] = stickers[37];
        stickers[37] = stickers[35];
        stickers[35] = auxiliarSticker;
    }
    
    public void Uprima(){
        
        U();U();U();
        
    }
    
    public void R(){
        
        int auxiliarSticker;
        //4 Edges
        auxiliarSticker = stickers[7]; 
        stickers[7] = stickers[18];
        stickers[18] = stickers[27];
        stickers[27] = stickers[15];
        stickers[15] = auxiliarSticker;
        
        auxiliarSticker = stickers[11]; 
        stickers[11] = stickers[17];
        stickers[17] = stickers[23];
        stickers[23] = stickers[16];
        stickers[16] = auxiliarSticker;
        
        //4 corners
        auxiliarSticker = stickers[31]; 
        stickers[31] = stickers[38];
        stickers[38] = stickers[52];
        stickers[52] = stickers[43];
        stickers[43] = auxiliarSticker;
        
        auxiliarSticker = stickers[37]; 
        stickers[37] = stickers[45];
        stickers[45] = stickers[44];
        stickers[44] = stickers[36];
        stickers[36] = auxiliarSticker;
        
        auxiliarSticker = stickers[35]; 
        stickers[35] = stickers[32];
        stickers[32] = stickers[46];
        stickers[46] = stickers[51];
        stickers[51] = auxiliarSticker;
    }
     
    public void Rprima(){
        
        R();R();R();
        
    }
    
    public void L(){
        
        int auxiliarSticker;
        //4 Edges
        auxiliarSticker = stickers[9]; 
        stickers[9] = stickers[14];
        stickers[14] = stickers[29];
        stickers[29] = stickers[19];
        stickers[19] = auxiliarSticker;
        
        auxiliarSticker = stickers[13]; 
        stickers[13] = stickers[21];
        stickers[21] = stickers[25];
        stickers[25] = stickers[20];
        stickers[20] = auxiliarSticker;
        
        //4 corners
        auxiliarSticker = stickers[40]; 
        stickers[40] = stickers[41];
        stickers[41] = stickers[49];
        stickers[49] = stickers[48];
        stickers[48] = auxiliarSticker;
        
        auxiliarSticker = stickers[30]; 
        stickers[30] = stickers[42];
        stickers[42] = stickers[53];
        stickers[53] = stickers[39];
        stickers[39] = auxiliarSticker;
        
        auxiliarSticker = stickers[33]; 
        stickers[33] = stickers[34];
        stickers[34] = stickers[50];
        stickers[50] = stickers[47];
        stickers[47] = auxiliarSticker;
    }
     
    public void Lprima(){
        
        L();L();L();
        
    }
    
    public void D(){
        
        int auxiliarSticker;
        //4 Edges
        auxiliarSticker = stickers[28]; 
        stickers[28] = stickers[29];
        stickers[29] = stickers[26];
        stickers[26] = stickers[27];
        stickers[27] = auxiliarSticker;
        
        auxiliarSticker = stickers[24]; 
        stickers[24] = stickers[25];
        stickers[25] = stickers[22];
        stickers[22] = stickers[23];
        stickers[23] = auxiliarSticker;
        
        //4 corners
        auxiliarSticker = stickers[52]; 
        stickers[52] = stickers[53];
        stickers[53] = stickers[50];
        stickers[50] = stickers[51];
        stickers[51] = auxiliarSticker;
        
        auxiliarSticker = stickers[46]; 
        stickers[46] = stickers[48];
        stickers[48] = stickers[42];
        stickers[42] = stickers[44];
        stickers[44] = auxiliarSticker;
        
        auxiliarSticker = stickers[47]; 
        stickers[47] = stickers[49];
        stickers[49] = stickers[43];
        stickers[43] = stickers[45];
        stickers[45] = auxiliarSticker;
    }
    
    public void Dprima(){
        
        D();D();D();
        
    }
    
    public void F(){
        
        int auxiliarSticker;
        //4 Edges
        auxiliarSticker = stickers[12]; 
        stickers[12] = stickers[19];
        stickers[19] = stickers[24];
        stickers[24] = stickers[18];
        stickers[18] = auxiliarSticker;
        
        auxiliarSticker = stickers[8]; 
        stickers[8] = stickers[20];
        stickers[20] = stickers[28];
        stickers[28] = stickers[17];
        stickers[17] = auxiliarSticker;
        
        //4 corners
        auxiliarSticker = stickers[39]; 
        stickers[39] = stickers[47];
        stickers[47] = stickers[46];
        stickers[46] = stickers[38];
        stickers[38] = auxiliarSticker;
        
        auxiliarSticker = stickers[33]; 
        stickers[33] = stickers[48];
        stickers[48] = stickers[52];
        stickers[52] = stickers[37];
        stickers[37] = auxiliarSticker;
        
        auxiliarSticker = stickers[32]; 
        stickers[32] = stickers[40];
        stickers[40] = stickers[53];
        stickers[53] = stickers[45];
        stickers[45] = auxiliarSticker;
    }
    
    public void Fprima(){
        
        F();F();F();
        
    }
    
    public void B(){
        
        int auxiliarSticker;
        //4 Edges
        auxiliarSticker = stickers[10]; 
        stickers[10] = stickers[15];
        stickers[15] = stickers[22];
        stickers[22] = stickers[14];
        stickers[14] = auxiliarSticker;
        
        auxiliarSticker = stickers[6]; 
        stickers[6] = stickers[16];
        stickers[16] = stickers[26];
        stickers[26] = stickers[21];
        stickers[21] = auxiliarSticker;
        
        //4 corners
        auxiliarSticker = stickers[35]; 
        stickers[35] = stickers[43];
        stickers[43] = stickers[42];
        stickers[42] = stickers[34];
        stickers[34] = auxiliarSticker;
        
        auxiliarSticker = stickers[31]; 
        stickers[31] = stickers[44];
        stickers[44] = stickers[50];
        stickers[50] = stickers[41];
        stickers[41] = auxiliarSticker;
        
        auxiliarSticker = stickers[30]; 
        stickers[30] = stickers[36];
        stickers[36] = stickers[51];
        stickers[51] = stickers[49];
        stickers[49] = auxiliarSticker;
    }
    
    public void Bprima(){
        
        B();B();B();
        
    }
    
    /************************************************************************/
    
    
    public void print(){
        // UB UR UF UL, BL BR FR FL, DB DR DF DL
        // ULB UBR URF UFL, DBL DRB DFR DLF
        edgesHelper();
        cornersHelper();
    }
    
    void edgesHelper(){
        
        char[] c = toColor(this.stickers);
        
        String top, middle, bottom;
        
        // Se imprimen las orientaciones en el formato: Top-X , Bottom-X , Front-X,  Back-X 
        top     = c[6] + "/" + c[10] + " " + c[7] + "/" + c[11] + " " + c[8] + "/" + c[12] + " " + c[9] + "/" + c[13];
        middle  = c[14] + "/" + c[21] + " " + c[15] + "/" + c[16] + " " + c[18] + "/" + c[17] + " " + c[19] + "/" + c[20];
        bottom  = c[26] + "/" + c[22] + " " + c[27] + "/" + c[23] + " " + c[28] + "/" + c[24] + " " + c[29] + "/" + c[25];
        
        System.out.println(top);
        System.out.println(middle);
        System.out.println(bottom);
        
    }
    
    void cornersHelper(){
        
        char[] c = toColor(this.stickers);
        
        String top, middle, bottom;
        
        // Se imprimen las orientaciones en el sig orden: first WhiteYellow face (UD) - después agujas del reloj
        top     = c[30] + "/" + c[41] + "/" + c[34] + " " + c[31] + "/" + c[35] + "/" + c[36] + " " + c[32] + "/" + c[37] + "/" + c[38] + " " + c[33] + "/" + c[39] + "/" + c[40];
        bottom  = c[50] + "/" + c[42] + "/" + c[49] + " " + c[51] + "/" + c[44] + "/" + c[43] + " " + c[52] + "/" + c[46] + "/" + c[45] + " " + c[53] + "/" + c[48] + "/" + c[47];
        
        System.out.println(top);
        System.out.println(bottom);
        
    }
    
    // Estaria bueno poder solucionar el tema de resueltos en las 6 orientaciones (para poder hacer R L' y M_up y que esté resuelto)
    public boolean isSolved(){
        
    for (int i=0; i<54; i++){
        if (this.stickers[i] != solvedState[i]){
            return false;
        }
    }
    return true;
    }
    
    public void printIsSolved(){
        
        if (this.isSolved())
      {
	System.out.println ("El cubo está resuelto.");
      }
    else
      {
	System.out.println ("El cubo no está resuelto.");
      }
        
    }
    
    public void realizarAlgoritmo(){
        realizarAlgoritmo(true);
    }
    
    public void realizarAlgoritmo(boolean b){
        
        char[] algoMoves = new char[this.algoritmo.length()+1];
        

        this.algoritmo.getChars(0, algoMoves.length-1, algoMoves, 0);
        
        for(int i=0 ; i< algoMoves.length; i++){
            
        switch(algoMoves[i]){
            
            case 'R': 
                if(algoMoves[i+1] == '\''){
                    this.Rprima();
                }else{
                    
                if(algoMoves[i+1] == '2'){
                    this.R(); this.R();
                }else{
                    this.R();
                    }
                };
                    break;
                    
            case 'U': 
                if(algoMoves[i+1] == '\''){
                    this.Uprima();
                }else{
                    
                if(algoMoves[i+1] == '2'){
                    this.U(); this.U();
                }else{
                    this.U();
                    }
                };
                    break;
                    
            case 'L': 
                if(algoMoves[i+1] == '\''){
                    this.Lprima();
                }else{
                    
                if(algoMoves[i+1] == '2'){
                    this.L(); this.L();
                }else{
                    this.L();
                    }
                };
                    break;
                    
            case 'D': 
                if(algoMoves[i+1] == '\''){
                    this.Dprima();
                }else{
                    
                if(algoMoves[i+1] == '2'){
                    this.D(); this.D();
                }else{
                    this.D();
                    }
                };
                    break;
                    
            case 'F': 
                if(algoMoves[i+1] == '\''){
                    this.Fprima();
                }else{
                    
                if(algoMoves[i+1] == '2'){
                    this.F(); this.F();
                }else{
                    this.F();
                    }
                };
                    break;
                    
            case 'B': 
                if(algoMoves[i+1] == '\''){
                    this.Bprima();
                }else{
                    
                if(algoMoves[i+1] == '2'){
                    this.B(); this.B();
                }else{
                    this.B();
                    }
                };
                    break;
                    
            default: break;
            
        }
            
        } 
        
        // Esta sobrecarga del algoritmo es para que en iteraciones no se printee infinitamente
        if (b){
        System.out.println("Se realizó el siguiente algoritmo: "+this.getAlgoritmo());
        }
    }
    
    public static boolean conditionsLetters(char c){
        //Agregar (x)(y)(z) entre paréntesis y movimientos de dos capas.
        if(c=='R' || c=='U' || c=='L' || c=='D' || c=='F' || c=='B' || c=='M' || c=='S' || c=='E'){
            return true;
        }else{
            return false;
        }
        
    }
    
    public static boolean conditionsSymbols(char c){
        //Agregar (x)(y)(z) entre paréntesis y movimientos de dos capas.
        if(c=='\'' || c=='2'){
            return true;
        }else{
            return false;
        }
        
    }
    
    public String algoStringBeautify(String algo){ 
    
    char[] algoChar = new char[algo.length()+1]; // Esto de +1 es para que cuando se fije si en el siguiente char no hay ', le meta espacio.
    String algoBeautified = "";
    
    algo.getChars(0, algo.length(), algoChar, 0);

    for (int i=0; i<algoChar.length-1; i++)
    {
        
    if(conditionsLetters(algoChar[i]) || conditionsSymbols(algoChar[i])){
    
    algoBeautified += algoChar[i];
        
    }
    
    if(conditionsLetters(algoChar[i+1])){      
        
        algoBeautified += ' ';
        
            }
            
    }
        
        return algoBeautified;
        
    }
    
    // Habría que reducir el código de estos dos
    public int calcularIteraciones(boolean b){
        
      int contadorDeIteraciones=0;
      
      do{
          
      contadorDeIteraciones++;
      
      this.realizarAlgoritmo(false);
      
      } while(!this.isSolved());
        
      this.realizarAlgoritmo(false);
        
      if(b) {
      System.out.println(contadorDeIteraciones + " iteraciones son necesarias para resolver el cubo con el siguiente algoritmo: " + this.algoritmo);
      }
      return contadorDeIteraciones;
      
    }
    
    public int resolverConIteraciones(boolean b){
        
      int contadorDeIteraciones=0;
      
      do{
          
      contadorDeIteraciones++;
      
      this.realizarAlgoritmo(false);
      
      } while(!this.isSolved());
        
      if(b) {
     System.out.println(contadorDeIteraciones + " iteraciones fueron necesarias para resolver el cubo con el siguiente algoritmo: " + this.algoritmo);
      }
      return contadorDeIteraciones;
      
    }
    
    public static String crearAlgoritmoAleatorio(int longitud){
        
        String azarAlgo = "";
        int iterador = longitud;
        int randomNumber;
        char m = 'x';
        char anterior = 'x';  // Para que si el anterior es distinto, lo permita.
        char preLetter = 'y'; // Para que si detecta que la last letter fue igual, no la acepte.
        
        Random rnd = new Random();
        
        while(iterador != 0){
            
        	
        // Si quiero ajustarlo, solo aplico menos que 8 y restrinjo los casos.
        randomNumber = rnd.nextInt(8);
            
        switch(randomNumber){
            
            case 0: m='R' ;break;
            case 1: m='L';break;
            case 2: m='F';break;
            case 3: m='D';break;
            case 4: m='B';break;
            case 5: m='U';break;
            case 6: if(m=='x') {break;}else{m='\'';break;}
            case 7: if(m=='x') {break;}else{m='2';break;}
        }
        
        
        // Condicion para que ' y 2 no aparezcan dos veces seguidas, y que al principio no haya 2 o ' . Tampoco F F o L L.
        if((anterior != m) && (preLetter != m)){
            azarAlgo+= m;
            anterior = m;
        if (conditionsLetters(m) ){ // Condicion para que 2 y ' no cuenten como un caracter en longitud
                iterador--;
                preLetter = m;
        }
        }
        
        
       
        }
        
        return azarAlgo;
    }
        
    
    public String toString(){
        String auxiliar = "";
        for (int i=0; i< this.stickers.length; i++){
        auxiliar = auxiliar + this.stickers[i] + " ";
    }
        
        return auxiliar;
    }
    
    public final int[] ollCase ={        // Tiene un Tperm abajo en yellow...
            0,1,2,3,4,5,     // 0-5
            0,0,0,0,         // 6-9
            1,2,3,4,         // 10-13
            1,1,2,2,3,3,4,4, // 14-21
            1,4,3,2,        // 22-25
            5,5,5,5,         // 26-29
            0,0,0,0,         // 30-33
            1,1,2,2,3,3,4,4, // 34-41
            4,1,2,2,3,4,1,3, // 42-49  
            5,5,5,5          // 50-53
    }; 
    
    public void toOllState(){
        
        for (int i=0; i<54; i++){
        this.stickers[i] = ollCase[i];
        }
        
    }
    
    public boolean isOllSolved(){
        
        for (int i=0; i<54; i++){
        	
        	if(i>=30 || (i>=6 && i<=13) || (i>=22 && i<=29)) {
        		continue;
        		}
            if (this.stickers[i] != ollCase[i]){
                return false;
            }
        }
        return true;
        }
    
    public void printIsOllSolved(){
        
        if (this.isOllSolved())
      {
	System.out.println ("El cubo está resuelto.");
      }
    else
      {
	System.out.println ("El cubo no está resuelto.");
      }
        
    }
    
    
    public String getReverseAlgorithm(String algo) {
    	
    	algo = algoStringBeautify(algo);
    	
    	String result = "";
    	
        char[] algoChars = new char[algo.length()];
        algo.getChars(0, algo.length(), algoChars, 0);
        
        char[] algoReversed = new char[algo.length()];
        ArrayList<Character> algoReversedNoSpaces = new ArrayList<Character>();
        algoReversedNoSpaces.ensureCapacity(algo.length());
        
        int j=0;
        
        
        if(algo.length()==1) {
        	
        	result=algo;
        	result+="\'";
        	
        } else {
        	
        for(int i=(algoChars.length-1); i>=0; i--) {
        	algoReversed[j]=algoChars[i];
        	j++;
        }
   
        for(int i=0; i<algoReversed.length; i++) {
        	if(algoReversed[i] != ' ') {
        		algoReversedNoSpaces.add(algoReversed[i]);
        	}
        }        

    	algoReversedNoSpaces.add('X');
        
        final int algoLength=algoReversedNoSpaces.size();
        
        
        for(int i=0; i<algoLength-1; i++) {
        	        	
          		if(algoReversedNoSpaces.get(i)=='\'') {
        			result+=algoReversedNoSpaces.get(i+1);
        			i++;
        		} else 
        		if(algoReversedNoSpaces.get(i)=='2') {
            		result+=algoReversedNoSpaces.get(i+1);
            		result+='2';
            		i++;
            	} else
            	 {
                	result+=algoReversedNoSpaces.get(i);
                	result+='\'';
            	 }
        }
        }
        
    	return result;
    }
    


}