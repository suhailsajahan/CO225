/*
S. Suhail
E/15/348
*/

import java.lang.*;

class Matrix extends Thread { 						//Creating a thread named Matrix 

    private static int [][] a; 
    private static int [][] b; 
    public static int [][] c; 
	private static int totalThreads;
	private static int ID;
	private static int row; 						
	private static int col;


	public Matrix(int [][] m, int [][] n, int threadCount, int threadID) { // Creating a constractor fo Matrix
		a = m;
		b = n;
		totalThreads = threadCount;
		ID = threadID;

		row = a.length;
		col = b[0].length;

	}
	
	public static void initialize_C(int x, int y){			//A method to initialize the result matrix c[]
		c = new int [x][y];
		}

   
	public void run(){ 

		int z1 = a[0].length; 							// number of columns in the a matrix
		int z2 = b.length;								// number of rows in the b matrix
	
		int start, end;
		start =  (int)Math.floor(ID*((double)row/totalThreads));			//Defining the starting and end points for the each threads
		end =  (int)Math.floor((ID+1)*((double)row/totalThreads));

			if(z1 != z2) { 										//checking for a valid matrix multipication
	    		System.out.println("Cannnot multiply");
			}
			int i, j, k, s; 

			for(i=start; i<end; i++){							//loop for multiplying both a and b
	    		for(j=0; j<col; j++) {							
					for(s=0, k=0; k<z1; k++){ 
						s += a[i][k] * b[k][j];
					}
					c[i][j] = s;
	    		} 
			}
			
	}
}