package frc.robot.commands;
import frc.robot.robotmain.*;

public class DriveStraight{

    public DriveStraight(double speed){
            double steeringAdjust = 0;

            Robot.globalVariables.calculatedX = Robot.oi.gyro.getAngleZ();//+Robot.globalVariables.gyroDrift;

            if((Robot.globalVariables.calculatedX)*.01 > speed) {
              steeringAdjust = speed;
            }else if ((Robot.globalVariables.calculatedX)*.01 < -speed) {
              steeringAdjust = -speed;
            } else {
              steeringAdjust = (Robot.globalVariables.calculatedX)*.01;
            }
            
            if(Robot.globalVariables.calculatedX - GlobalVariables.gyroThreshold > 0){
              Robot.oi.drive.tankDrive(-speed,-speed-steeringAdjust);
            }else if (Robot.globalVariables.calculatedX + GlobalVariables.gyroThreshold < 0) {
              Robot.oi.drive.tankDrive(-speed+steeringAdjust,-speed);
            } else {
              Robot.oi.drive.tankDrive(-speed,-speed);
            }
    }
}