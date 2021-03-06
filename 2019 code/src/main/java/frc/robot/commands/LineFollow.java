package frc.robot.commands;
import frc.robot.robotmain.*;

public class LineFollow{
    public LineFollow(){
        Robot.oi.gyro.reset();
        if(Robot.oi.lineSensor.get() != Robot.globalVariables.lineTrip){
            Robot.globalVariables.lineFollowCounter++;
        }
        if(Robot.oi.lineSensor.get()){
            Robot.globalVariables.lineTrip = true;
            Robot.oi.drive.tankDrive(-.7, 0);
        } else {
            Robot.globalVariables.lineTrip = false;
            Robot.oi.drive.tankDrive(.3, -.5);
        }     
        // if(Robot.globalVariables.lineFollowCounter > 6){
        //     Robot.oi.drive.tankDrive(.1, -.1);
        // }        
    }
}