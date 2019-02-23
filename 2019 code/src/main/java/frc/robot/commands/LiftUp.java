package frc.robot.commands;
import frc.robot.robotmain.*;

public class LiftUp {
    public LiftUp() {
        if(Robot.globalVariables.levelCounter < 5){
            Robot.globalVariables.levelCounter++;
            Robot.globalVariables.elevatorTargetValue = Robot.globalVariables.levelEncoderValues[Robot.globalVariables.levelCounter];
            Robot.globalVariables.buttonDone[3] = true;
        }
    }
}