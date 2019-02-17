package frc.robot.robotmain;

public class GlobalVariables {
    public static final double visionXThreshold = 2.0;
    public static final double visionYThreshold = 2.0;
    public static final double visionDistanceMax = 12.0;
    public static final double visionDistanceMin = .01;
    public static final double visionDistanceTarget = 7.0;
    public static final double visionDistanceThreshold = 0.8;
    public static final double joystickThreshold = 0.2;
    public static final double gyroThreshold = 15;
    public static final double scaler = 1.0;
    public double ultrasonicTarget;
    public double lineTarget;
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
    public double gyroDrift;                              
    public double visionStage;
    public double[] levelEncoderValues = {
        1.1,    //LEVEL 1
        2.2,    //LEVEL 2
        3.3,    //LEVEL 3
        4.4,    //LEVEL 4
        5.5,    //LEVEL 5
        6.6     //LEVEL 6
    };
    
    public static boolean hFlag = false;
    public static double count = 0;
    public static Boolean defaultDrivemode = false;       //FALSE FOR ARCADE, TRUE FOR TANK  
    public static Boolean enableGamepad = true;           //FALSE FOR JOYSTICKS, TRUE FOR GAMEPAD  
    public static Boolean enableGyroDrive = true;
    public boolean lineTrip = false;
    public boolean driverControl = true;
    public Boolean visionBreak;
    public Boolean ButtonFlag;        
    public Boolean visionFlag;  
    public Boolean[] buttonDone = {
        false,  //A
        false,  //B
        false,  //X
        false,  //Y
    };

    public int levelCounter = 1;
    public int lineFollowCounter = 0;
    public int ApproachTargetCounter = 1;
    public int controlMode;    
    
    public GlobalVariables() {
        debugcounter = 0.0;
        averageX = 0.0;
        averageY = 0.0;
        averageZ = 0.0;
        calculatedX = 0.0;
        calculatedY = 0.0;
        calculatedZ = 0.0;
        gyroDrift = -.015;
        visionStage = 0.0;
        ultrasonicTarget = 280;
        lineTarget = 450;
        oneFootLeftEncoder = 3825.25;
        oneFootRightEncoder = -3864.15;
        autonomousSpeed = 0.5;

        ButtonFlag = false;   
        visionFlag = false; 
        visionBreak = false; 
        controlMode = 0;  
    }
}
