package frc.robot.commands;
import frc.robot.robotmain.*;

public class LiftUpTest
{
    double speed1 = 0;
    public LiftUpTest(double speed)
    {
        speed1=speed;
        Robot.oi.mLift1.set(speed1);
    }
}
