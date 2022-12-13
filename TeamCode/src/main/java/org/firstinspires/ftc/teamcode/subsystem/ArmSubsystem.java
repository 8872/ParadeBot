package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;

public class ArmSubsystem extends SubsystemBase {

    private MotorEx left, right;

    public ArmSubsystem(MotorEx left, MotorEx right) {
        this.left = left;
        this.right = right;
    }

    public void manualMovement(double leftPower, double rightPower) {
        left.set(leftPower);
        right.set(rightPower);
    }
}
