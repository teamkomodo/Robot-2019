package frc.robot;

//IMPORTS
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;                    //NOT USED
import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;   //NOT WORKING
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;


//START ROBOT CLASS
public class Robot extends TimedRobot {
  //DEFINITIONS - WILL EVENTUALLY BE MADE INTO A ROBOT MAP FILE
    //MOTOR MAP
  private static final int rMotorPort = 1;
  private static final int lMotorPort = 2;
  private static final int lslavePort = 2;
  private static final int rslavePort = 2;



    //JOYSTICK MAP
  private static final int kJoystickPort = 0;
  private static final int leftX = 0;
  private static final int leftY = 1;  
  private static final int rightX = 4;  
  private static final int rightY = 5;
  private static final int buttonA = 1;
  private static final int buttonB = 2;
  private static final int buttonX = 3;

  double scaler = 0.5;
  Boolean buttonflag = false;

  //  
  WPI_TalonSRX rmotor = new WPI_TalonSRX(rMotorPort);
  WPI_TalonSRX lmotor = new WPI_TalonSRX(lMotorPort);
  WPI_TalonSRX lslave = new WPI_TalonSRX(lslavePort);
  WPI_TalonSRX rslave = new WPI_TalonSRX(rslavePort);

  SpeedControllerGroup mleft = new SpeedControllerGroup(lmotor, lslave);
  SpeedControllerGroup mright = new SpeedControllerGroup(rmotor, rslave);

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
    m_joystick = new Joystick(kJoystickPort);
  } //END ROBOT INIT

  @Override
  public void teleopPeriodic() {

    drive.arcadeDrive(m_joystick.getRawAxis(leftY), m_joystick.getRawAxis(leftX));

  } //END ROBOTOT TELEOP
} //END ROBOT CLASS