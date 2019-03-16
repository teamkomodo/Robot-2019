package frc.robot.commands;
import frc.robot.robotmain.*;
import frc.robot.subsystems.HatchManipulator;
import frc.robot.commands.*;
import frc.robot.robotmain.*;

public class ApproachTarget{
    public static Vision vision;
    public static DriveStraight driveStraight;
    public static LineFollow lineFollow;
    public static HatchManipulator hatchManipulator;
    public static BetaVision betaVision;

    public ApproachTarget(double distance, double speed){               //PASS IN TARGET DISTANCE (% OF LIMELIGHT IMAGE) AND FINAL APPROACH SPEED
        if(Robot.globalVariables.ApproachTargetCounter == 1){           //USE VISION TO GO TO TARGET
            betaVision = new BetaVision(GlobalVariables.visionDistanceTarget,0);
        }else if (Robot.globalVariables.ApproachTargetCounter == 2){
            /*
            if(Robot.oi.ultrasonic.getValue() >= Robot.globalVariables.ultrasonicTarget){
                driveStraight = new DriveStraight(.4);
                } else {
                Robot.globalVariables.ApproachTargetCounter++;
            }
            */
            Robot.globalVariables.ApproachTargetCounter++;
        }else if (Robot.globalVariables.ApproachTargetCounter == 3) {  //STOP THE ROBOT
            Robot.oi.drive.tankDrive(0, 0);
            Robot.globalVariables.ApproachTargetCounter++;
        }else if (Robot.globalVariables.ApproachTargetCounter == 4){
            hatchManipulator = new HatchManipulator(1000);
            Robot.globalVariables.ApproachTargetCounter++;
        } else if (Robot.globalVariables.ApproachTargetCounter == 5){   //GIVE THE DRIVER CONTROLS BACK
            Robot.globalVariables.driverControl = true;
            Robot.globalVariables.visionFlag = false;
        }
    }
}