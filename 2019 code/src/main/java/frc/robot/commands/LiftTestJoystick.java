package frc.robot.commands;
import frc.robot.robotmain.*;

public class LiftTestJoystick{
    public LiftTestJoystick()
    {
        moveLift();
    }
    public void moveLift()
    {
        Robot.oi.mLift1.set(Robot.oi.gamepad.getRawAxis(RobotMap.leftY));
    }
}      