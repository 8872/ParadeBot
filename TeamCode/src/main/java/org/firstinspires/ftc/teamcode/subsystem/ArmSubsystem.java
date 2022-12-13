package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;

public class ArmSubsystem extends SubsystemBase {
    MotorEx dr4bLeft, dr4bRight;
    ServoEx slide, claw;

    public ArmSubsystem(MotorEx dr4bLeft,MotorEx dr4bRight,ServoEx slide, ServoEx claw) {
        this.dr4bLeft = dr4bLeft;
        this.dr4bRight = dr4bRight;
        this.slide = slide;
        this.claw = claw;
    }

    public void grab() {

    }

    public void release() {

    }

    public void extend() {

    }

    public void bringIn() {

    }
}
