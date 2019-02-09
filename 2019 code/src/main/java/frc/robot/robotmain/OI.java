package frc.robot.robotmain;

//INPUT
import edu.wpi.first.wpilibj.Joystick;
//SENSORS
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
//MOTORS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.VictorSP;
//ROBOT
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//MISC
import edu.wpi.first.wpilibj.Timer;

public class OI{
    //INPUT
    public Joystick gamepad;
    public Joystick rjoystick;
    public Joystick ljoystick;
    //SENSORS
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
    public AnalogGyro gyro;
    //MOTORS
    public WPI_TalonSRX rmotor1;
    public VictorSPX rmotor2;
    public VictorSPX rmotor3;
    public WPI_TalonSRX lmotor1;
    public VictorSPX lmotor2;
    public VictorSPX lmotor3;
    public WPI_TalonSRX mLift1;
    public VictorSPX mLift2;
    public WPI_TalonSRX rLift;
    public VictorSP bManipulator;
    public VictorSP hManipulator;
    //ROBOT
    public DifferentialDrive drive;
    //MISC
    public Timer timer;
    public Timer debugTimer;

   
    public OI() {
        gamepad = new Joystick(RobotMap.kJoystickPort);
        ljoystick = new Joystick(RobotMap.lJoystickPort);
        rjoystick = new Joystick(RobotMap.rJoystickPort);

        rmotor1 = new WPI_TalonSRX(RobotMap.rMotor1Port);
        rmotor2 = new VictorSPX(RobotMap.rMotor2Port);
        rmotor3 = new VictorSPX(RobotMap.rMotor3Port);
        lmotor1 = new WPI_TalonSRX(RobotMap.lMotor1Port);
        lmotor2 = new VictorSPX(RobotMap.lMotor2Port);
        lmotor3 = new VictorSPX(RobotMap.lMotor3Port);

        rmotor2.follow(rmotor1);
        rmotor3.follow(rmotor1);
        lmotor2.follow(lmotor1);
        lmotor3.follow(lmotor1);

        

        mLift1 = new WPI_TalonSRX(RobotMap.mLift1Port);
        mLift2 = new VictorSPX(RobotMap.mLift2Port);

        mLift2.follow(mLift1);
        
        rLift = new WPI_TalonSRX(RobotMap.rLiftPort);
        bManipulator = new VictorSP(RobotMap.bManipularotPort);
        hManipulator = new VictorSP(RobotMap.hManipularotPort);
        
        encoderTimeout = 30; //miliseconds

        rmotor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, encoderTimeout);
        lmotor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, encoderTimeout);
        rLift.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, encoderTimeout);

        gyro = new AnalogGyro(RobotMap.gyroPort);
        ultrasonic = new AnalogInput(RobotMap.ultrasonicPort);

        timer = new Timer();
        timer.reset();
        timer.start();

        debugTimer = new Timer();
        debugTimer.reset();
        debugTimer.start();

        drive = new DifferentialDrive(lmotor1, rmotor1);

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