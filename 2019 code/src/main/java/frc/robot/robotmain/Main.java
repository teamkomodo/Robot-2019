package frc.robot.robotmain;

import edu.wpi.first.wpilibj.RobotBase;
//DONT MESS WITH THIS
public final class Main {
  private Main() {
  }
  public static void main(String... args) {
    RobotBase.startRobot(Robot::new);
  }
}
