package org.usfirst.frc9001.BasketBallRobot.commands;

import org.usfirst.frc9001.BasketBallRobot.Robot;
import org.usfirst.frc9001.BasketBallRobot.subsystems.Launcher;
import org.usfirst.frc9001.BasketBallRobot.util.Button;
import org.usfirst.frc9001.BasketBallRobot.util.XboxHelper;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ManualLauncher extends Command {
	Joystick xbox;
	Launcher launcher;
	Button launcherBtn;
	Button feedBtn;
	
    public ManualLauncher() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.launcher);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	xbox = Robot.oi.xbox;
    	launcherBtn = new Button(xbox, XboxHelper.B);
    	feedBtn = new Button(xbox, XboxHelper.A);
    	launcher = Robot.launcher;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*
    	if (!launcherBtn.get()) {
			launcher.setLauncherSpeed(1);
		} else {
			launcher.setLauncherSpeed(0);
		}
    	
    	if (!feedBtn.get()) {
    		launcher.setLoaderSpeed(1);
    	} else {
    		launcher.setLoaderSpeed(0);
    	}
    	//*/
    	
//    	logData();
    }
    
    public void logData() {
    	SmartDashboard.putBoolean("Launcher_Enabled", launcherBtn.get());
    	SmartDashboard.putBoolean("Feed_Enabled", feedBtn.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	launcher.setLauncherSpeed(0);
    	launcher.setLoaderSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	launcher.setLauncherSpeed(0);
    	launcher.setLoaderSpeed(0);
    }
}
