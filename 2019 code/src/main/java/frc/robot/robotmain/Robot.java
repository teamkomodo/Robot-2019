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
      globalVariables = new GlobalVariables();
      oi = new OI();
      Robot.oi.gyro.reset();
      joystickControl = new JoystickControl();
      buttonControl = new ButtonControl();

  } //END ROBOT INIT
  @Override
  public void autonomousInit() {
      Robot.oi.gyro.reset();
  }
  @Override
  public void autonomousPeriodic() {
    joystickControl.autoJoystick();
    buttonControl.autoButtonControl();
    dashboard = new Dashboard();
  }//END ROBOT AUTO
  @Override
  public void teleopInit() {
    Robot.oi.gyro.reset();
  }
  @Override
  public void teleopPeriodic() {
    joystickControl.autoJoystick();
    buttonControl.autoButtonControl();
    dashboard = new Dashboard();
  } //END ROBOT TELEOP
} //END ROBOT CLASS