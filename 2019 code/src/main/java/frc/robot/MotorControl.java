package frc.robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.*;


public class MotorControl{
    public MotorControl(){

      //SETS LIMELIGHT TO CAMERA MODE
      Robot.oi.table.getEntry("pipeline").setNumber(1);

      /*
      //GYRO CALIBRATION (RAN FOR 5 MINUTES)
      Robot.oi.averageX = (Robot.oi.gyro.getRateX() + Robot.oi.averageX);
      Robot.oi.averageY = (Robot.oi.gyro.getRateY() + Robot.oi.averageY);
      Robot.oi.averageZ = (Robot.oi.gyro.getRateZ() + Robot.oi.averageZ);

      Robot.oi.debugcounter += 1.0;

      if(Robot.oi.debugTimer.get() > 1){
        SmartDashboard.putNumber("Average-X", Robot.oi.averageX / Robot.oi.debugcounter);
        SmartDashboard.putNumber("Average-Y", Robot.oi.averageY / Robot.oi.debugcounter);
        SmartDashboard.putNumber("Average-Z", Robot.oi.averageZ / Robot.oi.debugcounter);
        Robot.oi.debugTimer.reset();
      } 
      */

      Robot.oi.calculatedX = Robot.oi.gyro.getAngleX()-Robot.oi.xDrift;
      Robot.oi.calculatedY = Robot.oi.gyro.getAngleY()-Robot.oi.yDrift;
      Robot.oi.calculatedZ = Robot.oi.gyro.getAngleZ()-Robot.oi.zDrift;   //THE ONE WE CARE ABOUT

      SmartDashboard.putNumber("Actual-X", Robot.oi.gyro.getAngleX());
      SmartDashboard.putNumber("Actual-Y", Robot.oi.gyro.getAngleY());
      SmartDashboard.putNumber("Actual-Z", Robot.oi.gyro.getAngleZ());
      SmartDashboard.putNumber("Calculated-X", Robot.oi.calculatedX);
      SmartDashboard.putNumber("Calculated-Y", Robot.oi.calculatedY);
      SmartDashboard.putNumber("Calculated-Z", Robot.oi.calculatedZ);

      if(RobotMap.enableGyroDrive){
        if(Robot.oi.calculatedZ > 0){
          Robot.oi.lmotor.set(-Robot.oi.calculatedZ);
          Robot.oi.rmotor.set(-Robot.oi.calculatedZ);
        } else if (Robot.oi.calculatedZ > 0){
          Robot.oi.lmotor.set(-Robot.oi.calculatedZ);
          Robot.oi.rmotor.set(-Robot.oi.calculatedZ);
        }
      }

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
        Robot.oi.rmotor2.setSelectedSensorPosition(0);
        Robot.oi.lmotor.setSelectedSensorPosition(0);
        Robot.oi.gyro.reset();
      }
      if (RobotMap.enableGamepad){
        //DRIVE FUNCTIONS
        if(!Robot.oi.defaultDrivemode){
          Robot.oi.drive.arcadeDrive(-Robot.oi.gamepad.getRawAxis(RobotMap.leftY)*RobotMap.scaler, Robot.oi.gamepad.getRawAxis(RobotMap.leftX)*RobotMap.scaler);
          if(RobotMap.enableGyroDrive){
            if(Robot.oi.gamepad.getRawAxis(RobotMap.leftY) != 0 && Robot.oi.gamepad.getRawAxis(RobotMap.leftX) != 0) {
              Robot.oi.gyro.reset();
            }
          }
        } else {
          Robot.oi.drive.tankDrive(-Robot.oi.gamepad.getRawAxis(RobotMap.leftY)*RobotMap.scaler, -Robot.oi.gamepad.getRawAxis(RobotMap.rightY)*RobotMap.scaler);
          if(RobotMap.enableGyroDrive){
            if(Robot.oi.gamepad.getRawAxis(RobotMap.leftY) == 0 && Robot.oi.gamepad.getRawAxis(RobotMap.rightY) == 0) {
              Robot.oi.gyro.reset();
            }
          }
        }
      } else {  //CONTROL MODE CHECK
        if(!Robot.oi.defaultDrivemode){
          Robot.oi.drive.arcadeDrive(-Robot.oi.ljoystick.getRawAxis(RobotMap.joyY)*RobotMap.scaler, Robot.oi.ljoystick.getRawAxis(RobotMap.joyX)*RobotMap.scaler);
        } else {
          Robot.oi.drive.tankDrive(-Robot.oi.ljoystick.getRawAxis(RobotMap.joyY)*RobotMap.scaler, -Robot.oi.rjoystick.getRawAxis(RobotMap.joyY)*RobotMap.scaler);
        }
      } //END CONTROL MODE
      SmartDashboard.putNumber("Left X", Robot.oi.gamepad.getRawAxis(RobotMap.leftX));
      SmartDashboard.putNumber("Left Y", Robot.oi.gamepad.getRawAxis(RobotMap.leftY));
    } 
}