package org.usfirst.frc9001.BasketBallRobot.subsystems;

import org.usfirst.frc9001.BasketBallRobot.RobotMap;
import org.usfirst.frc9001.BasketBallRobot.commands.ManualDrive;
import org.usfirst.frc9001.BasketBallRobot.util.CheesySpeedController;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveTrain extends Subsystem {
	CheesySpeedController left = RobotMap.driveTrainLeft;
	CheesySpeedController right = RobotMap.driveTrainRight;
	RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;
	
	public void init() {
	}
    
    public void arcadeDrive(double forward, double rotate, boolean squaredInputs) {
    	robotDrive.arcadeDrive(forward, rotate, squaredInputs);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new ManualDrive());
    }

	public void logData() {
		SmartDashboard.putNumber("Left_Motor_Speed", left.get());
		SmartDashboard.putNumber("Right_Motor_Speed", right.get());
	}

}

