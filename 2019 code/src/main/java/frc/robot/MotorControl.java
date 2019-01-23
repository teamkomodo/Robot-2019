package frc.robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.*;

public class MotorControl{
    public MotorControl(){

      //SETS LIMELIGHT TO CAMERA MODE
      Robot.oi.table.getEntry("pipeline").setNumber(1);

      //FLASH LEDS FOR .25 SECONDS EVERY 10 SECONDS
      if(Robot.oi.timer.get() >= 10.0 && Robot.oi.timer.get() < 10.25){
        Robot.oi.table.getEntry("ledMode").setNumber(2);
      } 
      if(Robot.oi.timer.get() >= 10.25){
        Robot.oi.table.getEntry("ledMode").setNumber(1);
        Robot.oi.timer.reset();
      }

      //DRIVE MODE TOGGLE
      if(Robot.oi.gamepad.getRawButton(RobotMap.buttonA) && !Robot.oi.ButtonFlag){
        Robot.oi.defaultDrivemode = !Robot.oi.defaultDrivemode;
        Robot.oi.ButtonFlag = true;
      } 
      if(Robot.oi.ljoystick.getRawButton(RobotMap.lSwitch) && !Robot.oi.ButtonFlag) {
        Robot.oi.defaultDrivemode = !Robot.oi.defaultDrivemode;
        Robot.oi.ButtonFlag = true;
      }
      if(Robot.oi.gamepad.getRawButton(RobotMap.buttonY)){
        Robot.oi.rslave.setSelectedSensorPosition(0);
        Robot.oi.lmotor.setSelectedSensorPosition(0);
        Robot.oi.gyro.reset();
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
          Robot.oi.drive.arcadeDrive(-Robot.oi.ljoystick.getRawAxis(RobotMap.joyY)*RobotMap.scaler, Robot.oi.ljoystick.getRawAxis(RobotMap.joyX)*RobotMap.scaler);
        } else {
          Robot.oi.drive.tankDrive(-Robot.oi.ljoystick.getRawAxis(RobotMap.joyY)*RobotMap.scaler, -Robot.oi.rjoystick.getRawAxis(RobotMap.joyY)*RobotMap.scaler);
        }
      } //END CONTROL MODE
      SmartDashboard.putNumber("Right Encoder", Robot.oi.rslave.getSelectedSensorPosition());
      SmartDashboard.putNumber("Left Encoder", Robot.oi.lmotor.getSelectedSensorPosition());
      SmartDashboard.putNumber("Gyro X", Robot.oi.gyro.getAngleX());
      SmartDashboard.putNumber("Gyro Y", Robot.oi.gyro.getAngleY());
      SmartDashboard.putNumber("Gyro Z", Robot.oi.gyro.getAngleZ());
      SmartDashboard.putNumber("Timer", Robot.oi.timer.get());

    } 
}