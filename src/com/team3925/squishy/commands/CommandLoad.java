package com.team3925.squishy.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CommandLoad extends CommandGroup {
	public CommandLoad() {
		addParallel(new SetLauncherElevatorSpeed(1), 3);
	}
}
