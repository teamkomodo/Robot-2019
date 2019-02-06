package frc.robot.robotmain;

import edu.wpi.first.wpilibj.Joystick;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.analog.adis16448.frc.ADIS16448_IMU;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class OI{
    public Joystick gamepad;
    public Joystick rjoystick;
    public Joystick ljoystick;

    public WPI_TalonSRX rtmotor;
    public WPI_TalonSRX ltmotor;
    public WPI_TalonSRX ltmotor2;
    public WPI_TalonSRX rtmotor2;
    public WPI_TalonSRX rtmotor3;
    public WPI_TalonSRX ltmotor3;
    public VictorSPX lvmotor;

    public ADIS16448_IMU gyro;

    public SpeedControllerGroup mleft;
    public SpeedControllerGroup mright;

    public DifferentialDrive drive;


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

        rtmotor = new WPI_TalonSRX(RobotMap.rMotorPort);
        ltmotor = new WPI_TalonSRX(RobotMap.lMotorPort);
        ltmotor2 = new WPI_TalonSRX(RobotMap.lMotor2Port);
        rtmotor2 = new WPI_TalonSRX(RobotMap.rMotor2Port);
        ltmotor3 = new WPI_TalonSRX(RobotMap.lMotor2Port);
        rtmotor3 = new WPI_TalonSRX(RobotMap.rMotor2Port);

        encoderTimeout = 30;

        rtmotor2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, encoderTimeout);
        ltmotor2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, encoderTimeout);

         gyro = new ADIS16448_IMU();
        ultrasonic = new AnalogInput(0);

        timer = new Timer();
        timer.reset();
        timer.start();

        debugTimer = new Timer();
        debugTimer.reset();
        debugTimer.start();

        /* sample robot drive code
        mleft = new SpeedControllerGroup(ltmotor, ltmotor2, ltmotor3);
        */

        mleft = new SpeedControllerGroup(ltmotor, ltmotor2, ltmotor3);
        mright = new SpeedControllerGroup(rtmotor, rtmotor2, rtmotor3);

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