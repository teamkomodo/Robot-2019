package frc.robot.commands;
import frc.robot.robotmain.*;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class LiftDownTest
{
    double speed1 = 0;
    public LiftDownTest(double speed)
    {
        speed1=speed;
        System.out.println("works");
         Robot.oi.mLift1.set(speed);
         Robot.oi.mLift2.set(ControlMode.PercentOutput, speed1);
    }
}
