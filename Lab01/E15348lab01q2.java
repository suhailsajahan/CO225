// S. Suhail
// E/15/348
// CO225-Lab01

import java.util.Scanner;
public class E15348lab01q2 {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		int i, valid=0 ;
		int check = 0 ;
		int Arr[] = new int[3];		//create an array with size of 3
		int NewArr[] = new int[3];
		System.out.printf("Enter the color: ");
		for(i=0; i<3; i++) {					//take the red green blue inputs
			Arr[i] = keyboard.nextInt() ;
			if(112<=Arr[i] && Arr[i]<=143) {
				check += 1 ; 					//check for the gray color
			} 
		}
		for(i=0; i<3 ; i++) {					//complement for gray color
			if(check == 3) {
				if(Arr[i]<128) {
					NewArr[i] = Arr[i]+128;
				}
				else{
					NewArr[i] = Arr[i]-128 ; 
				}
			}
			else {
				if(Arr[i]>=0 && Arr[i]<=255) {	//normal complement (subtract from 255)
					NewArr[i] = 255 - Arr[i];
				}
				else {
					valid = 99 ;			// check for the valid input (between 0 to 255)
				}
			}
		}
		if(valid==99) {
			System.out.println("Invalid input");
		}
		else {
			System.out.println(NewArr[0]+" "+NewArr[1]+" "+NewArr[2]);
		}
	}
}
