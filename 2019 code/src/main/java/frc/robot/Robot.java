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
<<<<<<< HEAD
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
    } //END CONTROL MODE
=======
    //BUTON FLAG RESET
    if(!gamepad.getRawButton(RobotMap.buttonA) && !gamepad.getRawButton(RobotMap.buttonB) && !gamepad.getRawButton(RobotMap.buttonX) && !gamepad.getRawButton(RobotMap.buttonY)){
      buttonFlag = false;
    }
    //DRIVE MODE TOGGLE
    if(gamepad.getRawButton(RobotMap.buttonA) && !buttonFlag){
      driveMode = !driveMode;
      buttonFlag = true;
    }
    //DRIVE FUNCTIONS
    if(!driveMode){
      drive.arcadeDrive(-gamepad.getRawAxis(RobotMap.leftY)*RobotMap.scaler, gamepad.getRawAxis(RobotMap.leftX)*RobotMap.scaler);
    } else {
      drive.tankDrive(-gamepad.getRawAxis(RobotMap.leftY)*RobotMap.scaler, -gamepad.getRawAxis(RobotMap.rightY)*RobotMap.scaler);
    }
  } else {
    drive.tankDrive(-rjoystick.getRawAxis(RobotMap.joyY)*RobotMap.scaler, -ljoystick.getRawAxis(RobotMap.joyY)*RobotMap.scaler);
  }
>>>>>>> master
  } //END ROBOTOT TELEOP
} //END ROBOT CLASS