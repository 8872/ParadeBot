package org.firstinspires.ftc.teamcode.command.drive;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystem.DriveSubsystem;

import java.util.function.DoubleSupplier;

public class DriveRobotCentric extends CommandBase {
    private final DriveSubsystem drive;
    private final DoubleSupplier strafeSpeed, forwardSpeed, turnSpeed;

    public DriveRobotCentric(DriveSubsystem drive, DoubleSupplier strafeSpeed, DoubleSupplier forwardSpeed, DoubleSupplier turnSpeed) {
        this.drive = drive;
        this.strafeSpeed = strafeSpeed;
        this.forwardSpeed = forwardSpeed;
        this.turnSpeed = turnSpeed;
        addRequirements(this.drive);
    }

    @Override
    public void execute() {
        drive.DriveRobotCentric(
                strafeSpeed.getAsDouble(),
                forwardSpeed.getAsDouble(),
                turnSpeed.getAsDouble());
    }
}
