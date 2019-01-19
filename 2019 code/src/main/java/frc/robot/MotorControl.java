package frc.robot;
import frc.robot.*;

public class MotorControl{
    private Boolean driveMode = false;
    private Boolean buttonFlag;
    public MotorControl(Boolean flag){
      //SYNC EXTERNAL AND LOACAL VARIABLES
      buttonFlag = flag;
      //DRIVE MODE TOGGLE
      if((Robot.oi.gamepad.getRawButton(RobotMap.buttonA) && !buttonFlag) || (Robot.oi.ljoystick.getRawButton(RobotMap.lSwitch) && !buttonFlag)){
        driveMode = !driveMode;
        buttonFlag = true;
      }
      if (RobotMap.enableGamepad){
        //DRIVE FUNCTIONS
        if(!driveMode){
          Robot.oi.drive.arcadeDrive(-Robot.oi.gamepad.getRawAxis(RobotMap.leftY)*RobotMap.scaler, Robot.oi.gamepad.getRawAxis(RobotMap.leftX)*RobotMap.scaler);
        } else {
          Robot.oi.drive.tankDrive(-Robot.oi.gamepad.getRawAxis(RobotMap.leftY)*RobotMap.scaler, -Robot.oi.gamepad.getRawAxis(RobotMap.rightY)*RobotMap.scaler);
        }
      } else {  //CONTROL MODE CHECK
        if(!driveMode){
          Robot.oi.drive.arcadeDrive(-Robot.oi.ljoystick.getRawAxis(RobotMap.joyY)*RobotMap.scaler, -Robot.oi.ljoystick.getRawAxis(RobotMap.joyX)*RobotMap.scaler);
        } else {
          Robot.oi.drive.tankDrive(-Robot.oi.ljoystick.getRawAxis(RobotMap.joyY)*RobotMap.scaler, -Robot.oi.rjoystick.getRawAxis(RobotMap.joyY)*RobotMap.scaler);
        }
      } //END CONTROL MODE
    } 
}