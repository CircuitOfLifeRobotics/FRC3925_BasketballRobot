package org.usfirst.frc9001.BasketBallRobot.subsystems;

import org.usfirst.frc9001.BasketBallRobot.commands.ManualDrive;
import org.usfirst.frc9001.BasketBallRobot.util.CheesySpeedController;
import org.usfirst.frc9001.BasketBallRobot.util.DriveTrainSignal;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	
	private final CheesySpeedController left;
	private final CheesySpeedController right;
	
	private final RobotDrive robotdrive;
	
	public DriveTrain(CheesySpeedController leftMotors, CheesySpeedController rightMotors) {
		super("DriveTrain");
		left = leftMotors;
		right = rightMotors;
		
		robotdrive = new RobotDrive(left, right);
	}
	
	public void setOpenLoop(DriveTrainSignal signal) {
		left.set(signal.left);
		right.set(signal.right);
	}
	
	public void doArcadeDrive(double moveValue, double rotateValue) {
		robotdrive.arcadeDrive(moveValue, rotateValue, true);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ManualDrive());
	}

}
