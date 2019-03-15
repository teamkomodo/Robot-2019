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
        double Scaler = .9;
        Robot.oi.gyro.reset();
        if(Robot.oi.limelightTarget != 0.0){  //IF ROBOT SEES TARGET
            if(Robot.oi.limelightArea + GlobalVariables.visionDistanceThreshold < distance) {          //IF ROBOT IS TOO FAR
                if(.1*(Robot.oi.limelightArea - distance) < Scaler){
                    distanceAdjust = (.1*(Robot.oi.limelightArea - distance));                         //DISTANCE CALCULATION
                } else {
                    distanceAdjust = -1;
                }
            } else if (Robot.oi.limelightArea - GlobalVariables.visionDistanceThreshold > distance){    //IF ROBOT IS TOO CLOSE
                if(-.1*(distance - Robot.oi.limelightArea) > -Scaler){
                    distanceAdjust = (-.1*(distance - Robot.oi.limelightArea));                         //DISTANCE CALCULATION
                } else {
                    distanceAdjust = 1;
                }
            }
            steeringAdjust = (Robot.oi.limelightX-xOffset)/20;     //STEERING CALCULATION   
         //   distanceAdjust = distanceAdjust*-1;
            distanceAdjust = distanceAdjust*Scaler;
            steeringAdjust = (Robot.oi.limelightX-xOffset)/10;     //STEERING CALCULATION (MIGHT NEED TO BE 20)  

            if(distanceAdjust < .3 && distanceAdjust > -.3){       //IF TOO CLOSE OR TOO FAR
                if(steeringAdjust*10 > .6){
                    steeringAdjust = .6;
                } else if(steeringAdjust*10 < -.6){                 //ADJUST STEERING CURVE FOR FINAL APPROACH
                    steeringAdjust = -.6;
                } else {
                    steeringAdjust = steeringAdjust*10;
                }
                Robot.oi.drive.arcadeDrive(distanceAdjust, steeringAdjust);
            } else {                                               //IF IN RANGE BUT X IS OFF
                Robot.oi.drive.arcadeDrive(distanceAdjust, steeringAdjust*.75);
            }
            if(Robot.oi.limelightX < 1 && Robot.oi.limelightX > -1 && distanceAdjust < .3 && distanceAdjust > -.3){
                Robot.globalVariables.visionBreak = true;          //BREAK VISION CODE
                Robot.globalVariables.ApproachTargetCounter = 2;
              } else {
                Robot.globalVariables.visionBreak = false;
              } 

        } else {//IF NO TARGET
            Robot.oi.drive.tankDrive(0, 0);
        }
    }
}