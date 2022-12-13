package org.firstinspires.ftc.teamcode.command.drive;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystem.DriveSubsystem;

import java.util.function.DoubleSupplier;

public class DriveFieldCentric extends CommandBase {
    private final DriveSubsystem subsystem;
    private final DoubleSupplier strafeSpeed, forwardSpeed, turn, heading;

    public DriveFieldCentric(DriveSubsystem subsystem, DoubleSupplier strafeSpeed, DoubleSupplier forwardSpeed, DoubleSupplier turn, DoubleSupplier heading) {
        this.subsystem = subsystem;
        this.strafeSpeed = strafeSpeed;
        this.forwardSpeed = forwardSpeed;
        this.turn = turn;
        this.heading = heading;
        addRequirements(this.subsystem);
    }

    @Override
    public void execute() {
        subsystem.DriveFieldCentric(
                strafeSpeed.getAsDouble(),
                forwardSpeed.getAsDouble(),
                turn.getAsDouble(),
                heading.getAsDouble());
    }
}
