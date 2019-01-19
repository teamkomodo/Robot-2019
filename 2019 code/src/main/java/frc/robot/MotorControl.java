package frc.robot;
import frc.robot.*;

public class MotorControl{
    private Boolean driveMode = false;
    private Boolean buttonFlag;
    public MotorControl(Boolean flag){
      if (RobotMap.enableGamepad){
        //DRIVE MODE TOGGLE
        if(Robot.oi.gamepad.getRawButton(RobotMap.buttonA) && !buttonFlag){
          driveMode = !driveMode;
          buttonFlag = true;
        }
        //DRIVE FUNCTIONS
        if(!driveMode){
          Robot.oi.drive.arcadeDrive(-Robot.oi.gamepad.getRawAxis(RobotMap.leftY)*RobotMap.scaler, Robot.oi.gamepad.getRawAxis(RobotMap.leftX)*RobotMap.scaler);
        } else {
          Robot.oi.drive.tankDrive(-Robot.oi.gamepad.getRawAxis(RobotMap.leftY)*RobotMap.scaler, -Robot.oi.gamepad.getRawAxis(RobotMap.rightY)*RobotMap.scaler);
        }
      } else {  //CONTROL MODE CHECK
        Robot.oi.drive.tankDrive(-Robot.oi.ljoystick.getRawAxis(RobotMap.joyY)*RobotMap.scaler, -Robot.oi.rjoystick.getRawAxis(RobotMap.joyY)*RobotMap.scaler);
      } //END CONTROL MODE
    } 
}