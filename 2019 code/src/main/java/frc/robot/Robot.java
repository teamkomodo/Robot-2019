package frc.robot;

//IMPORTS
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.*;

//START ROBOT CLASS
public class Robot extends TimedRobot {
  
  //RANDOM DECLARATIONS
  public Boolean visionFlag = false;

  public static OI oi;
  public static TrackTarget visionCode;
  public static MotorControl motorControl;
  public static Autonomous autonomous;
  
  @Override
  public void robotInit() {
    //INITIALIZE ALL MOTOR CONTROLLERS AND VARIABLES
    oi = new OI();
  } //END ROBOT INIT
  @Override
  public void autonomousInit() {
    oi.rslave.setSelectedSensorPosition(0);
    oi.lmotor.setSelectedSensorPosition(0);
  }
  @Override
  public void autonomousPeriodic() {
    autonomous = new Autonomous();
  }
  @Override
  public void teleopPeriodic() {

    //BUTON FLAG RESET
    if(!oi.gamepad.getRawButton(RobotMap.buttonA) && !oi.gamepad.getRawButton(RobotMap.buttonB) && !oi.gamepad.getRawButton(RobotMap.buttonX) && !oi.gamepad.getRawButton(RobotMap.buttonY) && !oi.ljoystick.getRawButton(RobotMap.lSwitch)){
      oi.ButtonFlag = false;
    }
    //VISION CODE TOGGLE
    if(oi.gamepad.getRawButton(RobotMap.buttonB) && !oi.ButtonFlag){
      visionFlag = !visionFlag;
      oi.timer.reset();
      oi.ButtonFlag= true;
    }
    //DETERMINES IF WE ARE IN VISION MODE OR DRIVE MODE
    if(visionFlag){   //START VISION CODE
        visionCode = new TrackTarget();
       } else {       //END VISION CODE
        motorControl = new MotorControl();
    }
  } //END ROBOTOT TELEOP
} //END ROBOT CLASS
