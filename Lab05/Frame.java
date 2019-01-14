import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Frame extends JFrame{
    JButton[] button;
    JButton result;
    JLabel label_1;
    JLabel label_2;
    
    public Frame(){
        impBorder();
        setBorder();
        setVisible(true);
        pack();
        setTitle("Tic Tac Toe");      // Set a title for window
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   
    }
	
	public void impBorder(){
		this.button = new JButton[9];    
		
		for (int i=0; i<this.button.length; i++){
			this.button[i] = new JButton(" ");   // Implement buttons
		}
		this.label_1 = new JLabel("1");  //indicate player 1 to start
		this.label_2 = new JLabel("Turn of Player:");
		this.result = new JButton("Play Again");
                this.result.setEnabled(false);
	}
        
        private void setBorder(){
            GroupLayout border = new GroupLayout(getContentPane());
            getContentPane().setLayout(border);
            
            border.setAutoCreateGaps(true);
            border.setAutoCreateContainerGaps(true);
            
            border.setHorizontalGroup(border.createParallelGroup()
                    .addComponent(result,GroupLayout.Alignment.CENTER)
                    .addComponent(label_2,GroupLayout.Alignment.LEADING)
                    .addComponent(label_1,GroupLayout.Alignment.CENTER)
                    .addGroup(border.createSequentialGroup()
                            .addGroup(border.createParallelGroup()
                                    .addComponent(button[0])
                                    .addComponent(button[1])
                                    .addComponent(button[2]))
                            .addGroup(border.createParallelGroup()
                                    .addComponent(button[3])
                                    .addComponent(button[4])
                                    .addComponent(button[5]))
                            .addGroup(border.createParallelGroup()
                                    .addComponent(button[6])
                                    .addComponent(button[7])
                                    .addComponent(button[8]))
                        
                    )        
            );
            
            border.setVerticalGroup(border.createSequentialGroup()
                    .addComponent(result)
                    .addComponent(label_2)
                    .addComponent(label_1)
                    .addGroup(border.createSequentialGroup()
                            .addGroup(border.createParallelGroup()
                                   .addComponent(button[0])
                                   .addComponent(button[3])
                                   .addComponent(button[6]))
                            .addGroup(border.createParallelGroup()
                                   .addComponent(button[1])
                                   .addComponent(button[4])
                                   .addComponent(button[7]))
                            .addGroup(border.createParallelGroup()
                                   .addComponent(button[2])
                                   .addComponent(button[5])
                                   .addComponent(button[8]))
                    )
            );
        
        }
        
        void setReset(){
            this.label_1.setEnabled(true);
        }
        void setDraw(){
            JOptionPane.showMessageDialog(this,"Draw","Game Result",JOptionPane.INFORMATION_MESSAGE);
        }
        void setEnd(){
            this.result.setEnabled(true);
        }
        
        public String setPlayerString(){
            if("1".equals(this.label_1.getText())){
                return "1";
            }else if("2".equals(this.label_1.getText())){
                return "2";
            }
            return null;
        }
        
        public Number setPlayerNumber(){
            if("1".equals(this.label_1.getText())){
                return Number.player1;
            }else if("2".equals(this.label_1.getText())){
                return Number.player2;
            }
            return null;    
        }
        
        public Number setNext(Number num){
            if(num == Number.player1){
                return Number.player2;
            }else if(num == Number.player2){
                return Number.player1;
            }
            return null;
        }
        
        public String setNext(String num){
            if("1".equals(num)){
                return "2";
            }else if("2".equals(num)){
                return "1";
            }
            return null;
        }
        
        public void gameResult(){
            JOptionPane.showMessageDialog(this,"Congratulations Player "+setPlayerString()+ " won","Game Result",JOptionPane.INFORMATION_MESSAGE);
            for(JButton butt : this.button){
                butt.setEnabled(false);
            }
            setEnd();
        }
        
        public void nextPlayer(){
            String otherPlayer = setNext(setPlayerString());
            this.label_1.setText(otherPlayer);
        }
}
