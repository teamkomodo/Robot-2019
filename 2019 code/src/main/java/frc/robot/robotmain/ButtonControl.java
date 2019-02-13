package frc.robot.robotmain;
import frc.robot.robotmain.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class ButtonControl{
    public static HatchManipulator hatchManipulator;
    public static LiftUp liftUp;
    public static LiftDown liftDown;
    public static RobotLift robotLift;
    public static DriveStraight driveStraight;

    
    public ButtonControl(){

        if(Robot.oi.ljoystick.getRawButton(RobotMap.lTrigger)){
            driveStraight = new DriveStraight(1);
            Robot.globalVariables.driverControl = false;
        } else { 
            Robot.globalVariables.driverControl = true;
        }

        if(Robot.oi.rjoystick.getRawButton(RobotMap.rTrigger)){
            driveStraight = new DriveStraight(.5);
            Robot.globalVariables.driverControl = false;
        } else { 
            Robot.globalVariables.driverControl = true;
        }

        if(Robot.oi.gamepad.getRawButton(RobotMap.buttonA)){
            Robot.globalVariables.buttonDone[0] = false;
            Robot.globalVariables.controlMode = 1;
        }
        if(Robot.oi.gamepad.getRawButton(RobotMap.buttonB)){
            Robot.globalVariables.buttonDone[1] = false;
            Robot.globalVariables.controlMode = 2;
        }
        if(Robot.oi.gamepad.getRawButton(RobotMap.buttonX)){
            Robot.globalVariables.buttonDone[2] = false;
            Robot.globalVariables.controlMode = 3;
        }
        if(Robot.oi.gamepad.getRawButton(RobotMap.buttonY)){
            Robot.globalVariables.buttonDone[3] = false;
            Robot.globalVariables.controlMode = 4;
        }

        if(Robot.globalVariables.controlMode == 1 && !Robot.globalVariables.buttonDone[0]){     //A
            liftDown = new LiftDown();
        }
        if(Robot.globalVariables.controlMode == 2 && !Robot.globalVariables.buttonDone[1]){     //B
            hatchManipulator = new HatchManipulator();
        }
        if(Robot.globalVariables.controlMode == 3 && !Robot.globalVariables.buttonDone[2]){     //X
            robotLift = new RobotLift();
        }
        if(Robot.globalVariables.controlMode == 4 && !Robot.globalVariables.buttonDone[3]){     //Y
            liftUp = new LiftUp();
        }
    }
}
