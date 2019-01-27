package frc.robot.robotmain;

public class RobotMap {

    //MOTOR DECLARATIONS
    public static final int rMotorPort = 3;
    public static final int rMotor2Port = 5;
    public static final int rMotor3Port = 7;

    public static final int lMotorPort = 2;
    public static final int lMotor2Port = 4;
    public static final int lMotor3Port = 6;

    //JOYSTICK DECLARATIONS
    public static final int lJoystickPort = 0;
    public static final int joyX = 0;
    public static final int joyY = 1;
    
    public static final int lTrigger = 1;
    public static final int lSide = 2;
    public static final int lBLeft = 3;
    public static final int lBRight = 4;
    public static final int lTLeft = 5;
    public static final int lTRight = 6;
    public static final int lSide7 = 7;
    public static final int lSide8 = 8;
    public static final int lSide9 = 9;
    public static final int lSide10 = 10;
    public static final int lSide11 = 11;
    public static final int lSwitch = 12;

    public static final int rJoystickPort = 1;

    public static final int rTrigger = 1;
    public static final int rSide = 2;
    public static final int rBLeft = 3;
    public static final int rBRight = 4;
    public static final int rTLeft = 5;
    public static final int rTRight = 6;
    public static final int rSide7 = 7;
    public static final int rSide8 = 8;
    public static final int rSide9 = 9;
    public static final int rSide10 = 10;
    public static final int rSide11 = 11;
    public static final int rSwitch = 12;

    //GAMEPAD DECLARATIONS
    public static final int kJoystickPort = 2;

    public static final int leftX = 0;
    public static final int leftY = 1;  
    public static final int rightX = 4;  
    public static final int rightY = 5;
    public static final int rightTrigger = 3;
    public static final int leftTrigger = 2;

    public static final int buttonA = 1;
    public static final int buttonB = 2;
    public static final int buttonX = 3;
    public static final int buttonY = 4;
    public static final int lBumper = 5;
    public static final int rBumper = 6;

    //CONTROL METHOD
    public static Boolean enableGamepad = true;
    public static Boolean enableGyroDrive = false;

    //VISION CODE
    public static final double visionXThreshold = 2.0;
    public static final double visionYThreshold = 2.0;
    public static final double visionDistanceMax = 12.0;
    public static final double visionDistanceMin = .01;
    public static final double visionDistanceTarget = 2.85;
    public static final double visionDistanceThreshold = 0.8;

    //OTHER DECLARATIONS
    public static final double scaler = 1.0;
}