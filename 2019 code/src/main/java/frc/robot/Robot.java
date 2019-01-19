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
      oi.drive.tankDrive(-oi.ljoystick.getRawAxis(RobotMap.joyX)*RobotMap.scaler, -oi.ljoystick.getRawAxis(RobotMap.joyY)*RobotMap.scaler);
      //Matt was here but he was a mega loser so Ethan moved him to the bottom.
    } //END CONTROL MODE
  } //END ROBOTOT TELEOP
} //END ROBOT CLASS