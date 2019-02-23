package frc.robot.commands;
import frc.robot.robotmain.*;

public class Elevator{
    public Elevator(){
        if(Robot.globalVariables.ButtonXflag = false){
            if(Robot.oi.gamepad.getRawButton(RobotMap.buttonX)){
                Robot.globalVariables.levelCounter++;
                Robot.globalVariables.ButtonXflag = true;
                Robot.globalVariables.elevatortarget = Robot.globalVariables.levelEncoderValues[Robot.globalVariables.levelCounter];
            }
        }
        if(Robot.globalVariables.ButtonYflag = false){
            if(Robot.oi.gamepad.getRawButton(RobotMap.buttonY)){
                Robot.globalVariables.levelCounter--;
                Robot.globalVariables.ButtonYflag = true;
                Robot.globalVariables.elevatortarget = Robot.globalVariables.levelEncoderValues[Robot.globalVariables.levelCounter];
            }
        }
        if(Robot.oi.gamepad.getRawAxis(RobotMap.leftY) > .2 || Robot.oi.gamepad.getRawAxis(RobotMap.leftY) < -.2 ){
            Robot.globalVariables.elevatortarget = Robot.oi.mLift1.getSelectedSensorPosition();
            Robot.globalVariables.ElevatorFlag = true;
        }
        if(Robot.oi.mLift1.getSelectedSensorPosition() <= Robot.globalVariables.levelEncoderValues[6]&& Robot.oi.mLift1.getSelectedSensorPosition() >=  Robot.globalVariables.levelEncoderValues[0]){
            if(Robot.globalVariables.ElevatorFlag  = false){
                if(Robot.globalVariables.elevatortarget <  Robot.oi.mLift1.getSelectedSensorPosition()){
                    Robot.oi.mLift1.set(Robot.globalVariables.levelEncoderValues[Robot.globalVariables.levelCounter] % Robot.oi.mLift1.getSelectedSensorPosition());
                }else if(Robot.globalVariables.elevatortarget >  Robot.oi.mLift1.getSelectedSensorPosition()){
                    Robot.oi.mLift1.set(Robot.globalVariables.levelEncoderValues[Robot.globalVariables.levelCounter] % -Robot.oi.mLift1.getSelectedSensorPosition());
                }
            }else if(Robot.globalVariables.ElevatorFlag){
                Robot.oi.mLift1.set(Robot.oi.gamepad.getRawAxis(RobotMap.leftY));
            }
        }

    }
}      