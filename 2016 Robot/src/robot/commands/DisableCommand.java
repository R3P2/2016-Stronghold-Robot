package robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

public class DisableCommand extends Command {
	
	public DisableCommand() {
		requires(Robot.chassisSubsystem);
	}
	
	protected void initialize() {
		
	}
	
	public void execute() {
		if (Robot.oi.doDisable()) {
			Robot.chassisSubsystem.setShootingMotors(0);
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
