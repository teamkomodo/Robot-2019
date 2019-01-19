package frc.robot;

//IMPORTS
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.*;

//START ROBOT CLASS
public class Robot extends TimedRobot {
  
  //RANDOM DECLARATIONS
  public Boolean buttonFlag = false;
  public Boolean visionFlag = false;

  public static OI oi;
  public static TrackTarget trackTarget;
  public static MotorControl motorControl;

  private Boolean driveMode = false;
  
  @Override
  public void robotInit() {
    oi = new OI();
  } //END ROBOT INIT

  @Override
  public void teleopPeriodic() {

    //BUTON FLAG RESET
    if(!oi.gamepad.getRawButton(RobotMap.buttonA) && !oi.gamepad.getRawButton(RobotMap.buttonB) && !oi.gamepad.getRawButton(RobotMap.buttonX) && !oi.gamepad.getRawButton(RobotMap.buttonY)){
      buttonFlag = false;
    }
    //VISION CODE TOGGLE
    if(oi.gamepad.getRawButton(RobotMap.buttonB) && !buttonFlag){
      visionFlag = !visionFlag;
      buttonFlag = true;
    }
    //DETERMINES IF WE ARE IN VISION MODE OR DRIVE MODE
    if(visionFlag){
        //UPDATES VISION VALUES
        oi.limelightX = oi.tx.getDouble(0.0);
        oi.limelightY = oi.ty.getDouble(0.0);
        oi.limelightArea = oi.ta.getDouble(0.0);
        oi.limelightTarget = oi.tv.getDouble(0.0);

        if(oi.limelightX > 20){
          oi.visionScaler = 1.0;
        } else if(oi.limelightX < -20){
          oi.visionScaler = 1.0;
        } else {
          oi.visionScaler = oi.limelightX / 20;
        }
        //LOOKS FOR A TARGET
        if(oi.limelightTarget != 0.0){
          //DETECTS IF TARGET IS IN RANGE
          if(oi.limelightArea > RobotMap.visionDistanceMin && oi.limelightArea < RobotMap.visionDistanceMax){
            //DETECTS WHERE THE TARGET IS ON X AXIS
            if(oi.limelightX - RobotMap.visionXThreshold > 0){
              oi.mleft.set(oi.visionScaler);
              oi.mright.set(oi.visionScaler);
            }
            if(oi.limelightX + RobotMap.visionXThreshold < 0){
              oi.mleft.set(-oi.visionScaler);
              oi.mright.set(-oi.visionScaler);
            }
          } else {
            //DISABLES MOTORS IF IT DOES NOT FIND A TARGET
            oi.mleft.set(0);
            oi.mright.set(0);
          }
        }   
      
       } else {
        if (RobotMap.enableGamepad){
          //DRIVE MODE TOGGLE
          if(Robot.oi.gamepad.getRawButton(RobotMap.buttonA) && !buttonFlag){
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
    }
  } //END ROBOTOT TELEOP
} //END ROBOT CLASS