package robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;


public class ShootHighCommand extends Command {

    public ShootHighCommand() {
        requires(Robot.chassisSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassisSubsystem.setShootingMotors(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassisSubsystem.shootHighM.set(0.75);
    	if(timeSinceInitialized() >= 1.25){
    		Robot.chassisSubsystem.liftM.set(1.0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(timeSinceInitialized() >= 1.75){
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassisSubsystem.setShootingMotors(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
