package com.team3925.squishy.commands;

import com.team3925.squishy.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetLauncherElevatorSpeed extends Command {
	private double speed;
	
	public SetLauncherElevatorSpeed(double speed) {
		super("SetLauncherElevatorSpeed-" + speed);
		requires(Robot.launcherElevator);
		this.speed = speed;
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.launcherElevator.setMotorSpeed(speed);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.launcherElevator.setMotorSpeed(0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
