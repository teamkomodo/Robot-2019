package frc.robot.commands;
import frc.robot.robotmain.*;

public class LiftTestJoystick{
    public LiftTestJoystick()
    {   
        Robot.oi.mLift1.set(Robot.oi.gamepad.getRawAxis(RobotMap.leftY));
        // if(Robot.oi.gamepad.getRawAxis(RobotMap.leftY)==0 )
        // {
        //     Robot.oi.mLift1.set(-0.1);
        // }
        
        
    }
}      