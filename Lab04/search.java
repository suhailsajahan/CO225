/*
S. Suhail
E/15/348
Lab04
*/
import java.io.*;
import java.util.Scanner;


public class search{
    public static void main(String[] args){
        String csvFile = "contacts.csv";
        String line = "";
        int numOfContacts = 0;
        contacts[] cntcts = new contacts[1000];  // creating objects for 1000 contacts
        int check = 0;          // to check whether there is the contact or not

        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){       //read the csv file
            while((line =br.readLine()) != null){                                   //read the contents
                String[] name = line.split(",");                                    //save the contents 
                cntcts[numOfContacts] = new contacts(name[0], name[1], name[2]);
                numOfContacts +=1;                                                  //counting the numbers of contacts
            }

        
            System.out.println("\nWelcome to My Phone Book");
			System.out.println("-------------------------");
			System.out.println("\nInstructions:");
            System.out.println("F:(First Name prefix) L:(Last Name prefix) Q:(Exit)\n");
            
            Scanner keyboard = new Scanner(System.in);
            String[] input = new String[50]; 

            input = keyboard.next().split(":");

            if(input[0].equalsIgnoreCase("F")){                 //search with first name
                    for(int j=0 ; j<numOfContacts; j++ ){
                        if(input[1].equalsIgnoreCase(cntcts[j].getfName())){
                            System.out.println(cntcts[j].getfName()+" "+cntcts[j].getlName()+" "+cntcts[j].getNumber());
                            check = 100;
                        }
                    }
            }
            else if(input[0].equalsIgnoreCase("L")){            //search with last name
                for(int j=0 ; j<numOfContacts; j++ ){
                    if(input[1].equalsIgnoreCase(cntcts[j].getlName())){
                        System.out.println(cntcts[j].getfName()+" "+cntcts[j].getlName()+" "+cntcts[j].getNumber());
                        check = 100;
                    }
                }
            }else if(input[0].equalsIgnoreCase("Q")){           //quit
                System.out.println("Exiting...");
            }else{
                System.out.println("Invalid input prefix");     //invalid inputs
            }
            if(check == 0){
                System.out.println("Contact not found");        //if contacts not found
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
