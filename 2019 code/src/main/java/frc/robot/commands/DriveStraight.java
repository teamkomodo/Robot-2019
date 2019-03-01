package frc.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.robotmain.*;

public class DriveStraight{
    public DriveStraight(double speed){
            double steeringAdjust = 0;
            

            if((Robot.globalVariables.calculatedX)*.1 > speed) {
              steeringAdjust = speed;
            }else if ((Robot.globalVariables.calculatedX)*.1 < -speed) {
              steeringAdjust = -speed;
            } else {
              steeringAdjust = (Robot.globalVariables.calculatedX)*.1;
            }
            SmartDashboard.putNumber("Steeerroing Adj", steeringAdjust);

            if(Robot.globalVariables.calculatedX > 0){
              Robot.oi.drive.tankDrive(-speed,-speed+steeringAdjust);
            }else if (Robot.globalVariables.calculatedX < 0) {
              Robot.oi.drive.tankDrive(-speed-steeringAdjust,-speed);
              Robot.oi.gyro.reset();

            }
    }
}