package frc.robot.commands;
import frc.robot.robotmain.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard{
    public Dashboard() {
        //YOU CAN PUT GENERIC DEBUT STUFF IN HERE
        SmartDashboard.putNumber("Gyro Actual", Robot.oi.gyro.getAngle());
        SmartDashboard.putNumber("Gyro Calcualted", Robot.globalVariables.calculatedX);
        SmartDashboard.putNumber("Left Drive Encoder", Robot.oi.lmotor1.getSelectedSensorPosition());
        SmartDashboard.putNumber("Right Drive Encoder", Robot.oi.rmotor1.getSelectedSensorPosition());
        SmartDashboard.putNumber("Elevator Encoder", Robot.oi.mLift1.getSelectedSensorPosition());
        SmartDashboard.putNumber("Elevator Position", Robot.globalVariables.levelCounter);
        SmartDashboard.putNumber("Limelight X", Robot.oi.limelightX);
        SmartDashboard.putBoolean("Line Sensor", Robot.oi.lineSensor.get());
        SmartDashboard.putNumber("Ultrasonic", Robot.oi.ultrasonic.getValue());
    }
}