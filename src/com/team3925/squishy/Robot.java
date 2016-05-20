package com.team3925.squishy;

import com.team3925.squishy.subsystems.DriveTrain;
import com.team3925.squishy.subsystems.LauncherElevator;
import com.team3925.squishy.subsystems.LauncherShooter;
import com.team3925.squishy.util.hidhelpers.XboxHelper;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Command autonomousCommand;

	public static OI oi;
	public static DriveTrain driveTrain;
	public static LauncherShooter launcherShooter;
	public static LauncherElevator launcherElevator;

	public Robot() {
	}

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		HardwareAdaptor.init();
		driveTrain = new DriveTrain(HardwareAdaptor.drivetrainMotorLeft, HardwareAdaptor.drivetrainMotorRight);
		launcherShooter = new LauncherShooter(HardwareAdaptor.launcherShooterMotor);
		launcherElevator = new LauncherElevator(HardwareAdaptor.launcherElevatorMotor);
		
		// OI must be constructed after subsystems. If the OI creates Commands 
		//(which it very likely will), subsystems are not guaranteed to be 
		// constructed yet. Thus, their requires() statements may grab null 
		// pointers. Bad news. Don't move it.
		oi = new OI();

		XboxHelper.config(oi.driverXbox, oi.shooterXbox);
	}

	/**
	 * This function is called when the disabled button is hit.
	 * You can use it to reset subsystems before shutting down.
	 */
	public void disabledInit(){

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		autonomousCommand = oi.getAutonomous();
		
		if (autonomousCommand != null) autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (autonomousCommand != null) autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}

}
