package frc.robot.deprecated;
import frc.robot.robotmain.*;
import frc.robot.commands.*;

public class TrackTarget{
  public static DriveStraight driveStraight;
    public TrackTarget(){
      if (Robot.globalVariables.visionStage == 0) {
        Robot.oi.table.getEntry("pipeline").setNumber(0);      //SETS LIMELIGHT TO VISION MODE
        Robot.oi.table.getEntry("ledMode").setNumber(3);       //TURN LIMELIGHT LEDS ON
        Robot.oi.limelightX = Robot.oi.tx.getDouble(0.0);      //UPDATES VISION VALUES
        Robot.oi.limelightY = Robot.oi.ty.getDouble(0.0);      //UPDATES VISION VALUES
        Robot.oi.limelightArea = Robot.oi.ta.getDouble(0.0);   //UPDATES VISION VALUES
        Robot.oi.limelightTarget = Robot.oi.tv.getDouble(0.0); //UPDATES VISION VALUES
        double steeringAdjust = 0.0;
        double distanceAdjust = 0.0;
        double xOffset = -5;
        if(Robot.oi.limelightTarget != 0.0){  //IF ROBOT SEES TARGET
          //DISTANCE CALCULATIONS
          if(Robot.oi.limelightArea + GlobalVariables.visionDistanceThreshold < GlobalVariables.visionDistanceTarget) {          //IF ROBOT IS TOO FAR
              if(-.1*(Robot.oi.limelightArea - GlobalVariables.visionDistanceTarget) < 1){
                  distanceAdjust = (-.1*(Robot.oi.limelightArea - GlobalVariables.visionDistanceTarget));                        //DISTANCE CALCULATION
              } else {
                  distanceAdjust = 1;
              }
          } else if (Robot.oi.limelightArea - GlobalVariables.visionDistanceThreshold > GlobalVariables.visionDistanceTarget){    //IF ROBOT IS TOO CLOSE
              if(.1*(GlobalVariables.visionDistanceTarget - Robot.oi.limelightArea) > -1){
                  distanceAdjust = (.1*(GlobalVariables.visionDistanceTarget - Robot.oi.limelightArea));                          //DISTANCE CALCULATION
              } else {
                  distanceAdjust = -1;
              }
          }
          steeringAdjust = (Robot.oi.limelightX-xOffset)/20;     //STEERING CALCULATION        
          if(steeringAdjust > xOffset) {                         //IF X > 0
              Robot.oi.drive.tankDrive(distanceAdjust-steeringAdjust,distanceAdjust);
          } else {                                               //IF X < 0
              Robot.oi.drive.tankDrive(distanceAdjust,distanceAdjust+steeringAdjust);
          }
          if(steeringAdjust < .3 && steeringAdjust > -.3 && distanceAdjust < .3 && distanceAdjust > -.3){
              Robot.oi.gyro.reset();
              Robot.globalVariables.visionStage = 1;
          }
        } else {      //IF ROBOT DOES NOT SEE A TARGET
          Robot.oi.drive.tankDrive(0, 0);
        }   
      } else if(Robot.globalVariables.visionStage == 1){
        if(Robot.oi.ultrasonic.getVoltage() >= Robot.globalVariables.ultrasonicTarget){
         driveStraight = new DriveStraight(.5);
        }
      } else {
        Robot.oi.drive.tankDrive(0,0);
      }  
    }
}    