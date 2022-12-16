package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import org.firstinspires.ftc.teamcode.commands.FieldCentricDrive;
import org.firstinspires.ftc.teamcode.commands.RobotCentricDrive;
import org.firstinspires.ftc.teamcode.subsystem.ArmSubsystem;
import org.firstinspires.ftc.teamcode.subsystem.DriveSubsystem;

public class BaseOpMode extends CommandOpMode {
    private GamepadEx driver1;
    private FieldCentricDrive fieldCentricDrive;
    private RobotCentricDrive robotCentricDrive;

    protected MotorEx fL, fR, rL, rR, dr4bRight, dr4bLeft;
    protected RevIMU imu;
    protected SimpleServo slide, claw;
    protected DriveSubsystem drive;
    protected ArmSubsystem arm;

    private Button changeDrive;

    @Override
    public void initialize() {
        driver1 = new GamepadEx(gamepad1);

        fL = new MotorEx(hardwareMap, "frontLeft");
        fR = new MotorEx(hardwareMap, "frontRight");
        rL = new MotorEx(hardwareMap, "rearLeft");
        rR = new MotorEx(hardwareMap, "rearRight");
        imu = new RevIMU(hardwareMap,"imu");
        dr4bLeft = new MotorEx(hardwareMap, "dr4bLeft");
        dr4bRight = new MotorEx(hardwareMap,"dr4bRight");
        slide = new SimpleServo(hardwareMap,"slide",0,100);
        claw = new SimpleServo(hardwareMap,"claw",0,100);

        drive = new DriveSubsystem(fL,fR,rL,rR);
        arm = new ArmSubsystem(dr4bLeft,dr4bRight,slide,claw);

        changeDrive = (new GamepadButton(driver1, GamepadKeys.Button.LEFT_BUMPER).
                toggleWhenPressed(robotCentricDrive,fieldCentricDrive));

        fieldCentricDrive = new FieldCentricDrive(drive, () -> driver1.getLeftX(),
                () -> driver1.getLeftY(), () -> driver1.getRightX(), () -> imu.getHeading());
        robotCentricDrive = new RobotCentricDrive(drive, () -> driver1.getLeftX(),
                () -> driver1.getLeftY(),() -> driver1.getRightX());

        register(drive,arm);
        drive.setDefaultCommand(robotCentricDrive);
    }
}
