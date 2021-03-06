package frc.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.robotmain.*;

public class Vision{
    public Vision(double distance, int pipeline){
        Robot.oi.table.getEntry("pipeline").setNumber(pipeline);      //SETS LIMELIGHT TO VISION MODE
        Robot.oi.table.getEntry("ledMode").setNumber(3);       //TURN LIMELIGHT LEDS ON
        Robot.oi.limelightX = Robot.oi.tx.getDouble(0.0);      //UPDATES VISION VALUES
        Robot.oi.limelightY = Robot.oi.ty.getDouble(0.0);      //UPDATES VISION VALUES
        Robot.oi.limelightArea = Robot.oi.ta.getDouble(0.0);   //UPDATES VISION VALUES
        Robot.oi.limelightTarget = Robot.oi.tv.getDouble(0.0); //UPDATES VISION VALUES
        double steeringAdjust = 0.0;
        double distanceAdjust = 0.0;
        double xOffset = 1;
        double Scaler = .8;         //was .6
        double yDeadzone = 10;
        Robot.oi.gyro.reset();
        if(Robot.oi.limelightTarget != 0.0){  //IF ROBOT SEES TARGET
          //DISTANCE CALCULATIONS
          if(Robot.oi.limelightArea + GlobalVariables.visionDistanceThreshold < distance) {          //IF ROBOT IS TOO FAR
              if(.1*(Robot.oi.limelightArea - distance) < Scaler){
                  distanceAdjust = (.1*(Robot.oi.limelightArea - distance));                        //DISTANCE CALCULATION
              } else {
                  distanceAdjust = -1;
              }
          } else if (Robot.oi.limelightArea - GlobalVariables.visionDistanceThreshold > distance){    //IF ROBOT IS TOO CLOSE
              if(-.1*(distance - Robot.oi.limelightArea) > -Scaler){
                  distanceAdjust = (-.1*(distance - Robot.oi.limelightArea));                          //DISTANCE CALCULATION
              } else {
                  distanceAdjust = 1;
              }
          }
          //distanceAdjust = 1-distanceAdjust;
          steeringAdjust = (Robot.oi.limelightX-xOffset)/17;     //STEERING CALCULATION   
       //   distanceAdjust = distanceAdjust*-1;
          distanceAdjust = distanceAdjust*Scaler;
          
          SmartDashboard.putNumber("Steering Adjust", steeringAdjust);
          SmartDashboard.putNumber("Distance Adjust", distanceAdjust);

          if(Robot.oi.limelightY - yDeadzone > 0){
              if(Robot.oi.limelightY * .25 > .8){
                  Robot.oi.mLift1.set(-.8);
              } else {
                  Robot.oi.mLift1.set(-Robot.oi.limelightY * .25);
              }
          } else if(Robot.oi.limelightY + yDeadzone < 0){
              Robot.oi.mLift1.set(.2);
          } else if(Robot.oi.limelightY + yDeadzone > 0 && Robot.oi.limelightY - yDeadzone < 0) {
              Robot.oi.mLift1.set(-.11);
          }

          if(steeringAdjust > xOffset) {                         //IF X > 0
              Robot.oi.drive.tankDrive(distanceAdjust, distanceAdjust+steeringAdjust);
          } else {                                               //IF X < 0
              Robot.oi.drive.tankDrive(distanceAdjust-steeringAdjust ,distanceAdjust);
          }
          if(steeringAdjust < .27 && steeringAdjust > -.27 && distanceAdjust < .3 && distanceAdjust > -.3){
            Robot.globalVariables.visionBreak = true;
            Robot.globalVariables.ApproachTargetCounter = 2;
          } else {
            Robot.globalVariables.visionBreak = false;
          } 
        } else {      //IF ROBOT DOES NOT SEE A TARGET
          Robot.oi.drive.tankDrive(0, 0);
          Robot.oi.mLift1.set(0);
        }   
    }
}    