package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystem.DriveSubsystem;

import java.util.function.DoubleSupplier;

public class RobotCentricDrive extends CommandBase {
    private DriveSubsystem drive;
    DoubleSupplier strafeSpeed, forwardSpeed, turnSpeed;
    public RobotCentricDrive(DriveSubsystem drive, DoubleSupplier strafeSpeed,
                             DoubleSupplier forwardSpeed, DoubleSupplier turnSpeed) {
        this.drive = drive;
        this.strafeSpeed = strafeSpeed;
        this.forwardSpeed = forwardSpeed;
        this.turnSpeed = turnSpeed;
    }

    @Override
    public void execute() {
        drive.robotCentricDrive(
                strafeSpeed.getAsDouble(),
                forwardSpeed.getAsDouble(),
                turnSpeed.getAsDouble());
    }
}
