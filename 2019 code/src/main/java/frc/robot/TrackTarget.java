package frc.robot;
import frc.robot.*;

public class TrackTarget{
    public void startTracking(){
        //UPDATES VISION VALUES
        Robot.oi.limelightX = Robot.oi.tx.getDouble(0.0);
        Robot.oi.limelightY = Robot.oi.ty.getDouble(0.0);
        Robot.oi.limelightArea = Robot.oi.ta.getDouble(0.0);
        Robot.oi.limelightTarget = Robot.oi.tv.getDouble(0.0);
        //LOOKS FOR A TARGET
        if(Robot.oi.limelightTarget != 0.0){
          //DETECTS IF TARGET IS IN RANGE
          if(Robot.oi.limelightArea > RobotMap.visionDistanceMin && Robot.oi.limelightArea < RobotMap.visionDistanceMax){
            //DETECTS WHERE THE TARGET IS ON X AXIS
            if(Robot.oi.limelightX - RobotMap.visionXThreshold > 0){
              Robot.oi.mleft.set(-.50);
              Robot.oi.mright.set(-.50);
            }
            if(Robot.oi.limelightX + RobotMap.visionXThreshold < 0){
              Robot.oi.mleft.set(.50);
              Robot.oi.mright.set(.50);
            }
          } else {
            //DISABLES MOTORS IF IT DOES NOT FIND A TARGET
            Robot.oi.mleft.set(0);
            Robot.oi.mright.set(0);
          }
        }
    }
}
