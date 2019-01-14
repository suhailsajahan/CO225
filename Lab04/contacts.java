/*
S. Suhail
E/15/348
Lab04
*/
public class contacts{

    String fName ;
    String lName ;
    String number ;

    public contacts(String first, String last, String num){
        fName = first ;
        lName = last ;
        number = num ;
    }

    public String getfName(){
        return fName;
    }

    public String getlName(){
        return lName;
    }

    public String getNumber(){
        return number;
    }

}