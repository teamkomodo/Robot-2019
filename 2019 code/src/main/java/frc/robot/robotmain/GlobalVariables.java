
package frc.robot.robotmain;

public class GlobalVariables {
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

    public static Boolean defaultDrivemode = false;       //FALSE FOR ARCADE, TRUE FOR TANK  
    public static Boolean enableGamepad = true;           //FALSE FOR JOYSTICKS, TRUE FOR GAMEPAD  
    public static Boolean enableGyroDrive = false;
    public Boolean ButtonFlag;         

    public static final double visionXThreshold = 2.0;
    public static final double visionYThreshold = 2.0;
    public static final double visionDistanceMax = 12.0;
    public static final double visionDistanceMin = .01;
    public static final double visionDistanceTarget = 10.0;
    public static final double visionDistanceThreshold = 0.8;
    public static final double scaler = 1.0;

    public GlobalVariables() {
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
        ultrasonicTarget = 0.4;
        oneFootLeftEncoder = 3825.25;
        oneFootRightEncoder = -3864.15;
        autonomousSpeed = 0.5;

        ButtonFlag = false;       
    }
}