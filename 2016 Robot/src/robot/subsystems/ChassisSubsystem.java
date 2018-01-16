package robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.RobotMap;
import robot.commands.JoystickCommand;
import robot.util.R_Gyro;
import robot.util.R_Victor;

public class ChassisSubsystem extends Subsystem {

	Encoder leftEncoder = new Encoder(RobotMap.ENCODER_LEFT_PORT_1, RobotMap.ENCODER_LEFT_PORT_2);
	Encoder rightEncoder = new Encoder(RobotMap.ENCODER_RIGHT_PORT_1, RobotMap.ENCODER_RIGHT_PORT_2);
	
	R_Victor leftMotor = new R_Victor(RobotMap.LEFT_MOTOR_PORT, RobotMap.MotorSensitivity*0.75);
	R_Victor rightMotor = new R_Victor(RobotMap.RIGHT_MOTOR_PORT, RobotMap.MotorSensitivity);
	
	//shooting motors
	public R_Victor shootHighM = new R_Victor(RobotMap.HIGH_GOAL_MOTOR);
	public R_Victor liftM = new R_Victor(RobotMap.LIFT_MOTOR);
	public R_Victor shootLowM = new R_Victor(RobotMap.LOW_GOAL_MOTOR);
	
	public R_Gyro gyro = new R_Gyro(Port.kOnboardCS0);

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new JoystickCommand());
		rightMotor.setInverted(true);
		rightEncoder.setReverseDirection(true);
		resetEncoders();
		gyro.resetAccumulator();
	}

	public void invertMotors(boolean isInverted) {
		
		leftMotor.setInverted(isInverted);
		leftEncoder.setReverseDirection(isInverted);
		rightMotor.setInverted(!isInverted);
		rightEncoder.setReverseDirection(!isInverted);		
	}
	
	public void resetEncoders() {
		leftEncoder.reset();
//		rightEncoder.reset();
	}

	public double getEncoderDistance() {
		return (leftEncoder.getDistance() + rightEncoder.getDistance())/2;
	}

	public double getEncoderRate(){
		return leftEncoder.getRate();
	}
	

	public void setSpeed(double speed) {

		leftMotor.set(-speed);
		rightMotor.set(-speed);

	}
	
	public void setMovement(double speed, double turn){		
		if(speed < 0.3 && speed > -0.3){
			if(turn > 0.3 || turn < -0.3){
				leftMotor.set(-turn);
				rightMotor.set(turn);			
			}else{
				rightMotor.set(0);
				leftMotor.set(0);
			}
		}else{
			if(turn > 0.3){
				leftMotor.set(turn);
				rightMotor.set(turn/2);
			}else if(turn < -0.3){
				leftMotor.set(turn/6);
				rightMotor.set(turn);			
			}else{
				leftMotor.set(speed);
				rightMotor.set(speed);
			}
		}
	}

	public void setShootingMotors(double speed){
		shootHighM.set(speed);
		shootLowM.set(speed);
		liftM.set(speed);
	}


	public void callSmartdashboard() {
		// SmartDashboard.putData("Gyro", gyro);
		SmartDashboard.putData("Left Motor", leftMotor);
		SmartDashboard.putData("Right Motor", rightMotor);
		SmartDashboard.putData("Left Encoder", rightEncoder);
		SmartDashboard.putData("Right Encoder", leftEncoder);
		SmartDashboard.putNumber("Encoder Distance", getEncoderDistance());
		//TODO: Gear Visual
		SmartDashboard.putNumber("Robot Gear", RobotMap.MotorSensitivity);
		SmartDashboard.putNumber("Gyro Value", gyro.getAccumulatorValue());
	}

}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       