package frc.robot;

//IMPORTS
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;                    //NOT USED
import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;   //NOT WORKING
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

//START ROBOT CLASS
public class Robot extends TimedRobot {
  //DEFINITIONS - WILL EVENTUALLY BE MADE INTO A ROBOT MAP FILE
    //MOTOR MAP
  private static final int rMotorPort = 1;
  private static final int lMotorPort = 2;

    //JOYSTICK MAP
  private static final int kJoystickPort = 0;
  private static final int leftX = 0;
  private static final int leftY = 1;  
  private static final int rightX = 4;  
  private static final int rightY = 5;
  private static final int buttonA = 1;
  private static final int buttonB = 2;
  private static final int buttonX = 3;

  double scaler = 0.5;
  Boolean buttonflag = false;

  //  
  TalonSRX rmotor = new TalonSRX(rMotorPort);
  TalonSRX lmotor = new TalonSRX(lMotorPort);

  //VISION STUFF
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");
  NetworkTableEntry tv = table.getEntry("tv");

  double limelightX = tx.getDouble(0.0);
  double limelightY = ty.getDouble(0.0);
  double limelightArea = ta.getDouble(0.0);
  double limelightTarget = tv.getDouble(0.0);
  
  //DECLARATIONS
  private Joystick m_joystick;

  @Override
  public void robotInit() {
    m_joystick = new Joystick(kJoystickPort);
  } //END ROBOT INIT

  @Override
  public void teleopPeriodic() {

    //VISION CODE
    limelightX = tx.getDouble(0.0);
    limelightY = ty.getDouble(0.0);
    limelightArea = ta.getDouble(0.0);
    limelightTarget = tv.getDouble(0.0);

    //SMART DASHBOARD
    /*
    SmartDashboard.putNumber("Limelight X", limelightX);
    SmartDashboard.putNumber("Limelight Y", limelightY);
    SmartDashboard.putNumber("Limelight Area", limelightArea);

    ^SMART DASHBOARD IS BROKEN DO NOT USE^
    */

    //IF THE ROBOT SEES A TARRGET, RUN THE MOTORS AT 50% SPEED
    if(limelightTarget == 0.0){
      lmotor.set(ControlMode.PercentOutput, 0);
      rmotor.set(ControlMode.PercentOutput, 0);
    }else{
      lmotor.set(ControlMode.PercentOutput, .5);
      rmotor.set(ControlMode.PercentOutput, .5);
    }

    /*
    //BUTTON FLAG RESET
    if(!m_joystick.getRawButton(buttonB) && !m_joystick.getRawButton(buttonX)){
      buttonflag = false;
    }

    //SCALER INCREMENT
    if(m_joystick.getRawButton(buttonB) && !buttonflag){
      if(scaler <= 0.9){
        scaler += 0.1;
        buttonflag = true;
      }
    }

    if(m_joystick.getRawButton(buttonX) && !buttonflag){
      if(scaler >= 0.1){
        scaler += -0.1;
        buttonflag = true;
      }    
    }

    //MOTOR CONTROL
    lmotor.set(ControlMode.PercentOutput, m_joystick.getRawAxis(leftY)*scaler);
    rmotor.set(ControlMode.PercentOutput, m_joystick.getRawAxis(rightY)*scaler);
    */
  } //END ROBOTOT TELEOP
} //END ROBOT CLASS