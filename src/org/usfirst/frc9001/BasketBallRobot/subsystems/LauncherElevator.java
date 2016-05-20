package org.usfirst.frc9001.BasketBallRobot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LauncherElevator extends Subsystem {
	
	private final Talon motor;
	
	public LauncherElevator(Talon motor) {
		super("LauncherElevator");
		this.motor = motor;
	}
	
	public void setMotorSpeed(double speed) {
		motor.set(speed);
	}
	
	@Override
	protected void initDefaultCommand() {
	}

}
