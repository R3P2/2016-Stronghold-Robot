package robot.util;

import edu.wpi.first.wpilibj.Victor;

public class R_Victor extends Victor{

	double sensitivity = 0.8;
	
	public R_Victor(int channel) {
		super(channel);
	}

	public R_Victor(int channel, double sensitivity) {
		super(channel);
		this.sensitivity = sensitivity;
	}
	
	@Override
	public void set(double speed){
		super.set(speed * sensitivity);
	}
	
	public void setPID(double setPoint, double feedback) {
		
//		double normalizedFeedback = feedback/RobotMap.MAX_ENCODER_SPEED;
//		
//		if (normalizedFeedback >  1.0) { normalizedFeedback =  1.0; }
//		if (normalizedFeedback < -1.0) { normalizedFeedback = -1.0; }
//
//		double error = setPoint - normalizedFeedback;
//		
//		double output = setPoint + error * sensitivity;
//		
//		double normalizedOutput = output;
//
//		if (normalizedOutput >  1.0) { normalizedOutput =  1.0; }
//		if (normalizedOutput < -1.0) { normalizedOutput = -1.0; }
//
//		super.set(normalizedOutput);
		
		super.set(setPoint * sensitivity);
	}
	
	
}