import java.util.Arrays;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Action implements ActionListener{
    System system;
    Frame frame;
    
    public Action(System system,Frame frame){
        this.system = system;
        this.frame = frame;
        impListener();
    }
    
    private void impListener(){
        for(JButton butt : frame.button){
            butt.addActionListener(this);
            frame.result.addActionListener(this);
        }
    }
    
    private boolean setResult(Integer integer, Number number){
        system.getResult(integer,number);
        if(system.counter >= 5){
            if(system.lookResult()){
                frame.gameResult();
                frame.setEnd();
                return true;
            }
            if(system.counter == 9){
                frame.setEnd();
                frame.setDraw();
            }
        }
        return false;
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        Number playerSelect = frame.setPlayerNumber();
        
        if(Arrays.asList(frame.button).contains(event.getSource()) && playerSelect != null){
            Integer buttonNum = Arrays.asList(frame.button).indexOf((JButton)event.getSource());
            ((JButton)event.getSource()).setText(frame.setPlayerString());
            frame.pack();
            ((JButton)event.getSource()).setEnabled(false);
            if(!setResult(buttonNum,playerSelect)) 
                frame.nextPlayer();
        }else if(event.getSource().equals(frame.result)){
            this.frame.dispose();
            this.frame = new Frame();
            impListener();
            this.system = new System();
        }
    }
    
}
