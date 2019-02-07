package frc.robot.subsystems.auto;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.robotmain.*;
public class Autonomous{
    public double targetDistance = 10;      //THIS IS IN FEET
    private Boolean breakFlag = false;
    public Autonomous(){
        while(!breakFlag) {
        if(-Robot.oi.rtmotor2.getSelectedSensorPosition() / -Robot.globalVariables.oneFootRightEncoder*targetDistance < 100 && Robot.oi.lmotor.getSelectedSensorPosition() / Robot.globalVariables.oneFootLeftEncoder*targetDistance < 100){
            if(-Robot.oi.rtmotor2.getSelectedSensorPosition() / -Robot.globalVariables.oneFootRightEncoder*targetDistance > Robot.oi.lmotor.getSelectedSensorPosition() / Robot.globalVariables.oneFootLeftEncoder*targetDistance){
                Robot.oi.mleft.set(Robot.globalVariables.autonomousSpeed -.3);
                Robot.oi.mright.set(-Robot.globalVariables.autonomousSpeed +.1);            
            } else {
                Robot.oi.mleft.set(Robot.globalVariables.autonomousSpeed +.1);
                Robot.oi.mright.set(-Robot.globalVariables.autonomousSpeed -.3);
            }
        } else {
            Robot.oi.mleft.set(0);
            Robot.oi.mright.set(0);
            breakFlag = true;  
        }
        SmartDashboard.putNumber("Right Encoder", Robot.oi.rtmotor2.getSelectedSensorPosition());
        SmartDashboard.putNumber("Left Encoder", Robot.oi.ltmotor.getSelectedSensorPosition());
        SmartDashboard.putNumber("Left %", -Robot.oi.rtmotor2.getSelectedSensorPosition() / -Robot.globalVariables.oneFootRightEncoder*targetDistance);
        SmartDashboard.putNumber("Right %", Robot.oi.ltmotor.getSelectedSensorPosition() / Robot.globalVariables.oneFootLeftEncoder*targetDistance);
    }
    }   
}