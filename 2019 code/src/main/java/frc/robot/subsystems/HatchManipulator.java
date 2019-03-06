package frc.robot.subsystems;

import frc.robot.robotmain.*;
import frc.robot.robotmain.RobotMap;
import java.util.TimerTask;
import java.util.Timer;

public class HatchManipulator {
    public HatchManipulator(int delay) {


       if(Robot.oi.gamepad.getRawButton(RobotMap.buttonB)){
            Robot.oi.hManipulator.set(.6);
            Robot.oi.hatchTimer.reset();;
            Robot.oi.hatchTimer.start();;
                 } else {
           Robot.oi.hManipulator.set(-.6);
                 }
                if(Robot.oi.hatchTimer.get() > 1){
                    Robot.oi.hManipulator.set(0);
                }     
                     
      
                
        // if(forward)
        // {
        // hspeed = -hspeed;
        // }
        // Robot.oi.hManipulator.set(hspeed);

        // if(Robot.globalVariables.hFlag==false)
        // {
        // Robot.globalVariables.hFlag=true;
        // if(Robot.oi.gamepad.getRawButton(RobotMap.buttonB)){

        // if(Robot.globalVariables.count%2==0.0)
        // {
        // Robot.oi.hManipulator.set(-speed);
        // System.out.println(Robot.globalVariables.count);

        // new Timer().schedule(new TimerTask() {
        // @Override
        // public void run() {
        // Robot.oi.hManipulator.set(0);
        // Robot.globalVariables.count++;
        // Robot.globalVariables.hFlag=false;
        // }
        // }, 1000);

        // }
        // if(Robot.globalVariables.count%2!=0.0)
        // {
        // Robot.oi.hManipulator.set(speed);
        // System.out.println(Robot.globalVariables.count);

        // new Timer().schedule(new TimerTask() {
        // @Override
        // public void run() {
        // Robot.oi.hManipulator.set(0);
        // Robot.globalVariables.count++;
        // Robot.globalVariables.hFlag=false;
        // }
        // }, 1000);

        // }
        // }

        // }
        // if(Robot.oi.gamepad.getRawButton(RobotMap.buttonB))
        // {
        // Robot.oi.hManipulator.set(-speed);
        // new Timer().schedule(new TimerTask() {
        // @Override
        // public void run() {
        // Robot.oi.hManipulator.set(0);
        // // Robot.globalVariables.count++;
        // // Robot.globalVariables.hFlag=false;
        // }
        // }, 1000);
        // }
    
}
}