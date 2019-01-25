/***********************************************************
* 6007 2019 cargo (ball) delivery/arm movement
* Editors Hayley, Ebony, Mr Legge
************************************************************/

package org.usfirst.frc.team6007.robot;


public class CargoDelivery{
  
	public CargolDelivery(){
  		
    	}
	
	public void cargoIntake(){
		while(robotIO.cargoSwitchIntake()){
			//run motor to move to positon
		}
	}
	
  	public void cargoLoad(){                               //moves arm to range of position
		while(robotIO.ballPotentiometer.get >= RobotMap.HATCH_DELIVERY_LOWER_lIMIT && robotIO.ballPotentiometer.get <= RobotMap.HATCH_DELIVERY_UPPER_lIMIT){
			//run motor to move to positon
		}
	}
	
	public void loaderToHome(){                           //moves arm back to in/starting position
		while(robotIO.homeCargoSwitch.get()){
			//run motor to move to positon
		}
	}
  }
