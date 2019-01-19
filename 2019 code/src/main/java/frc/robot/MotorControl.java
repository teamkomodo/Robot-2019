package frc.robot;



import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class MotorControl{

    public Joystick leftJoystick;
    public Joystick rightJoystick;

    public Button setTankButton;
    public Button setArcade1Button;
    public Button setArcade2Button;
    
    public Button printEncoders;
    
    public JoystickButton rotateManipulatorUp;
    public JoystickButton rotateManipulatorDown;
    public JoystickButton switchDriveDirection;    
    public JoystickButton halfSpeedOut;

    public Joystick gamepadL;
    public Joystick gamepadR;
    public JoystickButton rightIntake;
	public JoystickButton leftIntake;


    public MotorControl() {
/* 2o18 Code
            // leftJoystick = new Joystick(RobotMap.lJoystickPort);
            // rightJoystick = new Joystick(RobotMap.rJoystickPort);
            
            // setTankButton = new JoystickButton (rightJoystick, 12);
            // setTankButton.whenPressed(new SetDriveTypeCommand(DriveType.TANK));
            // //setTankButton.whenPressed(new AutoRotateCommand(90));
            
            // setArcade1Button = new JoystickButton (rightJoystick, 11);
            // setArcade1Button.whenPressed(new SetDriveTypeCommand(DriveType.ARCADE_1));
            // //setArcade1Button.whenPressed(new AutoRotateCommand(-90));
            
            // setArcade2Button = new JoystickButton (rightJoystick, 10);
            // setArcade2Button.whenPressed(new SetDriveTypeCommand(DriveType.ARCADE_2));
            
            // printEncoders = new JoystickButton(rightJoystick, 9);
            // printEncoders.whenPressed(new PrintEncodersCommand());
            
            // gamepadL = new Joystick(RobotMap.gamepadPort);
            // gamepadL.setXChannel(RobotMap.gamepadLX);
            // gamepadL.setYChannel(RobotMap.gamepadLY);
            // //gamepadL.setZChannel(RobotMap.gamepadLT);
            
            // gamepadR = new Joystick(RobotMap.gamepadPort);
            // gamepadR.setXChannel(RobotMap.gamepadRX);
            // gamepadR.setYChannel(RobotMap.gamepadRY);
            // //gamepadR.setZChannel(RobotMap.gamepadRT);
            
            // halfSpeedOut = new JoystickButton(gamepadL, RobotMap.gamepadX);
            
            // rightIntake = new JoystickButton(gamepadL, RobotMap.gamepadB);
            // leftIntake = new JoystickButton(gamepadL, RobotMap.gamepadY);
            */
    
        }
    
        public Joystick getLeftJoystick() {
            return leftJoystick;
        }
    
        public Joystick getRightJoystick() {
            return rightJoystick;
        }
        
        public Joystick getGamepadL() {
            return gamepadL;
        }
        
        public Joystick getGamepadR() {
            return gamepadR;
        }
    }