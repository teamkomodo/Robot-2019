package frc.robot.robotmain;
import frc.robot.robotmain.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class ButtonControl{
    public static HatchManipulator hatchManipulator;
    public static RobotLift robotLift;
    public static DriveStraight driveStraight;
    public static LineFollow lineFollow;
    public static ApproachTarget approachTarget;
    public static LiftDown liftDown;
    public static LiftUp liftUp;

    public ButtonControl(){
    }
    public void autoButtonControl(){
        Robot.globalVariables.controlMode = 0;
        if(Robot.oi.gamepad.getRawButton(RobotMap.rBumper))
        /*
        if(Robot.oi.rjoystick.getRawButton(RobotMap.rTrigger)){
            Robot.globalVariables.driverControl = true;
            //driveStraight = new DriveStraight(.5);
            lineFollow = new LineFollow();
        } 
        if(Robot.oi.gamepad.getRawButton(RobotMap.lBumper)){
            Robot.globalVariables.driverControl = false;
           // Robot.oi.drive.arcadeDrive(-Robot.oi.gamepad.getRawAxis(RobotMap.joyY), Robot.oi.gamepad.getRawAxis(RobotMap.joyX));
           liftdowntest = new LiftDownTest(0.5);
            } else { 
            Robot.oi.mLift1.set(0);
           // Robot.oi.mLift2.set(ControlMode.PercentOutput, 0);
            Robot.globalVariables.driverControl = true;
        }

      
        if(Robot.oi.gamepad.getRawAxis(RobotMap.leftY) != 0){
            lifttestjoystick = new LiftTestJoystick();
        }
        */            
        if(Robot.oi.gamepad.getRawButton(RobotMap.rBumper)){                //BALL MANIPULATOR TILT CONTROL
            Robot.oi.bManipulatortilt.set(ControlMode.PercentOutput, .5);
        } else if(Robot.oi.gamepad.getRawButton(RobotMap.lBumper)){
            Robot.oi.bManipulatortilt.set(ControlMode.PercentOutput, -.5);
        } else {
            Robot.oi.bManipulatortilt.set(ControlMode.PercentOutput, 0);
        }            
            
        if(Robot.oi.gamepad.getRawButton(RobotMap.buttonA)){
            Robot.globalVariables.buttonDone[0] = false;
            Robot.globalVariables.controlMode = 1;
        }
        if(Robot.oi.gamepad.getRawButton(RobotMap.buttonB)){
            Robot.globalVariables.ApproachTargetCounter = 1;
            //Robot.globalVariables.buttonDone[1] = false;
            Robot.globalVariables.controlMode = 2;
        }
        if(Robot.oi.gamepad.getRawButton(RobotMap.buttonX)){
            //Robot.globalVariables.buttonDone[2] = false;
            Robot.globalVariables.controlMode = 3;
        }
        if(Robot.oi.gamepad.getRawButton(RobotMap.buttonY)){
            Robot.globalVariables.buttonDone[3] = false;
            Robot.globalVariables.controlMode = 4;
        }
        
        if(Robot.globalVariables.controlMode == 2 ){     //B
            System.out.println(Robot.globalVariables.controlMode);
            hatchManipulator = new HatchManipulator(false);

        } else if(Robot.globalVariables.controlMode == 3 ){     //X
            //robotLift = new RobotLift();
            System.out.println(Robot.globalVariables.controlMode);
            hatchManipulator = new HatchManipulator(true);
        }
        else {
            System.out.println(Robot.globalVariables.controlMode);
            Robot.oi.hManipulator.set(0);
        }
        // }else if (Robot.globalVariables.buttonDone[1]){
        //     Robot.globalVariables.driverControl = true;
        //     Robot.oi.hManipulator.set(0);
        // }
    }
}
