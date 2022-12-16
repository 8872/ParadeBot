package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;

public class DriveSubsystem extends SubsystemBase {
    private MecanumDrive drive;

    public DriveSubsystem(MotorEx lF, MotorEx rF, MotorEx lR, MotorEx rR) {
        drive = new MecanumDrive(lF, rF, lR, rR);
    }

    public void robotCentricDrive(double strafeSpeed, double forwardSpeed, double turnSpeed) {
        drive.driveRobotCentric(strafeSpeed, forwardSpeed, turnSpeed);
    }
    public void fieldCentricDrive(double strafeSpeed, double forwardSpeed, double turnSpeed, double gyroAngle) {
        drive.driveFieldCentric(strafeSpeed,forwardSpeed,turnSpeed,gyroAngle);
    }
}
