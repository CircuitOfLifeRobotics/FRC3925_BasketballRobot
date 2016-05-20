package com.team3925.squishy.commands;

import com.team3925.squishy.Robot;
import com.team3925.squishy.util.DriveTrainSignal;

import edu.wpi.first.wpilibj.command.Command;

public class ManualDrive extends Command {
	
	public ManualDrive() {
		super("ManualDrive");
		requires(Robot.driveTrain);
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.driveTrain.doArcadeDrive(
				Robot.oi.getManualDrive_ForwardValue(),
				Robot.oi.getManualDrive_RotateValue());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.driveTrain.setOpenLoop(DriveTrainSignal.NEUTRAL);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
