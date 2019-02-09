package frc.robot.commands;
import frc.robot.robotmain.*;
import frc.robot.commands.*;

public class ApproachTarget{
    public static Vision vision;
    public static DriveStraight driveStraight;
    public static LineFollow lineFollow;

    int stagecounter = 1;
    public ApproachTarget(double distance){
        switch(stagecounter){
            case 1:
                if(!Robot.globalVariables.visionBreak){
                    vision = new Vision(distance);
                } else {
                    Robot.globalVariables.lineFollowCounter = 0;
                    stagecounter++;
                    break;
                }
            case 2:
                if(Robot.globalVariables.lineFollowCounter < 3){
                    lineFollow = new LineFollow();
                } else {
                    Robot.oi.gyro.reset();
                    stagecounter++;
                    break;
                }
            case 3:
            if(Robot.oi.ultrasonic.getVoltage() >= Robot.globalVariables.ultrasonicTarget){
                driveStraight = new DriveStraight(.5);
            } else {
                Robot.oi.drive.tankDrive(0,0);
                stagecounter++;
                break;
            }

            default:
                Robot.oi.drive.tankDrive(0,0);
            break;
        }
    }
}