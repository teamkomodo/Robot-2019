package frc.robot.commands;
import frc.robot.robotmain.*;

public class DriveStraight{
    public DriveStraight(double speed){
            double steeringAdjust = 0;
            Robot.globalVariables.calculatedX = Robot.oi.gyro.getAngle()+Robot.globalVariables.gyroDrift;

            if((Robot.globalVariables.calculatedX)*.02 > speed) {
              steeringAdjust = speed;
            }else if ((Robot.globalVariables.calculatedX)*.02 < -speed) {
              steeringAdjust = -speed;
            } else {
              steeringAdjust = (Robot.globalVariables.calculatedX)*.02;
            }
            
            if(Robot.globalVariables.calculatedX> 0){
              Robot.oi.drive.tankDrive(-speed,-speed-steeringAdjust);
            }else if (Robot.globalVariables.calculatedX < 0) {
              Robot.oi.drive.tankDrive(-speed+steeringAdjust,-speed);
            } else {
              Robot.oi.drive.tankDrive(-speed,-speed);
            }
    }
}