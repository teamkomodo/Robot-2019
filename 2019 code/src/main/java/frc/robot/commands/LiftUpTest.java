package frc.robot.commands;
import frc.robot.robotmain.*;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class LiftUpTest
{
    double speed1 = 0;
    public LiftUpTest(double speed)
    {
        speed1=speed;
        Robot.oi.mLift1.set(-speed1);
        Robot.oi.mLift2.set(ControlMode.PercentOutput, -speed1);
    }
}
