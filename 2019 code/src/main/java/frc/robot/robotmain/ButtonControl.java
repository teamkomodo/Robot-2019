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

        //Ball Manipulator
        if(!GlobalVariables.demoMode[0]){
            if(Robot.oi.gamepad.getRawButton(RobotMap.rBumper)){
                Robot.oi.bManipulatortilt.set(ControlMode.PercentOutput, (-.45));      //was -.45
            }else if(Robot.oi.gamepad.getRawButton(RobotMap.lBumper)){
                Robot.oi.bManipulatortilt.set(ControlMode.PercentOutput, (.45));        //was .45
            }
            else{
                Robot.oi.bManipulatortilt.set(ControlMode.PercentOutput, (-.07));
            }
        } else if(GlobalVariables.demoMode[5]){
            if(Robot.oi.gamepad.getRawButton(RobotMap.rBumper)){
                Robot.oi.bManipulatortilt.set(ControlMode.PercentOutput, (-.3));
            }else if(Robot.oi.gamepad.getRawButton(RobotMap.lBumper)){
                Robot.oi.bManipulatortilt.set(ControlMode.PercentOutput, (.1));
            }
            else{
                Robot.oi.bManipulatortilt.set(ControlMode.PercentOutput, (-.07));
            }
        } else {
            Robot.oi.bManipulatortilt.set(ControlMode.PercentOutput, (-.07));
        }


        //Hatch Manipulator
        if(Robot.globalVariables.controlMode == 2 ){     //B
            if(!GlobalVariables.demoMode[0]){
                hatchManipulator = new HatchManipulator(650);
            } else if (GlobalVariables.demoMode[4]){
                hatchManipulator = new HatchManipulator(650);
            }
        }
        else
        {
            Robot.oi.hManipulator.set(0);
        }
        if(Robot.oi.ljoystick.getRawButtonPressed(RobotMap.lTrigger)){
            Robot.oi.gyro.reset();
        }


        if(!GlobalVariables.demoMode[0]){
            if(Robot.oi.ljoystick.getRawButton(RobotMap.lTrigger)){
                Robot.globalVariables.driverControl = false;
                driveStraight = new DriveStraight(.6);
                Robot.globalVariables.buttonDone[4] = false;
            } else {
                if(Robot.globalVariables.buttonDone[4] = false){
                    Robot.globalVariables.driverControl = true;
                    Robot.globalVariables.buttonDone[4] = true;
                }
            }
        }

        if(Robot.oi.rjoystick.getRawButton(6)&&!Robot.globalVariables.buttonDone[5]){
            if(Robot.globalVariables.direction == 1)
            {
                Robot.globalVariables.direction=-1;                
            }
            else{
                Robot.globalVariables.direction=1;
            }
            Robot.globalVariables.buttonDone[5] = true;
        } else {
            if(!Robot.oi.rjoystick.getRawButton(6)&&Robot.globalVariables.buttonDone[5]){
                Robot.globalVariables.driverControl = true;
                Robot.globalVariables.buttonDone[5] = false;
            }
        }

        if(!GlobalVariables.demoMode[0]){
            if(Robot.oi.hatchTimer.get() > 1 && !Robot.oi.gamepad.getRawButton(RobotMap.buttonB)){
                Robot.oi.hManipulator.set(0);
            } else if(Robot.oi.hatchTimer.get() < 1 && !Robot.oi.gamepad.getRawButton(RobotMap.buttonB)){
                Robot.oi.hManipulator.set(.6);
            } else if (Robot.oi.gamepad.getRawButton(RobotMap.buttonB)){
                Robot.oi.hManipulator.set(-.6);
                Robot.oi.hatchTimer.reset();
                Robot.oi.hatchTimer.start();
            }
        } else if(GlobalVariables.demoMode[4]){
            if(Robot.oi.hatchTimer.get() > 1 && !Robot.oi.gamepad.getRawButton(RobotMap.buttonB)){
                Robot.oi.hManipulator.set(0);
            } else if(Robot.oi.hatchTimer.get() < 1 && !Robot.oi.gamepad.getRawButton(RobotMap.buttonB)){
                Robot.oi.hManipulator.set(.6);
            } else if (Robot.oi.gamepad.getRawButton(RobotMap.buttonB)){
                Robot.oi.hManipulator.set(-.6);
                Robot.oi.hatchTimer.reset();
                Robot.oi.hatchTimer.start();
            }
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