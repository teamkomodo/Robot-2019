package frc.robot.commands;
import frc.robot.robotmain.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard{
    public Dashboard() {
        SmartDashboard.putNumber("Gyro 1", Robot.oi.gyro.getAngleZ());
        SmartDashboard.putNumber("Gyro 2", Robot.oi.gyro2.getAngle());
\        SmartDashboard.putNumber("Left Y", Robot.oi.ljoystick.getRawAxis(RobotMap.joyY));
        SmartDashboard.putNumber("Right Y", Robot.oi.rjoystick.getRawAxis(RobotMap.joyY));
    }
}