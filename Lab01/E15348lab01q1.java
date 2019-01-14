// S. Suhail
// E/15/348
// CO225-Lab01

import java.util.Scanner;
public class E15348lab01q1 {
    public static void main(String[] args) {
	// write your code here
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a number : ");

        int Num = keyboard.nextInt();
        int a=0 ,b=0 ,c=0 ;

        if (Num%15 == 0){
            a = 1;
        }
        if (Num > 999){
            b = 1;
        }
        if (Num%5 ==0 && Num%6==0 && Num%18 !=0){
            c = 1;
        }

        if (a ==1 && b!=1 && c!=1){
            System.out.println(Num + " is special, but not scary.");
        }
        else if (a==1 && b!=1 && c==1){
            System.out.println(Num + " is special, weird, scary, but not big.");
        }
        else if(a==1 && b==1 && c!=1){
            System.out.println(Num + " is special, big, scary, but not weird.");
        }
        else if(a!=1 && b==1 && c==1){
            System.out.println(Num + " is big, weird, scary, but not special.");
        }
        else if(a!=1 && b==1 && c!=1){
            System.out.println(Num + " is big, scary, but not special, weired.");
        }
        else if(a!=1 && b!=1 && c==1){
            System.out.println(Num + " is weired, scary but not special, big.");
        }
        else if(a==1 && b==1 && c==1) {
            System.out.println(Num + " is special, big, weired, scary.");
        }
        else {
            System.out.println(Num + " is not special, big, weired, scary.");
        }
    }
}
