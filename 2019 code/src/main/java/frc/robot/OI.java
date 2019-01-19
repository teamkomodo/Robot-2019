package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class OI{
    public Joystick gamepad;
    public Joystick rjoystick;
    public Joystick ljoystick;

    public WPI_TalonSRX rmotor;
    public WPI_TalonSRX lmotor;
    public WPI_TalonSRX lslave;
    public WPI_TalonSRX rslave;

    public SpeedControllerGroup mleft;
    public SpeedControllerGroup mright;

    public DifferentialDrive drive;

    public NetworkTable table;
    public NetworkTableEntry tx;
    public NetworkTableEntry ty;
    public NetworkTableEntry ta;
    public NetworkTableEntry tv;
  
    public double limelightX;
    public double limelightY;
    public double limelightArea;
    public double limelightTarget;
    public double visionXScaler;
    public double visionDistanceScaler;
    public double adjustedLeft;
    public double adjustedRight;
    public double oneFootLeftEncoder;
    public double oneFootRightEncoder;
    public double autonomousSpeed;

    public Boolean defaultDrivemode;
    public Boolean ButtonFlag;

    public int encoderTimeout;

    public OI() {
        gamepad = new Joystick(RobotMap.kJoystickPort);
        ljoystick = new Joystick(RobotMap.lJoystickPort);
        rjoystick = new Joystick(RobotMap.rJoystickPort);

        encoderTimeout = 30;

        rmotor = new WPI_TalonSRX(RobotMap.rMotorPort);
        lmotor = new WPI_TalonSRX(RobotMap.lMotorPort);
        lslave = new WPI_TalonSRX(RobotMap.lslavePort);
        rslave = new WPI_TalonSRX(RobotMap.rslavePort);

        rslave.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, encoderTimeout);
        lslave.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, encoderTimeout);

        oneFootLeftEncoder = 3825.25;
        oneFootRightEncoder = -3864.15;

        autonomousSpeed = 0.5;

        mleft = new SpeedControllerGroup(lmotor, lslave);
        mright = new SpeedControllerGroup(rmotor, rslave);

        drive = new DifferentialDrive(mleft, mright);
        defaultDrivemode = false;       //FALSE FOR ARCADE, TRUE FOR TANK
        ButtonFlag = false;

        table = NetworkTableInstance.getDefault().getTable("limelight");
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");
        tv = table.getEntry("tv");
      
        limelightX = tx.getDouble(0.0);
        limelightY = ty.getDouble(0.0);
        limelightArea = ta.getDouble(0.0);
        limelightTarget = tv.getDouble(0.0);
        } 
    }