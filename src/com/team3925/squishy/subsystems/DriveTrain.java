package com.team3925.squishy.subsystems;

import com.team3925.squishy.commands.ManualDrive;
import com.team3925.squishy.util.CheesySpeedController;
import com.team3925.squishy.util.DriveTrainSignal;

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
