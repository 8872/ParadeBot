package org.firstinspires.ftc.teamcode.command.lift;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystem.ArmSubsystem;

import java.util.function.DoubleSupplier;

public class ManualLift extends CommandBase {

    private final ArmSubsystem arm;
    private final DoubleSupplier leftPower, rightPower;

    public ManualLift (ArmSubsystem arm, DoubleSupplier leftPwer, DoubleSupplier rightPower) {
        this.arm = arm;
        this.leftPower = leftPwer;
        this.rightPower = rightPower;
    }

    @Override
    public void execute() {
        arm.manualMovement(leftPower.getAsDouble(), rightPower.getAsDouble());
    }
}
