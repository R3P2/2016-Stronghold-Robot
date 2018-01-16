
package robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
//import robot.OI.AutoSelector;
import robot.OI.OI;
import robot.commands.DisableCommand;
//import robot.commands.auto.AutoCommands;
//import robot.commands.auto.DriveStraightCommand;
import robot.subsystems.ChassisSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ChassisSubsystem chassisSubsystem = new ChassisSubsystem();
	public static OI oi;
//	public static AutoSelector autoSelector;
//	public static AutoCommands autoCommands;
//	Command autoCommand = new DriveStraightCommand(5, -0.7, 10);
	public static DisableCommand dc = new DisableCommand();

	
		
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		CameraServer server = CameraServer.getInstance();
		server.startAutomaticCapture(0);
		
		
//		autoSelector = new AutoSelector();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		callSmartDashboard();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit(){
		//chassisSubsystem.gyro.calibrate();
//		autoCommand.start();
		
	}
	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		callSmartDashboard();
	}

	
	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
//		if (autoCommands != null)
//			autoCommands.cancel();
		
		//Lower Sensitivity to not shock the driver
		RobotMap.MotorSensitivity = 0.4;
		
		chassisSubsystem.shootHighM.setSpeed(0);
		chassisSubsystem.shootLowM.set(0);
		chassisSubsystem.liftM.setSpeed(0);
		chassisSubsystem.setSpeed(0);
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		dc.execute();
		Scheduler.getInstance().run();
		callSmartDashboard();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	public void callSmartDashboard() {
		
		//TODO: SmartDashboard
		chassisSubsystem.callSmartdashboard();
//		autoSelector.updateSmartDashboard();
	}
	
}
