public class System {
    
    public int counter = 0;
    int[][] window = new int[3][3];
    
    public void getResult(Integer integer, Number number){
        Integer windowNum = null;                  
        if(number == Number.player1){
            windowNum = -1;
        }else if(number == Number.player2){
            windowNum = 1;
        }
        window[integer %3][integer/3] = windowNum;
        counter++;
    }
    
    public boolean lookResult(){
        int diagonal_1 = 0;
        int diagonal_2 = 0;
        int column = 0;
        int row = 0;
        
        for (int i=0; i<=2; i++){
            diagonal_1 = diagonal_1 + window[i][i]; 
        }
        for (int i=0; i<=2; i++){
            diagonal_2 = diagonal_2 + window[i][2-i];
        }
        if(Math.abs(diagonal_1) == 3 || Math.abs(diagonal_2) == 3){
            return true;
        }
        for(int i=0; i<=2; i++){
            for(int r=0; r<=2; r++){
                column = column + window[r][i];
                row = row + window[i][r];
            }
            if(Math.abs(column) == 3 || Math.abs(row) == 3){
                return true;
            }else{
                column = 0;
                row = 0;
            }
        }
        return false;
    }
    
}
