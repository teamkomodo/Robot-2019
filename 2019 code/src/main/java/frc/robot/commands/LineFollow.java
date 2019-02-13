package frc.robot.commands;
import frc.robot.robotmain.*;

public class LineFollow{
    public LineFollow(){
        if(Robot.oi.lineSensor.get() != Robot.globalVariables.lineTrip){
            Robot.globalVariables.lineFollowCounter++;
        }
        if(Robot.oi.lineSensor.get()){
            Robot.globalVariables.lineTrip = true;
            Robot.oi.drive.tankDrive(.6, .4);
        } else {
            Robot.globalVariables.lineTrip = false;
            Robot.oi.drive.tankDrive(.4, .6);
        }             
    }
}