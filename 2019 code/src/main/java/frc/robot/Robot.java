package frc.robot;

//IMPORTS
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.*;

//START ROBOT CLASS
public class Robot extends TimedRobot {
  
  //RANDOM DECLARATIONS
  Boolean driveMode = false;
  Boolean buttonFlag = false;
  public static OI oi;
  
  @Override
  public void robotInit() {
    oi = new OI();
  } //END ROBOT INIT

  @Override
  public void teleopPeriodic() {
    
    oi.limelightX = oi.tx.getDouble(0.0);
    oi.limelightY = oi.ty.getDouble(0.0);
    oi.limelightArea = oi.ta.getDouble(0.0);
    oi.limelightTarget = oi.tv.getDouble(0.0);

    if(oi.limelightTarget != 0.0){ 

      if(oi.limelightArea > 1.0 && oi.limelightArea < 12.0
      ){
        if(oi.limelightX - RobotMap.visionThreshold > 0){
          oi.mleft.set(-.50);
          oi.mright.set(-.50);
        }
        if(oi.limelightX + RobotMap.visionThreshold < 0){
          oi.mleft.set(.50);
          oi.mright.set(.50);
        }
      } else {
        oi.mleft.set(0);
        oi.mright.set(0);
      }
    }
    
    /*

    if (RobotMap.enableGamepad){
      //BUTON FLAG RESET
      if(!oi.gamepad.getRawButton(RobotMap.buttonA) && !oi.gamepad.getRawButton(RobotMap.buttonB) && !oi.gamepad.getRawButton(RobotMap.buttonX) && !oi.gamepad.getRawButton(RobotMap.buttonY)){
        buttonFlag = false;
      }
      //DRIVE MODE TOGGLE
      if(oi.gamepad.getRawButton(RobotMap.buttonA) && !buttonFlag){
        driveMode = !driveMode;
        buttonFlag = true;
      }
      //DRIVE FUNCTIONS
      if(!driveMode){
        oi.drive.arcadeDrive(-oi.gamepad.getRawAxis(RobotMap.leftY)*RobotMap.scaler, oi.gamepad.getRawAxis(RobotMap.leftX)*RobotMap.scaler);
      } else {
        oi.drive.tankDrive(-oi.gamepad.getRawAxis(RobotMap.leftY)*RobotMap.scaler, -oi.gamepad.getRawAxis(RobotMap.rightY)*RobotMap.scaler);
      }
    } else {  //CONTROL MODE CHECK
      oi.drive.tankDrive(-oi.ljoystick.getRawAxis(RobotMap.joyY)*RobotMap.scaler, -oi.rjoystick.getRawAxis(RobotMap.joyY)*RobotMap.scaler);
    } //END CONTROL MODE
    */
  } //END ROBOTOT TELEOP
} //END ROBOT CLASS