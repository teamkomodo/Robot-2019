package frc.robot.commands;
import frc.robot.robotmain.*;
import frc.robot.subsystems.HatchManipulator;
import frc.robot.commands.*;
import frc.robot.robotmain.*;

public class ApproachCargo{
    public static Vision vision;
    public static DriveStraight driveStraight;
    public static LineFollow lineFollow;
    public static HatchManipulator hatchManipulator;

    public ApproachCargo(double distance, double speed){               //PASS IN TARGET DISTANCE (% OF LIMELIGHT IMAGE) AND FINAL APPROACH SPEED
        if(Robot.globalVariables.ApproachTargetCounter == 1){       
            Robot.globalVariables.driverControl = false;                                                                    //USE VISION TO GO TO TARGET
            vision = new Vision(GlobalVariables.visionDistanceTarget, 3);
        }else if (Robot.globalVariables.ApproachTargetCounter == 2){
            if(Robot.oi.ljoystick.getRawButton(RobotMap.lTrigger)){
                driveStraight = new DriveStraight(speed);
                Robot.oi.bManipulator.set(-.7);
            }else{
                Robot.oi.bManipulator.set(0);
                Robot.globalVariables.driverControl = true;
            }
        }
    }
}