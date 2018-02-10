package org.usfirst.frc.team6007.robot;

import com.kauailabs.navx.frc.AHRS;
//import com.kauailabs.navx.frc.AHRS.SerialDataType;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType; 


public class IORobot(){
  
  AHRS ahrs;
 // Joystick driverStick;
  
  
}

public IORobot(){
  try{
  ahrs = new AHRS(SPI.Port.kMXP); 
  }
  catch (RuntimeException ex ){
     DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
  }
}

/* things to use when measuring and adjusting vears/turns to be put in robot ?
 yaw is left and right of an object on an axis running up and down
 goes in operator control part:
  
  SmartDashboard.putNumber(   "IMU_Yaw",              ahrs.getYaw());
  SmartDashboard.putNumber(   "IMU_TotalYaw",         ahrs.getAngle());
  SmartDashboard.putNumber(   "IMU_YawRateDPS",       ahrs.getRate());
 
  SmartDashboard.putNumber(   "YawAxis",              yaw_axis.board_axis.getValue() );
  SmartDashboard.putString(   "YawAxisDirection",     yaw_axis.up ? "Up" : "Down" );
  
or just compass:      SmartDashboard.putNumber(   "IMU_CompassHeading",   ahrs.getCompassHeading());
if compassHeading when driving forward/backward changes by 5? or more degrees, reverse direction by change. Figure if left or right
*/
