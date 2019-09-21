package frc.robot.robotmain;
import frc.robot.robotmain.*;
import frc.robot.commands.*;
import frc.robot.commands.Elevator;
import frc.robot.subsystems.*;

public class JoystickControl{
    public ApproachTarget approachTarget;
    public ApproachCargo approachCargo;
    public StationaryGyroCorrect gyroCode;
    public Elevator elevator;
    public BetaVision betaVision;
    public DriveStraight driveStraight;
    public Vision vision;
    public JoystickControl(){
    }
    public void autoJoystick(){
        if(!GlobalVariables.demoMode[0]){                                           //if not in demo mode
            Robot.globalVariables.driveScaler = 1;
            Robot.globalVariables.elevatorUpScaler = .9;
            Robot.globalVariables.elevatorDownScaler = .3;
        } else if (GlobalVariables.demoMode[0] && !GlobalVariables.demoMode[6]){    //if in demo mode but robot is fast
            Robot.globalVariables.driveScaler = 1;
            Robot.globalVariables.elevatorUpScaler = .9;
            Robot.globalVariables.elevatorDownScaler = .3;
        } else {                                                                    //if in demo mode but robot is slow
            Robot.globalVariables.driveScaler = .5;
            Robot.globalVariables.elevatorUpScaler = .45;
            Robot.globalVariables.elevatorDownScaler = .15;
        }

        //MANIPULATOR
        //Robot.oi.bManipulator.set(Robot.oi.gamepad.getRawAxis(RobotMap.leftY));
        Robot.oi.bManipulator.set(Robot.oi.gamepad.getRawAxis(RobotMap.rightY)*-.75);

        //ELEVATOR CODE
        Robot.globalVariables.calculatedX = Robot.oi.gyro.getAngle()+Robot.globalVariables.gyroDrift;

        if(!GlobalVariables.demoMode[0]){
            elevator = new Elevator();
        } else if(GlobalVariables.demoMode[3]){
            elevator = new Elevator();
        }

        //BUTTON FLAG
        if(Robot.oi.rjoystick.getRawButton(RobotMap.rTrigger) && !Robot.globalVariables.ButtonFlag){
            Robot.globalVariables.visionFlag = !Robot.globalVariables.visionFlag;
            if(Robot.globalVariables.visionFlag){                   //VISION INIT STUFF
                Robot.oi.table.getEntry("pipeline").setNumber(0);   //SET LIMELIGHT PIPELINE
                Robot.oi.table.getEntry("ledMode").setNumber(3);    //TURN ON LIMELIGHT LEDS
                Robot.globalVariables.ApproachTargetCounter = 1;    //TAKE DRIVER CONTROLS AWAY
                Robot.globalVariables.driverControl = false;
            } else
                Robot.oi.table.getEntry("pipeline").setNumber(1);   //SET LIMELIGHT PIPELINE
                Robot.oi.table.getEntry("ledMode").setNumber(1);    //TURN ON LIMELIGHT LEDS
                Robot.globalVariables.driverControl = true;
                Robot.globalVariables.ButtonFlag = true;
        }
        //Hatch Trigger
        if(!Robot.oi.rjoystick.getRawButton(RobotMap.rTrigger)){
            Robot.globalVariables.ButtonFlag = false;
        }

        //VISION CHECK
        if(!Robot.globalVariables.visionFlag && Robot.globalVariables.tankDrive){
            if(Robot.globalVariables.driverControl){
                Robot.oi.table.getEntry("pipeline").setNumber(1);   //SET LIMELINE PIPELINE
                Robot.oi.table.getEntry("ledMode").setNumber(1);    //TURN OFF LIMELIGHT LEDS
                if(!GlobalVariables.demoMode[0]){
                    if(Robot.globalVariables.direction==1) {
                        Robot.oi.drive.tankDrive(Robot.globalVariables.direction*Robot.oi.ljoystick.getRawAxis(RobotMap.joyY)*Robot.globalVariables.driveScaler, Robot.globalVariables.direction*Robot.oi.rjoystick.getRawAxis(RobotMap.joyY)*Robot.globalVariables.driveScaler);
                    }else{
                        Robot.oi.drive.tankDrive(Robot.globalVariables.direction*Robot.oi.rjoystick.getRawAxis(RobotMap.joyY)*Robot.globalVariables.driveScaler, Robot.globalVariables.direction*Robot.oi.ljoystick.getRawAxis(RobotMap.joyY)*Robot.globalVariables.driveScaler);
                    }
                    gyroCode = new StationaryGyroCorrect();
                } else {
                    Robot.oi.drive.tankDrive(Robot.oi.ljoystick.getRawAxis(RobotMap.joyY)*Robot.globalVariables.driveScaler, Robot.oi.rjoystick.getRawAxis(RobotMap.joyY)*Robot.globalVariables.driveScaler);
                    if(GlobalVariables.demoMode[1]){
                        gyroCode = new StationaryGyroCorrect();
                    }
                }
            }
        } else if(!Robot.globalVariables.visionFlag && !Robot.globalVariables.tankDrive) {
            if(Robot.globalVariables.driverControl){
                Robot.oi.table.getEntry("pipeline").setNumber(1);   //SET LIMELINE PIPELINE
                Robot.oi.table.getEntry("ledMode").setNumber(1);    //TURN OFF LIMELIGHT LEDS
                Robot.oi.drive.arcadeDrive(Robot.oi.rjoystick.getRawAxis(RobotMap.joyY), -Robot.oi.rjoystick.getRawAxis(RobotMap.joyX));
            }
            //gyroCode = new StationaryGyroCorrect();
        }else {
            vision = new Vision(10, 0);
            //approachTarget = new ApproachTarget(GlobalVariables.visionDistanceTarget, .6);
       }
    }
}