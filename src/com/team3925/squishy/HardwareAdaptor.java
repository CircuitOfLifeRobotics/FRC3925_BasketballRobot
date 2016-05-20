package com.team3925.squishy;

import static com.team3925.squishy.Constants.*;

import com.team3925.squishy.util.CheesySpeedController;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

public class HardwareAdaptor {
	private HardwareAdaptor() {}
	
	public static CheesySpeedController drivetrainMotorLeft;
	public static CheesySpeedController drivetrainMotorRight;
	
	public static Talon launcherShooterMotor;
	public static Talon launcherElevatorMotor;
	
	public static PowerDistributionPanel pdp;
	
	public static void init() {
		
		pdp = new PowerDistributionPanel();
		
		drivetrainMotorLeft = new CheesySpeedController(
				new SpeedController[]{new Talon(DRIVETRAIN_MOTOR_LEFT_A),new Talon(DRIVETRAIN_MOTOR_LEFT_B)},
				new int[] {DRIVETRAIN_MOTOR_LEFT_A, DRIVETRAIN_MOTOR_LEFT_B});
		
		drivetrainMotorRight = new CheesySpeedController(
				new SpeedController[]{new Talon(DRIVETRAIN_MOTOR_RIGHT_A),new Talon(DRIVETRAIN_MOTOR_RIGHT_B)},
				new int[] {DRIVETRAIN_MOTOR_RIGHT_A, DRIVETRAIN_MOTOR_RIGHT_B});
		
		
		launcherShooterMotor = new Talon(LAUNCHER_SHOOTER);
		launcherElevatorMotor = new Talon(LAUNCHER_ELEVATOR);
	}
	
}
