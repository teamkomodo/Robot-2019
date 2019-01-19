package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

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
    public  NetworkTableEntry tv;
  
    public double limelightX;
    public double limelightY;
    public double limelightArea;
    public double limelightTarget;
    public double visionScaler;

    public OI() {
        gamepad = new Joystick(RobotMap.kJoystickPort);
        ljoystick = new Joystick(RobotMap.lJoystickPort);
        rjoystick = new Joystick(RobotMap.rJoystickPort);

        rmotor = new WPI_TalonSRX(RobotMap.rMotorPort);
        lmotor = new WPI_TalonSRX(RobotMap.lMotorPort);
        lslave = new WPI_TalonSRX(RobotMap.lslavePort);
        rslave = new WPI_TalonSRX(RobotMap.rslavePort);

        mleft = new SpeedControllerGroup(lmotor, lslave);
        mright = new SpeedControllerGroup(rmotor, rslave);

        drive = new DifferentialDrive(mleft, mright);

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