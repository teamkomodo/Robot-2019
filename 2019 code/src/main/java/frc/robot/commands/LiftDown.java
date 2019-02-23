package frc.robot.commands;
import frc.robot.robotmain.*;

public class LiftDown {
    public LiftDown() {
        if(Robot.globalVariables.levelCounter > 0){
            Robot.globalVariables.levelCounter--;
            Robot.globalVariables.elevatorTargetValue = Robot.globalVariables.levelEncoderValues[Robot.globalVariables.levelCounter];
            Robot.globalVariables.buttonDone[0] = true;
        }
    }
}