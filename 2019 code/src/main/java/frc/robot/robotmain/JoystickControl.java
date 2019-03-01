package frc.robot.robotmain;
import frc.robot.robotmain.*;
import frc.robot.commands.*;
import frc.robot.commands.Elevator;
import frc.robot.subsystems.*;

public class JoystickControl{
    public ApproachTarget approachTarget;
    public StationaryGyroCorrect gyroCode;
    public Elevator elevator;
    public DriveStraight driveStraight;
    public JoystickControl(){
    }
    public void autoJoystick(){
        //MANIPULATOR
        //Robot.oi.bManipulator.set(Robot.oi.gamepad.getRawAxis(RobotMap.leftY));

        //ELEVATOR CODE
        Robot.globalVariables.calculatedX = Robot.oi.gyro.getAngle()+Robot.globalVariables.gyroDrift;



      

        elevator =  new Elevator();
        
        
        
        //BUTTON FLAG
        if(Robot.oi.rjoystick.getRawButton(RobotMap.rTrigger) && !Robot.globalVariables.ButtonFlag){
            Robot.globalVariables.visionFlag = !Robot.globalVariables.visionFlag;
            if(Robot.globalVariables.visionFlag){                   //VISION INIT STUFF
                Robot.oi.table.getEntry("pipeline").setNumber(0);   //SET LIMELIGHT PIPELINE
                Robot.oi.table.getEntry("ledMode").setNumber(3);    //TURN ON LIMELIGHT LEDS
                Robot.globalVariables.ApproachTargetCounter = 1;    //TAKE DRIVER CONTROLS AWAY
                Robot.globalVariables.driverControl = false;
            }
            Robot.globalVariables.ButtonFlag = true;
        }
        if(!Robot.oi.rjoystick.getRawButton(RobotMap.rTrigger)){
            Robot.globalVariables.ButtonFlag = false;
        }
        
        //VISION CHECK
        if(!Robot.globalVariables.visionFlag && (Robot.globalVariables.tankDrive==true)){
            if(Robot.globalVariables.driverControl){
                Robot.oi.table.getEntry("pipeline").setNumber(1);   //SET LIMELINE PIPELINE
                Robot.oi.table.getEntry("ledMode").setNumber(1);    //TURN OFF LIMELIGHT LEDS
                Robot.oi.drive.tankDrive(Robot.oi.ljoystick.getRawAxis(RobotMap.joyY)*GlobalVariables.scaler, Robot.oi.rjoystick.getRawAxis(RobotMap.joyY)*GlobalVariables.scaler);
            }
            gyroCode = new StationaryGyroCorrect();
        } else if(!Robot.globalVariables.visionFlag && (Robot.globalVariables.tankDrive==false)) {
            if(Robot.globalVariables.driverControl){
                Robot.oi.table.getEntry("pipeline").setNumber(1);   //SET LIMELINE PIPELINE
                Robot.oi.table.getEntry("ledMode").setNumber(1);    //TURN OFF LIMELIGHT LEDS
                Robot.oi.drive.arcadeDrive(Robot.oi.rjoystick.getRawAxis(RobotMap.joyY), -Robot.oi.rjoystick.getRawAxis(RobotMap.joyX));
            }
            //gyroCode = new StationaryGyroCorrect();
        }else {
            approachTarget = new ApproachTarget(GlobalVariables.visionDistanceTarget, .4);
        }
    }
}