package frc.robot;
import frc.robot.*;

public class MotorControl{
    public MotorControl(){
      //DRIVE MODE TOGGLE
      if(Robot.oi.gamepad.getRawButton(RobotMap.buttonA) && !Robot.oi.ButtonFlag){
        Robot.oi.defaultDrivemode = !Robot.oi.defaultDrivemode;
        Robot.oi.ButtonFlag = true;
      } 
      if(Robot.oi.ljoystick.getRawButton(RobotMap.lSwitch) && !Robot.oi.ButtonFlag) {
        Robot.oi.defaultDrivemode = !Robot.oi.defaultDrivemode;
        Robot.oi.ButtonFlag = true;
      }

      if (RobotMap.enableGamepad){
        //DRIVE FUNCTIONS
        if(!Robot.oi.defaultDrivemode){
          Robot.oi.drive.arcadeDrive(-Robot.oi.gamepad.getRawAxis(RobotMap.leftY)*RobotMap.scaler, Robot.oi.gamepad.getRawAxis(RobotMap.leftX)*RobotMap.scaler);
        } else {
          Robot.oi.drive.tankDrive(-Robot.oi.gamepad.getRawAxis(RobotMap.leftY)*RobotMap.scaler, -Robot.oi.gamepad.getRawAxis(RobotMap.rightY)*RobotMap.scaler);
        }
      } else {  //CONTROL MODE CHECK
        if(!Robot.oi.defaultDrivemode){
          Robot.oi.drive.arcadeDrive(-Robot.oi.ljoystick.getRawAxis(RobotMap.joyY)*RobotMap.scaler, -Robot.oi.ljoystick.getRawAxis(RobotMap.joyX)*RobotMap.scaler);
        } else {
          Robot.oi.drive.tankDrive(-Robot.oi.ljoystick.getRawAxis(RobotMap.joyY)*RobotMap.scaler, -Robot.oi.rjoystick.getRawAxis(RobotMap.joyY)*RobotMap.scaler);
        }
      } //END CONTROL MODE
    } 
}