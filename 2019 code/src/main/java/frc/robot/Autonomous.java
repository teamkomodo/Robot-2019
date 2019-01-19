package frc.robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.*;
public class Autonomous{
    public double targetDistance = 10;      //THIS IS IN FEET
    public Autonomous(){
        if(-1*((Robot.oi.oneFootLeftEncoder*targetDistance) - Robot.oi.rslave.getSelectedSensorPosition()) > ((Robot.oi.oneFootRightEncoder*targetDistance) - Robot.oi.lmotor.getSelectedSensorPosition())){
            Robot.oi.mleft.set(Robot.oi.autonomousSpeed);
            Robot.oi.mright.set(-Robot.oi.autonomousSpeed + .1);            
        } else {
            Robot.oi.mleft.set(Robot.oi.autonomousSpeed + .1);
            Robot.oi.mright.set(-Robot.oi.autonomousSpeed);
        }
    }
}