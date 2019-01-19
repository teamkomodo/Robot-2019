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
      trackTarget.startTracking();
    } else {
      motorControl.control(buttonFlag);
    }
  } //END ROBOTOT TELEOP
} //END ROBOT CLASS