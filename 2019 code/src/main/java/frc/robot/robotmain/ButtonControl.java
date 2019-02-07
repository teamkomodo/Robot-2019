package frc.robot.robotmain;
import frc.robot.robotmain.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class ButtonControl{
    public static HatchManipulator hatchManipulator;
    public static LiftUp liftUp;
    public static LiftDown liftDown;
    public static RobotLift robotLift;
    
    public ButtonControl(){

        if(Robot.oi.gamepad.getRawButton(RobotMap.buttonA)){Robot.globalVariables.controlMode = 1;}
        if(Robot.oi.gamepad.getRawButton(RobotMap.buttonB)){Robot.globalVariables.controlMode = 2;}
        if(Robot.oi.gamepad.getRawButton(RobotMap.buttonX)){Robot.globalVariables.controlMode = 3;}
        if(Robot.oi.gamepad.getRawButton(RobotMap.buttonY)){Robot.globalVariables.controlMode = 4;}

        if(Robot.globalVariables.controlMode == 1){     //A
            liftDown = new LiftDown();
        }
        if(Robot.globalVariables.controlMode == 2){     //B
            hatchManipulator = new HatchManipulator();
        }
        if(Robot.globalVariables.controlMode == 3){     //X
            robotLift = new RobotLift();
        }
        if(Robot.globalVariables.controlMode == 4){     //Y
            liftUp = new LiftUp();
        }
    }
}
