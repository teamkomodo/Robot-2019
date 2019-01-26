package frc.robot.subsystems.auto;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.robotmain.*;
public class Autonomous{
    public double targetDistance = 10;      //THIS IS IN FEET
    private Boolean breakFlag = false;
    public Autonomous(){
        while(!breakFlag) {
        if(-Robot.oi.rmotor2.getSelectedSensorPosition() / -Robot.oi.oneFootRightEncoder*targetDistance < 100 && Robot.oi.lmotor.getSelectedSensorPosition() / Robot.oi.oneFootLeftEncoder*targetDistance < 100){
            if(-Robot.oi.rmotor2.getSelectedSensorPosition() / -Robot.oi.oneFootRightEncoder*targetDistance > Robot.oi.lmotor.getSelectedSensorPosition() / Robot.oi.oneFootLeftEncoder*targetDistance){
                Robot.oi.mleft.set(Robot.oi.autonomousSpeed -.3);
                Robot.oi.mright.set(-Robot.oi.autonomousSpeed +.1);            
            } else {
                Robot.oi.mleft.set(Robot.oi.autonomousSpeed +.1);
                Robot.oi.mright.set(-Robot.oi.autonomousSpeed -.3);
            }
        } else {
            Robot.oi.mleft.set(0);
            Robot.oi.mright.set(0);
            breakFlag = true;  
        }
        SmartDashboard.putNumber("Right Encoder", Robot.oi.rmotor2.getSelectedSensorPosition());
        SmartDashboard.putNumber("Left Encoder", Robot.oi.lmotor.getSelectedSensorPosition());
        SmartDashboard.putNumber("Left %", -Robot.oi.rmotor2.getSelectedSensorPosition() / -Robot.oi.oneFootRightEncoder*targetDistance);
        SmartDashboard.putNumber("Right %", Robot.oi.lmotor.getSelectedSensorPosition() / Robot.oi.oneFootLeftEncoder*targetDistance);
    }
    }   
}