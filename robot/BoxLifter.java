/* this is the code that brings the external libries in for our use  */
package org.usfirst.frc.team6007.robot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive; 
import edu.wpi.first.wpilibj.VictorSP;
//import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/* this is the declaraion of the class everything must be within these curly braces  */
public class BoxLifter extends PIDSubsystem{
	
	/* sets asside some space to make these objects will be declared later  */
	
	public static DifferentialDrive lifterBase;
	public static double currentLiftDistance;
	public static double liftPower;
	public static double holdPower;
	
	/* select correct controller for robot configuration  */
	//private VictorSP topLifterMotor;
	//private VictorSP bottomLifterMotor;
	private VictorSP topLifterMotor;
	private VictorSP bottomLifterMotor;

	
	

	/* this is the constructor that 'builds' the object when called  */
	public BoxLifter(){
		super("BoxLifter", 2.0, 0.0, 0.0 );
		setAbsoluteTolerance(0.05);
		getPIDController().setContinuous(false);
		//topLifterMotor = new VictorSP(RobotMap.PWM_PinOut.RIGHT_TOP_LIFTER_MOTOR_ID);
		//bottomLifterMotor = new VictorSP(RobotMap.PWM_PinOut.RIGHT_BOTTOM_LIFTER_MOTOR_ID);
		topLifterMotor = new VictorSP(RobotMap.RIGHT_TOP_LIFTER_MOTOR_ID);
		bottomLifterMotor = new VictorSP(RobotMap.RIGHT_BOTTOM_LIFTER_MOTOR_ID);		
		bottomLifterMotor.setInverted(true);
		lifterBase = new DifferentialDrive(topLifterMotor, bottomLifterMotor);
		lifterBase.setExpiration(0.1);
		lifterBase.setSafetyEnabled(true);
		currentLiftDistance = 0.0;
		holdPower = 0.55;
		liftPower = 0;
		
}
	
	/* function to pull the power cube into the holder  */
	public void liftUp(double liftPower){

		lifterBase.arcadeDrive(-liftPower, 0);

	}
	
	/* function to eject the power cube from the holder  */
	public void placeDown(double lowerPower){

		lifterBase.arcadeDrive(lowerPower, 0);	
	
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return RobotIO.getRobotLifterGyroAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	public double getCurrentLiftDistance() {
		
		return currentLiftDistance;
	}
	public void setCurrentLiftDistance(double value) {
		
		currentLiftDistance = value;
	}
	
	public void softDown () {
		//Timer 
		//while (Math.abs(Robot.boxLifter.getCurrentLiftDistance()) > 10 && !Robot.getLocalRobotIO().getDriverStick().getRawButton(RobotMap.SWITCH_HEIGHT_BUTTON)) {
		//	currentLiftDistance = Robot.robotIO.getLifter_motor_encoder().getDistance();
			//liftPower = 0.40;
			//Robot.boxLifter.liftUp(liftPower);
			//Timer.delay(seconds);
			Timer.delay(0.4);
			liftUp(0.5);
			Timer.delay(0.2); 
			liftUp(0.5);
			Timer.delay(0.2);
			liftUp(0.4);
			Timer.delay(0.3);
		}

	//}
	public static double getHoldPower() {
		
		return holdPower; 
	}
	public void setLiftPower(double inValue) {
		
		liftPower = inValue;
	}
	public static double getLiftPower() {
		
		return liftPower;
	}	

}






