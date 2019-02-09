package frc.robot.subsystems;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.robotmain.*;

 //THIS NEEDS TO BACK UP A SET DISTACNE, RUN LIFT, AND DRIVE FORWARD
public class RobotLift{
    public RobotLift(){
       
 double targetDistance = -2;      //THIS IS IN FEET

 {
    int stagecounter=1;
     switch(stagecounter){
        case 1:
            if(-Robot.oi.rmotor1.getSelectedSensorPosition() / -Robot.globalVariables.oneFootRightEncoder*targetDistance < 100 && Robot.oi.lmotor1.getSelectedSensorPosition() / Robot.globalVariables.oneFootLeftEncoder*targetDistance < 100){
                if(-Robot.oi.rmotor1.getSelectedSensorPosition() / -Robot.globalVariables.oneFootRightEncoder*targetDistance > Robot.oi.lmotor1.getSelectedSensorPosition() / Robot.globalVariables.oneFootLeftEncoder*targetDistance){
                    Robot.oi.drive.tankDrive(Robot.globalVariables.autonomousSpeed -.3, -Robot.globalVariables.autonomousSpeed +.1);            
                } else {
                    Robot.oi.drive.tankDrive(Robot.globalVariables.autonomousSpeed +.1 , -Robot.globalVariables.autonomousSpeed -.3);
                }
            } else {
                Robot.oi.drive.tankDrive(0, 0);
            }
            stagecounter++;
            break;

            case 2:
            Robot.oi.rLift.set(.6);
            stagecounter++;
            break;

            case 3:
                 Robot.oi.drive.tankDrive(.6, .6);
                 stagecounter++;
                 break;

                 default:
                 Robot.oi.drive.tankDrive(0, 0);
    }
}
}
}
