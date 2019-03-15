package frc.robot.robotmain;
import frc.robot.robotmain.*;
import frc.robot.commands.*;
import frc.robot.commands.Elevator;
import frc.robot.subsystems.*;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class ButtonControl{
    public static HatchManipulator hatchManipulator;
    // public static RobotLift robotLift;
    public static DriveStraight driveStraight;
    public static LineFollow lineFollow;
    public static ApproachTarget approachTarget;
    public static Elevator elevator;

    public ButtonControl(){
    }
    public void autoButtonControl(){
        //Random Variables
        Robot.globalVariables.controlMode = 0;

        //Elevator
        elevator = new Elevator();    
        //Ball Manipulator
        Robot.oi.bManipulator.set(Robot.oi.gamepad.getRawAxis(RobotMap.rightY)*-.7);
        if(Robot.oi.gamepad.getRawButton(RobotMap.rBumper)){
            Robot.oi.bManipulatortilt.set(ControlMode.PercentOutput, (-.3));
        }else if(Robot.oi.gamepad.getRawButton(RobotMap.lBumper)){
            Robot.oi.bManipulatortilt.set(ControlMode.PercentOutput, (.3));
        }
        else{
            Robot.oi.bManipulatortilt.set(ControlMode.PercentOutput, (-.07));
        }


        //Hatch Manipulator
        if(Robot.globalVariables.controlMode == 2 ){     //B
            System.out.println(Robot.globalVariables.controlMode);
            hatchManipulator = new HatchManipulator(650);

        } //else if(Robot.globalVariables.controlMode == 3 ){     //X
        //     //robotLift = new RobotLift();
        //     System.out.println(Robot.globalVariables.controlMode);
        //     hatchManipulator = new HatchManipulator(true);
        // }
        else
        {
            System.out.println(Robot.globalVariables.controlMode);
            Robot.oi.hManipulator.set(0);
        }

        
        if(Robot.oi.hatchTimer.get() > 1 && !Robot.oi.gamepad.getRawButton(RobotMap.buttonB)){
            Robot.oi.hManipulator.set(0);
        } else if(Robot.oi.hatchTimer.get() < 1 && !Robot.oi.gamepad.getRawButton(RobotMap.buttonB)){
            Robot.oi.hManipulator.set(.6);
        } else if (Robot.oi.gamepad.getRawButton(RobotMap.buttonB)){
            Robot.oi.hManipulator.set(-.6);
            Robot.oi.hatchTimer.reset();
            Robot.oi.hatchTimer.start();
        }

        //Button Controls
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


        /*Unused code for now */


        // if(Robot.globalVariables.controlMode == 1 && !Robot.globalVariables.buttonDone[0]){     //A
        //     liftDown = new LiftDown();
        // }
        
        // }else if (Robot.globalVariables.buttonDone[1]){
        //     Robot.globalVariables.driverControl = true;
        //     Robot.oi.hManipulator.set(0);
        // }
        
        
       
        // if(Robot.globalVariables.controlMode == 4 && !Robot.globalVariables.buttonDone[3]){     //Y
        //     liftUp = new LiftUp();
        // } 
        
        // //RoboRaiser
        // if(Robot.oi.gamepad.getRawButton(RobotMap.rTrigger)){
        //     Robot.oi.rLift.set(.5);
        // } else if(Robot.oi.gamepad.getRawButton(RobotMap.lTrigger)){
        //     Robot.oi.rLift.set(-.5);
        // } else{
        //     Robot.oi.rLift.set(0);
        // }

    }
}
