package org.usfirst.frc9001.BasketBallRobot.commands;

import org.usfirst.frc9001.BasketBallRobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetLauncherShooterSpeed extends Command {
	private double speed;
	
	public SetLauncherShooterSpeed(double speed) {
		super("SetLauncherShooterSpeed-" + speed);
		requires(Robot.launcherShooter);
		this.speed = speed;
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.launcherShooter.setMotorSpeed(speed);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.launcherShooter.setMotorSpeed(0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
