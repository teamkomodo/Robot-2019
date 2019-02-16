package frc.robot.commands;
import frc.robot.robotmain.*;

public class LiftDownTest
{
    double speed1 = 0;
    public LiftDownTest(double speed)
    {
        speed1=speed;
        Robot.oi.mLift1.set(-speed1);
    }
}
