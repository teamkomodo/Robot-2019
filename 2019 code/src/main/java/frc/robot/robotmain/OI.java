package frc.robot.robotmain;

import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogGyro;

public class OI{
    public Joystick gamepad;
    public Joystick rjoystick;
    public Joystick ljoystick;

    public WPI_TalonSRX rmotor;
    public WPI_TalonSRX lmotor;
    public WPI_TalonSRX lmotor2;
    public WPI_TalonSRX rmotor2;
    public WPI_TalonSRX rmotor3;
    public WPI_TalonSRX lmotor3;

    public SpeedControllerGroup mleft;
    public SpeedControllerGroup mright;

    public DifferentialDrive drive;

    public AnalogGyro gyro;

    public Timer timer;
    public Timer debugTimer;

    public AnalogInput ultrasonic;

    public NetworkTable table;
    public NetworkTableEntry tx;
    public NetworkTableEntry ty;
    public NetworkTableEntry ta;
    public NetworkTableEntry tv;
  
    public double limelightX;
    public double limelightY;
    public double limelightArea;
    public double limelightTarget;

    public int encoderTimeout;

    public OI() {
        gamepad = new Joystick(RobotMap.kJoystickPort);
        ljoystick = new Joystick(RobotMap.lJoystickPort);
        rjoystick = new Joystick(RobotMap.rJoystickPort);

        rmotor = new WPI_TalonSRX(RobotMap.rMotorPort);
        lmotor = new WPI_TalonSRX(RobotMap.lMotorPort);
        lmotor2 = new WPI_TalonSRX(RobotMap.lMotor2Port);
        rmotor2 = new WPI_TalonSRX(RobotMap.rMotor2Port);
        lmotor3 = new WPI_TalonSRX(RobotMap.lMotor2Port);
        rmotor3 = new WPI_TalonSRX(RobotMap.rMotor2Port);

        encoderTimeout = 30;

        rmotor2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, encoderTimeout);
        lmotor2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, encoderTimeout);

        gyro = new AnalogGyro(1);
        ultrasonic = new AnalogInput(0);

        timer = new Timer();
        timer.reset();
        timer.start();

        debugTimer = new Timer();
        debugTimer.reset();
        debugTimer.start();

        mleft = new SpeedControllerGroup(lmotor, lmotor2, lmotor3);
        mright = new SpeedControllerGroup(rmotor, rmotor2, rmotor3);

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