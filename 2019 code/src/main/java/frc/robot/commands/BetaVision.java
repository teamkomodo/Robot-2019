package frc.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.robotmain.*;

public class BetaVision{
    public BetaVision(double distance, int pipeline){
        Robot.oi.table.getEntry("pipeline").setNumber(pipeline);      //SETS LIMELIGHT TO VISION MODE
        Robot.oi.table.getEntry("ledMode").setNumber(3);       //TURN LIMELIGHT LEDS ON
        Robot.oi.limelightX = Robot.oi.tx.getDouble(0.0);      //UPDATES VISION VALUES
        Robot.oi.limelightY = Robot.oi.ty.getDouble(0.0);      //UPDATES VISION VALUES
        Robot.oi.limelightArea = Robot.oi.ta.getDouble(0.0);   //UPDATES VISION VALUES
        Robot.oi.limelightTarget = Robot.oi.tv.getDouble(0.0); //UPDATES VISION VALUES
        double steeringAdjust = 0.0;
        double distanceAdjust = 0.0;
        double xOffset = 0;
        double Scaler = .6;
        Robot.oi.gyro.reset();
        if(Robot.oi.limelightTarget != 0.0){  //IF ROBOT SEES TARGET
            if(Robot.oi.limelightArea + GlobalVariables.visionDistanceThreshold < distance) {          //IF ROBOT IS TOO FAR
                if(.2*(Robot.oi.limelightArea - distance) < Scaler){
                    distanceAdjust = (.2*(Robot.oi.limelightArea - distance));                         //DISTANCE CALCULATION
                } else {
                    distanceAdjust = -1;
                }
            } else if (Robot.oi.limelightArea - GlobalVariables.visionDistanceThreshold > distance){    //IF ROBOT IS TOO CLOSE
                if(-.2*(distance - Robot.oi.limelightArea) > -Scaler){
                    distanceAdjust = (-.2*(distance - Robot.oi.limelightArea));                         //DISTANCE CALCULATION
                } else {
                    distanceAdjust = 1;
                }
            }
            steeringAdjust = (Robot.oi.limelightX-xOffset)/20;     //STEERING CALCULATION   
         //   distanceAdjust = distanceAdjust*-1;
            distanceAdjust = distanceAdjust*Scaler;
            steeringAdjust = (Robot.oi.limelightX-xOffset)/10;     //STEERING CALCULATION (MIGHT NEED TO BE 20)  

            if(distanceAdjust < .3 && distanceAdjust > -.3){       //IF TOO CLOSE OR TOO FAR
                if(steeringAdjust*6 > .4){
                    steeringAdjust = .4;
                } else if(steeringAdjust*6 < -.4){                 //ADJUST STEERING CURVE FOR FINAL APPROACH
                    steeringAdjust = -.4;
                } else {
                    steeringAdjust = steeringAdjust*6;
                }
                Robot.oi.drive.arcadeDrive(distanceAdjust, -steeringAdjust);
            } else {                                               //IF IN RANGE BUT X IS OFF
                Robot.oi.drive.arcadeDrive(distanceAdjust, -steeringAdjust*.65);
            }
            if(Robot.oi.limelightX < 1 && Robot.oi.limelightX > -1 && distanceAdjust < .1 && distanceAdjust > -.1){
                if(Robot.oi.visionTimer.get() > 1){
                    Robot.globalVariables.visionBreak = true;          //BREAK VISION CODE
                    Robot.globalVariables.ApproachTargetCounter = 2;
                }
              } else {
                Robot.globalVariables.visionBreak = false;
                Robot.oi.visionTimer.reset();
              } 

        } else {//IF NO TARGET
            Robot.oi.drive.tankDrive(0, 0);
        }
    }
}