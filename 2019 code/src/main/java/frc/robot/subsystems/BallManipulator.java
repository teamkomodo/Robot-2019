// package frc.robot.subsystems;
// import frc.robot.robotmain.*;
// import frc.robot.robotmain.RobotMap;
// import com.ctre.phoenix.motorcontrol.ControlMode;

// public class BallManipulator{
//     public BallManipulator(){

//         if(Robot.oi.gamepad.getRawAxis(RobotMap.rightY) !=0){
//             Robot.oi.bManipulator.set(1);
//         }
//         if(Robot.oi.gamepad.getRawButton(RobotMap.rBumper)){
//             Robot.oi.bManipulatortilt.set(ControlMode.PercentOutput, (.7));
//         }
//         if(Robot.oi.gamepad.getRawButton(RobotMap.lBumper)){
//             Robot.oi.bManipulatortilt.set(ControlMode.PercentOutput, (-.7));
//         }
//     }
// }