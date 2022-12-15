package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;

public class DriveSubsystem extends SubsystemBase {

    private final MecanumDrive drive;

    public DriveSubsystem (MotorEx Fl, MotorEx Fr, MotorEx Bl, MotorEx Br) {
        drive = new MecanumDrive(Fl, Fr, Bl, Br);
    }

    public void DriveRobotCentric(double strafeSpeed, double forwardSpeed, double turnSpeed) {
        drive.driveRobotCentric(strafeSpeed, forwardSpeed, turnSpeed);
    }

    public void DriveFieldCentric(double strafeSpeed, double forwardSpeed, double turn, double heading) {
        drive.driveFieldCentric(strafeSpeed, forwardSpeed, turn, heading);
    }
}
