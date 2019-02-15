package frc.robot.commands;
import frc.robot.robotmain.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard{
    public Dashboard() {
        //YOU CAN PUT GENERIC DEBUT STUFF IN HERE
        SmartDashboard.putNumber("Gyro Actual", Robot.oi.gyro.getAngle());
        SmartDashboard.putNumber("Gyro Calcualted", Robot.globalVariables.calculatedX);
        SmartDashboard.putBoolean("Line Sensor", Robot.oi.lineSensor.get());
        SmartDashboard.putNumber("Line Counter", Robot.globalVariables.lineFollowCounter);
        SmartDashboard.putNumber("Ultrasonic", Robot.oi.ultrasonic.getValue());
        SmartDashboard.putNumber("Vision Stage", Robot.globalVariables.ApproachTargetCounter);
        SmartDashboard.putBoolean("Vision Break", Robot.globalVariables.visionBreak);
        SmartDashboard.putNumber("Gyro 1", Robot.oi.gyro.getAngleZ());
        SmartDashboard.putNumber("Gyro 2", Robot.oi.gyro2.getAngle());
        SmartDashboard.putNumber("Left Y", Robot.oi.ljoystick.getRawAxis(RobotMap.joyY));
        SmartDashboard.putNumber("Right Y", Robot.oi.rjoystick.getRawAxis(RobotMap.joyY));
    }
}