package frc.robot.commands;
import frc.robot.robotmain.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard{
    public Dashboard() {
        SmartDashboard.putNumber("Gyro Real", Robot.oi.gyro.getAngleZ());
        SmartDashboard.putNumber("Gyro Corrected", Robot.globalVariables.calculatedX);
        SmartDashboard.putNumber("Left Y", Robot.oi.ljoystick.getRawAxis(RobotMap.joyY));
        SmartDashboard.putNumber("Right Y", Robot.oi.rjoystick.getRawAxis(RobotMap.joyY));
    }
}