package frc.robot.vision;
import frc.robot.robotmain.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class TrackTarget{
  public double targetDistance = 10;      //THIS IS IN FEET
    public TrackTarget(){
    
      //SETS LIMELIGHT TO VISION MODE
      Robot.oi.table.getEntry("pipeline").setNumber(0);

      //TURN LIMELIGHT LEDS ON
      Robot.oi.table.getEntry("ledMode").setNumber(3);

      SmartDashboard.putNumber("Ultrasonic", Robot.oi.ultrasonic.getVoltage());

      if(Robot.globalVariables.visionStage == 0){

          //UPDATES VISION VALUES
          Robot.oi.limelightX = Robot.oi.tx.getDouble(0.0);
          Robot.oi.limelightY = Robot.oi.ty.getDouble(0.0);
          Robot.oi.limelightArea = Robot.oi.ta.getDouble(0.0);
          Robot.oi.limelightTarget = Robot.oi.tv.getDouble(0.0);

          //CALCULATES DISTANCE SCALERS
          if(Robot.oi.limelightArea + GlobalVariables.visionDistanceThreshold < GlobalVariables.visionDistanceTarget) {
            Robot.globalVariables.visionDistanceScaler = 1- (Robot.oi.limelightArea / (GlobalVariables.visionDistanceTarget*1));    //THIS CAN BE A MINIMUM OF 1
          } else if(Robot.oi.limelightArea - GlobalVariables.visionDistanceThreshold > GlobalVariables.visionDistanceTarget) {
            Robot.globalVariables.visionDistanceScaler = Robot.oi.limelightArea / (GlobalVariables.visionDistanceTarget*1);         //THIS CAN BE A MINIMUM OF 1
          }

          //CALCULATES HORIZONTAL SCALERS
          if(Robot.oi.limelightX >= 20.0){
            Robot.globalVariables.visionXScaler = 1.0;
          } else if(Robot.oi.limelightX <= -20.0){
            Robot.globalVariables.visionXScaler = -1.0;
          } else {
            Robot.globalVariables.visionXScaler = Robot.oi.limelightX / 20;  //THIS CAN BE A MINIMUM OF 20
          }
          //LOOKS FOR A TARGET
          if(Robot.oi.limelightTarget != 0.0){
            //DETECTS IF TARGET IS IN RANGE
            if(Robot.oi.limelightArea > GlobalVariables.visionDistanceMin && Robot.oi.limelightArea < GlobalVariables.visionDistanceMax){
              //DETECTS WHERE THE TARGET IS ON X AXIS
              if(Robot.oi.limelightX - GlobalVariables.visionXThreshold > 0 && Robot.oi.limelightArea + GlobalVariables.visionDistanceThreshold < GlobalVariables.visionDistanceTarget){
                //IF X > 0 AND ROBOT IS TOO CLOSE
                Robot.globalVariables.adjustedLeft = ((-Robot.globalVariables.visionXScaler) + (Robot.globalVariables.visionDistanceScaler))/2;
                Robot.globalVariables.adjustedRight = ((-Robot.globalVariables.visionXScaler)+ (-Robot.globalVariables.visionDistanceScaler))/2;
              }
              else if(Robot.oi.limelightX + GlobalVariables.visionXThreshold < 0 && Robot.oi.limelightArea + GlobalVariables.visionDistanceThreshold < GlobalVariables.visionDistanceTarget){
                //IF X < 0 AND ROBOT IS TOO CLOSE
                Robot.globalVariables.adjustedLeft = ((-Robot.globalVariables.visionXScaler) + (Robot.globalVariables.visionDistanceScaler))/2;
                Robot.globalVariables.adjustedRight = ((-Robot.globalVariables.visionXScaler)+ (-Robot.globalVariables.visionDistanceScaler))/2;
              }
              else if(Robot.oi.limelightX - GlobalVariables.visionXThreshold > 0 && Robot.oi.limelightArea - GlobalVariables.visionDistanceThreshold > GlobalVariables.visionDistanceTarget){
                //IF X > 0 AND ROBOT IS TOO FAR
                Robot.globalVariables.adjustedLeft = ((-Robot.globalVariables.visionXScaler) + (-Robot.globalVariables.visionDistanceScaler))/2;
                Robot.globalVariables.adjustedRight = ((-Robot.globalVariables.visionXScaler)+ (Robot.globalVariables.visionDistanceScaler))/2;
              }
              else if(Robot.oi.limelightX + GlobalVariables.visionXThreshold < 0 && Robot.oi.limelightArea - GlobalVariables.visionDistanceThreshold > GlobalVariables.visionDistanceTarget){
                //IF X < 0 AND ROBOT IS TOO FAR
                Robot.globalVariables.adjustedLeft = ((-Robot.globalVariables.visionXScaler) + (-Robot.globalVariables.visionDistanceScaler))/2;
                Robot.globalVariables.adjustedRight = ((-Robot.globalVariables.visionXScaler)+ (Robot.globalVariables.visionDistanceScaler))/2;
              } else if(Robot.oi.limelightX - GlobalVariables.visionXThreshold > 0 && Robot.oi.limelightArea + GlobalVariables.visionDistanceThreshold > GlobalVariables.visionDistanceTarget && Robot.oi.limelightArea + GlobalVariables.visionDistanceThreshold > GlobalVariables.visionDistanceTarget){
                //IF X > 0 AND DISTANCE IS RIGHT
                Robot.globalVariables.adjustedLeft = -Robot.globalVariables.visionXScaler;
                Robot.globalVariables.adjustedRight = -Robot.globalVariables.visionXScaler;
              } else if(Robot.oi.limelightX + GlobalVariables.visionXThreshold < 0 && Robot.oi.limelightArea + GlobalVariables.visionDistanceThreshold > GlobalVariables.visionDistanceTarget && Robot.oi.limelightArea + GlobalVariables.visionDistanceThreshold > GlobalVariables.visionDistanceTarget){
                //IF X < 0 AND DISTANCE IS RIGHT
                Robot.globalVariables.adjustedLeft = -Robot.globalVariables.visionXScaler;
                Robot.globalVariables.adjustedRight = -Robot.globalVariables.visionXScaler;
              } else if(Robot.oi.limelightX + GlobalVariables.visionXThreshold > 0 && Robot.oi.limelightX - GlobalVariables.visionXThreshold < 0 && Robot.oi.limelightArea + GlobalVariables.visionDistanceThreshold < GlobalVariables.visionDistanceTarget){
                //IF X IS GOOD AND DISTANCE IS TOO CLOSE
                Robot.globalVariables.adjustedLeft = Robot.globalVariables.visionDistanceScaler;
                Robot.globalVariables.adjustedRight = -Robot.globalVariables.visionDistanceScaler;
              } else if(Robot.oi.limelightX + GlobalVariables.visionXThreshold > 0 && Robot.oi.limelightX - GlobalVariables.visionXThreshold < 0 && Robot.oi.limelightArea - GlobalVariables.visionDistanceThreshold > GlobalVariables.visionDistanceTarget){
                //IF X IS GOOD AND DISTANCE IS TOO FAR
                Robot.globalVariables.adjustedLeft = -Robot.globalVariables.visionDistanceScaler;
                Robot.globalVariables.adjustedRight = Robot.globalVariables.visionDistanceScaler;
              } else if (Robot.oi.limelightX + GlobalVariables.visionXThreshold > 0 && Robot.oi.limelightX - GlobalVariables.visionXThreshold < 0 && Robot.oi.limelightArea + GlobalVariables.visionDistanceThreshold > GlobalVariables.visionDistanceTarget && Robot.oi.limelightArea + GlobalVariables.visionDistanceThreshold > GlobalVariables.visionDistanceTarget){
                //IF DISTANCE AND X ARE GOOD
                  Robot.globalVariables.visionStage = 1.0;
              } 
              //SETS MOTORS TO CALCULATED VALUES TO FOLLOW TARGET
              Robot.oi.mleft.set(Robot.globalVariables.adjustedLeft);
              Robot.oi.mright.set(Robot.globalVariables.adjustedRight);
            } else {
              //DISABLES MOTORS IF TARGET IS OUT OF RANGE
              Robot.oi.mleft.set(0);
              Robot.oi.mright.set(0);
              Robot.oi.debugTimer.reset();
            }
          } else {
            //DISABLES MOTORS IF IT DOES NOT FIND A TARGET
            Robot.oi.mleft.set(0);
            Robot.oi.mright.set(0);
          }
  } else if (Robot.globalVariables.visionStage == 1.0){
    //ULTRASONIC CODE
    if(Robot.oi.ultrasonic.getVoltage() >= Robot.globalVariables.ultrasonicTarget){
      //DRIVE STRAIGHT CODE
      /*
      if(-Robot.oi.rmotor2.getSelectedSensorPosition() / -Robot.oi.oneFootRightEncoder*targetDistance > Robot.oi.lmotor.getSelectedSensorPosition() / Robot.oi.oneFootLeftEncoder*targetDistance){
          Robot.oi.mleft.set(Robot.oi.autonomousSpeed -.3);
          Robot.oi.mright.set((-Robot.oi.autonomousSpeed) +.1);            
      } else {
          Robot.oi.mleft.set(Robot.oi.autonomousSpeed +.1);
          Robot.oi.mright.set((-Robot.oi.autonomousSpeed) -.3);
      }
      */
      Robot.oi.mleft.set(.3);
      Robot.oi.mright.set(-.375); //was .4
    } else {
      //STOP IF WE ARE AT OUR TARGET
      Robot.oi.mleft.set(0);
      Robot.oi.mright.set(0);
    }
  }
}
}
 
    
