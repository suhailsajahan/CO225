/*
   S.SUHAIL
   E/15/348
   CO225-Lab02
   26/10/2018
*/
import java.lang.*;                     // import library (we need some maths functions)

public class E15348Ball{
    public static void main(String[] args){

        Ball b1 = new Ball(0.0, 1.0, 10.0, 45.0);           //Input the ball b1
        Ball.updateTime(5.0);                                                              //add +5 for the global time
        Ball b2 = new Ball(0.0, 1.0, 20.0, 45.0);           //Input another ball b2
        Ball.updateTime(5.0);                                                              //add +5 for the global time

        if(b1.willCollide(b2)){                                                 //check whether b1 and b2 collide or not
            System.out.println("B1 and B2 will collide");
        }else{
            System.out.println("B1 and B2 won’t collide");
        }

        Ball b3 = new Ball(-10.0, 5.0, 3.0, 30.0);          //Input another ball b3
        Ball.updateTime(20.0);                                                             //add +20 to the global time

        if(b2.willCollide(b3)){                                                 //check whether ball b2 and b3 collide or not
            System.out.println("B2 and B3 will collide");
        }else{
            System.out.println("B2 and B3 won’t collide");
        }
    }
}

class Ball {                                    // A class file named Ball
    private double x;
    private double y;
    private double speed;
    private double angleOfSpeedWithX;
    private double addTime;
    public static double realTime = 0 ;
    private double xUpdated ;
    private double yUpdated ;

    Ball(double x, double y, double speed, double angleOfSpeedWithX) {          //Creating a constructor
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.angleOfSpeedWithX = angleOfSpeedWithX;
        this.addTime = realTime;                        // when we add a ball it saves the time
        this.xUpdated = 0;
        this.yUpdated = 0;
    }

    public static void updateTime(double time){         // a method to update the time
        realTime += time ;
    }


    public boolean willCollide(Ball b){                 // a method to check whether the balls are collide or not

        // all 4 equations in below help us to calculate the new positions of the balls
        this.xUpdated = this.x + ((this.speed * Math.cos(Math.toRadians(this.angleOfSpeedWithX)))*(realTime-this.addTime));
        this.yUpdated = this.y + ((this.speed * Math.sin(Math.toRadians(this.angleOfSpeedWithX)))*(realTime-this.addTime));

        b.xUpdated = b.x + ((b.speed * Math.cos(Math.toRadians(b.angleOfSpeedWithX)))*(realTime-b.addTime));
        b.yUpdated = b.y + ((b.speed * Math.sin(Math.toRadians(b.angleOfSpeedWithX)))*(realTime-b.addTime));


        if((this.x == b.x)&&(this.y == b.y)){       //check the coordinates of the balls to check whether they are colliding or not
            return true;
        }else{
             return false;
        }

    }



}
