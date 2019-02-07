package frc.robot.robotmain;

//IMPORTS
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

//START ROBOT CLASS
public class Robot extends TimedRobot {
  
  //RANDOM DECLARATIONS

  public static OI oi;
  public static TrackTarget visionCode;
  public static GlobalVariables globalVariables;  
  public static ButtonControl buttonControl;
  public static JoystickControl joystickControl;
  
  @Override
  public void robotInit() {
    //INITIALIZE ALL MOTOR CONTROLLERS AND VARIABLES
    oi = new OI();
    globalVariables = new GlobalVariables();
  } //END ROBOT INIT
  @Override
  public void autonomousInit() {
    //AUTO INIT
  }
  @Override
  public void autonomousPeriodic() {
    //AUTO CODE
  }
  @Override
  public void teleopPeriodic() {
    buttonControl = new ButtonControl();
    joystickControl = new JoystickControl();
  } //END ROBOTOT TELEOP
} //END ROBOT CLASS