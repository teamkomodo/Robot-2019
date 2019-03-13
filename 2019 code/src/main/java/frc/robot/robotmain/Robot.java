package frc.robot.robotmain;

//IMPORTS
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import frc.robot.commands.Elevator;
import frc.robot.deprecated.TrackTarget;

//START ROBOT CLASS
public class Robot extends TimedRobot {
  
  //RANDOM DECLARATIONS

  public static OI oi;
  public static GlobalVariables globalVariables;  
  public static ButtonControl buttonControl;
  public static JoystickControl joystickControl;
  public static Dashboard dashboard;
  public static Elevator elevator;
  
  
  @Override
  public void robotInit() {
    //INITIALIZE ALL MOTOR CONTROLLERS AND VARIABLES
    oi = new OI();
    joystickControl = new JoystickControl();
    buttonControl = new ButtonControl();
    globalVariables = new GlobalVariables();
    
  } //END ROBOT INIT
  @Override
  public void autonomousInit() {
  }
  @Override
  public void autonomousPeriodic() {
    joystickControl.autoJoystick();
    buttonControl.autoButtonControl();
    dashboard = new Dashboard();
    elevator =  new Elevator();
  }//END ROBOT AUTO
  @Override
  public void teleopPeriodic() {
    joystickControl.autoJoystick();
    buttonControl.autoButtonControl();
    dashboard = new Dashboard();
    elevator =  new Elevator();
  } //END ROBOT TELEOP
} //END ROBOT CLASS