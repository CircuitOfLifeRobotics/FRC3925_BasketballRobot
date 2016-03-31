package org.usfirst.frc9001.BasketBallRobot;
    
import org.usfirst.frc9001.BasketBallRobot.util.CheesySpeedController;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static PowerDistributionPanel pdp;
	
	public static CheesySpeedController driveTrainLeft;
	public static CheesySpeedController driveTrainRight;
    public static Victor launcherMotorLauncher;
    public static Victor launcherMotorLoader;
    
    public static RobotDrive driveTrainRobotDrive;

    public static void init() {
    	
    	pdp = new PowerDistributionPanel();
    	
    	driveTrainLeft = new CheesySpeedController(new SpeedController[]{new Victor(3), new Victor(4)}, new int[]{3, 4});
    	driveTrainRight = new CheesySpeedController(new SpeedController[]{new Victor(5), new Victor(6)}, new int[]{5, 6});
    	
//    	launcherMotorLauncher = new Victor(7);
//    	launcherMotorLoader = new Victor(8);
        
    	
        driveTrainRobotDrive = new RobotDrive(driveTrainLeft, driveTrainRight);
        
        driveTrainRobotDrive.setSafetyEnabled(true);
        driveTrainRobotDrive.setExpiration(0.1);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1.0);
        
    }
}
