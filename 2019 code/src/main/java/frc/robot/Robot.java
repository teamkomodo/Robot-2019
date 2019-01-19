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
  
  //RANDOM DECLARATIONS
  private Joystick m_joystick;
  Boolean driveMode = false;
  Boolean buttonFlag = false;


  @Override
  public void robotInit() {
    m_joystick = new Joystick(RobotMap.kJoystickPort);
  } //END ROBOT INIT

  @Override
  public void teleopPeriodic() {
<<<<<<< HEAD
    //BUTON FLAG RESET
    if(!m_joystick.getRawButton(RobotMap.buttonA) && !m_joystick.getRawButton(RobotMap.buttonB) && !m_joystick.getRawButton(RobotMap.buttonX) && !m_joystick.getRawButton(RobotMap.buttonY)){
      buttonFlag = false;
    }
    //DRIVE MODE TOGGLE
    if(m_joystick.getRawButton(RobotMap.buttonA) && !buttonFlag){
      driveMode = !driveMode;
      buttonFlag = true;
    }
    //DRIVE FUNCTIONS
    if(!driveMode){
      drive.arcadeDrive(-m_joystick.getRawAxis(RobotMap.leftY)*RobotMap.scaler, m_joystick.getRawAxis(RobotMap.leftX)*RobotMap.scaler);
    } else {
      drive.tankDrive(m_joystick.getRawAxis(RobotMap.leftY), m_joystick.getRawAxis(RobotMap.rightY));
    }
=======
    drive.arcadeDrive(-m_joystick.getRawAxis(RobotMap.leftY)*RobotMap.scaler, m_joystick.getRawAxis(RobotMap.leftX)*RobotMap.scaler);

drive.tankDrive(m_joystick.getRawAxis(RobotMap.leftY), m_joystick.getRawAxis(RobotMap.rightY));
>>>>>>> master
  } //END ROBOTOT TELEOP
} //END ROBOT CLASS