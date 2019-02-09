package frc.robot.commands;

import frc.robot.robotmain.*;

public class LiftDown{
    double level;
    double encoderValue = Robot.oi.mLift1.getSelectedSensorPosition();
    double targetValueEven = 45;
    double targetValueOdd = 20;
    
    public LiftDown(double initialLevel){
        //LOWER AN ELEVATOR TO A SET VALUE
        level=initialLevel;
        while(Robot.globalVariables.levelCounter<=6)
        {
            if(level%2==0)
            {
                //encoderValue=0; //reset
                encoderValue = Robot.oi.mLift1.getSelectedSensorPosition();
                if(encoderValue <=targetValueEven)
                {
                    Robot.oi.mLift1.set(-0.5);
                }
                else{
                    Robot.oi.mLift1.set(0);
                }
            }
            if(level%2!=0)
            {
                //encoderValue=0; //reset
                encoderValue = Robot.oi.mLift1.getSelectedSensorPosition();
                if(encoderValue <=targetValueOdd)
                {
                    Robot.oi.mLift1.set(-0.5);
                }
                else{
                    Robot.oi.mLift1.set(0);
                }
            }
        }
        
     }
}