package org.usfirst.frc9001.BasketBallRobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CommandLoad extends CommandGroup {
	public CommandLoad() {
		addParallel(new SetLauncherElevatorSpeed(1), 3);
	}
}
