package frc.robot.robotmain;

import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.analog.adis16448.frc.ADIS16448_IMU;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.AnalogInput;

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

    public ADIS16448_IMU gyro;

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
    public double ultrasonicTarget;
    public double visionXScaler;
    public double visionDistanceScaler;
    public double adjustedLeft;
    public double adjustedRight;
    public double oneFootLeftEncoder;
    public double oneFootRightEncoder;
    public double autonomousSpeed;
    public double debugcounter;
    public double averageX;
    public double averageY;
    public double averageZ;
    public double calculatedX;
    public double calculatedY;
    public double calculatedZ;
    public double xDrift;
    public double yDrift;
    public double zDrift;
    public double visionStage;

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
        lmotor2 = new WPI_TalonSRX(RobotMap.lMotor2Port);
        rmotor2 = new WPI_TalonSRX(RobotMap.rMotor2Port);
        lmotor3 = new WPI_TalonSRX(RobotMap.lMotor2Port);
        rmotor3 = new WPI_TalonSRX(RobotMap.rMotor2Port);


        rmotor2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, encoderTimeout);
        lmotor2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, encoderTimeout);

        oneFootLeftEncoder = 3825.25;
        oneFootRightEncoder = -3864.15;

        gyro = new ADIS16448_IMU();
        ultrasonic = new AnalogInput(0);

        autonomousSpeed = 0.5;

        timer = new Timer();
        timer.reset();
        timer.start();

        debugTimer = new Timer();
        debugTimer.reset();
        debugTimer.start();

        debugcounter = 0.0;
        averageX = 0.0;
        averageY = 0.0;
        averageZ = 0.0;
        calculatedX = 0.0;
        calculatedY = 0.0;
        calculatedZ = 0.0;
        xDrift = 0.139;
        yDrift = -0.403;
        zDrift = -0.0267;
        visionStage = 0.0;
        ultrasonicTarget = 0.3;

        mleft = new SpeedControllerGroup(lmotor, lmotor2, lmotor3);
        mright = new SpeedControllerGroup(rmotor, rmotor2, rmotor3);

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