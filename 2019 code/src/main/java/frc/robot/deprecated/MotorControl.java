package frc.robot.deprecated;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.robotmain.*;

/*
ATTENTION:

THIS FILE WAS REPLACED BY JOYSTICK CONTROL. THIS IS NOW DEPRICATED AND WE 
ARE NOT USING IT. PLEASE USE THIS FILE ONLY FOR REFERNCE!
*/

public class MotorControl{
    public MotorControl(){

      SmartDashboard.putNumber("Ultrasonic", Robot.oi.ultrasonic.getVoltage());

      //SETS LIMELIGHT TO CAMERA MODE
      Robot.oi.table.getEntry("pipeline").setNumber(1);

      /*      
      //GYRO CALIBRATION (RAN FOR 5 MINUTES)
      Robot.globalVariables.averageX = (Robot.oi.gyro.getRate() + Robot.globalVariables.averageX);
      Robot.globalVariables.debugcounter += 1.0;

      if(Robot.oi.debugTimer.get() > 1){
        SmartDashboard.putNumber("Average-X", Robot.globalVariables.averageX / Robot.globalVariables.debugcounter);
        Robot.oi.debugTimer.reset();
      } 
      */

      Robot.globalVariables.calculatedX = Robot.oi.gyro.getAngle()+Robot.globalVariables.gyroDrift;
      
      SmartDashboard.putNumber("Raw Gyro Value", Robot.oi.gyro.getAngle());
      SmartDashboard.putNumber("Calculated-X", Robot.globalVariables.calculatedX);

      //FLASH LEDS FOR .25 SECONDS EVERY 10 SECONDS
      if(Robot.oi.timer.get() >= 10.0 && Robot.oi.timer.get() < 10.25){
        Robot.oi.table.getEntry("ledMode").setNumber(2);
      } 
      if(Robot.oi.timer.get() >= 10.25){
        Robot.oi.table.getEntry("ledMode").setNumber(1);
        Robot.oi.timer.reset();
      }

      //DRIVE MODE TOGGLE
      if(Robot.oi.gamepad.getRawButton(RobotMap.buttonA) && !Robot.globalVariables.ButtonFlag){
        GlobalVariables.defaultDrivemode = !GlobalVariables.defaultDrivemode;
        Robot.globalVariables.ButtonFlag = true;
      } 
      if(Robot.oi.ljoystick.getRawButton(RobotMap.lSwitch) && !Robot.globalVariables.ButtonFlag) {
        GlobalVariables.defaultDrivemode = !GlobalVariables.defaultDrivemode;
        Robot.globalVariables.ButtonFlag = true;
      }
      if(Robot.oi.gamepad.getRawButton(RobotMap.buttonY)){
        Robot.oi.drive.tankDrive(0, 0);
        Robot.oi.gyro.reset();
      }
      if (GlobalVariables.enableGamepad){
        
        //RESET GYRO
        if(GlobalVariables.enableGyroDrive){
          if(Robot.oi.gamepad.getRawAxis(RobotMap.leftY) != 0 || Robot.oi.gamepad.getRawAxis(RobotMap.leftX) != 0) {
            Robot.oi.gyro.reset();
          } else if(Robot.oi.gamepad.getRawAxis(RobotMap.leftY) == 0 || Robot.oi.gamepad.getRawAxis(RobotMap.leftX) == 0){
            double steeringAdjust = 0;
            if((Robot.globalVariables.calculatedX)/10 > .5) {
              steeringAdjust = .5;
            }else if ((Robot.globalVariables.calculatedX)/10 < -.5) {
              steeringAdjust = -.5;
            } else {
              steeringAdjust = (Robot.globalVariables.calculatedX)/10;
            }
            SmartDashboard.putNumber("Steering Adjust", steeringAdjust);
            Robot.oi.drive.arcadeDrive(0, steeringAdjust);
          }
        }

        //DRIVE FUNCTIONS
        if(!GlobalVariables.defaultDrivemode){
          Robot.oi.drive.arcadeDrive(-Robot.oi.gamepad.getRawAxis(RobotMap.leftY)*GlobalVariables.scaler, Robot.oi.gamepad.getRawAxis(RobotMap.leftX)*GlobalVariables.scaler);
        } else {
          Robot.oi.drive.tankDrive(-Robot.oi.gamepad.getRawAxis(RobotMap.leftY)*GlobalVariables.scaler, -Robot.oi.gamepad.getRawAxis(RobotMap.rightY)*GlobalVariables.scaler);
        }
      } else {  //CONTROL MODE CHECK
        if(!GlobalVariables.defaultDrivemode){
          Robot.oi.drive.arcadeDrive(-Robot.oi.ljoystick.getRawAxis(RobotMap.joyY)*GlobalVariables.scaler, Robot.oi.ljoystick.getRawAxis(RobotMap.joyX)*GlobalVariables.scaler);
        } else {
          Robot.oi.drive.tankDrive(-Robot.oi.ljoystick.getRawAxis(RobotMap.joyY)*GlobalVariables.scaler, -Robot.oi.rjoystick.getRawAxis(RobotMap.joyY)*GlobalVariables.scaler);
        }
      } //END CONTROL MODE
      SmartDashboard.putNumber("Left X", Robot.oi.gamepad.getRawAxis(RobotMap.leftX));
      SmartDashboard.putNumber("Left Y", Robot.oi.gamepad.getRawAxis(RobotMap.leftY));
    } 
}