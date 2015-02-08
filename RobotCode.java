// This code goes before constructor
public DoubleSolenoid solenoid;
public boolean triggerPressed;

// This code goes into constructor
solenoid = new DoubleSolenoid(0,1);
compressor.start();

// Reverses the solenoid in order to move the Piston
public void movePiston() {
	if(solenoid.get() == DoubleSolenoid.Value.kForward) {
		solenoid.set(DoubleSolenoid.Value.kReverse);
	} else {
		solenoid.set(DoubleSolenoid.Value.kForward);
	}
}

// Checks the value of the X button
public boolean checkButton() {
	if(!triggerPressed) { triggerPressed = true; return stick.getRawButton(3);}
	else {
		if(!stick.getRawButton(3)) {
			triggerPressed = false;
			return false;
		}
	}
}

// This code goes into UserOperated Mode
if(checkButton()) { movePiston(); }