package frc.robot.robotmain;
import edu.wpi.first.wpilibj.Encoder;
//INPUT
import edu.wpi.first.wpilibj.Joystick;
//SENSORS
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import com.analog.adis16448.frc.ADIS16448_IMU;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;
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
    public DigitalInput limitSwitch;
    public AnalogInput lineSensor2;
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
    public ADXRS450_Gyro gyro;
    public DigitalInput lineSensor;
    Encoder encoder;
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
    public TalonSRX bManipulatortilt;
    //ROBOT
    public DifferentialDrive drive;
    public boolean competitionRobot = true;
    //MISC
    public Timer timer;
    public Timer debugTimer;
    public Timer hatchTimer;
    public Timer visionTimer;


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
        
        rLift = new WPI_TalonSRX(1);
        bManipulator = new VictorSP(RobotMap.bManipulatorPort);
        hManipulator = new VictorSP(RobotMap.hManipulatorPort);
        bManipulatortilt = new TalonSRX(RobotMap.bManipularottiltPort);
        
        encoderTimeout = 30;

        rmotor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, encoderTimeout);
        lmotor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, encoderTimeout);
        mLift1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, encoderTimeout);
        rLift.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, encoderTimeout);

        // encoderRight = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
        // encoderRight.setPIDSourceType(PIDSourceType.kDisplacement);
        // encoderRight.setDistancePerPulse(1.0 / tinch);
        // encoderRight.reset();
        
        // encoderLeft = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
        // encoderLeft.setPIDSourceType(PIDSourceType.kDisplacement);
        // encoderLeft.setDistancePerPulse(1.0 / tinch);
        // encoderLeft.reset();

        gyro = new ADXRS450_Gyro();

        ultrasonic = new AnalogInput(RobotMap.ultrasonicPort);
        lineSensor2 = new AnalogInput(3);
        lineSensor = new DigitalInput(0);
        limitSwitch = new DigitalInput(1);

        timer = new Timer();
        timer.reset();
        timer.start();

        debugTimer = new Timer();
        debugTimer.reset();
        debugTimer.start();

        hatchTimer = new Timer();
        hatchTimer.reset();
        hatchTimer.start();

        visionTimer = new Timer();
        visionTimer.reset();
        visionTimer.start();

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