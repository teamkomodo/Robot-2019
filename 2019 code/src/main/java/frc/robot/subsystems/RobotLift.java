package frc.robot.subsystems;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.robotmain.*;

 //THIS NEEDS TO BACK UP A SET DISTACNE, RUN LIFT, AND DRIVE FORWARD
public class RobotLift{
    public RobotLift(){
       
 double targetDistance = -2;       //THIS IS IN FEET
 double targetBoi = .21; //sample
 double targetDistance2 = 1;


 {
    int stagecounter=1;
     switch(stagecounter){
        case 1:
            if(Robot.oi.rmotor1.getSelectedSensorPosition()>targetDistance*Robot.globalVariables.oneFootRightEncoder && Robot.oi.lmotor1.getSelectedSensorPosition()>targetDistance*Robot.globalVariables.oneFootLeftEncoder){
                Robot.oi.drive.tankDrive(-.6,-.6);
            } 
            else{
                Robot.oi.drive.tankDrive(0, 0);
                stagecounter++;
                break;
            }
            
           

        case 2:
            Robot.oi.rLift.set(.6);
            if(Robot.oi.rLift.getSelectedSensorPosition()<targetBoi){
                Robot.oi.rLift.set(.6);
            }
            else{
                Robot.oi.rLift.set(0); 

                stagecounter++;
                break;
            }
        
            if(Robot.globalVariables.rliftencoder/targetBoi>.5) {
                Robot.oi.drive.tankDrive(.6, .6);
            }
        case 3:
            if(Robot.oi.rmotor1.getSelectedSensorPosition()<targetDistance2*Robot.globalVariables.oneFootRightEncoder && Robot.oi.lmotor1.getSelectedSensorPosition()<targetDistance2*Robot.globalVariables.oneFootLeftEncoder ){
                Robot.oi.drive.tankDrive(.6, .6);  
            }
            else{
                Robot.oi.drive.tankDrive(0, 0);
                stagecounter++;
                break;
            }
        default:
                 Robot.oi.drive.tankDrive(0, 0);
    }
}
}
}
