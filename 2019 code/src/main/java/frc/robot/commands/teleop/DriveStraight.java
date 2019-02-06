package frc.robot.commands.teleop;
import frc.robot.robotmain.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveStraight
{
    boolean buttonFlag = false;
    public DriveStraight()
    {
           
        
        System.out.println("shivs my dad");
        Robot.globalVariables.calculatedX = Robot.oi.gyro.getAngleX()-Robot.globalVariables.xDrift;
        Robot.globalVariables.calculatedY = Robot.oi.gyro.getAngleY()-Robot.globalVariables.yDrift;
        Robot.globalVariables.calculatedZ = Robot.oi.gyro.getAngleZ()-Robot.globalVariables.zDrift; 

        SmartDashboard.putNumber("Actual-X", Robot.oi.gyro.getAngleX());
        SmartDashboard.putNumber("Actual-Y", Robot.oi.gyro.getAngleY());
        SmartDashboard.putNumber("Actual-Z", Robot.oi.gyro.getAngleZ());
        SmartDashboard.putNumber("Calculated-X", Robot.globalVariables.calculatedX);
        SmartDashboard.putNumber("Calculated-Y", Robot.globalVariables.calculatedY);
        SmartDashboard.putNumber("Calculated-Z", Robot.globalVariables.calculatedZ);
        straight(true);
    }

    public void straight(boolean aFlag)
    {
        buttonFlag=aFlag;
        if(buttonFlag)
        {
            Robot.oi.mleft.set(0.5);
            Robot.oi.mright.set(-0.5);
            
        }
    }
}
