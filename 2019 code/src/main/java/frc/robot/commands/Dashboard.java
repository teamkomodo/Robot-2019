package frc.robot.commands;
import frc.robot.robotmain.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Dashboard{
    public Dashboard() {
        //YOU CAN PUT GENERIC DEBUT STUFF IN HERE
       // Robot.oi.mLift1.changeControlMode(ControlMode.Position);
        SmartDashboard.putNumber("Gyro Actual", Robot.oi.gyro.getAngle());
        SmartDashboard.putNumber("Gyro Calcualted", Robot.globalVariables.calculatedX);
        SmartDashboard.putNumber("Lift Encoder", Robot.oi.mLift1.getSelectedSensorPosition());
        SmartDashboard.putNumber("Right Drive Encoder", Robot.oi.rmotor1.getSelectedSensorPosition());
        SmartDashboard.putNumber("Left Drive Encoder", Robot.oi.lmotor1.getSelectedSensorPosition());
        SmartDashboard.putBoolean("Line Sensor", Robot.oi.lineSensor.get());
        SmartDashboard.putNumber("Line Counter", Robot.globalVariables.lineFollowCounter);
        SmartDashboard.putNumber("Ultrasonic", Robot.oi.ultrasonic.getValue());
        SmartDashboard.putNumber("Vision Stage", Robot.globalVariables.ApproachTargetCounter);
        SmartDashboard.putBoolean("Vision Break", Robot.globalVariables.visionBreak);
        SmartDashboard.putNumber("Left Y", Robot.oi.ljoystick.getRawAxis(RobotMap.joyY));
        SmartDashboard.putNumber("Right Y", Robot.oi.rjoystick.getRawAxis(RobotMap.joyY));
        SmartDashboard.putNumber("Vision Stage", Robot.globalVariables.ApproachTargetCounter);
    }
}