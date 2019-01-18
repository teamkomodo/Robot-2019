package frc.robot;

//IMPORTS
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.ControlMode;             //NOT USED
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;   //NOT WORKING
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.RobotMap;

//START ROBOT CLASS
public class Robot extends TimedRobot {

  //DEFINE MOTORS
  WPI_TalonSRX rmotor = new WPI_TalonSRX(RobotMap.rMotorPort);
  WPI_TalonSRX lmotor = new WPI_TalonSRX(RobotMap.lMotorPort);
  WPI_TalonSRX lslave = new WPI_TalonSRX(RobotMap.lslavePort);
  WPI_TalonSRX rslave = new WPI_TalonSRX(RobotMap.rslavePort);

  //CREATE SPEED CONTROLLER GROUPS
  SpeedControllerGroup mleft = new SpeedControllerGroup(lmotor, lslave);
  SpeedControllerGroup mright = new SpeedControllerGroup(rmotor, rslave);

  //INITIALIZE ARCADE DRIVE
  DifferentialDrive drive = new DifferentialDrive(mleft, mright);

  //VISION STUFF
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");
  NetworkTableEntry tv = table.getEntry("tv");

  double limelightX = tx.getDouble(0.0);
  double limelightY = ty.getDouble(0.0);
  double limelightArea = ta.getDouble(0.0);
  double limelightTarget = tv.getDouble(0.0);
  
  //DECLARATIONS
  private Joystick m_joystick;

  @Override
  public void robotInit() {
    m_joystick = new Joystick(RobotMap.kJoystickPort);
  } //END ROBOT INIT

  @Override
  public void teleopPeriodic() {

    drive.arcadeDrive(-m_joystick.getRawAxis(RobotMap.leftY)*RobotMap.scaler, m_joystick.getRawAxis(RobotMap.leftX)*RobotMap.scaler);

  } //END ROBOTOT TELEOP
} //END ROBOT CLASS