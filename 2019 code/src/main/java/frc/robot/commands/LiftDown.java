package frc.robot.commands;
import frc.robot.robotmain.*;

public class LiftDown {
    public LiftDown() {
        if(Robot.globalVariables.levelCounter > 1){
            if(Robot.oi.mLift1.getSelectedSensorPosition() > Robot.globalVariables.levelEncoderValues[Robot.globalVariables.levelCounter - 1]){
                Robot.oi.mLift1.set(-.6);
            } else {
                Robot.oi.mLift1.set(0);
                Robot.globalVariables.levelCounter--;
                Robot.globalVariables.buttonDone[0] = true;
               
            }
        }
    }
}