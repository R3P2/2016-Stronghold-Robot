package robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import robot.Robot;
import robot.RobotMap;

public class JoystickCommand extends Command {

	public JoystickCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.chassisSubsystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {

		double speed = Robot.oi.getSpeed();
		double turn = Robot.oi.getTurn();

		// boolean isGearUp = Robot.oi.gearUp();
		// boolean isGearDown = Robot.oi.gearDown();

		boolean shootHigh = Robot.oi.isShootHigh();
		Robot.chassisSubsystem.setMovement(speed, turn);

		// if(placeGearOnPeg){
		// Scheduler.getInstance().add(new DriveStraightCommand(5, 0.5));
		// Scheduler.getInstance().add(new TurnToAngle(60));
		// }

		if (shootHigh) {
			Scheduler.getInstance().add(new ShootHighCommand());
		}

		// if(isTurnToAnglePressed){
		// Scheduler.getInstance().add(new TurnToAngle(60));
		// }

		// if (Robot.oi.switchBackwards()){
		//
		// Robot.chassisSubsystem.invertMotors(false);
		//
		// }else if (Robot.oi.switchForward()){
		//
		// Robot.chassisSubsystem.invertMotors(true);
		//
		// }

		// if (isGearUp && RobotMap.MotorSensitivity <= 1){
		// RobotMap.MotorSensitivity += 0.1;
		// }

		// if (isGearDown && RobotMap.MotorSensitivity >= 0) {
		// RobotMap.MotorSensitivity -= 0.1;
		// }

	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
