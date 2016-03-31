package org.usfirst.frc9001.BasketBallRobot.commands;

import org.usfirst.frc9001.BasketBallRobot.Robot;
import org.usfirst.frc9001.BasketBallRobot.subsystems.DriveTrain;
import org.usfirst.frc9001.BasketBallRobot.util.FlightStickHelper;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class  ManualDrive extends Command {
	private final DriveTrain driveTrain = Robot.driveTrain;
	
    public ManualDrive() {
        requires(Robot.driveTrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    	driveTrain.arcadeDrive(-FlightStickHelper.getAxis(FlightStickHelper.AXIS_Y),
    			-FlightStickHelper.getAxis(FlightStickHelper.AXIS_X), true);
    	
    	logData();
    }
    
    public void logData() {
    	SmartDashboard.putNumber("RobotTime", Timer.getFPGATimestamp());
    	SmartDashboard.putNumber("ForwardValue", FlightStickHelper.getAxis(FlightStickHelper.AXIS_Y));
    	SmartDashboard.putNumber("TurnValue", FlightStickHelper.getAxis(FlightStickHelper.AXIS_X));
    }
    
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.driveTrain.arcadeDrive(0, 0, false);
    }

    protected void interrupted() {
    	Robot.driveTrain.arcadeDrive(0, 0, false);
    }
}
