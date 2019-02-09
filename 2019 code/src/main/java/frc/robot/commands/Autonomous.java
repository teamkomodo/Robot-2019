package frc.robot.commands;
import frc.robot.robotmain.*;
public class Autonomous{
    public double targetDistance = 10;      //THIS IS IN FEET
    private Boolean breakFlag = false;
    public Autonomous(){
        while(!breakFlag) {
        if(-Robot.oi.rmotor1.getSelectedSensorPosition() / -Robot.globalVariables.oneFootRightEncoder*targetDistance < 100 && Robot.oi.lmotor1.getSelectedSensorPosition() / Robot.globalVariables.oneFootLeftEncoder*targetDistance < 100){
            if(-Robot.oi.rmotor1.getSelectedSensorPosition() / -Robot.globalVariables.oneFootRightEncoder*targetDistance > Robot.oi.lmotor1.getSelectedSensorPosition() / Robot.globalVariables.oneFootLeftEncoder*targetDistance){
                Robot.oi.drive.tankDrive(Robot.globalVariables.autonomousSpeed -.3, -Robot.globalVariables.autonomousSpeed +.1);            
            } else {
                Robot.oi.drive.tankDrive(Robot.globalVariables.autonomousSpeed +.1 , -Robot.globalVariables.autonomousSpeed -.3);
            }
        } else {
            Robot.oi.drive.tankDrive(0, 0);
            breakFlag = true;  
        }
      }
    }   
}