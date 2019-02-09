package frc.robot.commands;
import frc.robot.robotmain.*;

public class LiftUp {
    public LiftUp() {
        if(Robot.globalVariables.levelCounter < 6){
            if(Robot.oi.mLift1.getSelectedSensorPosition() < Robot.globalVariables.levelEncoderValues[Robot.globalVariables.levelCounter + 1]){
                Robot.oi.mLift1.set(.6);
            } else {
                Robot.oi.mLift1.set(0);
                Robot.globalVariables.levelCounter++;
                Robot.globalVariables.buttonDone[3] = true;
            }
        }
    }
}