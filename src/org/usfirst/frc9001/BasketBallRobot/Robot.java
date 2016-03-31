package org.usfirst.frc9001.BasketBallRobot;

import java.util.Collections;
import java.util.LinkedList;

import org.usfirst.frc9001.BasketBallRobot.commands.AutonomousCommand;
import org.usfirst.frc9001.BasketBallRobot.commands.ManualDrive;
import org.usfirst.frc9001.BasketBallRobot.commands.VisionTest;
import org.usfirst.frc9001.BasketBallRobot.subsystems.DriveTrain;
import org.usfirst.frc9001.BasketBallRobot.subsystems.Launcher;
import org.usfirst.frc9001.BasketBallRobot.util.FlightStickHelper;
import org.usfirst.frc9001.BasketBallRobot.util.PixyCmu5;
import org.usfirst.frc9001.BasketBallRobot.util.PixyCmu5.PixyFrame;
import org.usfirst.frc9001.BasketBallRobot.util.XboxHelper;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;
    Command launcherEnable;
    Command feedBall;
    Command manualDrive;
    Command manualLauncher;
    VisionTest visionTest;

    public static OI oi;
    public static DriveTrain driveTrain;
    public static Launcher launcher;
    
	public static PixyCmu5 pixy;
    
    
    public Robot() {
		try {
    	    pixy = new PixyCmu5(168, .25);
		} catch (Exception e) {
			DriverStation.reportError("There was an error instantiating the Pixy/Frames!" + e.getMessage(), true);
		}
	}
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    RobotMap.init();
        driveTrain = new DriveTrain();
//        launcher = new Launcher();
        // OI must be constructed after subsystems. If the OI creates Commands 
        //(which it very likely will), subsystems are not guaranteed to be 
        // constructed yet. Thus, their requires() statements may grab null 
        // pointers. Bad news. Don't move it.
        oi = new OI();

        XboxHelper.init();
        FlightStickHelper.config(oi.flightStick);
//        launcher.init();
        driveTrain.init();
        
        // instantiate the commands
        autonomousCommand = new AutonomousCommand();
//        launcherEnable = new LauncherEnable();
//        feedBall = new FeedBall();
        manualDrive = new ManualDrive();
        visionTest = new VisionTest();
//        manualLauncher = new ManualLauncher();
        
//        oi.feederEnabler.toggleWhenPressed(feedBall);
//        oi.turnOnLauncher.toggleWhenPressed(launcherEnable);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        manualDrive.start();
        visionTest.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
//        launcher.logData();
        driveTrain.logData();
		SmartDashboard.putBoolean("NullPixy", pixy == null);

        /* Manual override for testing purposes
        launcher.setLauncherSpeed(1);
        launcher.setLoaderSpeed(1);
        //*/
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
}
