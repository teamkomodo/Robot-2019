package frc.robot.commands;
import frc.robot.robotmain.*;

public class StationaryGyroCorrect {
    public StationaryGyroCorrect() {
        
        if(Robot.oi.ljoystick.getRawAxis(RobotMap.joyY) - GlobalVariables.joystickThreshold > 0 || Robot.oi.ljoystick.getRawAxis(RobotMap.joyY) + GlobalVariables.joystickThreshold < 0 || Robot.oi.rjoystick.getRawAxis(RobotMap.joyY) - GlobalVariables.joystickThreshold > 0 || Robot.oi.rjoystick.getRawAxis(RobotMap.joyY) + GlobalVariables.joystickThreshold < 0){
            Robot.globalVariables.driverControl = true;
            Robot.oi.gyro.reset();
        } else {
            double steeringAdjust = 0;
            Robot.globalVariables.calculatedX = Robot.oi.gyro.getAngle()+Robot.globalVariables.gyroDrift;
            Robot.globalVariables.driverControl = false;

            if((Robot.globalVariables.calculatedX)*.02 > 1) {
              steeringAdjust = 1;
            }else if ((Robot.globalVariables.calculatedX)*.02 < -1) {
              steeringAdjust = -1;
            } else {
              steeringAdjust = (Robot.globalVariables.calculatedX)*.02;
            }
            
            if(Robot.oi.gyro.getAngle() - GlobalVariables.gyroThreshold > 0){
                Robot.oi.drive.tankDrive(steeringAdjust, -steeringAdjust);
            } else if(Robot.oi.gyro.getAngle() + GlobalVariables.gyroThreshold < 0){
                Robot.oi.drive.tankDrive(steeringAdjust, -steeringAdjust);
            } else {
                Robot.oi.drive.tankDrive(0, 0);
            }
        }
    }
}