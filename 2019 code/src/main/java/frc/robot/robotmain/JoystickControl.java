package frc.robot.robotmain;
import frc.robot.robotmain.*;
import frc.robot.commands.*;
import frc.robot.deprecated.TrackTarget;
import frc.robot.subsystems.*;

public class JoystickControl{
    public ApproachTarget approachTarget;
    public StationaryGyroCorrect gyroCode;
    public JoystickControl(){
        //MANIPULATOR
        Robot.oi.bManipulator.set(Robot.oi.gamepad.getRawAxis(RobotMap.leftY));
        //BUTTON FLAG
        /*
        if(Robot.oi.ljoystick.getRawButton(RobotMap.lTrigger) && !Robot.globalVariables.ButtonFlag){
            Robot.globalVariables.visionFlag = !Robot.globalVariables.visionFlag;
            Robot.globalVariables.ButtonFlag = true;
        }
        if(!Robot.oi.ljoystick.getRawButton(RobotMap.lTrigger)){
            Robot.globalVariables.ButtonFlag = false;
        }
        */
        //VISION CHECK
        if(!Robot.globalVariables.visionFlag){
            Robot.oi.table.getEntry("pipeline").setNumber(1);
            Robot.oi.table.getEntry("ledMode").setNumber(2);
            if(Robot.globalVariables.driverControl){
                Robot.oi.drive.tankDrive(Robot.oi.ljoystick.getRawAxis(RobotMap.joyY)*GlobalVariables.scaler, Robot.oi.rjoystick.getRawAxis(RobotMap.joyY)*GlobalVariables.scaler);
            }
            gyroCode = new StationaryGyroCorrect();
        } else {
            approachTarget = new ApproachTarget(GlobalVariables.visionDistanceTarget);
        }
    }
}