package org.usfirst.frc9001.BasketBallRobot;

import org.usfirst.frc9001.BasketBallRobot.commands.CommandLoad;
import org.usfirst.frc9001.BasketBallRobot.commands.CommandShoot;
import org.usfirst.frc9001.BasketBallRobot.util.hidhelpers.XboxHelper;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public final class OI {

	public Joystick driverXbox;
	public Joystick shooterXbox;
	
	private JoystickButton buttonShoot;
	private JoystickButton buttonLoad;

	private CommandShoot commandShoot;
	private CommandLoad commandLoad;

	
	public OI() {
		driverXbox = new Joystick(0);
		shooterXbox = new Joystick(1);
		
		
		commandShoot = new CommandShoot();
		commandLoad = new CommandLoad();
		
		
		buttonShoot = new JoystickButton(driverXbox, XboxHelper.X);
		buttonShoot.whenPressed(commandShoot);
		buttonShoot.cancelWhenActive(commandLoad);;
		
		buttonLoad = new JoystickButton(driverXbox, XboxHelper.Y);
		buttonLoad.whenPressed(commandLoad);
		buttonShoot.cancelWhenActive(commandShoot);
		
	}

	public CommandGroup getAutonomous() {
		CommandGroup janky = new CommandGroup();

		return janky;
	}

	
	
	// ROBOT BEHAVIOR
	public double getManualDrive_ForwardValue() {
		return -XboxHelper.getDriverAxis(XboxHelper.AXIS_RIGHT_Y);
	}

	public double getManualDrive_RotateValue() {
		return XboxHelper.getDriverAxis(XboxHelper.AXIS_RIGHT_X);
	}

	public boolean getManualDrive_HighGearToggle() {
		return false;
	}

}