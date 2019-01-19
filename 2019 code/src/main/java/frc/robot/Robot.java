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
  public static TrackTarget visionCode;
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
        visionCode = new TrackTarget();
       } else { //END VISION CODE
        motorControl = new MotorControl(buttonFlag);
    }
  } //END ROBOTOT TELEOP
} //END ROBOT CLASS