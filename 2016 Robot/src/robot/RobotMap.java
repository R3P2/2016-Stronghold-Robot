package robot;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	
	//PWM Ports (Motors)
	public final static int LEFT_MOTOR_PORT = 0;
	public final static int RIGHT_MOTOR_PORT = 1;
	
	public final static int HIGH_GOAL_MOTOR = 2; //Left - 5    Right - 4 
	public final static int LIFT_MOTOR = 3;
	public final static int LOW_GOAL_MOTOR = 5;
	
	//DIO Ports (Encoders, Sensors)
	public final static int ENCODER_RIGHT_PORT_1 = 0;
	public final static int ENCODER_RIGHT_PORT_2 = 1;
	public final static int ENCODER_LEFT_PORT_1 = 2;
	public final static int ENCODER_LEFT_PORT_2 = 3;
	
	// Physical Properties
	public final static int MAX_ENCODER_COUNTS_PER_FT = 200;
	public final static int MAX_ENCODER_SPEED = 1800;
	public static double MotorSensitivity = 0.8;
	
	//Analog ports
	public final static int GYRO_PORT = 1; 
	
	//Field Information
	public final static double BASE_LINE_DISTANCE = 4.0;
	public final static int GEAR_ANGLE = 60;
	public final static double BASELINE_TO_GEAR_DISTANCE = 2.5;
	public final static double GEAR_TO_BOILER_DISTANCE = -4.5;
	public final static double BASELINE_TO_BOILER_DISTANCE = -2.5;
}
