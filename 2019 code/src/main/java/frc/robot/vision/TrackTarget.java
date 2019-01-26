package frc.robot.vision;
import frc.robot.robotMain.*;

public class TrackTarget{
    public TrackTarget(){
      
      //SETS LIMELIGHT TO VISION MODE
      Robot.oi.table.getEntry("pipeline").setNumber(0);

      //TURN LIMELIGHT LEDS ON
      Robot.oi.table.getEntry("ledMode").setNumber(3);

      //UPDATES VISION VALUES
      Robot.oi.limelightX = Robot.oi.tx.getDouble(0.0);
      Robot.oi.limelightY = Robot.oi.ty.getDouble(0.0);
      Robot.oi.limelightArea = Robot.oi.ta.getDouble(0.0);
      Robot.oi.limelightTarget = Robot.oi.tv.getDouble(0.0);

      //CALCULATES DISTANCE SCALERS
      if(Robot.oi.limelightArea + RobotMap.visionDistanceThreshold < RobotMap.visionDistanceTarget) {
        Robot.oi.visionDistanceScaler = 1- (Robot.oi.limelightArea / (RobotMap.visionDistanceTarget*2));
      } else if(Robot.oi.limelightArea - RobotMap.visionDistanceThreshold > RobotMap.visionDistanceTarget) {
        Robot.oi.visionDistanceScaler = Robot.oi.limelightArea / (RobotMap.visionDistanceTarget*2);
      }

      //CALCULATES HORIZONTAL SCALERS
      if(Robot.oi.limelightX >= 20.0){
        Robot.oi.visionXScaler = 0.7;
      } else if(Robot.oi.limelightX <= -20.0){
        Robot.oi.visionXScaler = -0.7;
      } else {
        Robot.oi.visionXScaler = Robot.oi.limelightX / 30;
      }
      //LOOKS FOR A TARGET
      if(Robot.oi.limelightTarget != 0.0){
        //DETECTS IF TARGET IS IN RANGE
        if(Robot.oi.limelightArea > RobotMap.visionDistanceMin && Robot.oi.limelightArea < RobotMap.visionDistanceMax){
          //DETECTS WHERE THE TARGET IS ON X AXIS
          if(Robot.oi.limelightX - RobotMap.visionXThreshold > 0 && Robot.oi.limelightArea + RobotMap.visionDistanceThreshold < RobotMap.visionDistanceTarget){
            //IF X > 0 AND ROBOT IS TOO CLOSE
            Robot.oi.adjustedLeft = ((-Robot.oi.visionXScaler) + (Robot.oi.visionDistanceScaler))/2;
            Robot.oi.adjustedRight = ((-Robot.oi.visionXScaler)+ (-Robot.oi.visionDistanceScaler))/2;
          }
          else if(Robot.oi.limelightX + RobotMap.visionXThreshold < 0 && Robot.oi.limelightArea + RobotMap.visionDistanceThreshold < RobotMap.visionDistanceTarget){
            //IF X < 0 AND ROBOT IS TOO CLOSE
            Robot.oi.adjustedLeft = ((-Robot.oi.visionXScaler) + (Robot.oi.visionDistanceScaler))/2;
            Robot.oi.adjustedRight = ((-Robot.oi.visionXScaler)+ (-Robot.oi.visionDistanceScaler))/2;
          }
          else if(Robot.oi.limelightX - RobotMap.visionXThreshold > 0 && Robot.oi.limelightArea - RobotMap.visionDistanceThreshold > RobotMap.visionDistanceTarget){
            //IF X > 0 AND ROBOT IS TOO FAR
            Robot.oi.adjustedLeft = ((-Robot.oi.visionXScaler) + (-Robot.oi.visionDistanceScaler))/2;
            Robot.oi.adjustedRight = ((-Robot.oi.visionXScaler)+ (Robot.oi.visionDistanceScaler))/2;
          }
          else if(Robot.oi.limelightX + RobotMap.visionXThreshold < 0 && Robot.oi.limelightArea - RobotMap.visionDistanceThreshold > RobotMap.visionDistanceTarget){
            //IF X < 0 AND ROBOT IS TOO FAR
            Robot.oi.adjustedLeft = ((-Robot.oi.visionXScaler) + (-Robot.oi.visionDistanceScaler))/2;
            Robot.oi.adjustedRight = ((-Robot.oi.visionXScaler)+ (Robot.oi.visionDistanceScaler))/2;
          } else if(Robot.oi.limelightX - RobotMap.visionXThreshold > 0 && Robot.oi.limelightArea + RobotMap.visionDistanceThreshold > RobotMap.visionDistanceTarget && Robot.oi.limelightArea + RobotMap.visionDistanceThreshold > RobotMap.visionDistanceTarget){
            //IF X > 0 AND DISTANCE IS RIGHT
            Robot.oi.adjustedLeft = -Robot.oi.visionXScaler;
            Robot.oi.adjustedRight = -Robot.oi.visionXScaler;
          } else if(Robot.oi.limelightX + RobotMap.visionXThreshold < 0 && Robot.oi.limelightArea + RobotMap.visionDistanceThreshold > RobotMap.visionDistanceTarget && Robot.oi.limelightArea + RobotMap.visionDistanceThreshold > RobotMap.visionDistanceTarget){
            //IF X < 0 AND DISTANCE IS RIGHT
            Robot.oi.adjustedLeft = -Robot.oi.visionXScaler;
            Robot.oi.adjustedRight = -Robot.oi.visionXScaler;
          } else if(Robot.oi.limelightX + RobotMap.visionXThreshold > 0 && Robot.oi.limelightX - RobotMap.visionXThreshold < 0 && Robot.oi.limelightArea + RobotMap.visionDistanceThreshold < RobotMap.visionDistanceTarget){
            //IF X IS GOOD AND DISTANCE IS TOO CLOSE
            Robot.oi.adjustedLeft = Robot.oi.visionDistanceScaler;
            Robot.oi.adjustedRight = -Robot.oi.visionDistanceScaler;
          } else if(Robot.oi.limelightX + RobotMap.visionXThreshold > 0 && Robot.oi.limelightX - RobotMap.visionXThreshold < 0 && Robot.oi.limelightArea - RobotMap.visionDistanceThreshold > RobotMap.visionDistanceTarget){
            //IF X IS GOOD AND DISTANCE IS TOO FAR
            Robot.oi.adjustedLeft = -Robot.oi.visionDistanceScaler;
            Robot.oi.adjustedRight = Robot.oi.visionDistanceScaler;
          } else if (Robot.oi.limelightX + RobotMap.visionXThreshold > 0 && Robot.oi.limelightX - RobotMap.visionXThreshold < 0 && Robot.oi.limelightArea + RobotMap.visionDistanceThreshold > RobotMap.visionDistanceTarget && Robot.oi.limelightArea + RobotMap.visionDistanceThreshold > RobotMap.visionDistanceTarget){
            //IF DISTANCE AND X ARE GOOD
            Robot.oi.adjustedLeft = 0;
            Robot.oi.adjustedRight = 0;          
          } 
          //SETS MOTORS TO CALCULATED VALUES TO FOLLOW TARGET
          Robot.oi.mleft.set(Robot.oi.adjustedLeft);
          Robot.oi.mright.set(Robot.oi.adjustedRight);
        } else {
          //DISABLES MOTORS IF TARGET IS OUT OF RANGE
          Robot.oi.mleft.set(0);
          Robot.oi.mright.set(0);
        }
      } else {
        //DISABLES MOTORS IF IT DOES NOT FIND A TARGET
        Robot.oi.mleft.set(0);
        Robot.oi.mright.set(0);
      }
      //LOOKS FOR A TARGET
      if(Robot.oi.limelightTarget != 0.0){
        //DETECTS IF TARGET IS IN RANGE
        if(Robot.oi.limelightArea > RobotMap.visionDistanceMin && Robot.oi.limelightArea < RobotMap.visionDistanceMax){
       // if 
    }
  }
}
}
 
    
