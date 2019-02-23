package frc.robot.subsystems;
import frc.robot.robotmain.*;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Elevator{
    public Elevator(){
        Double speed;
        if(Robot.oi.gamepad.getRawAxis(RobotMap.leftY) > GlobalVariables.joystickThreshold || Robot.oi.gamepad.getRawAxis(RobotMap.leftY) < -GlobalVariables.joystickThreshold){
            Robot.globalVariables.ElevatorBreak = true;
            Robot.globalVariables.elevatorTargetValue = Robot.oi.mLift1.getSelectedSensorPosition();
            Robot.oi.mLift1.set(ControlMode.PercentOutput, Robot.oi.gamepad.getRawAxis(RobotMap.leftY));
        } else {
            Robot.globalVariables.ElevatorBreak = false;
        }

        if(!Robot.globalVariables.ElevatorBreak){
            if(Robot.oi.mLift1.getSelectedSensorPosition()>Robot.globalVariables.elevatorTargetValue){
                speed = Robot.globalVariables.elevatorTargetValue/Robot.oi.mLift1.getSelectedSensorPosition();
                Robot.oi.mLift1.set(ControlMode.PercentOutput, -speed);
            }else {
                speed = Robot.oi.mLift1.getSelectedSensorPosition()/Robot.globalVariables.elevatorTargetValue;
                Robot.oi.mLift1.set(ControlMode.PercentOutput, speed);
            } 
        }
    }
}