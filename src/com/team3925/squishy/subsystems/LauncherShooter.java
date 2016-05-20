package com.team3925.squishy.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LauncherShooter extends Subsystem {
	
	private final Talon motor;
	
	public LauncherShooter(Talon motor) {
		super("LauncherShooter");
		this.motor = motor;
	}
	
	public void setMotorSpeed(double speed) {
		motor.set(speed);
	}
	
	@Override
	protected void initDefaultCommand() {
	}

}
