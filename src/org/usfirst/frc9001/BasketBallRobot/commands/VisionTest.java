package org.usfirst.frc9001.BasketBallRobot.commands;

import java.awt.Frame;
import java.util.List;

import org.usfirst.frc9001.BasketBallRobot.Robot;
import org.usfirst.frc9001.BasketBallRobot.util.PixyCmu5;
import org.usfirst.frc9001.BasketBallRobot.util.PixyCmu5.PixyFrame;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VisionTest extends Command {
	// CAMERA CONSTANTS

	public static final double PIXY_FOV = 76; //degrees
	public static final double CAMERA_OFFSET_COMP = 6;
	public static final String AXIS_CAMERA_IP = "192.168.0.90";
	public static final double CAMERA_AIMED_X = 159;
	public static final double CAMERA_FOV_DEG = 45.134;
	public static final double CAMERA_FOV_PIX = 320;
	public static final double CAMERA_DEGS_PER_PX = CAMERA_FOV_DEG/CAMERA_FOV_PIX;
	public static final double CAMERA_TARGET_WIDTH = 5d/3d;//in feet
	public static final double CAMERA_TARGET_HEIGHT_GROUND = 83.5d;
	public static final double CAMERA_PIVOT_HEIGHT_GROUND = (7d / 12d);
	public static final double CAMERA_PIVOT_DIST = (18d / 12d);
	public static final double CAMERA_MID_OFFSET = (6.5d / 12d);
	public static final double MAX_BALL_EXIT_VELOCITY = 7.7;//meters / second

	// Do I care that this is a GIANT mess (no) #toojankyforme #thejankistoodank #newhashtags


	private final PixyCmu5 pixy = Robot.pixy;

	double vertSetpoint, degFromCenter;

	private int centerX, centerY, area, width, height, arrSize;
	private double camDist, pixCenter;
	private List<PixyFrame> frames;
	private boolean hasTurned, isReading;
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		if (pixy == null) {
			DriverStation.reportError("Null Camera! Cannot do Vision!\n", false);
			this.cancel();
		}
		
		try {
			arrSize = pixy.getFrames().size();
			isReading = pixy.getIsReading();
			frames = pixy.getFrames();
			if (arrSize>0) {
				frames.get(1);
			}
//			calcData();
		} catch (Exception e) {
			DriverStation.reportError("Error retrieving latest frame\n", false);
		}
		
		logData();
	}

	private void calcData() {
		if (arrSize>0) {
			centerX = frames.get(0).xCenter;
			centerY = frames.get(0).yCenter;
			area = frames.get(0).area;
			width = frames.get(0).width;
			height = frames.get(0).height;

			camDist = CAMERA_TARGET_WIDTH/2 / Math.tan(Math.toRadians(width/2 * PixyCmu5.PIXY_X_DEG_PER_PIXEL));
			pixCenter = -Math.atan(CAMERA_MID_OFFSET/camDist)/PixyCmu5.PIXY_X_DEG_PER_PIXEL + PixyCmu5.PIXY_X_FOV/2;
			degFromCenter = PixyCmu5.degreesXFromCenter(pixy.getCurrentframes().get(0));
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

	public void logData() {
		if (pixy != null) {
		SmartDashboard.putNumber("CamDist", camDist);
		SmartDashboard.putNumber("PixCenter", pixCenter);

		SmartDashboard.putNumber("size", arrSize);
		
		SmartDashboard.putBoolean("Pixy_ObjectDetected", pixy.isObjectDetected());
		SmartDashboard.putBoolean("Pixy_ObjectDetected", pixy.isDetectedAndCentered());
		SmartDashboard.putNumber("Pixy_DegFromCenter", degFromCenter);
		SmartDashboard.putBoolean("Pixy_IsReading", isReading);
		}
	}

}
