
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
    public double gyroDrift;                              
    public double visionStage;

    public static Boolean defaultDrivemode = false;       //FALSE FOR ARCADE, TRUE FOR TANK  
    public static Boolean enableGamepad = true;           //FALSE FOR JOYSTICKS, TRUE FOR GAMEPAD  
    public static Boolean enableGyroDrive = true;
    public Boolean ButtonFlag;        
    public Integer controlMode;    
    public Boolean visionFlag;   
    
    //idk abut the encoder values. Placeholder values
    public double level1 = 0;  
    public double level2 = 30;
    public double level3 = 60;
    public double level4 = 90;
    public double level5 = 120;
    public double level6 = 150;
    public int levelCounter=0;
   

    public static final double visionXThreshold = 2.0;
    public static final double visionYThreshold = 2.0;
    public static final double visionDistanceMax = 12.0;
    public static final double visionDistanceMin = .01;
    public static final double visionDistanceTarget = 10.0;
    public static final double visionDistanceThreshold = 0.8;
    public static final double joystickThreshold = 0.5;

    public static final double scaler = 1.0;

    public GlobalVariables() {
        debugcounter = 0.0;
        averageX = 0.0;
        averageY = 0.0;
        averageZ = 0.0;
        calculatedX = 0.0;
        calculatedY = 0.0;
        calculatedZ = 0.0;
        gyroDrift = -.005;
        visionStage = 0.0;
        ultrasonicTarget = 0.4;
        oneFootLeftEncoder = 3825.25;
        oneFootRightEncoder = -3864.15;
        autonomousSpeed = 0.5;

        ButtonFlag = false;   
        visionFlag = false;  
        controlMode = 0;  
    }
}
