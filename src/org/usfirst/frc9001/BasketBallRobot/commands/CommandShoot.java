package org.usfirst.frc9001.BasketBallRobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CommandShoot extends CommandGroup {
	public CommandShoot() {
		addParallel(new SetLauncherShooterSpeed(1), 3);
	}
}
