/*
S. Suhail
E/15/348
*/

class Main { 
    public static int [][] a = {{1, 1, 1},				//Defining the matrix a[]
								{5, 6, 3},
								{1, 0, 9}};
    
    public static int [][] b = {{2, 2},					//Defining the matrix b[]
								{1, 5},
								{4, 5}};

	public static int threadCount = 4;					//Setting the total amount of threads to be used

    public static void print_matrix(int[][] m) {		//A method to print the answer matrix c
		for(int i=0; i < m.length; i++) {
	    	for(int j=0; j< m[i].length; j++){
				System.out.print(m[i][j] + " \t"); 
			}
			System.out.println();
    	}
	}

    public static void main(String [] args) throws Exception{ 		

		if(threadCount>a.length){						//Check the number of threads with the number of rows 
			threadCount = a.length;						//to prevent using more threads than need
		}
		
		Matrix[] t = new Matrix[threadCount] ;			//creating a Matrix array
		Matrix.initialize_C(a.length, b[0].length);		//initializing the resultant matrix c[]
		
		for(int i=0; i<threadCount; i++){				//Creating threads
			t[i] = new Matrix(a,b,threadCount,i);
			t[i].start();
			t[i].join();
		}

		print_matrix(Matrix.c); 						// calling a method to print the answer	

    }
}