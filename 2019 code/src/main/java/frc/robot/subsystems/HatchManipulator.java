package frc.robot.subsystems;
import frc.robot.robotmain.*;
import frc.robot.robotmain.RobotMap;
public class HatchManipulator{
    public HatchManipulator(){
        double speed = 0.4;
        if(Robot.oi.gamepad.getRawButton(RobotMap.buttonB)){
            Robot.oi.hManipulator.set(speed);
        } else {
            Robot.oi.hManipulator.set(-speed);
        }
    }
}