package frc.robot.commands;
import frc.robot.robotmain.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TrackTarget{
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
          steeringAdjust = (Robot.oi.limelightX+7)/20;     //STEERING CALCULATION        
          if(steeringAdjust > -7) {                     //IF X > 0
              Robot.oi.drive.tankDrive(distanceAdjust-steeringAdjust,distanceAdjust);
          } else {                                     //IF X < 0
              Robot.oi.drive.tankDrive(distanceAdjust,distanceAdjust+steeringAdjust);
          }

          SmartDashboard.putNumber("steering adjust", steeringAdjust);
          SmartDashboard.putNumber("distance adjust", distanceAdjust);

          if(steeringAdjust < .3 && steeringAdjust > -.3 && distanceAdjust < .3 && distanceAdjust > -.3){
              Robot.oi.gyro.reset();
              Robot.globalVariables.visionStage = 1;
          }
        } else {      //IF ROBOT DOES NOT SEE A TARGET
          Robot.oi.mleft.set(0);
          Robot.oi.mright.set(0);
        }   
      } else if(Robot.globalVariables.visionStage == 1){
        if(Robot.oi.ultrasonic.getVoltage() >= Robot.globalVariables.ultrasonicTarget){
          double steeringAdjust = 0;
          Robot.globalVariables.calculatedZ = Robot.oi.gyro.getAngleZ()-Robot.globalVariables.zDrift;   //THE ONE WE CARE ABOUT
          if((Robot.globalVariables.calculatedZ)*.01 > .5) {
            steeringAdjust = .5;
          }else if ((Robot.globalVariables.calculatedZ)*.01 < -.5) {
            steeringAdjust = -.5;
          } else {
            steeringAdjust = (Robot.globalVariables.calculatedZ)*.005;
          }
          /*
          if(Robot.globalVariables.calculatedZ > 0){
            Robot.oi.drive.tankDrive(.5-steeringAdjust,.5);
          }else {
            Robot.oi.drive.tankDrive(.5,.5+steeringAdjust);
          }
          */
          Robot.oi.drive.tankDrive(.5,.53);
        }
      } else {
        Robot.oi.drive.tankDrive(0,0);
      }  
    }
}    