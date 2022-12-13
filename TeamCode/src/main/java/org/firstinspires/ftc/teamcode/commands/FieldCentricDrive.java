package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystem.DriveSubsystem;

import java.util.function.DoubleSupplier;

public class FieldCentricDrive extends CommandBase {
    private DriveSubsystem drive;
    private DoubleSupplier strafeSpeed, forwardSpeed, turnSpeed, gyroAngle;

    public FieldCentricDrive(DriveSubsystem driveSubsystem, DoubleSupplier strafeSpeed,
                                     DoubleSupplier forwardSpeed,DoubleSupplier turnSpeed, DoubleSupplier gyroAngle) {
        this.drive = driveSubsystem;
        this.strafeSpeed = strafeSpeed;
        this.forwardSpeed = forwardSpeed;
        this.turnSpeed = turnSpeed;
        this.gyroAngle = gyroAngle;
        addRequirements(driveSubsystem);
    }

    @Override
    public void execute() {
        drive.fieldCentricDrive(
                strafeSpeed.getAsDouble(),
                forwardSpeed.getAsDouble(),
                turnSpeed.getAsDouble(),
                gyroAngle.getAsDouble()
        );
    }
}
